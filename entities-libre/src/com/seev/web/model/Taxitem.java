package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the taxitem database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="taxitem")
//@NamedQuery(name="Taxitem.findAll", query="SELECT t FROM Taxitem t")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Taxitem extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="TAXITEM_ID_GENERATOR", sequenceName="txtitm_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAXITEM_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=8)
	private String cd;

	private Integer rate;

	//bi-directional many-to-one association to ProduitTaxitem
	@OneToMany(mappedBy="taxitem")
	private List<ProduitTaxitem> produitTaxitems;

	public Taxitem() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCd() {
		return this.cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public Integer getRate() {
		return this.rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
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
		produitTaxitem.setTaxitem(this);

		return produitTaxitem;
	}

	public ProduitTaxitem removeProduitTaxitem(ProduitTaxitem produitTaxitem) {
		getProduitTaxitems().remove(produitTaxitem);
		produitTaxitem.setTaxitem(null);

		return produitTaxitem;
	}

}