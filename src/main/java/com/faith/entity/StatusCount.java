package com.faith.entity;

public class StatusCount {
	private int statusId;
	private long count;

	public StatusCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatusCount(int statusId, long count) {
		super();
		this.statusId = statusId;
		this.count = count;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
