package ms_AdminAction;

public class ms_SearchPagingAction {
	

	private int currentPage;   // 현재페이지
	private int totalCount;	 // 전체 게시물 수
	private int totalPage;	 // 전체 페이지 수
	private int blockCount;	 // 한 페이지의  게시물의 수
	private int blockPage;	 // 한 화면에 보여줄 페이지 수
	private int startCount;	 // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount;	 // 한 페이지에서 보여줄 게시글의 끝 번호
	private int startPage;	 // 시작 페이지
	private int endPage;	 // 마지막 페이지
	private String searchStore;

	private StringBuffer SearchPagingHtml;

	// 페이징 생성자
	public ms_SearchPagingAction(int currentPage, int totalCount, int blockCount,
			int blockPage, String searchStore) {
		

		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.searchStore = searchStore;
		// 전체 페이지 수
		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// 현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// 현재 페이지의 처음과 마지막 글의 번호 가져오기.
		startCount = (currentPage - 1) * blockCount;
		endCount = startCount + blockCount - 1;

		// 시작 페이지와 마지막 페이지 값 구하기.
		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;

		// 마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// 이전 block 페이지
		SearchPagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			SearchPagingHtml.append("<a href=ms_SearchListAction.action?currentPage="
					+ (startPage - 1) + ">");
			SearchPagingHtml.append("이전");
			SearchPagingHtml.append("</a>");
		}

		SearchPagingHtml.append("&nbsp;|&nbsp;");

		//페이지 번호.현재 페이지는 빨간색으로 강조하고 링크를 제거.
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

		// 다음 block 페이지
		if (totalPage - startPage >= blockPage) {
			SearchPagingHtml.append("<a href=ms_SearchListAction.action?currentPage="
					+ (endPage + 1) + ">");
			SearchPagingHtml.append("다음");
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
