package com.think.in.spring.configuration.metadata;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 外部化配置示例
 * @author xschen
 */

@PropertySource("classpath:/META-INF/user-bean-definitions.properties")
public class PropertySourceDemo {

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
        context.register(PropertySourceDemo.class);

        // 扩展 Environment 中的 PropertySources
        // 添加 PropertySource 的操作必须在 refresh 执行之前完成
        Map<String, Object> propertiesSource = new HashMap<>();
        propertiesSource.put("user.name", "xiangsong");
        org.springframework.core.env.PropertySource propertySource =
                new MapPropertySource("first-property-source", propertiesSource);
        context.getEnvironment().getPropertySources().addFirst(propertySource);

        context.refresh();
        Map<String, User> userMap = context.getBeansOfType(User.class);
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.printf("User bean name: %s, User content: %s \n", entry.getKey(), entry.getValue());
        }

        System.out.println(context.getEnvironment().getPropertySources());
        context.close();
    }
}
