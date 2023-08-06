package Hi.coretest.autoWired;

import Hi.coretest.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{

        @Autowired(required = true)//에러 왜 member가 빈으로 등록 안되있어서 그래서 false로 해야됌
        public void setNoBean1(Member member){
            System.out.println("member1 = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("member2 = " + member); //스프링빈이 없으면 null로 출력
        }

        @Autowired
        public void setNoBean2(Optional<Member> member){
            System.out.println("member3 = " + member);// 스프링빈이 없으면 Optional.empty로 출력
        }


    }
}
