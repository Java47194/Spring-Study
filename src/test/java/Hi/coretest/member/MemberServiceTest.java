package Hi.coretest.member;

import Hi.coretest.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService= appConfig.memberService();
    }

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
