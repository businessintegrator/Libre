package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the pstltn database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="pstltn")
//@NamedQuery(name="Pstltn.findAll", query="SELECT p FROM Pstltn p")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Pstltn extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="PSTLTN_ID_GENERATOR", sequenceName="pstltn_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSTLTN_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Temporal(TemporalType.DATE)
	private Date aplydt;

	//bi-directional many-to-one association to Cndt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cndt_id")
	private Cndt cndt;

	//bi-directional many-to-one association to Cv
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="aplycv_id")
	private Cv cv;

	//bi-directional many-to-one association to Lm
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="aplylm_id")
	private Lm lm;

	//bi-directional many-to-one association to Offrmpl
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="offr_id")
	private Offrmpl offrmpl;

	public Pstltn() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAplydt() {
		return this.aplydt;
	}

	public void setAplydt(Date aplydt) {
		this.aplydt = aplydt;
	}

	public Cndt getCndt() {
		return this.cndt;
	}

	public void setCndt(Cndt cndt) {
		this.cndt = cndt;
	}

	public Cv getCv() {
		return this.cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public Lm getLm() {
		return this.lm;
	}

	public void setLm(Lm lm) {
		this.lm = lm;
	}

	public Offrmpl getOffrmpl() {
		return this.offrmpl;
	}

	public void setOffrmpl(Offrmpl offrmpl) {
		this.offrmpl = offrmpl;
	}

}