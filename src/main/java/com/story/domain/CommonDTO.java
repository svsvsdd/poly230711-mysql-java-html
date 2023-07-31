package com.story.domain;

import java.time.LocalDateTime;

import com.story.paging.Criteria;
import com.story.paging.PaginationInfo;

public class CommonDTO extends Criteria {
	private PaginationInfo paginationInfo;
	private String delYn;
	private LocalDateTime regTime;
	private LocalDateTime updateTime;
	private LocalDateTime deleteTime;
	
	public PaginationInfo getPaginationInfo() {
		return paginationInfo;
	}
	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public LocalDateTime getRegTime() {
		return regTime;
	}
	public void setRegTime(LocalDateTime regTime) {
		this.regTime = regTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}
	
	@Override
	public String toString() {
		return "CommonDTO [paginationInfo=" + paginationInfo + ", delYn=" + delYn + ", regTime=" + regTime
				+ ", updateTime=" + updateTime + ", deleteTime=" + deleteTime + "]";
	}
	
	
}
