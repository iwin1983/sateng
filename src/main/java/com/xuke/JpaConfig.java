package com.xuke;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;

@Configuration
@EnableJpaRepositories(
		basePackages= {"com.xuke.dao"},
		repositoryImplementationPostfix = "Impl",
		queryLookupStrategy=Key.CREATE_IF_NOT_FOUND,
		repositoryFactoryBeanClass=com.xuke.base.dao.BaseDaoFactoryBean.class,
		entityManagerFactoryRef="entityManagerFactory",
		transactionManagerRef="transactionManager"
		)
public class JpaConfig {

}
