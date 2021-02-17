package com.think.in.spring.configuration.metadata;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Map;

/**
 * 基于 Java 注解 Spring IoC 容器元信息配置 示例
 * @author xschen
 */

@ImportResource("classpath:/META-INF/dependency-lookup-context.xml")
@Import(User.class)
@PropertySource("classpath:/META-INF/user-bean-definitions.properties") // Java 8+ @Repeatable 注解支持
@PropertySource("classpath:/META-INF/user-bean-definitions.properties")
public class AnnotatedSpringIoCContainerMetadataConfigurationDemo {

    /**
     * user.name 是 Java Properties 默认存在，计算机的当前用户，而非配置文件中定义的
     * @param id
     * @param name
     * @return
     */
    @Bean
    public User configUser(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotatedSpringIoCContainerMetadataConfigurationDemo.class);
        context.refresh();
        Map<String, User> userMap = context.getBeansOfType(User.class);
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.printf("User bean name: %s, User content: %s \n", entry.getKey(), entry.getValue());
        }
        context.close();
    }
}
