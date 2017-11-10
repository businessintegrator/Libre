package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the societe_cpt_recrut database table.
 *
 */
@Entity
@Table(schema = "activeimage2", name = "societe_cpt_recrut")
//@NamedQuery(name="SocieteCptRecrut.findAll", query="SELECT s FROM SocieteCptRecrut s")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class SocieteCptRecrut extends Distributor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, schema = "activeimage2", name = "SOCIETE_CPT_RECRUT_ID_GENERATOR", sequenceName = "cptsoc_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOCIETE_CPT_RECRUT_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    @XmlAttribute(name = "sId")
    private Long id;

    @Column(name = "c_pay")
    private Long cPay;

    
    @ManyToOne
    @JoinColumn(name = "c_societe")
    private Societe cSociete;
    
    
    @JoinColumn(name = "agent")
    @ManyToOne
    private Recrtr agentRecruteur;
    
    @Column(name = "e2e",length = 110)
    private String e2e;

    @Column(name = "instid",length = 110)
    private String instid;
        
    @Column(name = "idt")
    @Temporal(TemporalType.DATE)
    private Date initDate;
    
    @Column(name = "pdt")
    @Temporal(TemporalType.DATE)
    private Date payDate;
    
     @Column(name = "paid")
    private Boolean payee;
     @Column(name = "cancelled")
    private Boolean cancelled;

    //bi-directional many-to-one association to RqtRspSouscription
    @OneToMany(mappedBy = "societeCptRecrut")
    private List<RqtRspSouscription> rqtRspSouscriptions;

    //bi-directional many-to-one association to Produit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_produit")
    private Produit produit;


    public SocieteCptRecrut() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCPay() {
        return this.cPay;
    }

    public void setCPay(Long cPay) {
        this.cPay = cPay;
    }

    public Societe getCSociete() {
        return this.cSociete;
    }

    public void setCSociete(Societe cSociete) {
        this.cSociete = cSociete;
    }

    public Boolean getPayee() {
        return this.payee;
    }

    public void setPayee(Boolean payee) {
        this.payee = payee;
    }

    @XmlTransient
    public List<RqtRspSouscription> getRqtRspSouscriptions() {
        return this.rqtRspSouscriptions;
    }

    public void setRqtRspSouscriptions(List<RqtRspSouscription> rqtRspSouscriptions) {
        this.rqtRspSouscriptions = rqtRspSouscriptions;
    }

    public RqtRspSouscription addRqtRspSouscription(RqtRspSouscription rqtRspSouscription) {
        getRqtRspSouscriptions().add(rqtRspSouscription);
        rqtRspSouscription.setSocieteCptRecrut(this);

        return rqtRspSouscription;
    }

    public RqtRspSouscription removeRqtRspSouscription(RqtRspSouscription rqtRspSouscription) {
        getRqtRspSouscriptions().remove(rqtRspSouscription);
        rqtRspSouscription.setSocieteCptRecrut(null);

        return rqtRspSouscription;
    }

    public Produit getProduit() {
        return this.produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    

    

   

  

   

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public String getE2e() {
        return e2e;
    }

    public void setE2e(String e2e) {
        this.e2e = e2e;
    }

    public String getInstid() {
        return instid;
    }

    public void setInstid(String instid) {
        this.instid = instid;
    }

    public Societe getcSociete() {
        return cSociete;
    }

    public void setcSociete(Societe cSociete) {
        this.cSociete = cSociete;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Recrtr getAgentRecruteur() {
        return agentRecruteur;
    }

    public void setAgentRecruteur(Recrtr agentRecruteur) {
        this.agentRecruteur = agentRecruteur;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }


    
}
