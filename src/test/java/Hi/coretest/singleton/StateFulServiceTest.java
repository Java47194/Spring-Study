package Hi.coretest.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {
    
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac =new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);
        //Thread lee가 10000원 주문
        int lee = stateFulService1.order("lee", 10000);

        //Thread kim이 20000원 주문
        int kim = stateFulService2.order("kim", 20000);



        System.out.println(kim);


    }



    
    static class TestConfig{
        
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }

}