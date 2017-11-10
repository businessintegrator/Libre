package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the psprsp database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="psprsp")
//@NamedQuery(name="Psprsp.findAll", query="SELECT p FROM Psprsp p")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Psprsp extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="PSPRSP_ID_GENERATOR", sequenceName="psprsp_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSPRSP_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=20)
	private String rspkey;

	@Column(length=255)
	private String rspvalue;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="psprsp")
	private List<Payment> payments;

	//bi-directional many-to-one association to Psprsp
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ext_id")
	private Psprsp psprsp;

	//bi-directional many-to-one association to Psprsp
	@OneToMany(mappedBy="psprsp")
	private List<Psprsp> psprsps;

	public Psprsp() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRspkey() {
		return this.rspkey;
	}

	public void setRspkey(String rspkey) {
		this.rspkey = rspkey;
	}

	public String getRspvalue() {
		return this.rspvalue;
	}

	public void setRspvalue(String rspvalue) {
		this.rspvalue = rspvalue;
	}

    @XmlTransient
	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setPsprsp(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setPsprsp(null);

		return payment;
	}

	public Psprsp getPsprsp() {
		return this.psprsp;
	}

	public void setPsprsp(Psprsp psprsp) {
		this.psprsp = psprsp;
	}

    @XmlTransient
	public List<Psprsp> getPsprsps() {
		return this.psprsps;
	}

	public void setPsprsps(List<Psprsp> psprsps) {
		this.psprsps = psprsps;
	}

	public Psprsp addPsprsp(Psprsp psprsp) {
		getPsprsps().add(psprsp);
		psprsp.setPsprsp(this);

		return psprsp;
	}

	public Psprsp removePsprsp(Psprsp psprsp) {
		getPsprsps().remove(psprsp);
		psprsp.setPsprsp(null);

		return psprsp;
	}

}