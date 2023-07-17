package Hi.coretest.discount;

import Hi.coretest.member.Member;

public interface DiscountPolicy {
    int disCount(Member member, int price);
}
