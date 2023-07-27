package Hi.coretest.beanfind;

import Hi.coretest.discount.DiscountPolicy;
import Hi.coretest.discount.FixDiscountPolicy;
import Hi.coretest.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextExtendsFindTest {
    
    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(TestConfig.class);
    

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면 중복 오류가 발생")
    void 중복오류(){

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                ()->ac.getBean(DiscountPolicy.class));

    }


    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면 빈이름 으로 조회")
    void 빈이름으로조회(){

        DiscountPolicy ratediscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(ratediscountPolicy).isInstanceOf(RateDiscountPolicy.class);

    }
    @Test
    @DisplayName("특정타입으로 조회")
    void 타입으로조회(){

        DiscountPolicy ratediscountPolicy = ac.getBean( RateDiscountPolicy.class);
        assertThat(ratediscountPolicy).isInstanceOf(DiscountPolicy.class);

    }
    
    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void 부모타입으로모두조회(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("key   = " + key + " value = " +beansOfType.get(key));
            
        }
    }


    @Test
    @DisplayName("부모 타입으로 모두 조회하기 -Object")
    void Object타입으로꺼내기(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key   = " + key + " value = " +beansOfType.get(key));

        }
    }
    
    @Configuration
    static class TestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
