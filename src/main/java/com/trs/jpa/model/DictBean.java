package com.trs.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_MLF_CDWH_CKMDICT")
public class DictBean {
	@Id
	@Column(name="ID",length=25)
	private String id;
	@Column(name="DICTNUM",length=25)
	private String dictNum;
	@Column(name="DICTNAME",length=25)
	private String dictName;
	@Column(name="CONTENT",columnDefinition="TEXT")
	private String content;
	@Column(name="SECTION",length=100)
	private String section;
	@Column(name="TYPE",length=11)
	private String type;
	@Column(name="ORDERNUM",length=3)
	private Integer orderNum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDictNum() {
		return dictNum;
	}
	public String getDictName() {
		return dictName;
	}
	public String getContent() {
		return content;
	}
	public String getSection() {
		return section;
	}
	public void setDictNum(String dictNum) {
		this.dictNum = dictNum;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getType() {
		return type;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
