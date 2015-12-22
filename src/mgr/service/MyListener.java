/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgr.service;

import java.util.logging.Logger;

/**
 *
 * @author sherwinp
 */
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.session.SqlSession;

import data.model.User;
import data.model.Users;
import mgr.storage.MyBatisUtil;

public class MyListener implements ServletContextListener {
	private static final Logger logger = Logger.getLogger(MyListener.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// start the thread
//		Users users = null;
//		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
//			logger.info("database connection established.");
//			users = sqlSession.getMapper(Users.class);
//		} finally {
//
//		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// stop the thread
	}
}
