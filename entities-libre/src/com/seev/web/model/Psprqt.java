package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the psprqt database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="psprqt")
//@NamedQuery(name="Psprqt.findAll", query="SELECT p FROM Psprqt p")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Psprqt extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="PSPRQT_ID_GENERATOR", sequenceName="psprqt_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSPRQT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=20)
	private String rqtkey;

	@Column(length=150)
	private String rqtvalue;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="psprqt")
	private List<Payment> payments;

	public Psprqt() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRqtkey() {
		return this.rqtkey;
	}

	public void setRqtkey(String rqtkey) {
		this.rqtkey = rqtkey;
	}

	public String getRqtvalue() {
		return this.rqtvalue;
	}

	public void setRqtvalue(String rqtvalue) {
		this.rqtvalue = rqtvalue;
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
		payment.setPsprqt(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setPsprqt(null);

		return payment;
	}

}