package builder;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlBuilder {
	public static SqlSessionFactory build() {
		String resource = "config/mybatis-config.xml";
		
	 	try {
			InputStream stream = Resources.getResourceAsStream(resource);
			return new SqlSessionFactoryBuilder().build(stream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	 	
	 	return null;
	 	
	}
}
