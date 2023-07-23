package Hi.coretest;

import Hi.coretest.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
   /*     AppConfig appConfig=new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class); //Appconfig에 있는 빈적혀있는 것들을 다 등록해줌
        MemberService memberService = ac.getBean("memberService", MemberService.class); // 이름(memberService) , 타입(MemberService 타입)
        Member member = new Member(1L,"user",Grade.VIP);
        memberService.join(member);
        Member member1 = memberService.findMember(1l);

        System.out.println("member = " + member);
        System.out.println("member1 = " + member1);


    }
}
