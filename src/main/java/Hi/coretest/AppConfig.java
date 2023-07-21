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

public class AppConfig {
    //AppCongig 리펙토링
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }

    private static DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
