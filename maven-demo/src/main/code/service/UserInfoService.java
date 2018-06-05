package service;

import dto.UserInfo;

public interface UserInfoService {
	/**
	 * 查询同名人员最老的人
	 * @param name
	 */
	public UserInfo queryOldestUserWithTheSameName(String name);
}
