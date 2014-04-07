package ms_AdminAction;

import java.util.*;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

public class ms_ListAction extends ActionSupport implements StoreDAOAware{

	SqlMapClient sqlMapper;
	
	private List<ms_AdminDTO> list;
	private int currentPage = 1;  //���� ������
	private int totalCount;  //�ѰԽù��� ��
	private int blockCount = 10;  //�� �������� �Խù���
	private int blockPage = 5; //�� ȭ�鿡 ������ �������� ��
	private String pagingHtml; //����¡�� ������ HTML
	private ms_PagingAction page;  //����¡ Ŭ����
	
	public void setStoreDAO(SqlMapClient sqlMapper) {
		this.sqlMapper= sqlMapper;
	}
    //�Խ��� LIST �׼�
	public String execute() throws Exception{
		list = new ArrayList<ms_AdminDTO>(); 
		//������ list�� �ְ�
		list = sqlMapper.queryForList("ms_SelectAll"); //����� �������϶� queryForList,������ϳ��� queryForObject
		totalCount = list.size(); //��ü �� ����
		page = new ms_PagingAction(currentPage, totalCount, blockCount, blockPage);//ms_PagingAction��ü ����
		pagingHtml = page.getPagingHtml().toString(); //������ HTML����
		
		//���� ���������� ������ ������ ���� ��ȣ
		int lastCount = totalCount;
		//���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1��ȣ�� ����
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() +1;
		//��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� ������
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
