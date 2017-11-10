package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the offrmpl database table.
 *
 */
@Entity
@Table(schema = "activeimage2", name = "offrmpl")
//@NamedQuery(name = "Offrmpl.findAll", query = "SELECT o FROM Offrmpl o")
@XmlRootElement  @XmlAccessorType(XmlAccessType.FIELD)
public class Offrmpl extends Distributor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, schema = "activeimage2", name = "OFFRMPL_ID_GENERATOR", sequenceName = "offrmpl_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OFFRMPL_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    @XmlAttribute(name="sId") private Long id;

    @Column(name="b",length = 1920)
    private String b;

    @Column(name="titl",length = 40)
    private String titl;

    @Column(name="lieu",length = 40)
    private String lieu;

    @Column(name="typcontrat",length = 10)
    private String typcontrat;

    @Column(name="b1",length = 1920)
    private String b1;

    @Column(name="b2",length = 1920)
    private String b2;

    @Column(name="b3",length = 1920)
    private String b3;

    @Column(name="b4",length = 1920)
    private String b4;

    @Column(name="cdt")
    @Temporal(TemporalType.DATE)
    ////@Convert(converter = DateConverter.class)
    private Date cdt;

    @Column(name="cntrlled")
    private Boolean cntrlled;

    @Column(name="curcy",length = 255)
    private String curcy;

    @Column(name="logouri",length = 255)
    private String logouri;

    @Column(name="maxs")
    private Integer maxs;
    
    @Column(name="maxx")
    private Integer maxx;

    @Column(name="mins")
    private Integer mins;

    @Column(name="minx")
    private Integer minx;

    @Column(name="ml",length = 255)
    private String ml;

    @Column(name="pbldt")
    @Temporal(TemporalType.DATE)
    ////@Convert(converter = DateConverter.class)
    private Date pbldt;

    
    @Column(name="edt")
    @Temporal(TemporalType.DATE)
   // //@Convert(converter = DateConverter.class)
    private Date edt;

    @Column(name="pblshd")
    private Boolean pblshd;

    @Column(name="phn")
    private Integer phn;

    
    @Column(name="reff",length = 255)
    private String reff;

    @Column(name="rnk")
    private Boolean rnk;

    @Column(name="sdt")
    @Temporal(TemporalType.DATE)
   ////@Convert(converter = DateConverter.class)
    private Date sdt;

    @Column(name="spnsrd")
    private Boolean spnsrd;

    
    @Column(name="t",length = 255)
    private String t;

    
    @Column(name="t1",length = 255)
    private String t1;

    
    @Column(name="t2",length = 255)
    private String t2;

    
    @Column(name="t3",length = 255)
    private String t3;

    
    @Column(name="t4",length = 255)
    private String t4;

    
    @Column(name="unit",length = 255)
    private String unit;

    //bi-directional many-to-one association to Recrtr
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rtrt_id")
    private Recrtr recrtr;

    //bi-directional many-to-one association to Pstltn
    @OneToMany(mappedBy = "offrmpl")
    private List<Pstltn> pstltns;

    //bi-directional many-to-one association to RspSearchJob
    @OneToMany(mappedBy = "offrmpl")
    private List<RspSearchJob> rspSearchJobs;

    public Offrmpl() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getB() {
        return this.b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getB1() {
        return this.b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return this.b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB3() {
        return this.b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    public String getB4() {
        return this.b4;
    }

    public void setB4(String b4) {
        this.b4 = b4;
    }

    public Date getCdt() {
        return this.cdt;
    }

    public void setCdt(Date cdt) {
        this.cdt = cdt;
    }

    public Boolean getCntrlled() {
        return this.cntrlled;
    }

    public void setCntrlled(Boolean cntrlled) {
        this.cntrlled = cntrlled;
    }

    public String getCurcy() {
        return this.curcy;
    }

    public void setCurcy(String curcy) {
        this.curcy = curcy;
    }

    public String getLogouri() {
        return this.logouri;
    }

    public void setLogouri(String logouri) {
        this.logouri = logouri;
    }

    public Integer getMaxs() {
        return this.maxs;
    }

    public void setMaxs(Integer maxs) {
        this.maxs = maxs;
    }

    public Integer getMaxx() {
        return this.maxx;
    }

    public void setMaxx(Integer maxx) {
        this.maxx = maxx;
    }

    public Integer getMins() {
        return this.mins;
    }

    public void setMins(Integer mins) {
        this.mins = mins;
    }

    public Integer getMinx() {
        return this.minx;
    }

    public void setMinx(Integer minx) {
        this.minx = minx;
    }

    public String getMl() {
        return this.ml;
    }

    public void setMl(String ml) {
        this.ml = ml;
    }

    public Date getPbldt() {
        return this.pbldt;
    }

    public void setPbldt(Date pbldt) {
        this.pbldt = pbldt;
    }

    public Boolean getPblshd() {
        return this.pblshd;
    }

    public void setPblshd(Boolean pblshd) {
        this.pblshd = pblshd;
    }

    public Integer getPhn() {
        return this.phn;
    }

    public void setPhn(Integer phn) {
        this.phn = phn;
    }

    public String getReff() {
        return this.reff;
    }

    public void setReff(String reff) {
        this.reff = reff;
    }

    public Boolean getRnk() {
        return this.rnk;
    }

    public void setRnk(Boolean rnk) {
        this.rnk = rnk;
    }

    public Date getSdt() {
        return this.sdt;
    }

    public void setSdt(Date sdt) {
        this.sdt = sdt;
    }

    public Boolean getSpnsrd() {
        return this.spnsrd;
    }

    public void setSpnsrd(Boolean spnsrd) {
        this.spnsrd = spnsrd;
    }

    public String getT() {
        return this.t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getT1() {
        return this.t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return this.t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT3() {
        return this.t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getT4() {
        return this.t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Recrtr getRecrtr() {
        return this.recrtr;
    }

    public void setRecrtr(Recrtr recrtr) {
        this.recrtr = recrtr;
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
        pstltn.setOffrmpl(this);

        return pstltn;
    }

    public Pstltn removePstltn(Pstltn pstltn) {
        getPstltns().remove(pstltn);
        pstltn.setOffrmpl(null);

        return pstltn;
    }

    @XmlTransient
    public List<RspSearchJob> getRspSearchJobs() {
        return this.rspSearchJobs;
    }

    public void setRspSearchJobs(List<RspSearchJob> rspSearchJobs) {
        this.rspSearchJobs = rspSearchJobs;
    }

    public RspSearchJob addRspSearchJob(RspSearchJob rspSearchJob) {
        getRspSearchJobs().add(rspSearchJob);
        rspSearchJob.setOffrmpl(this);

        return rspSearchJob;
    }

    public RspSearchJob removeRspSearchJob(RspSearchJob rspSearchJob) {
        getRspSearchJobs().remove(rspSearchJob);
        rspSearchJob.setOffrmpl(null);

        return rspSearchJob;
    }

    public Date getEdt() {
        return edt;
    }

    public void setEdt(Date edt) {
        this.edt = edt;
    }

    public String getTitl() {
        return titl;
    }

    public void setTitl(String titl) {
        this.titl = titl;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getTypcontrat() {
        return typcontrat;
    }

    public void setTypcontrat(String typcontrat) {
        this.typcontrat = typcontrat;
    }

}
