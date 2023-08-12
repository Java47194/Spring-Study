package Hi.coretest.discount;

import Hi.coretest.member.Grade;
import Hi.coretest.member.Member;
import org.springframework.stereotype.Component;

@Component
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
