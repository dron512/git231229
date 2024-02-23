package conf;

import component.AA;
import component.BB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public AA aa(){
        return new AA();
    }

    @Bean
    public BB bb(){
        return new BB();
    }

}
