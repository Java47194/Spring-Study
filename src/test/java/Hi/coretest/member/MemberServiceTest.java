package Hi.coretest.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {
    private final MemberService memberService= new MemberServiceImpl();

    @Test
    void 회원가입(){
        //given
        Member member =new Member(1L,"UserA",Grade.VIP);

        //when
        memberService.join(member);
        Member member1 = memberService.findMember(1L);

        //then
        assertThat(member1).isEqualTo(member);
    }
}
