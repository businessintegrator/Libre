/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author tiaray
 */
@Entity
@Table(schema = "activeimage2", name = "other_cv")
//@NamedQuery(name="EtablissementCv.findAll", query="SELECT e FROM EtablissementCv e")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class OtherCv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, schema = "activeimage2", name = "EXPERIENCE_CV_ID_GENERATOR", sequenceName = "other_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPERIENCE_CV_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    @XmlAttribute(name = "sId")
    private Long id;
    @Column(name = "hobby")
    private Boolean hobby;
    @Column(name = "other")
    private Boolean other;
    @Column(name = "complement")
    private Boolean complement;

    //bi-directional many-to-one association to Cv
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_ref")
    @XmlTransient
    private Cv cv;

    //bi-directional many-to-one association to ContentCv
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "content")
    private ContentCv contentCv;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "interval_")
    private IntervaldtCv intervaldtCv;

    public OtherCv() {
    }

    public OtherCv(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getHobby() {
        return hobby;
    }

    public void setHobby(Boolean hobby) {
        this.hobby = hobby;
    }

    public Boolean getOther() {
        return other;
    }

    public void setOther(Boolean other) {
        this.other = other;
    }

    public Boolean getComplement() {
        return complement;
    }

    public void setComplement(Boolean complement) {
        this.complement = complement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OtherCv)) {
            return false;
        }
        OtherCv other = (OtherCv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seev.web.model.OtherCv[ id=" + id + " ]";
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public ContentCv getContentCv() {
        return contentCv;
    }

    public void setContentCv(ContentCv contentCv) {
        this.contentCv = contentCv;
    }

    public IntervaldtCv getIntervaldtCv() {
        return intervaldtCv;
    }

    public void setIntervaldtCv(IntervaldtCv intervaldtCv) {
        this.intervaldtCv = intervaldtCv;
    }

}
