package dao;

import java.util.List;

import dto.UserInfo;

public interface UserInfoDao {
	public List<UserInfo> getUserInfoByName(String name);
}
