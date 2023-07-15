package Hi.coretest;

import Hi.coretest.member.*;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L,"UserA", Grade.VIP);
        memberService.join(member);

        System.out.println(member.toString());

        Member member1 = memberService.findMember(1L);

        System.out.println("member1 = " + member1);
        


    }
}
