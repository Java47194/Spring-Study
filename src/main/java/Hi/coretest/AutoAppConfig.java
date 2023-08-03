package Hi.coretest;

import Hi.coretest.member.MemberRepository;
import Hi.coretest.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        basePackages = "Hi.coretest.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @Filter(type = FilterType.ANNOTATION , classes = Configuration.class)
)
public class AutoAppConfig {
    //이름이 같은 수동 빈 과 자동 빈 이 있을경우 수동 빈이 우선권을 갖는다
    //근데 스프링 부트는 같은 빈이 있을경우 실행이 안되게 설정 되어있다. 그럴떈 밑에 설정을 application.properties에 붙이면 된다
    //spring.main.allow-bean-definition-overriding=true
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
//@ComponentScan
//classes =  excludeFilters = @Filter(type = FilterType.ANNOTATION , classes = Configuration.class) 붙은 클래스를 뺸다라는 뜻이다.