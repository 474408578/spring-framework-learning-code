package com.think.in.spring.configuration.metadata;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * 基于 Java 注解的YAML 外部化配置示例
 * @author xschen
 * @see YamlPropertiesFactoryBean
 * @see YamlProcessor
 */

@PropertySource(name = "yamlPropertySource",
                value = "classpath:/META-INF/user.yaml",
                factory = YamlPropertiesFactory.class)
public class AnnotatedYamlPropertySourceDemo {

    /**
     * user.name 是 Java Properties 默认存在，计算机的当前用户，而非配置文件中定义的
     * @param id
     * @param name
     * @return
     */
    @Bean
    public User user(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotatedYamlPropertySourceDemo.class);

        context.refresh();

        User user = context.getBean("user", User.class);
        System.out.println(user);

        context.close();
    }
}
