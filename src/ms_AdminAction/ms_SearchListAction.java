package ms_AdminAction;

import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

public class ms_SearchListAction extends ActionSupport implements StoreDAOAware {

	SqlMapClient sqlMapper;

	private List<ms_AdminDTO> list;
	private int currentPage; // 현재 페이지
	private int totalCount; // 총게시물의 수
	private int blockCount = 10; // 한 페이지의 게시물수
	private int blockPage = 5; // 한 화면에 보여줄 페이지의 수
	private String SearchPagingHtml; // 페이징을 구현한 HTML
	private ms_SearchPagingAction page; // 페이징 클래스
	private String result;

	private String searchStore; // text에서 매장이름 써서 검색

	public void setStoreDAO(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}

	public String execute() throws Exception {
		
		if ("".equals(searchStore)) { //검색값이 없으면
			result = "LIST";
		} else { //검색 값이 있으면
			list = new ArrayList<ms_AdminDTO>();
			// 모든글을 list에 넣고
			list = sqlMapper.queryForList("ms_SelectStore", searchStore); // 결과가
																		// 여러개일때
																		// queryForList,결과가하나면
																		// queryForObject
			totalCount = list.size(); // 전체 글 갯수
			page = new ms_SearchPagingAction(currentPage, totalCount,
					blockCount, blockPage, searchStore);// ms_PagingAction객체 생성
			SearchPagingHtml = page.getSearchPagingHtml().toString(); // 페이지
																		// HTML생성

			// 현재 페이지에서 보여줄 마지막 글의 번호
			int lastCount = totalCount;
			// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1번호로 설정
			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			// 전체 리스트에서 현재 페이지만큼의 리스트만 가져옴
			list = list.subList(page.getStartCount(), lastCount);

			result = "SUCCESS";
		}
		return result;
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

	public String getSearchPagingHtml() {
		return SearchPagingHtml;
	}

	public void setSearchPagingHtml(String searchPagingHtml) {
		SearchPagingHtml = searchPagingHtml;
	}

	public ms_SearchPagingAction getPage() {
		return page;
	}

	public void setSearchPage(ms_SearchPagingAction page) {
		this.page = page;
	}

	public String getSearchStore() {
		return searchStore;
	}

	public void setSearchStore(String searchStore) {
		this.searchStore = searchStore;
	}

}
