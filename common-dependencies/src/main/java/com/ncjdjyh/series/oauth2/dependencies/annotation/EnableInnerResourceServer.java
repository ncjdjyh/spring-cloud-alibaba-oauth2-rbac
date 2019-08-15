package com.ncjdjyh.series.oauth2.dependencies.annotation;

import com.ncjdjyh.series.oauth2.dependencies.config.SecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.lang.annotation.*;

/**
 * @author ncjdjyh
 * <p>
 * 资源服务注解
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({SecurityBeanDefinitionRegistrar.class})
public @interface EnableInnerResourceServer {

}
