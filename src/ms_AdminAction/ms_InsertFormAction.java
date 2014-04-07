package ms_AdminAction;

import java.io.File;

import java.util.*;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ms_InsertFormAction extends ActionSupport implements StoreDAOAware, Preparable, ModelDriven{

	private SqlMapClient sqlMapper; //SqlMapClient API사용할 객체
	private ms_AdminDTO msDTO; //파라미터 저장 DTO
	private int currentPage; //현재 페이지
	Calendar today = Calendar.getInstance(); //오늘 날짜 구하는 부분
	
	private String s_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\store\\"; //업로드 경로
	private String ma_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\a\\";
	private String mb_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\b\\";
	private String mc_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\c\\";
	
	private File s_Upload; //매장이미지 파일 객체
	private String s_UploadContentType; //컨텐츠 타입
	private String s_UploadFileName; //파일 이름
	
	private File ma_Upload; //메뉴 A이미지 객체
	private String ma_UploadContentType; 
	private String ma_UploadFileName;
	
	private File mb_Upload; //메뉴B
	private String mb_UploadContentType;
	private String mb_UploadFileName; 
	
	private File mc_Upload; //메뉴C
	private String mc_UploadContentType; 
	private String mc_UploadFileName;
	
	public String form() throws Exception {
	  // System.out.println("method form");
		return SUCCESS;
	}
	
	public Object getModel() {
		// System.out.println("getModel");
		return msDTO;
	}

	
	public void prepare() throws Exception {
		 //System.out.println("prepare");
		msDTO = new ms_AdminDTO();
	}

	
	public void setStoreDAO(SqlMapClient sqlMapper) {
		// System.out.println("setStoreDAO");
		this.sqlMapper = sqlMapper;
		
	}
	
	//메뉴 등록 액션
	public String execute() throws Exception{
		 //System.out.println("execute");
		msDTO.setSreg_Date(today.getTime()); //시간넣는 부분
		sqlMapper.insert("ms_InsertStore", msDTO); //ibatis 인서트 사용구문
		msDTO = (ms_AdminDTO)sqlMapper.queryForObject("ms_SelectLastNo"); //no 최대값 가져오기
		
		if(getS_Upload() != null){
			//실제 서버에 저장될 파일 이름과 확장자 설정
			String file_name= "file_" + msDTO.getNo();  //msDTO가 100이면 file_100이렇게 savname이 만들어짐
			String file_ext = getS_UploadFileName().substring(
					getS_UploadFileName().lastIndexOf('.') +1,
					getS_UploadFileName().length()
					);
			//서버에 파일 저장
			File destFile = new File(s_FileUploadPath + file_name +"." + file_ext); //e:\\testUpload\\file_100.jsp로 저장
			FileUtils.copyFile(getS_Upload(), destFile);
			
			//파일정보 파라미터 설정
			msDTO.setNo(msDTO.getNo());
			msDTO.setSfile_Orgname(getS_UploadFileName());
			msDTO.setSfile_Savname(file_name+"."+file_ext);
			
			//파일 정보 업데이트
			sqlMapper.update("s_UpdateFile",msDTO);
		}
		if(getMa_Upload() != null){
			String file_name= "file_" + msDTO.getNo(); 
			String file_ext = getMa_UploadFileName().substring(
					getMa_UploadFileName().lastIndexOf('.') +1,
					getMa_UploadFileName().length()
					);
			
			File destFile = new File(ma_FileUploadPath + file_name +"." + file_ext); 
			FileUtils.copyFile(getMa_Upload(), destFile);
			
			
			msDTO.setNo(msDTO.getNo());
			msDTO.setM_Afile_Orgname(getMa_UploadFileName());
			msDTO.setM_Afile_Savname(file_name+"."+file_ext);
			
			sqlMapper.update("ma_UpdateFile",msDTO);
		}
        if(getMb_Upload() != null){
			String file_name= "file_" + msDTO.getNo();  
			String file_ext = getMb_UploadFileName().substring(
					getMb_UploadFileName().lastIndexOf('.') +1,
					getMb_UploadFileName().length()
					);
			
			File destFile = new File(mb_FileUploadPath + file_name +"." + file_ext); 
			FileUtils.copyFile(getMb_Upload(), destFile);
			
			msDTO.setNo(msDTO.getNo());
			msDTO.setM_Bfile_Orgname(getMb_UploadFileName());
			msDTO.setM_Bfile_Savname(file_name+"."+file_ext);
			
			sqlMapper.update("mb_UpdateFile",msDTO);
	    }
        if(getMc_Upload() != null){
			String file_name= "file_" + msDTO.getNo();  
			String file_ext = getMc_UploadFileName().substring(
					getMc_UploadFileName().lastIndexOf('.') +1,
					getMc_UploadFileName().length()
					);
			
			File destFile = new File(mc_FileUploadPath + file_name +"." + file_ext);
			FileUtils.copyFile(getMc_Upload(), destFile);
			
			
			msDTO.setNo(msDTO.getNo());
			msDTO.setM_Cfile_Orgname(getMc_UploadFileName());
			msDTO.setM_Cfile_Savname(file_name+"."+file_ext);
			
			sqlMapper.update("mc_UpdateFile",msDTO);
        }
        return SUCCESS;
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

	public File getS_Upload() {
		return s_Upload;
	}

	public void setS_Upload(File s_Upload) {
		this.s_Upload = s_Upload;
	}

	public String getS_UploadContentType() {
		return s_UploadContentType;
	}

	public void setS_UploadContentType(String s_UploadContentType) {
		this.s_UploadContentType = s_UploadContentType;
	}

	public String getS_UploadFileName() {
		return s_UploadFileName;
	}

	public void setS_UploadFileName(String s_UploadFileName) {
		this.s_UploadFileName = s_UploadFileName;
	}

	public File getMa_Upload() {
		return ma_Upload;
	}

	public void setMa_Upload(File ma_Upload) {
		this.ma_Upload = ma_Upload;
	}

	public String getMa_UploadContentType() {
		return ma_UploadContentType;
	}

	public void setMa_UploadContentType(String ma_UploadContentType) {
		this.ma_UploadContentType = ma_UploadContentType;
	}

	public String getMa_UploadFileName() {
		return ma_UploadFileName;
	}

	public void setMa_UploadFileName(String ma_UploadFileName) {
		this.ma_UploadFileName = ma_UploadFileName;
	}

	public File getMb_Upload() {
		return mb_Upload;
	}

	public void setMb_Upload(File mb_Upload) {
		this.mb_Upload = mb_Upload;
	}

	public String getMb_UploadContentType() {
		return mb_UploadContentType;
	}

	public void setMb_UploadContentType(String mb_UploadContentType) {
		this.mb_UploadContentType = mb_UploadContentType;
	}

	public String getMb_UploadFileName() {
		return mb_UploadFileName;
	}

	public void setMb_UploadFileName(String mb_UploadFileName) {
		this.mb_UploadFileName = mb_UploadFileName;
	}

	public File getMc_Upload() {
		return mc_Upload;
	}

	public void setMc_Upload(File mc_Upload) {
		this.mc_Upload = mc_Upload;
	}

	public String getMc_UploadContentType() {
		return mc_UploadContentType;
	}

	public void setMc_UploadContentType(String mc_UploadContentType) {
		this.mc_UploadContentType = mc_UploadContentType;
	}

	public String getMc_UploadFileName() {
		return mc_UploadFileName;
	}

	public void setMc_UploadFileName(String mc_UploadFileName) {
		this.mc_UploadFileName = mc_UploadFileName;
	}
	

}
