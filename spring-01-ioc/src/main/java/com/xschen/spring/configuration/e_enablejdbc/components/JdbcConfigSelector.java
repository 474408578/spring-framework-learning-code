package com.xschen.spring.configuration.e_enablejdbc.components;

import com.xschen.spring.configuration.e_enablejdbc.config.EnableJdbc;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import java.util.List;

/**
 * @author xschen
 * 通过类路径META-INF/spring.factories去获取 MySQLJdbcConfiguration，OracleJdbcConfiguration，H2JdbcConfiguration
 */


public class JdbcConfigSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> configClassNames = SpringFactoriesLoader.loadFactoryNames(EnableJdbc.class, this.getClass().getClassLoader());
        return configClassNames.toArray(new String[0]);
    }
}