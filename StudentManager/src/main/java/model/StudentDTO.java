package model;

import java.util.Calendar;
import java.util.Date;

public class StudentDTO {
	private int id;
	private String name;
	private int korean;
	private int english;
	private int math;
	private Calendar entryDate;
	private Calendar updatedDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKorean() {
		return korean;
	}
	
	public void setKorean(int korean) {
		this.korean = korean;
	}
	
	public int getEnglish() {
		return english;
	}
	
	public void setEnglish(int english) {
		this.english = english;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public Calendar getEntryDate() {
		return entryDate;
	}
	
	public void setEntryDate(Date entryDate) {
		this.entryDate = Calendar.getInstance();
		this.entryDate.setTime(entryDate);
	}
	
	public Calendar getUpdatedDate() {
		return updatedDate;
	}
	
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = Calendar.getInstance();
		this.updatedDate.setTime(updatedDate);
	}
	
	public boolean equals(Object o) {
		if(o instanceof StudentDTO) {
			StudentDTO s = (StudentDTO) o;
			return id == s.id;
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
