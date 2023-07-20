package Hi.coretest;

import Hi.coretest.member.Grade;
import Hi.coretest.member.Member;
import Hi.coretest.member.MemberService;
import Hi.coretest.member.MemberServiceImpl;
import Hi.coretest.order.Order;
import Hi.coretest.order.OrderService;
import Hi.coretest.order.OrderServiceImpl;

public class OrderWeb {
    public static void main(String[] args) {
        AppConfig appConfig =new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "UserA", Grade.VIP);

        memberService.join(member);

        Order itemA = orderService.createOrder(1L, "itemA", 10000);
        int i = itemA.calculatePrice();

        System.out.println(i);


    }
}
