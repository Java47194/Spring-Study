package Hi.coretest.discount;

import Hi.coretest.member.Grade;
import Hi.coretest.member.Member;
import Hi.coretest.member.MemberService;
import Hi.coretest.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    MemberService memberService=new MemberServiceImpl();
    DiscountPolicy discountPolicy=new RateDiscountPolicy();

    long id= 1L;
    @Test
    void 정률할인(){

        Member member = new Member(id, "lee", Grade.VIP);
        memberService.join(member);

        int findByMember = discountPolicy.disCount(member, 10000);
        System.out.println(findByMember);

        Assertions.assertThat(findByMember).isEqualTo(1000);

    }

    @Test
    @DisplayName("아니면")
    void vip아니면(){
        Member member = new Member(id, "lee", Grade.BASIC);
        memberService.join(member);

        int findByMember = discountPolicy.disCount(member, 10000);
        System.out.println(findByMember);

        Assertions.assertThat(findByMember).isEqualTo(0);
    }


}