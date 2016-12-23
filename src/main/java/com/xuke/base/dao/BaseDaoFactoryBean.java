package com.xuke.base.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class BaseDaoFactoryBean<R extends JpaRepository<S, ID>, S, ID extends Serializable>
		extends JpaRepositoryFactoryBean<R, S, ID> {

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		// TODO Auto-generated method stub
		return new BaseDaoFactory(entityManager);
	}

	private static class BaseDaoFactory extends JpaRepositoryFactory {
		public BaseDaoFactory(EntityManager entityManager) {
			super(entityManager);
			// TODO Auto-generated constructor stub
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
				RepositoryInformation information, EntityManager entityManager) {
			// TODO Auto-generated method stub
			return new BaseDaoImpl(information.getDomainType(), entityManager);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			// TODO Auto-generated method stub
			return BaseDao.class;
		}
	}
}
