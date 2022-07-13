package com.comp.view;

public class ListResponseView {
	private long totalCount;
	private Object list;
	@Override
	public String toString() {
		return "ListResponseView [totalCount=" + totalCount + ", list=" + list + "]";
	}
	public ListResponseView(long totalCount, Object list) {
		super();
		this.totalCount = totalCount;
		this.list = list;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public Object getList() {
		return list;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public void setList(Object list) {
		this.list = list;
	}
}
