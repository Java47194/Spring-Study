package Hi.coretest.discount;

import Hi.coretest.member.Grade;
import Hi.coretest.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount =1000;
    @Override
    public int disCount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
