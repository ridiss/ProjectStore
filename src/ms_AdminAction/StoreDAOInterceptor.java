package ms_AdminAction;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class StoreDAOInterceptor implements Interceptor{

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	
	public void destroy() {
		sqlMapper = null;
	}

	
	public void init() {
		try{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		}catch(IOException e){ e.printStackTrace(); }
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		try{
			reader.close();
		}catch(IOException e){ e.printStackTrace(); }
	}

	
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		if(action instanceof StoreDAOAware){
			StoreDAOAware storeDAOAware = (StoreDAOAware)action;
			storeDAOAware.setStoreDAO(sqlMapper);
		}
		return invocation.invoke();
	}

}
