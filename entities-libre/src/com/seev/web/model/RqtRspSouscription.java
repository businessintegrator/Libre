package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_rsp_souscription database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_rsp_souscription")
//@NamedQuery(name="RqtRspSouscription.findAll", query="SELECT r FROM RqtRspSouscription r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtRspSouscription extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_RSP_SOUSCRIPTION_ID_GENERATOR", sequenceName="sous_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_RSP_SOUSCRIPTION_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Temporal(TemporalType.DATE)
	private Date dt;

	private Boolean livree;

	private Boolean payee;

	@Column(length=80)
	private String reason;

	private Boolean rejetee;

	private Long soucriptor;

	private Long sousproduit;

	//bi-directional many-to-one association to SocieteCptRecrut
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sold_product")
	private SocieteCptRecrut societeCptRecrut;

	public RqtRspSouscription() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDt() {
		return this.dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public Boolean getLivree() {
		return this.livree;
	}

	public void setLivree(Boolean livree) {
		this.livree = livree;
	}

	public Boolean getPayee() {
		return this.payee;
	}

	public void setPayee(Boolean payee) {
		this.payee = payee;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Boolean getRejetee() {
		return this.rejetee;
	}

	public void setRejetee(Boolean rejetee) {
		this.rejetee = rejetee;
	}

	public Long getSoucriptor() {
		return this.soucriptor;
	}

	public void setSoucriptor(Long soucriptor) {
		this.soucriptor = soucriptor;
	}

	public Long getSousproduit() {
		return this.sousproduit;
	}

	public void setSousproduit(Long sousproduit) {
		this.sousproduit = sousproduit;
	}

	public SocieteCptRecrut getSocieteCptRecrut() {
		return this.societeCptRecrut;
	}

	public void setSocieteCptRecrut(SocieteCptRecrut societeCptRecrut) {
		this.societeCptRecrut = societeCptRecrut;
	}

}