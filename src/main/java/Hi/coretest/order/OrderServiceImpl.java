package Hi.coretest.order;

import Hi.coretest.annotation.MainDiscountPolicy;
import Hi.coretest.discount.DiscountPolicy;
import Hi.coretest.member.Member;
import Hi.coretest.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //Lombok 기능: final이 붙은 필드를 모아  생성자를 자동으로 만들어줌
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy=new RateDiscountPolicy(); //Dip 위반 왜? OrderServiceImple 코드를 수정 했긴 떄문
                                                                          //Dip 위반: 인터페이스에만 의존해라 구현체에 의존 하지마라
    private final DiscountPolicy discountPolicy;
  /*  @Autowired
    //수정자 주입
    //선택 변경 가능성이 있는 의존관계에 사용
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //메인db는 @primary 사용
    //서브db는 @Quilifier 사용


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.disCount(member, itemPrice);

        return new Order(memberId ,itemName,itemPrice,discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
