package Hi.coretest;

import Hi.coretest.discount.DiscountPolicy;
import Hi.coretest.discount.FixDiscountPolicy;
import Hi.coretest.discount.RateDiscountPolicy;
import Hi.coretest.member.MemberRepository;
import Hi.coretest.member.MemberService;
import Hi.coretest.member.MemberServiceImpl;
import Hi.coretest.member.MemoryMemberRepository;
import Hi.coretest.order.OrderService;
import Hi.coretest.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration이 붙은 AppConfig를 설정 정보로 사용
// 여기서 @Bean이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록. 등록된 객체를 스프링 빈이라고 함
// 스프링 빈은 @Bean이 붙은 메서드명을 스프링 빈의 이름(키)로 사용 memberService,orderService
// ac.getBean(memberService,MemberService.class) 스프링 빈을 찾는 메서드

@Configuration
public class AppConfig {
    //AppCongig 리펙토링

    //내생각
    //memberService call
    //memberRepository call
    //memberRepository call
    //orderService call
    //memberRepository call


    //현실
    //memberService call
    //memberRepository call
    //orderService call


    @Bean
    public MemberService memberService(){
        System.out.println("memberService call");
        return new MemberServiceImpl(memberRepository());
    }

    /*public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }*/


   /* 중요 ★★★★★★★★★★
   @Configuration 과 @Bean의 조합으로 static을 사용하면 싱글톤을 보장을 못받는다.
   */

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("memberRepository call");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("orderService call");
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }
    @Bean
    public  DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
