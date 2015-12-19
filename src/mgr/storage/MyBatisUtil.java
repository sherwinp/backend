package mgr.storage;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisUtil {
		private static final Logger logger = Logger.getLogger(MyBatisUtil.class.getName());
	 	private static SqlSessionFactory sqlSessionFactory;
		static {
			String resource = "mybatis-config.xml";
			try (Reader reader = Resources.getResourceAsReader(resource)){
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static SqlSessionFactory getSqlSessionFactory(){
			return sqlSessionFactory;
		}
}
