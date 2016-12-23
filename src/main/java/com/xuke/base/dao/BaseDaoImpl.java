package com.xuke.base.dao;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.xuke.util.TimeUtil;

@Transactional
public class BaseDaoImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseDao<T, ID> {

	@PersistenceContext
	private final EntityManager em;

	public BaseDaoImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
		this.em = em;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int update(T obj) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate cu = cb.createCriteriaUpdate(obj.getClass());
		Root root = cu.from(obj.getClass());
		
		JSONObject json = (JSONObject) JSONObject.toJSON(obj);
		Iterator<?> iter = json.keySet().iterator();

		while (iter.hasNext()) {
			String key = (String) iter.next();
			Object value = json.get(key);
			if (value == null || key.equals("objectId") || key.equals("createAt") || key.equals("updateAt")
					|| key.equals("msglist") || key.equals("credentialsNonExpired") || key.equals("authorities")
					|| key.equals("enabled") || key.equals("accountNonLocked") || key.equals("accountNonExpired"))
				continue;
			
			System.out.println("Key:" + key + "      Value:" + value);
			cu.set(root.get(key), value);
		}
		cu.set("updateAt", TimeUtil.getCurrentTime());
		cu.where(cb.equal(root.get("objectId"),json.getString("objectId")));
		return em.createQuery(cu).executeUpdate();
	}

}
