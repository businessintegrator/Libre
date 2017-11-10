package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="payment")
//@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Payment extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="PAYMENT_ID_GENERATOR", sequenceName="pmt_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=20)
	private String refclient;

	//bi-directional many-to-one association to Psprqt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rqt_id")
	private Psprqt psprqt;

	//bi-directional many-to-one association to Psprsp
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rsp_id")
	private Psprsp psprsp;

	public Payment() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefclient() {
		return this.refclient;
	}

	public void setRefclient(String refclient) {
		this.refclient = refclient;
	}

	public Psprqt getPsprqt() {
		return this.psprqt;
	}

	public void setPsprqt(Psprqt psprqt) {
		this.psprqt = psprqt;
	}

	public Psprsp getPsprsp() {
		return this.psprsp;
	}

	public void setPsprsp(Psprsp psprsp) {
		this.psprsp = psprsp;
	}

}