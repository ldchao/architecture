package dao;

import Entity.User;

public interface UserDao {
	
	//向数据库里添加一个用户, 返回生成的id
	public int addAUser(User user);
	
	//用user来替换原来的用户，达到修改目的
	public void modifyUser(User user);
	
	//通过id删用户
	public boolean deleteUser(int id);
	
	//通过电子邮件获得user
	public User getUserByEmail(String email);
	
	//通过ID获得user
	public User getUserByID(int id);
	
}
