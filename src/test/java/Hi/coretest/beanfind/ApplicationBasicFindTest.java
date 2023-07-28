package Hi.coretest.beanfind;

import Hi.coretest.AppConfig;
import Hi.coretest.member.MemberService;
import Hi.coretest.member.MemberServiceImpl;
import Hi.coretest.singleton.SingletonService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationBasicFindTest {
    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("빈 이름으로 조회")
    void 빈이름으로찾기(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void 이름없이타입으로만조회(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName(" 구체 타입으로 조회")
    void 구체타입으로조회(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class); //반환 되는 구체로 적어두 된다.
                                                                                                  //근데 이방법은 안좋다
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void 빈이름조회X(){
        //MemberService memberService = ac.getBean("xxxx", MemberService.class);
        //에러 발생( NoSuchBeanDefinitionException: No bean named 'xxxx' available)
        assertThrows(NoSuchBeanDefinitionException.class,() ->
                ac.getBean("xxxx", MemberService.class) );
    }


}
