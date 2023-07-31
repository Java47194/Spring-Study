package Hi.coretest.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository {

    private  static Map<Long,Member> store= new HashMap<>(); //데이터가 확정이 안되서 Map으로 임시 DB를 만듬
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);


    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
