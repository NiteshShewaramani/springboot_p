package splwg;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(scopeName = "prototype")
public class DoctorComp implements BeanNameAware {

    public void assist(){
        System.out.println("DoctorComp is assisting");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName() called");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct is called");
    }
}
