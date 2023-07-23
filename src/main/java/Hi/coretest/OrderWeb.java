package Hi.coretest;

import Hi.coretest.member.Grade;
import Hi.coretest.member.Member;
import Hi.coretest.member.MemberService;
import Hi.coretest.member.MemberServiceImpl;
import Hi.coretest.order.Order;
import Hi.coretest.order.OrderService;
import Hi.coretest.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderWeb {
    public static void main(String[] args) {
    /*    AppConfig appConfig =new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();*/

        ApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        Member member = new Member(1L, "UserA", Grade.VIP);

        memberService.join(member);

        Order itemA = orderService.createOrder(1L, "itemA", 20000);
        int i = itemA.calculatePrice();

        System.out.println(i);


    }
}
