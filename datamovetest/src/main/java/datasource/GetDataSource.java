package datasource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class GetDataSource {
	

private static final Map<DataSourceEnvironment, SqlSessionFactory> SQLSESSIONFACTORYS   
  = new HashMap<DataSourceEnvironment, SqlSessionFactory>();  

/** 
* 根据指定的DataSourceEnvironment获取对应的SqlSessionFactory 
* @param environment 数据源environment 
* @return SqlSessionFactory 
*/  
public static SqlSessionFactory getSqlSessionFactory(DataSourceEnvironment environment) {  
    
  SqlSessionFactory sqlSessionFactory = SQLSESSIONFACTORYS.get(environment);  
  if (sqlSessionFactory != null)  
      return sqlSessionFactory;  
  else {  
      InputStream inputStream = null;  
      try {  
    	  File file = new File("D:/workspace/datamovetest/src/resources/sqlmap.xml");
    	  inputStream = new FileInputStream(file);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, environment.name());  
            
      } catch (IOException e) {  
    	  e.printStackTrace();
      }  
      finally {  
          IOUtils.closeQuietly(inputStream);  
      }  
        
      SQLSESSIONFACTORYS.put(environment, sqlSessionFactory);  
      return sqlSessionFactory;  
  }  
}  

public static enum DataSourceEnvironment {  
	development,  
	  qa;  
	} 

	
	public static <T> T getdatasource(Class<T> t,DataSourceEnvironment source){
		SqlSessionFactory factory = GetDataSource.getSqlSessionFactory(source);
		SqlSession session = factory.openSession(true);
		T mapper = session.getMapper(t);
		return mapper;
	}
	
	public static SqlSession getSqlSession(DataSourceEnvironment source){
		SqlSessionFactory factory = GetDataSource.getSqlSessionFactory(source);
		SqlSession session = factory.openSession(false);
		return session;
	}
	
	public static <T> T getMapper(Class<T> t ,SqlSession session){
		T mapper =  session.getMapper(t);
		return mapper;
	}
	
}
