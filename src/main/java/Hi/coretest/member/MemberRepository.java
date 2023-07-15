package Hi.coretest.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);

}
