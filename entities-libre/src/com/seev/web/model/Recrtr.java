package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the recrtr database table.
 *
 */
@Entity
@Table(schema = "activeimage2", name = "recrtr")
//@NamedQuery(name = "Recrtr.findAll", query = "SELECT r FROM Recrtr r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Recrtr extends Distributor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, schema = "activeimage2", name = "RECRTR_ID_GENERATOR", sequenceName = "recrtr_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECRTR_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    @XmlAttribute(name="sId") private Long id;

    @Column(length = 35)
    private String identifiant;
    
    @JoinColumn(name = "s")
    @ManyToOne
    private Societe societe;

    @Column(length = 255,name = "line1")
    private String line1;

    @Column(length = 255,name = "line2")
    private String line2;

    @Column(length = 255,name = "line3")
    private String line3;

    @Column(length = 255,name = "codepostal")
    private String codepostal;

    @Column(length = 255,name = "fax")
    private String fax;
    @Column(length = 254,unique = true, nullable = false,name = "email")
    private String email;

    @Column(name = "emailvalid")
    private Boolean emailvalid = false;

    @Column(length = 255,name = "ville")
    private String ville;

    @Column(length = 255,name = "pays")
    private String pays;

    @Column(length = 255,name = "telephone")
    private String telephone;

    @Column(length = 80,name = "cd")
    private String cd;

    @Column(length = 80,name = "cmname")
    private String cmname;

    @Column(name = "rate")
    private double rate;

    @Column(length = 9,name = "siret")
    private String siret;
    @Column(length = 5,name = "siren",unique=true)
    private String siren;

    @Column(length = 255,name = "tvanumber")
    private String tvanumber;

    @Convert(converter = Iconv.class)
    @Column(length = 4000,name = "pssword")
    private String pssword;
    
    @Transient
    private String psswordb;
    
    @Column(length = 255,name = "salt")
    private String salt;
    
    @Column(length = 254,name = "postulationmail")
    private String postulationmail;
    
    @Column(name = "attempt")
     private int attempt =0;
    @Column(name = "lockedacct")
    private Boolean lockedacct = false;


    //bi-directional many-to-one association to Cmnd
    @OneToMany(mappedBy = "recrtr",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   private List<Cmnd> cmnds = null;

    //bi-directional many-to-one association to Cnsltprfl
    @OneToMany(mappedBy = "recrtr",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Cnsltprfl> cnsltprfls = null;

    //bi-directional many-to-one association to Offrmpl
    @OneToMany(mappedBy = "recrtr",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Offrmpl> offrmpls = null;

    //bi-directional many-to-one association to Clzreza
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cur_reza_id")
    private Clzreza clzreza;

    public Recrtr() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
        cmnd.setRecrtr(this);

        return cmnd;
    }

    public Cmnd removeCmnd(Cmnd cmnd) {
        getCmnds().remove(cmnd);
        cmnd.setRecrtr(null);

        return cmnd;
    }

    @XmlTransient
    public List<Cnsltprfl> getCnsltprfls() {
        return this.cnsltprfls;
    }

    public void setCnsltprfls(List<Cnsltprfl> cnsltprfls) {
        this.cnsltprfls = cnsltprfls;
    }

    public Cnsltprfl addCnsltprfl(Cnsltprfl cnsltprfl) {
        getCnsltprfls().add(cnsltprfl);
        cnsltprfl.setRecrtr(this);

        return cnsltprfl;
    }

    public Cnsltprfl removeCnsltprfl(Cnsltprfl cnsltprfl) {
        getCnsltprfls().remove(cnsltprfl);
        cnsltprfl.setRecrtr(null);

        return cnsltprfl;
    }

    @XmlTransient
    public List<Offrmpl> getOffrmpls() {
        return this.offrmpls;
    }

    public void setOffrmpls(List<Offrmpl> offrmpls) {
        this.offrmpls = offrmpls;
    }

    public Offrmpl addOffrmpl(Offrmpl offrmpl) {
        getOffrmpls().add(offrmpl);
        offrmpl.setRecrtr(this);

        return offrmpl;
    }

    public Offrmpl removeOffrmpl(Offrmpl offrmpl) {
        getOffrmpls().remove(offrmpl);
        offrmpl.setRecrtr(null);

        return offrmpl;
    }

    public Clzreza getClzreza() {
        return this.clzreza;
    }

    public void setClzreza(Clzreza clzreza) {
        this.clzreza = clzreza;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailvalid() {
        return emailvalid;
    }

    public void setEmailvalid(Boolean emailvalid) {
        this.emailvalid = emailvalid;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getCmname() {
        return cmname;
    }

    public void setCmname(String cmname) {
        this.cmname = cmname;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }

    public String getTvanumber() {
        return tvanumber;
    }

    public void setTvanumber(String tvanumber) {
        this.tvanumber = tvanumber;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPssword() {
        return pssword;
    }

    public void setPssword(String pssword) {
        this.pssword = pssword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPsswordb() {
        return psswordb;
    }

    public void setPsswordb(String psswordb) {
        this.psswordb = psswordb;
    }

    public String getPostulationmail() {
        return postulationmail;
    }

    public void setPostulationmail(String postulationmail) {
        this.postulationmail = postulationmail;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public Boolean getLockedacct() {
        return lockedacct;
    }

    public void setLockedacct(Boolean lockedacct) {
        this.lockedacct = lockedacct;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }


    
    
}
