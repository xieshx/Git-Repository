import com.neu.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest02 {

    @Test
    public void testb02() {
        String config="ba02/applicationContext.xml";
        ApplicationContext ac= new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student3");
        System.out.println(student);
    }
}
