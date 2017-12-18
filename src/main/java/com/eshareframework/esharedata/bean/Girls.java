package com.eshareframework.esharedata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="girls")
public class Girls {

	private int id;
	private String sname;
	private String cometime;
	private int age;
	private String maxscore;
	private String minscore;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="sname")
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Column(name="cometime")
	public String getCometime() {
		return cometime;
	}
	
	
	public void setCometime(String cometime) {
		this.cometime = cometime;
	}
	
	@Column(name="age")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column(name="maxscore")
	public String getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(String maxscore) {
		this.maxscore = maxscore;
	}
	
	@Column(name="minscore")
	public String getMinscore() {
		return minscore;
	}
	public void setMinscore(String minscore) {
		this.minscore = minscore;
	}
	
	
}
