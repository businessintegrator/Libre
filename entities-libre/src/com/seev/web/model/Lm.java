package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the lm database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="lm")
//@NamedQuery(name="Lm.findAll", query="SELECT l FROM Lm l")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Lm extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="LM_ID_GENERATOR", sequenceName="lm_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LM_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=255)
	private String cntnt;

	@Column(length=255)
	private String lmnm;

	@Column(length=255)
	private String lmuri;

	//bi-directional many-to-one association to Cndt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lmowner_id")
	private Cndt cndt;

	//bi-directional many-to-one association to Pstltn
	@OneToMany(mappedBy="lm")
	private List<Pstltn> pstltns;

	public Lm() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCntnt() {
		return this.cntnt;
	}

	public void setCntnt(String cntnt) {
		this.cntnt = cntnt;
	}

	public String getLmnm() {
		return this.lmnm;
	}

	public void setLmnm(String lmnm) {
		this.lmnm = lmnm;
	}

	public String getLmuri() {
		return this.lmuri;
	}

	public void setLmuri(String lmuri) {
		this.lmuri = lmuri;
	}

	public Cndt getCndt() {
		return this.cndt;
	}

	public void setCndt(Cndt cndt) {
		this.cndt = cndt;
	}

    @XmlTransient
	public List<Pstltn> getPstltns() {
		return this.pstltns;
	}

	public void setPstltns(List<Pstltn> pstltns) {
		this.pstltns = pstltns;
	}

	public Pstltn addPstltn(Pstltn pstltn) {
		getPstltns().add(pstltn);
		pstltn.setLm(this);

		return pstltn;
	}

	public Pstltn removePstltn(Pstltn pstltn) {
		getPstltns().remove(pstltn);
		pstltn.setLm(null);

		return pstltn;
	}

}