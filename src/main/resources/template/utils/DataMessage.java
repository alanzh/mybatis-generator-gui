${copyright}

package com.accenture.digital.common.utils;

/**
 * @author alan.yang.zhang
 *
 */
public class DataMessage<T> extends IMessage<T> {

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	private int pageSize;
	
	private int curPage;

	private int total;

}
