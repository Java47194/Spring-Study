package Hi.coretest.singleton;

import Hi.coretest.AppConfig;
import Hi.coretest.member.MemberRepository;
import Hi.coretest.member.MemberService;
import Hi.coretest.member.MemberServiceImpl;
import Hi.coretest.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {


    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void 순수한DI컨테이너(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);

        TestAppConfig testAppConfig = new TestAppConfig();
        MemberService memberService3 = testAppConfig.memberService();
        MemberService memberService4 = testAppConfig.memberService();

        System.out.println("memberService3 = " + memberService3);
        System.out.println("memberService4 = " + memberService4);


        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestAppConfig.class);
        MemberService memberService5 = ac.getBean(MemberService.class);
        MemberService memberService6 = ac.getBean(MemberService.class);


        System.out.println("memberService5 = " + memberService5);
        System.out.println("memberService6 = " + memberService6);

        assertThat(memberService5).isSameAs(memberService6);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        Assertions.assertThat(instance1).isSameAs(instance2);
    }

    @Configuration
    static class TestAppConfig{
        @Bean
        public MemberService memberService(){
            return new MemberServiceImpl(memberRepository());
        }
        @Bean
        public MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }

    }
}
