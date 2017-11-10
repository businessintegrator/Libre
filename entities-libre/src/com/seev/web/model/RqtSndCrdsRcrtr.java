package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_snd_crds_rcrtr database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_snd_crds_rcrtr")
//@NamedQuery(name="RqtSndCrdsRcrtr.findAll", query="SELECT r FROM RqtSndCrdsRcrtr r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtSndCrdsRcrtr extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_SND_CRDS_RCRTR_ID_GENERATOR", sequenceName="pruri_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_SND_CRDS_RCRTR_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	private Boolean effectuee;

	private Boolean envoyee;

	@Temporal(TemporalType.DATE)
	private Date expiration;

	@Column(length=80)
	private String salt;

	@Column(length=32)
	private String token;

	public RqtSndCrdsRcrtr() {
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

	public Boolean getEnvoyee() {
		return this.envoyee;
	}

	public void setEnvoyee(Boolean envoyee) {
		this.envoyee = envoyee;
	}

	public Date getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}