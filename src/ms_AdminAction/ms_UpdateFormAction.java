package ms_AdminAction;

import java.io.File;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ms_UpdateFormAction extends ActionSupport implements StoreDAOAware, Preparable, ModelDriven {

	private SqlMapClient sqlMapper;
	private ms_AdminDTO msDTO;
	private int currentPage;
	
	
	public Object getModel() {return msDTO;}
	
	public void prepare() throws Exception {msDTO = new ms_AdminDTO();}
	
	public void setStoreDAO(SqlMapClient sqlMapper) {this.sqlMapper = sqlMapper;	}
	
	public String execute() throws Exception{
		
		try{// DB에서 하나의 테이블을 가져오는 부분
			msDTO = (ms_AdminDTO)sqlMapper.queryForObject("ms_SelectOne",msDTO.getNo());
		}catch(Exception e){e.printStackTrace();}		
		
		return SUCCESS;
	}
	
	public SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public void setSqlMapper(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}

	public ms_AdminDTO getMsDTO() {
		return msDTO;
	}

	public void setMsDTO(ms_AdminDTO msDTO) {
		this.msDTO = msDTO;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
