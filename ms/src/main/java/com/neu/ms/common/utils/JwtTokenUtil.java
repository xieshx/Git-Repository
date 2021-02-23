package com.neu.ms.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//Jwt本质是一串字符串：头部(header).有效载荷(payload).签名(signature)
//一、头部分是一个描述JWT元数据的JSON对象，包含两个属性：
//      1.alg：签名使用的算法，默认为HMAC SHA256（写为HS256）
//      2.typ：令牌的类型，JWT令牌统一写为JWT
//二、有效载荷是JWT的主体内容部分，也是一个JSON对象，包含需要传递的数据。JWT指定七个默认字段供选择，也可以自定义放到claims中去
//      iss发行人;exp到期时间;sub主题;aud用户;nbf在此之前不可用;iat发行时间;jti是JWT的识别唯一ID
//三、签名是对上面两部分数据签名，通过指定的算法生成哈希，以确保数据不会被篡改。
// 首先，需要制定一个密钥（secret）。该密钥仅仅为保存在服务器中，并且不能向用户公开。
// 然后，使用头部中指定的签名算法（默认情况下为HMACSHA256）根据以下公式生成签名:
// HMACSHA256(bash64UrlEncode(header)+"."+bash64UrlEncode(payload),secret)
//四、在计算出签名后，将JWT头部，有效载荷和签名的三个部分组合成一个字符串，每个部分用"."分隔，就构成整个JWT对象，返回给用户。
//五、JWT的特点：
// （1）JWT默认是不加密的，但也是可以加密的。生成原始Token以后，可以用密钥在加密一次。
// （2）JWT不加密的情况下，不能将秘密数据写入JWT。
// （3）JWT不仅可以用于认证，也可以死用于交换信息。有效使用JWT，可以降低服务器的查询数据库的次数。
// （4）JWT最大的缺点是，用于服务器不保存session状态，因此无法在使用过程中废止某个token，或者更改token的权限，也就是说，一旦JWT签发了，在到期之前就会始终有效，除非服务器部署额外的逻辑。
// （5）JWT本身包含了认证信息，一旦泄露，任何人都可以获得该令牌的所有权限。为了减少盗用，JWT的有效期限应该设置的比较短。对于一些比较重要的权限，使用时应该再次对用户进行认证。
// （6）为了较少盗用，JWT不应该使用HTTP协议明码传输，要使用HTTPS协议传输。

//需要Component注解将类注入到spring容器中，这样@value的值才能注入
@Component
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    // 获取用户生成token
    //与security结合
    public String generateToken(UserDetails userDetails) {
        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        //当前项目使用：用户名、创建时间、生成时间
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 从token中获取登录用户名
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 从token中获取过期时间
     */
    public Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     *
     * @param token 客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否已经失效
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    //TODO:刷新token功能

    //私有方法，生成token
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                //设置过期时间
                .setExpiration(generateExpirationDate())
                // signWith解析：
                // 第一个参数是签名算法
                // 第二个参数是生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露。
                // 它就是服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
                // 这里报了个javax的异常，因为JAXB API是java EE 的API，因此在java SE 9.0 中不再包含这个 Jar 包。
                // java 9 中引入了模块的概念，默认情况下，Java SE中将不再包含java EE 的Jar包
                // 解决办法：可以降低JDK8，也可以导入对应的jar包
                .signWith(SignatureAlgorithm.HS512, secret)
                //加密为jwt
                .compact();
    }

    //私有方法,生成token的过期时间
    private Date generateExpirationDate() {
        //有效期7天，从当前系统时间开始计算，下周过期
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    //私有方法,从token中获取JWT中的负载
    //JWT有效载荷的一个属性对被成为一个claims，Claims类继承了Map，但是是个接口，自己是没办法new出来使用的
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
        }
        return claims;
    }

}
