package splwg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "splwg")
public class BeanConfig {
    //we define all beans here
    @Bean
    public Doctor doctor()
    {
        return new Doctor();
    }
}
