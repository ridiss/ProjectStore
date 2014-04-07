package ms_AdminAction;

import java.util.*;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

public class ms_ListAction extends ActionSupport implements StoreDAOAware{

	SqlMapClient sqlMapper;
	
	private List<ms_AdminDTO> list;
	private int currentPage = 1;  //현재 페이지
	private int totalCount;  //총게시물의 수
	private int blockCount = 10;  //한 페이지의 게시물수
	private int blockPage = 5; //한 화면에 보여줄 페이지의 수
	private String pagingHtml; //페이징을 구현한 HTML
	private ms_PagingAction page;  //페이징 클래스
	
	public void setStoreDAO(SqlMapClient sqlMapper) {
		this.sqlMapper= sqlMapper;
	}
    //게시판 LIST 액션
	public String execute() throws Exception{
		list = new ArrayList<ms_AdminDTO>(); 
		//모든글을 list에 넣고
		list = sqlMapper.queryForList("ms_SelectAll"); //결과가 여러개일때 queryForList,결과가하나면 queryForObject
		totalCount = list.size(); //전체 글 갯수
		page = new ms_PagingAction(currentPage, totalCount, blockCount, blockPage);//ms_PagingAction객체 생성
		pagingHtml = page.getPagingHtml().toString(); //페이지 HTML생성
		
		//현재 페이지에서 보여줄 마지막 글의 번호
		int lastCount = totalCount;
		//현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1번호로 설정
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() +1;
		//전체 리스트에서 현재 페이지만큼의 리스트만 가져옴
		list = list.subList(page.getStartCount(), lastCount);
		
		return SUCCESS;
	}
	public List<ms_AdminDTO> getList() {
		return list;
	}
	public void setList(List<ms_AdminDTO> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public String getPagingHtml() {
		return pagingHtml;
	}
	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	public ms_PagingAction getPage() {
		return page;
	}
	public void setPage(ms_PagingAction page) {
		this.page = page;
	}

}
