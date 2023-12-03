package spingaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext annocontext= new AnnotationConfigApplicationContext(BeanConfig.class);

        ShoppingCart cart = annocontext.getBean(ShoppingCart.class);
        cart.checkout();
        System.out.println();

    }
}
