package Hi.coretest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    @Autowired // 생성자 주입(필수값)
                // 1. 불변 필수 ,
                // 2.생성자 호출시점에 딱 1번만 호출되는 것이 보장
                // 3. 생성자가 하나 일경우 @Autowired 생략가능
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
