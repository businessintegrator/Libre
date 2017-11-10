package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_rsp_add_cv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_rsp_add_cv")
//@NamedQuery(name="RqtRspAddCv.findAll", query="SELECT r FROM RqtRspAddCv r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtRspAddCv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_RSP_ADD_CV_ID_GENERATOR", sequenceName="addcv_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_RSP_ADD_CV_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	private Long candidate;

	private Long resultcv;

	@Temporal(TemporalType.DATE)
	private Date rqtdt;

	public RqtRspAddCv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Long candidate) {
		this.candidate = candidate;
	}

	public Long getResultcv() {
		return this.resultcv;
	}

	public void setResultcv(Long resultcv) {
		this.resultcv = resultcv;
	}

	public Date getRqtdt() {
		return this.rqtdt;
	}

	public void setRqtdt(Date rqtdt) {
		this.rqtdt = rqtdt;
	}

}