package Hi.coretest;

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
}
//@ComponentScan
//classes =  excludeFilters = @Filter(type = FilterType.ANNOTATION , classes = Configuration.class) 붙은 클래스를 뺸다라는 뜻이다.