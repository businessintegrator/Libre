package com.seev.web.model;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the cndt database table.
 *
 */
@Entity
@Table(schema = "activeimage2", name = "cndt")
//@NamedQuery(name = "Cndt.findAll", query = "SELECT c FROM Cndt c")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Cndt extends Distributor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, schema = "activeimage2", name = "CNDT_ID_GENERATOR", sequenceName = "cndt_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CNDT_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    @XmlAttribute(name="sId") private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "bdt")
    private Date birth;
    @Column(name = "nom",length = 255)
    @Convert(converter = Roster.class)
    private String nom;

    @Column(name = "prenom",length = 255)
    @Convert(converter = Roster.class)
    private String prenom;

    @Column(name = "codepostal",length = 8)
    private String codepostal;

    @Column(name = "email",length = 254,unique = true, nullable = false)
    private String email;

    @Column(name = "emailvalid")
    private Boolean emailvalid;

    @Column(name = "line1",length = 255)
    @Convert(converter = Roster.class)
    private String line1;

    @Column(name = "line2",length = 40)
    private String line2;

    @Column(name = "line3",length = 40)
    private String line3;

    @Column(name = "pays",length = 40)
    private String pays;

    @Convert(converter = Roster.class)
    @Column(name="telephone",length = 255)
    private String telephone;

    @Column(name="ville",length = 50)
    private String ville;
    @Convert(converter = Iconv.class)
    @Column(name="pssword",length = 4000)
    private String pssword;
    @Column(name = "salt",length = 255,unique = true, nullable = false)
    private String salt;

    @Column(name = "civ", length = 3)
    private String civilite;
    
    @Column(name = "unit", length = 15)
    private String  salaryTimeUnit;
    
    @Column(name = "curcy", length = 3)
    private String currency;
 
    
    @Column(name = "mins")
    private Integer minimumSalary;
    @Column(name = "maxs")
    private Integer maxsimumSalary;

    @Temporal(TemporalType.DATE)
    @Column(name = "dispo")
    private Date dateDispo;

    @Column(name = "preavis")
    private Boolean preavis = false;

    @Column(name = "attempt")
     private int attempt =0;
    
    @Column(name = "lockedacct")
    private Boolean lockedacct = false;
    

    //bi-directional many-to-one association to Cv
    @OneToMany(mappedBy = "cndt", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Cv> cvs = null;

    //bi-directional many-to-one association to Cv
    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
 private List<Pretention> pretentions = null;
    //bi-directional many-to-one association to Lm
    @OneToMany(mappedBy = "cndt", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   private List<Lm> lms = null;

    //bi-directional many-to-one association to Pstltn
  @OneToMany(mappedBy = "cndt", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   private List<Pstltn> pstltns = null;

    //bi-directional many-to-one association to RqtCndtexis
   @OneToMany(mappedBy = "cndt", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   private List<RqtCndtexist> rqtCndtexists = null;

    //bi-directional many-to-one association to RqtCv2txt
   @OneToMany(mappedBy = "cndt", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  private List<RqtCv2txt> rqtCv2txts = null;

    //bi-directional many-to-one association to XchCandidat
  @OneToMany(mappedBy = "cndt1", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  private List<XchCandidat> xchCandidats1 = null;

    //bi-directional many-to-one association to XchCandidat
    @OneToMany(mappedBy = "cndt2", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<XchCandidat> xchCandidats2 = null;

    public Cndt() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

   
   @XmlTransient
   public List<Cv> getCvs() {
        return this.cvs;
    }

    public void setCvs(List<Cv> pcvs) {
        this.cvs = pcvs;
    }



    public Cv addCv(Cv cv) {
        getCvs().add(cv);
        cv.setCndt(this);

        return cv;
    }

    public Cv removeCv(Cv cv) {
        getCvs().remove(cv);
        cv.setCndt(null);

        return cv;
    }

    @XmlTransient
    public List<Lm> getLms() {
        return this.lms;
    }

    public void setLms(List<Lm> lms) {
        this.lms = lms;
    }

    public Lm addLm(Lm lm) {
        getLms().add(lm);
        lm.setCndt(this);

        return lm;
    }

    public Lm removeLm(Lm lm) {
        getLms().remove(lm);
        lm.setCndt(null);

        return lm;
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
        pstltn.setCndt(this);

        return pstltn;
    }

    public Pstltn removePstltn(Pstltn pstltn) {
        getPstltns().remove(pstltn);
        pstltn.setCndt(null);

        return pstltn;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    @XmlTransient
    public List<RqtCndtexist> getRqtCndtexists() {
        return this.rqtCndtexists;
    }

    public void setRqtCndtexists(List<RqtCndtexist> rqtCndtexists) {
        this.rqtCndtexists = rqtCndtexists;
    }

    public RqtCndtexist addRqtCndtexist(RqtCndtexist rqtCndtexist) {
        getRqtCndtexists().add(rqtCndtexist);
        rqtCndtexist.setCndt(this);

        return rqtCndtexist;
    }

    public RqtCndtexist removeRqtCndtexist(RqtCndtexist rqtCndtexist) {
        getRqtCndtexists().remove(rqtCndtexist);
        rqtCndtexist.setCndt(null);

        return rqtCndtexist;
    }

    @XmlTransient
    public List<RqtCv2txt> getRqtCv2txts() {
        return this.rqtCv2txts;
    }

    public void setRqtCv2txts(List<RqtCv2txt> rqtCv2txts) {
        this.rqtCv2txts = rqtCv2txts;
    }

    public RqtCv2txt addRqtCv2txt(RqtCv2txt rqtCv2txt) {
        getRqtCv2txts().add(rqtCv2txt);
        rqtCv2txt.setCndt(this);

        return rqtCv2txt;
    }

    public RqtCv2txt removeRqtCv2txt(RqtCv2txt rqtCv2txt) {
        getRqtCv2txts().remove(rqtCv2txt);
        rqtCv2txt.setCndt(null);

        return rqtCv2txt;
    }

    @XmlTransient
    public List<XchCandidat> getXchCandidats1() {
        return this.xchCandidats1;
    }

    public void setXchCandidats1(List<XchCandidat> xchCandidats1) {
        this.xchCandidats1 = xchCandidats1;
    }

    public XchCandidat addXchCandidats1(XchCandidat xchCandidats1) {
        getXchCandidats1().add(xchCandidats1);
        xchCandidats1.setCndt1(this);

        return xchCandidats1;
    }

    public XchCandidat removeXchCandidats1(XchCandidat xchCandidats1) {
        getXchCandidats1().remove(xchCandidats1);
        xchCandidats1.setCndt1(null);

        return xchCandidats1;
    }

    @XmlTransient
    public List<XchCandidat> getXchCandidats2() {
        return this.xchCandidats2;
    }

    public void setXchCandidats2(List<XchCandidat> xchCandidats2) {
        this.xchCandidats2 = xchCandidats2;
    }

    public XchCandidat addXchCandidats2(XchCandidat xchCandidats2) {
        getXchCandidats2().add(xchCandidats2);
        xchCandidats2.setCndt2(this);

        return xchCandidats2;
    }

    public XchCandidat removeXchCandidats2(XchCandidat xchCandidats2) {
        getXchCandidats2().remove(xchCandidats2);
        xchCandidats2.setCndt2(null);

        return xchCandidats2;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

  /*  public List<Pretention> getPretentions() {
        return pretentions;
    }

    public void setPretentions(List<Pretention> pretentions) {
        this.pretentions = pretentions;
    }
*/
    public Integer getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(Integer minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public Integer getMaxsimumSalary() {
        return maxsimumSalary;
    }

    public void setMaxsimumSalary(Integer maxsimumSalary) {
        this.maxsimumSalary = maxsimumSalary;
    }

    public Date getDateDispo() {
        return dateDispo;
    }

    public void setDateDispo(Date dateDispo) {
        this.dateDispo = dateDispo;
    }

    public Boolean getPreavis() {
        return preavis;
    }

    public void setPreavis(Boolean preavis) {
        this.preavis = preavis;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public List<Pretention> getPretentions() {
        return pretentions;
    }

    public void setPretentions(List<Pretention> pretentions) {
        this.pretentions = pretentions;
    }

    public Boolean getLockedacct() {
        return lockedacct;
    }

    public void setLockedacct(Boolean lockedacct) {
        this.lockedacct = lockedacct;
    }

    public String getSalaryTimeUnit() {
        return salaryTimeUnit;
    }

    public void setSalaryTimeUnit(String salaryTimeUnit) {
        this.salaryTimeUnit = salaryTimeUnit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    

}
