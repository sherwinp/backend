/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgr.service;

/**
 *
 * @author sherwinp
 */
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
         // start the thread
         
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         // stop the thread
    }
}
