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

import mgr.storage.MyBatisUtil;

public class MyListener implements ServletContextListener {
	private static final Logger logger = Logger.getLogger(MyBatisUtil.class.getName());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
         // start the thread
    	MyBatisUtil.getSqlSessionFactory();
    	logger.info("database connection established.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         // stop the thread
    }
}
