package org.example.conf;

import org.example.aspect.TimeAspect;
import org.example.components.ExeCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.example")
public class AppCtx {
//    @Bean
//    public ExeCalculator exeCalculator(){
//        return  new ExeCalculator();
//    }
    @Bean
    public TimeAspect timeAspect(){
        return new TimeAspect();
    }
}
