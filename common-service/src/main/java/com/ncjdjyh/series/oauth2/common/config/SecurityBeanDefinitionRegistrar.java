package com.ncjdjyh.series.oauth2.common.config;

import com.ncjdjyh.series.oauth2.common.constant.SecurityConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Slf4j
public class SecurityBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	/**
	 * 根据注解值动态注入资源服务器的相关属性
	 * @param metadata 注解信息
	 * @param registry 注册器
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		GenericBeanDefinition resourceServerBean = new GenericBeanDefinition();
		GenericBeanDefinition rbacServiceBean = new GenericBeanDefinition();
		resourceServerBean.setBeanClass(DefaultResourceServerConfigurerAdapter.class);
		rbacServiceBean.setBeanClass(RbacService.class);
		registry.registerBeanDefinition(SecurityConstants.RESOURCE_SERVER_CONFIGURER, resourceServerBean);
		registry.registerBeanDefinition(SecurityConstants.RBAC_SERVICE_BEAN_NAME, rbacServiceBean);
	}
}
