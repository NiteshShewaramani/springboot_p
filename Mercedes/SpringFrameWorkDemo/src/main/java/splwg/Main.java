package splwg;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");

//        Doctor d = context.getBean(Doctor.class);
//        d.assist();
//        System.out.println(d);
//        Nurse n =context.getBean(Nurse.class);
//        n.assist();
//        Staff s = context.getBean(Doctor.class);
//        s.assist();
//        System.out.println(d.getQualification());



        //Annotation based
         DoctorComp dc = context.getBean(DoctorComp.class);
        dc.assist();


//        //this is java config based
//        ApplicationContext annocontext= new AnnotationConfigApplicationContext(BeanConfig.class);
//
//        DoctorComp dc2 = annocontext.getBean(DoctorComp.class);
//        dc2.assist();


    }
}
