package com.seev.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * The persistent class for the xchg_rctr database table.
 *
 */
@Entity
@Table(schema = "activeimage2", name = "xchg_rctr")
//@NamedQuery(name="XchgRctr.findAll", query="SELECT x FROM XchgRctr x")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class XchgRctr extends Distributor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, schema = "activeimage2", name = "XCHG_RCTR_ID_GENERATOR", sequenceName = "z_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XCHG_RCTR_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    @XmlAttribute(name = "sId")
    private Long id;

    private Long canal;

    @Column(name = "torecruter")
    private Boolean torecruter;
    

    @Column(name = "sts")
    private Integer sts = 0;
    
    @Column(name = "numero")
    private Long numero;
    
    @Column(length = 4000,name = "resp")
    private String resp;
    
    @Column(length = 80,name = "titre")
    private String titre;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "lastupdt")
    private Date lastupdt;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "submitdt")
    private Date submitdt;

    @Column(length = 4000,name = "bloc")
    private String bloc;
    
    @Column(length = 255)
    private String uri;

    //bi-directional many-to-one association to SocieteCptRecrut
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fromrcrt")
    private Recrtr societeCptRecrut1;

    //bi-directional many-to-one association to SocieteCptRecrut
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "torctr")
    private Recrtr societeCptRecrut2;

    public XchgRctr() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCanal() {
        return this.canal;
    }

    public void setCanal(Long canal) {
        this.canal = canal;
    }

    public Boolean getTorecruter() {
        return this.torecruter;
    }

    public void setTorecruter(Boolean torecruter) {
        this.torecruter = torecruter;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Recrtr getSocieteCptRecrut1() {
        return this.societeCptRecrut1;
    }

    public void setSocieteCptRecrut1(Recrtr societeCptRecrut1) {
        this.societeCptRecrut1 = societeCptRecrut1;
    }

    public Recrtr getSocieteCptRecrut2() {
        return this.societeCptRecrut2;
    }

    public void setSocieteCptRecrut2(Recrtr societeCptRecrut2) {
        this.societeCptRecrut2 = societeCptRecrut2;
    }

    public Integer getSts() {
        return sts;
    }

    public void setSts(Integer sts) {
        this.sts = sts;
    }

    public Date getLastupdt() {
        return lastupdt;
    }

    public void setLastupdt(Date lastupdt) {
        this.lastupdt = lastupdt;
    }

    public String getBloc() {
        return bloc;
    }

    public void setBloc(String bloc) {
        this.bloc = bloc;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getSubmitdt() {
        return submitdt;
    }

    public void setSubmitdt(Date submitdt) {
        this.submitdt = submitdt;
    }


    
    
}
