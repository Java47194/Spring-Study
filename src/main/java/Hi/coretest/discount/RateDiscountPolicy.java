package Hi.coretest.discount;

import Hi.coretest.annotation.MainDiscountPolicy;
import Hi.coretest.member.Grade;
import Hi.coretest.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private int disCountPercent=10;
    @Override
    public int disCount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){

            return price *disCountPercent/100;
        }else {

            return 0;
        }
    }
}
