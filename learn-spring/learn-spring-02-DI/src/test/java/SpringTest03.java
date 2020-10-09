import com.neu.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest03 {

    @Test
    public void test() {
        String config="ba03/applicationContext.xml";
        ApplicationContext ac= new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student2");
        System.out.println(student);
    }
}
