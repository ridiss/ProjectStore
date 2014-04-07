package ms_AdminAction;

import java.io.File;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ms_DeleteAction extends ActionSupport implements StoreDAOAware, Preparable, ModelDriven{

	private SqlMapClient sqlMapper;
	private ms_AdminDTO msDTO;
	private int currentPage;
	//삭제할 파일 경로
	private String s_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\store\\"; 
	private String ma_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\a\\";
	private String mb_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\b\\";
	private String mc_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\c\\";
	
	public Object getModel() {return msDTO;}
	public void prepare() throws Exception {msDTO = new ms_AdminDTO();}
	public void setStoreDAO(SqlMapClient sqlMapper) {this.sqlMapper = sqlMapper;	}
	
	public String execute() throws Exception{
		msDTO = (ms_AdminDTO)sqlMapper.queryForObject("ms_SelectOne", msDTO.getNo()); //리턴타입 object라 형변환해서 넣어줌
		
		File s_deleteFile = new File(s_FileUploadPath + msDTO.getSfile_Savname());
		File ma_deleteFile = new File(ma_FileUploadPath + msDTO.getM_Afile_Savname());
		File mb_deleteFile = new File(ma_FileUploadPath + msDTO.getM_Bfile_Savname());
		File mc_deleteFile = new File(ma_FileUploadPath + msDTO.getM_Cfile_Savname());
		s_deleteFile.delete();
		ma_deleteFile.delete();
		mb_deleteFile.delete();
		mc_deleteFile.delete(); //파일삭제 명령메서드
		
		sqlMapper.update("ms_DeleteStore",msDTO);
		
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
	public String getS_FileUploadPath() {
		return s_FileUploadPath;
	}
	public void setS_FileUploadPath(String s_FileUploadPath) {
		this.s_FileUploadPath = s_FileUploadPath;
	}
	public String getMa_FileUploadPath() {
		return ma_FileUploadPath;
	}
	public void setMa_FileUploadPath(String ma_FileUploadPath) {
		this.ma_FileUploadPath = ma_FileUploadPath;
	}
	public String getMb_FileUploadPath() {
		return mb_FileUploadPath;
	}
	public void setMb_FileUploadPath(String mb_FileUploadPath) {
		this.mb_FileUploadPath = mb_FileUploadPath;
	}
	public String getMc_FileUploadPath() {
		return mc_FileUploadPath;
	}
	public void setMc_FileUploadPath(String mc_FileUploadPath) {
		this.mc_FileUploadPath = mc_FileUploadPath;
	}

}
