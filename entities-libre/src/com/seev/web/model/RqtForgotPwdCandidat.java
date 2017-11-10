package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_forgot_pwd_candidat database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_forgot_pwd_candidat")
//@NamedQuery(name="RqtForgotPwdCandidat.findAll", query="SELECT r FROM RqtForgotPwdCandidat r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtForgotPwdCandidat extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_FORGOT_PWD_CANDIDAT_ID_GENERATOR", sequenceName="frcn_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_FORGOT_PWD_CANDIDAT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	private Boolean effectuee;

	@Column(length=80)
	private String email;

	private Boolean envoyee;

	@Column(length=20)
	private String token;

	public RqtForgotPwdCandidat() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getEffectuee() {
		return this.effectuee;
	}

	public void setEffectuee(Boolean effectuee) {
		this.effectuee = effectuee;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnvoyee() {
		return this.envoyee;
	}

	public void setEnvoyee(Boolean envoyee) {
		this.envoyee = envoyee;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}