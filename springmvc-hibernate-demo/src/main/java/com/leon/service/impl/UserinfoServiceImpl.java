package com.leon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.bean.Userinfo;
import com.leon.dao.UserinfoDao;
import com.leon.service.UserinfoService;
@Service
public class UserinfoServiceImpl implements UserinfoService {
	@Autowired
	private UserinfoDao userinfoDao;
	@Override
	public void save(Userinfo userinfo) {
		if(userinfo!=null)
			userinfoDao.save(userinfo);
	}
	@Override
	public Userinfo queryById(String id) {
		// TODO Auto-generated method stub
		return userinfoDao.queryById(id);
	}

}
