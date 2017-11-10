package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_payment database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_payment")
//@NamedQuery(name="RqtPayment.findAll", query="SELECT r FROM RqtPayment r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtPayment extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_PAYMENT_ID_GENERATOR", sequenceName="rqtpmt_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_PAYMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=255)
	private String ref;

	@Column(name="rqt_id")
	private Long rqtId;

	@Column(name="rsp_id")
	private Long rspId;

	public RqtPayment() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Long getRqtId() {
		return this.rqtId;
	}

	public void setRqtId(Long rqtId) {
		this.rqtId = rqtId;
	}

	public Long getRspId() {
		return this.rspId;
	}

	public void setRspId(Long rspId) {
		this.rspId = rspId;
	}

}