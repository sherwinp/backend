package data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.ibatis.session.SqlSession;

import mgr.storage.MyBatisUtil;
@ManagedBean(name = "onlineUsers", eager = true)
@SessionScoped
public class OnlineUsers {
	private static final Logger logger = Logger.getLogger(OnlineUsers.class.getName());
	public ArrayList<User> getUsers() {
		
		ArrayList<User> userlist = new ArrayList<User>();
		Users users = null;
		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			logger.info("database connection established.");
			users = sqlSession.getMapper(Users.class);
			userlist.add(users.selectUserById(1));
		} finally {

		}
		return userlist;
		
	}
}
