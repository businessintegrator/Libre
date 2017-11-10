package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the produit_taxitem database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="produit_taxitem")
//@NamedQuery(name="ProduitTaxitem.findAll", query="SELECT p FROM ProduitTaxitem p")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class ProduitTaxitem extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="PRODUIT_TAXITEM_ID_GENERATOR", sequenceName="prdtx_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUIT_TAXITEM_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	//bi-directional many-to-one association to Produit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produit")
	private Produit produit;

	//bi-directional many-to-one association to Taxitem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_taxunit")
	private Taxitem taxitem;

	public ProduitTaxitem() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Taxitem getTaxitem() {
		return this.taxitem;
	}

	public void setTaxitem(Taxitem taxitem) {
		this.taxitem = taxitem;
	}

}