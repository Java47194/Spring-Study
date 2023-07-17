package Hi.coretest.order;

import Hi.coretest.member.Grade;
import Hi.coretest.member.Member;
import Hi.coretest.member.MemberService;
import Hi.coretest.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService =new MemberServiceImpl();
    OrderService orderService=new OrderServiceImpl();


    @Test
    void 할인정책(){
        long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }
}
