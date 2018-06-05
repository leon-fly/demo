package com.leon.service;

import com.leon.bean.Userinfo;

public interface UserinfoService {
	void save(Userinfo userinfo);
	Userinfo queryById(String id);
}
