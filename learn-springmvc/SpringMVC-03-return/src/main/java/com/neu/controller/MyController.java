package com.neu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class MyController {

    @GetMapping("/return.do")
    public String doGet(String name, Integer age, HttpServletRequest request){
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        return "show";
    }

    @GetMapping("/returnAjax.do")
    public void doGetAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println(name+age);
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        String json = "";
        //把结果的对象转为json格式的数据
        if( student != null){
            ObjectMapper om  = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换的json===="+json);
        }
        //输出数据，响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    @GetMapping("/returnJson.do")
    @ResponseBody
    public Student doGetAnnotation(String name, Integer age){
        System.out.println(name+age);
        Student student = new Student();
        student.setAge(20);
        student.setName("李四");
        return student;
    }

    @GetMapping("/returnList.do")
    @ResponseBody
    public List doGetList(String name, Integer age){

        List<Student> list =new ArrayList<>();

        Student student1 = new Student();
        student1.setAge(20);
        student1.setName("李四");
        list.add(student1);

        Student student2=new Student();
        student2.setName(name);
        student2.setAge(age);
        list.add(student2);

        return list;
    }

    @GetMapping(value = "/returnString.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doReturnString(String name, Integer age){
        return "你好啊！";
    }


}
