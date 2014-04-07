package ms_AdminAction;

import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

public class ms_SearchListAction extends ActionSupport implements StoreDAOAware {

	SqlMapClient sqlMapper;

	private List<ms_AdminDTO> list;
	private int currentPage; // ���� ������
	private int totalCount; // �ѰԽù��� ��
	private int blockCount = 10; // �� �������� �Խù���
	private int blockPage = 5; // �� ȭ�鿡 ������ �������� ��
	private String SearchPagingHtml; // ����¡�� ������ HTML
	private ms_SearchPagingAction page; // ����¡ Ŭ����
	private String result;

	private String searchStore; // text���� �����̸� �Ἥ �˻�

	public void setStoreDAO(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}

	public String execute() throws Exception {
		
		if ("".equals(searchStore)) { //�˻����� ������
			result = "LIST";
		} else { //�˻� ���� ������
			list = new ArrayList<ms_AdminDTO>();
			// ������ list�� �ְ�
			list = sqlMapper.queryForList("ms_SelectStore", searchStore); // �����
																		// �������϶�
																		// queryForList,������ϳ���
																		// queryForObject
			totalCount = list.size(); // ��ü �� ����
			page = new ms_SearchPagingAction(currentPage, totalCount,
					blockCount, blockPage, searchStore);// ms_PagingAction��ü ����
			SearchPagingHtml = page.getSearchPagingHtml().toString(); // ������
																		// HTML����

			// ���� ���������� ������ ������ ���� ��ȣ
			int lastCount = totalCount;
			// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1��ȣ�� ����
			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� ������
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
