package spingaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "springaop")
public class ShoppingCart {

    public void checkout(){
        System.out.println("checked out ");
    }
}
