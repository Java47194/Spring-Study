package Hi.coretest;

import Hi.coretest.member.*;

public class MemberApp {

    public static void main(String[] args) {
      AppConfig appConfig=new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L,"user",Grade.VIP);
        memberService.join(member);
        Member member1 = memberService.findMember(1l);

        System.out.println("member = " + member);
        System.out.println("member1 = " + member1);


    }
}
