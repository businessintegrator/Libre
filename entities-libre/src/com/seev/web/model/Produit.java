package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="produit")
//@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Produit extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="PRODUIT_ID_GENERATOR", sequenceName="prd_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUIT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=255)
	private String dsc;

        @Column(length=255,name="days")
	private Integer days = 0;
        
	//bi-directional many-to-one association to Cmnd
	@OneToMany(mappedBy="produit")
	private List<Cmnd> cmnds;

	//bi-directional many-to-one association to Clzreza
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="reza_id")
	private Clzreza clzreza;

	//bi-directional many-to-one association to ProduitTaxitem
	@OneToMany(mappedBy="produit")
	private List<ProduitTaxitem> produitTaxitems;

	//bi-directional many-to-one association to SocieteCptRecrut
	@OneToMany(mappedBy="produit")
	private List<SocieteCptRecrut> societeCptRecruts;

	public Produit() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsc() {
		return this.dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

    @XmlTransient
	public List<Cmnd> getCmnds() {
		return this.cmnds;
	}

	public void setCmnds(List<Cmnd> cmnds) {
		this.cmnds = cmnds;
	}

	public Cmnd addCmnd(Cmnd cmnd) {
		getCmnds().add(cmnd);
		cmnd.setProduit(this);

		return cmnd;
	}

	public Cmnd removeCmnd(Cmnd cmnd) {
		getCmnds().remove(cmnd);
		cmnd.setProduit(null);

		return cmnd;
	}

	public Clzreza getClzreza() {
		return this.clzreza;
	}

	public void setClzreza(Clzreza clzreza) {
		this.clzreza = clzreza;
	}

    @XmlTransient
	public List<ProduitTaxitem> getProduitTaxitems() {
		return this.produitTaxitems;
	}

	public void setProduitTaxitems(List<ProduitTaxitem> produitTaxitems) {
		this.produitTaxitems = produitTaxitems;
	}

	public ProduitTaxitem addProduitTaxitem(ProduitTaxitem produitTaxitem) {
		getProduitTaxitems().add(produitTaxitem);
		produitTaxitem.setProduit(this);

		return produitTaxitem;
	}

	public ProduitTaxitem removeProduitTaxitem(ProduitTaxitem produitTaxitem) {
		getProduitTaxitems().remove(produitTaxitem);
		produitTaxitem.setProduit(null);

		return produitTaxitem;
	}

    @XmlTransient
	public List<SocieteCptRecrut> getSocieteCptRecruts() {
		return this.societeCptRecruts;
	}

	public void setSocieteCptRecruts(List<SocieteCptRecrut> societeCptRecruts) {
		this.societeCptRecruts = societeCptRecruts;
	}

	public SocieteCptRecrut addSocieteCptRecrut(SocieteCptRecrut societeCptRecrut) {
		getSocieteCptRecruts().add(societeCptRecrut);
		societeCptRecrut.setProduit(this);

		return societeCptRecrut;
	}

	public SocieteCptRecrut removeSocieteCptRecrut(SocieteCptRecrut societeCptRecrut) {
		getSocieteCptRecruts().remove(societeCptRecrut);
		societeCptRecrut.setProduit(null);

		return societeCptRecrut;
	}

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

        
}