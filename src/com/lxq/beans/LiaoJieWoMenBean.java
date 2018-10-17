package com.lxq.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="liaojiewomen")
public class LiaoJieWoMenBean {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name = "system-uuid",strategy="uuid")
	@Column(length=32)
	private String id;
	
	@Column(length=500)
	private String title;
	
	@Column(length=25)
	private String type;
	
	@Column(length=20000)
	private String content;
	
	@Column(length=32)
	private Timestamp creatime;
	
	@Column(length=32)
	private String fmimg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatime() {
		return creatime;
	}

	public void setCreatime(Timestamp creatime) {
		this.creatime = creatime;
	}

	public String getFmimg() {
		return fmimg;
	}

	public void setFmimg(String fmimg) {
		this.fmimg = fmimg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
