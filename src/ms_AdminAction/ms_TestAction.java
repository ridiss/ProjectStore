package ms_AdminAction;

import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

public class ms_TestAction extends ActionSupport implements StoreDAOAware{

	private SqlMapClient sqlMapper;
	private List<ms_AdminDTO> list;

	public void setStoreDAO(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}
	
	public String execute() throws Exception{
		list = new ArrayList<ms_AdminDTO>(); 
		//������ list�� �ְ�
		list = sqlMapper.queryForList("ms_SelectAll"); //����� �������϶� queryForList,������ϳ��� queryForObject
		
		return SUCCESS;
	}
	public SqlMapClient getSqlMapper() {
		return sqlMapper;
	}
	public void setSqlMapper(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}
	public List<ms_AdminDTO> getList() {
		return list;
	}
	public void setList(List<ms_AdminDTO> list) {
		this.list = list;
	}

}
