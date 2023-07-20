package Hi.coretest;

import Hi.coretest.discount.DiscountPolicy;
import Hi.coretest.discount.FixDiscountPolicy;
import Hi.coretest.member.MemberRepository;
import Hi.coretest.member.MemberService;
import Hi.coretest.member.MemberServiceImpl;
import Hi.coretest.member.MemoryMemberRepository;
import Hi.coretest.order.OrderService;
import Hi.coretest.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());

    }
}
