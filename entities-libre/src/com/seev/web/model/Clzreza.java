package com.seev.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the clzreza database table.
 *
 */
@Entity
@Table(schema = "activeimage2", name = "clzreza")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Clzreza extends Distributor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, schema = "activeimage2", name = "CLZREZA_ID_GENERATOR", sequenceName = "clzreza_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLZREZA_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    @XmlAttribute(name="sId") private Long id;
    
    
    @JoinColumn(name = "nextreza")
    @OneToOne
      private Clzreza nextreza = null;

    @Column(name = "clazz", length = 255)
    private String clazz;

    @Column(name = "codepromo", length = 255)
    private String codepromo;

    @Column(name = "prix")
    private double prix=0;
    
    @Column(name = "maxc")
    private Integer nbMaxConsult = 0;

    @Temporal(TemporalType.DATE)
    @Column(name = "promostr")
    private Date promoStart;
    @Temporal(TemporalType.DATE)
    @Column(name = "promoend")
    private Date promoEnd;
    @Column(name = "promorate")
    private Integer promoRate;

    //bi-directional many-to-one association to Produit
    @OneToMany(mappedBy = "clzreza")
    private List<Produit> produits;

    //bi-directional many-to-one association to Recrtr
    @OneToMany(mappedBy = "clzreza")
    private List<Recrtr> recrtrs;

    //bi-directional many-to-one association to Tarif
    @OneToMany(mappedBy = "clzreza")
    private List<Tarif> tarifs;

    public Clzreza() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClazz() {
        return this.clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getCodepromo() {
        return this.codepromo;
    }

    public void setCodepromo(String codepromo) {
        this.codepromo = codepromo;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @XmlTransient
    public List<Produit> getProduits() {
        return this.produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Produit addProduit(Produit produit) {
        getProduits().add(produit);
        produit.setClzreza(this);

        return produit;
    }

    public Produit removeProduit(Produit produit) {
        getProduits().remove(produit);
        produit.setClzreza(null);

        return produit;
    }

    @XmlTransient
    public List<Recrtr> getRecrtrs() {
        return this.recrtrs;
    }

    public void setRecrtrs(List<Recrtr> recrtrs) {
        this.recrtrs = recrtrs;
    }

    public Recrtr addRecrtr(Recrtr recrtr) {
        getRecrtrs().add(recrtr);
        recrtr.setClzreza(this);

        return recrtr;
    }

    public Recrtr removeRecrtr(Recrtr recrtr) {
        getRecrtrs().remove(recrtr);
        recrtr.setClzreza(null);

        return recrtr;
    }

    @XmlTransient
    public List<Tarif> getTarifs() {
        return this.tarifs;
    }

    public void setTarifs(List<Tarif> tarifs) {
        this.tarifs = tarifs;
    }

    public Tarif addTarif(Tarif tarif) {
        getTarifs().add(tarif);
        tarif.setClzreza(this);

        return tarif;
    }

    public Tarif removeTarif(Tarif tarif) {
        getTarifs().remove(tarif);
        tarif.setClzreza(null);

        return tarif;
    }

    public Date getPromoStart() {
        return promoStart;
    }

    public void setPromoStart(Date promoStart) {
        this.promoStart = promoStart;
    }

    public Date getPromoEnd() {
        return promoEnd;
    }

    public void setPromoEnd(Date promoEnd) {
        this.promoEnd = promoEnd;
    }

    public Integer getPromoRate() {
        return promoRate;
    }

    public void setPromoRate(Integer promoRate) {
        this.promoRate = promoRate;
    }

    public Clzreza getNextreza() {
        return nextreza;
    }

    public void setNextreza(Clzreza nextreza) {
        this.nextreza = nextreza;
    }

    public Integer getNbMaxConsult() {
        return nbMaxConsult;
    }

    public void setNbMaxConsult(Integer nbMaxConsult) {
        this.nbMaxConsult = nbMaxConsult;
    }

    @Override
    public String toString() {
        return "Clzreza{" + "id=" + id + ", clazz=" + clazz + ", prix=" + prix + '}';
    }


    
}
