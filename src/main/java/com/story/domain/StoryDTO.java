package com.story.domain;

import java.time.LocalDateTime;

public class StoryDTO extends CommonDTO {
	private Long num;
	private String title;
	private String contents;
	private String nickname;
	private int count;
	
	private String notiYn;
	private String secYn;
	
	private int lev;
	private String grade;
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getNotiYn() {
		return notiYn;
	}
	public void setNotiYn(String notiYn) {
		this.notiYn = notiYn;
	}
	public String getSecYn() {
		return secYn;
	}
	public void setSecYn(String secYn) {
		this.secYn = secYn;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "StoryDTO [num=" + num + ", title=" + title + ", contents=" + contents + ", nickname=" + nickname
				+ ", count=" + count + ", notiYn=" + notiYn + ", secYn=" + secYn + ", lev=" + lev + ", grade=" + grade
				+ "]";
	}
	
	
	
	
	
//	private String delYn;
//	private LocalDateTime regTime;
//	private LocalDateTime updateTime;
//	private LocalDateTime deleteTime;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
