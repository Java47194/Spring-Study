package Hi.coretest.order;

import Hi.coretest.discount.DiscountPolicy;
import Hi.coretest.member.Member;
import Hi.coretest.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy=new RateDiscountPolicy(); //Dip 위반 왜? OrderServiceImple 코드를 수정 했긴 떄문
                                                                          //Dip 위반: 인터페이스에만 의존해라 구현체에 의존 하지마라
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.disCount(member, itemPrice);

        return new Order(memberId ,itemName,itemPrice,discountPrice);
    }
}
