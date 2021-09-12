${copyright}

package ${modulePackage}.utils;

/**
 * @author alan.yang.zhang
 * @version ${.now?date}
 */

public class SearchCondition<T> {

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getcurrentRow() {
		if (currentPage > 0 && pageSize > 0) {
			if (currentPage < 1) {
				currentPage = 1;
			}

			return (currentPage - 1) * pageSize;
		}

		return 0;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	private T data;
	
	private int pageSize;
	
	private int currentPage;

	private String orderBy;

	private String keyword;
}
