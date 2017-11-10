package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_rctrexist database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_rctrexist")
//@NamedQuery(name="RqtRctrexist.findAll", query="SELECT r FROM RqtRctrexist r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtRctrexist extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_RCTREXIST_ID_GENERATOR", sequenceName="rqtrctrexist_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_RCTREXIST_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=255)
	private String email;

	@Column(length=255)
	private String nm;

	private Long result;

	public RqtRctrexist() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNm() {
		return this.nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public Long getResult() {
		return this.result;
	}

	public void setResult(Long result) {
		this.result = result;
	}

}