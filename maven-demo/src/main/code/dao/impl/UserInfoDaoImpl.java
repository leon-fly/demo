package dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.UserInfoDao;
import dto.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao{

	public List<UserInfo> getUserInfoByName(String name) {
		Date birth = null;
		try {
			birth = new SimpleDateFormat("yyyyMMdd").parse("19990311");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		UserInfo user = new UserInfo("1", "Leon", "M", birth);
		ArrayList<UserInfo> users = new ArrayList<UserInfo>();
		users.add(user);
		return users;
	}

	

	

}
