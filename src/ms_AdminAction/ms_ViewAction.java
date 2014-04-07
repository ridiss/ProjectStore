package ms_AdminAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ms_ViewAction extends ActionSupport implements StoreDAOAware, Preparable, ModelDriven{

	private SqlMapClient sqlMapper;
	private ms_AdminDTO msDTO;
    private int currentPage;
    
    private String s_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\store\\"; //업로드 경로
	private String ma_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\a\\";
	private String mb_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\b\\";
	private String mc_FileUploadPath = "E:\\Javaclass\\workspace\\ProjectStore\\WebContent\\ms_UploadFile\\c\\";
	
	private InputStream s_InputStream;
	private String s_ContentDisposition;
	private long s_ContentLength;
	
	private InputStream ma_InputStream;
	private String ma_ContentDisposition;
	private long ma_ContentLength;
	
	private InputStream mb_InputStream;
	private String mb_ContentDisposition;
	private long mb_ContentLength;
	
	private InputStream mc_InputStream;
	private String mc_ContentDisposition;
	private long mc_ContentLength;
	
	
	public Object getModel() {
		return msDTO;
	}

	public void prepare() throws Exception {
		msDTO = new ms_AdminDTO();
	}
	
	public void setStoreDAO(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}
	
	public String execute() throws Exception{
		try{// DB에서 하나의 테이블을 가져오는 부분
			msDTO = (ms_AdminDTO)sqlMapper.queryForObject("ms_SelectOne",msDTO.getNo());
		}catch(Exception e){e.printStackTrace();}		
		return SUCCESS;
	}
	
	
	public String s_Download() throws Exception{
		//해당 번호의 파일 정보
		msDTO = (ms_AdminDTO)sqlMapper.queryForObject("ms_SelectOne", msDTO.getNo());
		//파일 경로와 파일명을 file객체에 넣음
		File fileInfo = new File(s_FileUploadPath + msDTO.getSfile_Savname());
		
		//다운로드 파일 정보 설정.
		setS_ContentLength(fileInfo.length());
		setS_ContentDisposition("attachment;filename="
				+ URLEncoder.encode(msDTO.getSfile_Orgname(), "UTF-8"));
		setS_InputStream(new FileInputStream(s_FileUploadPath
				+ msDTO.getSfile_Savname()));
		
		return SUCCESS;
	}
	public String ma_Download() throws Exception{
		//해당 번호의 파일 정보
		msDTO = (ms_AdminDTO)sqlMapper.queryForObject("ms_SelectOne", msDTO.getNo());
		//파일 경로와 파일명을 file객체에 넣음
		File fileInfo = new File(ma_FileUploadPath + msDTO.getM_Afile_Savname());
		
		//다운로드 파일 정보 설정.
		setMa_ContentLength(fileInfo.length());
		setMa_ContentDisposition("attachment;filename="
				+ URLEncoder.encode(msDTO.getM_Afile_Orgname(), "UTF-8"));
		setMa_InputStream(new FileInputStream(ma_FileUploadPath
				+ msDTO.getM_Afile_Savname()));
		
		return SUCCESS;
	}
	public String mb_Download() throws Exception{
		//해당 번호의 파일 정보
		msDTO = (ms_AdminDTO)sqlMapper.queryForObject("ms_SelectOne", msDTO.getNo());
		//파일 경로와 파일명을 file객체에 넣음
		File fileInfo = new File(mb_FileUploadPath + msDTO.getM_Bfile_Savname());
		
		//다운로드 파일 정보 설정.
		setMb_ContentLength(fileInfo.length());
		setMb_ContentDisposition("attachment;filename="
				+ URLEncoder.encode(msDTO.getM_Bfile_Orgname(), "UTF-8"));
		setMb_InputStream(new FileInputStream(mb_FileUploadPath
				+ msDTO.getM_Bfile_Savname()));
		
		return SUCCESS;
	}
	public String mc_Download() throws Exception{
		//해당 번호의 파일 정보
		msDTO = (ms_AdminDTO)sqlMapper.queryForObject("ms_SelectOne", msDTO.getNo());
		//파일 경로와 파일명을 file객체에 넣음
		File fileInfo = new File(mc_FileUploadPath + msDTO.getM_Cfile_Savname());
		
		//다운로드 파일 정보 설정.
		setMc_ContentLength(fileInfo.length());
		setMc_ContentDisposition("attachment;filename="
				+ URLEncoder.encode(msDTO.getM_Cfile_Orgname(), "UTF-8"));
		setMc_InputStream(new FileInputStream(mc_FileUploadPath
				+ msDTO.getM_Cfile_Savname()));
		
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

	public InputStream getS_InputStream() {
		return s_InputStream;
	}

	public void setS_InputStream(InputStream s_InputStream) {
		this.s_InputStream = s_InputStream;
	}

	public String getS_ContentDisposition() {
		return s_ContentDisposition;
	}

	public void setS_ContentDisposition(String s_ContentDisposition) {
		this.s_ContentDisposition = s_ContentDisposition;
	}

	public long getS_ContentLength() {
		return s_ContentLength;
	}

	public void setS_ContentLength(long s_ContentLength) {
		this.s_ContentLength = s_ContentLength;
	}

	public InputStream getMa_InputStream() {
		return ma_InputStream;
	}

	public void setMa_InputStream(InputStream ma_InputStream) {
		this.ma_InputStream = ma_InputStream;
	}

	public String getMa_ContentDisposition() {
		return ma_ContentDisposition;
	}

	public void setMa_ContentDisposition(String ma_ContentDisposition) {
		this.ma_ContentDisposition = ma_ContentDisposition;
	}

	public long getMa_ContentLength() {
		return ma_ContentLength;
	}

	public void setMa_ContentLength(long ma_ContentLength) {
		this.ma_ContentLength = ma_ContentLength;
	}

	public InputStream getMb_InputStream() {
		return mb_InputStream;
	}

	public void setMb_InputStream(InputStream mb_InputStream) {
		this.mb_InputStream = mb_InputStream;
	}

	public String getMb_ContentDisposition() {
		return mb_ContentDisposition;
	}

	public void setMb_ContentDisposition(String mb_ContentDisposition) {
		this.mb_ContentDisposition = mb_ContentDisposition;
	}

	public long getMb_ContentLength() {
		return mb_ContentLength;
	}

	public void setMb_ContentLength(long mb_ContentLength) {
		this.mb_ContentLength = mb_ContentLength;
	}

	public InputStream getMc_InputStream() {
		return mc_InputStream;
	}

	public void setMc_InputStream(InputStream mc_InputStream) {
		this.mc_InputStream = mc_InputStream;
	}

	public String getMc_ContentDisposition() {
		return mc_ContentDisposition;
	}

	public void setMc_ContentDisposition(String mc_ContentDisposition) {
		this.mc_ContentDisposition = mc_ContentDisposition;
	}

	public long getMc_ContentLength() {
		return mc_ContentLength;
	}

	public void setMc_ContentLength(long mc_ContentLength) {
		this.mc_ContentLength = mc_ContentLength;
	}

}
