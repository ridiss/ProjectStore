package ms_AdminAction;

public class ms_SearchPagingAction {
	

	private int currentPage;   // ����������
	private int totalCount;	 // ��ü �Խù� ��
	private int totalPage;	 // ��ü ������ ��
	private int blockCount;	 // �� ��������  �Խù��� ��
	private int blockPage;	 // �� ȭ�鿡 ������ ������ ��
	private int startCount;	 // �� ���������� ������ �Խñ��� ���� ��ȣ
	private int endCount;	 // �� ���������� ������ �Խñ��� �� ��ȣ
	private int startPage;	 // ���� ������
	private int endPage;	 // ������ ������
	private String searchStore;

	private StringBuffer SearchPagingHtml;

	// ����¡ ������
	public ms_SearchPagingAction(int currentPage, int totalCount, int blockCount,
			int blockPage, String searchStore) {
		

		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.searchStore = searchStore;
		// ��ü ������ ��
		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// ���� �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// ���� �������� ó���� ������ ���� ��ȣ ��������.
		startCount = (currentPage - 1) * blockCount;
		endCount = startCount + blockCount - 1;

		// ���� �������� ������ ������ �� ���ϱ�.
		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;

		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// ���� block ������
		SearchPagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			SearchPagingHtml.append("<a href=ms_SearchListAction.action?currentPage="
					+ (startPage - 1) + ">");
			SearchPagingHtml.append("����");
			SearchPagingHtml.append("</a>");
		}

		SearchPagingHtml.append("&nbsp;|&nbsp;");

		//������ ��ȣ.���� �������� ���������� �����ϰ� ��ũ�� ����.
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				SearchPagingHtml.append("&nbsp;<b> <font color='red'>");
				SearchPagingHtml.append(i);
				SearchPagingHtml.append("</font></b>");
			} else {
				SearchPagingHtml
						.append("&nbsp;<a href='ms_SearchListAction.action?currentPage=");
				SearchPagingHtml.append(i);
				SearchPagingHtml.append("&searchStore=");
				SearchPagingHtml.append(searchStore);
				SearchPagingHtml.append("'>");
				SearchPagingHtml.append(i);
				SearchPagingHtml.append("</a>");
			}

			SearchPagingHtml.append("&nbsp;");
		}

		SearchPagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");

		// ���� block ������
		if (totalPage - startPage >= blockPage) {
			SearchPagingHtml.append("<a href=ms_SearchListAction.action?currentPage="
					+ (endPage + 1) + ">");
			SearchPagingHtml.append("����");
			SearchPagingHtml.append("</a>");
		}
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public StringBuffer getSearchPagingHtml() {
		return SearchPagingHtml;
	}

	public void setSearchPagingHtml(StringBuffer searchPagingHtml) {
		SearchPagingHtml = searchPagingHtml;
	}

	public String getSearchStore() {
		return searchStore;
	}

	public void setSearchStore(String searchStore) {
		this.searchStore = searchStore;
	}


}
