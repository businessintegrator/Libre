package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;

/**
 * The persistent class for the xch_candidat database table.
 *
 */
@Entity
@Table(schema = "activeimage2", name = "xch_candidat")
//@NamedQuery(name="XchCandidat.findAll", query="SELECT x FROM XchCandidat x")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class XchCandidat extends Distributor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, schema = "activeimage2", name = "XCH_CANDIDAT_ID_GENERATOR", sequenceName = "x_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XCH_CANDIDAT_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    @XmlAttribute(name = "sId")
    private Long id;

    private Integer canal;

    @Column(name = "sts")
    private Integer sts=0;
    
    @Column(length = 4000,name = "bloc")
    private String bloc;
    

    private Boolean tocandidate;

    @Column(name = "numero")
    private Long numero;

    @Column(length = 4000, name = "resp")
    private String resp;

    @Column(length = 80, name = "titre")
    private String titre;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastupdt")
    private Date lastupdt;

    @Column(length = 255)
    private String token;

    @Column(length = 255)
    private String uri;

    @Temporal(TemporalType.DATE)
    private Date xchgdt;

    //bi-directional many-to-one association to Cndt
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fromcndt")
    private Cndt cndt1;

    //bi-directional many-to-one association to Cndt
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tocndt")
    private Cndt cndt2;

    public XchCandidat() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCanal() {
        return this.canal;
    }

    public void setCanal(Integer canal) {
        this.canal = canal;
    }

    public Boolean getTocandidate() {
        return this.tocandidate;
    }

    public void setTocandidate(Boolean tocandidate) {
        this.tocandidate = tocandidate;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getXchgdt() {
        return this.xchgdt;
    }

    public void setXchgdt(Date xchgdt) {
        this.xchgdt = xchgdt;
    }

    public Cndt getCndt1() {
        return this.cndt1;
    }

    public void setCndt1(Cndt cndt1) {
        this.cndt1 = cndt1;
    }

    public Cndt getCndt2() {
        return this.cndt2;
    }

    public void setCndt2(Cndt cndt2) {
        this.cndt2 = cndt2;
    }

    public Integer getSts() {
        return sts;
    }

    public void setSts(Integer sts) {
        this.sts = sts;
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

    
    
}
