package ms_AdminAction;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface StoreDAOAware {
	public void setStoreDAO(SqlMapClient sqlMapper);
}
