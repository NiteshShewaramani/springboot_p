package spingaop;

import org.aspectj.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public void beforeLogger(){

    }

    public void afterLogger(){}
}
