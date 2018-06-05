package com.leon.dao;

import java.util.List;

import org.hibernate.Criteria;

import com.leon.bean.Userinfo;

public interface UserinfoDao {
	void save(Userinfo userinfo);
	Userinfo queryById(String id);
	List<Userinfo> query(Criteria criteria);
}
