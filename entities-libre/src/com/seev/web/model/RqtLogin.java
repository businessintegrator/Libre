package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_login database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_login")
//@NamedQuery(name="RqtLogin.findAll", query="SELECT r FROM RqtLogin r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtLogin extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_LOGIN_ID_GENERATOR", sequenceName="lgin_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_LOGIN_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=20)
	private String salt;

	@Column(length=256)
	private String sessiontok;

	public RqtLogin() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSessiontok() {
		return this.sessiontok;
	}

	public void setSessiontok(String sessiontok) {
		this.sessiontok = sessiontok;
	}

}