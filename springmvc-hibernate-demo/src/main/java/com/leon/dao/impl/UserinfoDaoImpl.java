package com.leon.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.leon.bean.Userinfo;
import com.leon.dao.UserinfoDao;

public class UserinfoDaoImpl extends HibernateDaoSupport implements UserinfoDao {

	@Override
	public void save(Userinfo userinfo) {
		getHibernateTemplate().save(userinfo);
	}

	@Override
	public Userinfo queryById(String id) {
		return getHibernateTemplate().get(Userinfo.class, Integer.valueOf(id));
	}

	@Override
	public List<Userinfo> query(Criteria criteria) {
		HibernateTemplate ht = getHibernateTemplate();
		return (List<Userinfo>) ht.findByCriteria((DetachedCriteria) criteria);
	}
}
