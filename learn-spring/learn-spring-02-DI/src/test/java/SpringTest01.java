import com.neu.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {

    @Test
    public void testb01() {
        String config="ba01/applicationContext.xml";
        ApplicationContext ac= new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student1");
        System.out.println(student);
    }

}
