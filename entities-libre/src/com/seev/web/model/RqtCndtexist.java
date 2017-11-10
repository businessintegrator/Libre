package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_cndtexist database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_cndtexist")
//@NamedQuery(name="RqtCndtexist.findAll", query="SELECT r FROM RqtCndtexist r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtCndtexist extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_CNDTEXIST_ID_GENERATOR", sequenceName="rqtcndtexist_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_CNDTEXIST_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=255)
	private String email;

	@Temporal(TemporalType.DATE)
	private Date rqtdt;

	//bi-directional many-to-one association to Cndt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="result")
	private Cndt cndt;

	public RqtCndtexist() {
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

	public Date getRqtdt() {
		return this.rqtdt;
	}

	public void setRqtdt(Date rqtdt) {
		this.rqtdt = rqtdt;
	}

	public Cndt getCndt() {
		return this.cndt;
	}

	public void setCndt(Cndt cndt) {
		this.cndt = cndt;
	}

}