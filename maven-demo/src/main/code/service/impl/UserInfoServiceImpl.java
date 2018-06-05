package service.impl;

import java.util.List;

import dao.UserInfoDao;
import dto.UserInfo;
import service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDao userInfoDao;
	public UserInfo queryOldestUserWithTheSameName(String name) {
		List<UserInfo> users = userInfoDao.getUserInfoByName(name);
		UserInfo user =  users.get(0);
		return user;
	}
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

}
