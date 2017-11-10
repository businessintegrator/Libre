package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the langage_cv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="langage_cv")
//@NamedQuery(name="LangageCv.findAll", query="SELECT l FROM LangageCv l")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class LangageCv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="LANGAGE_CV_ID_GENERATOR", sequenceName="lng_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LANGAGE_CV_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	//bi-directional many-to-one association to Cv
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cv_id")
        @XmlTransient
	private Cv cv;

	//bi-directional many-to-one association to ContentCv
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="txt_id")
	private ContentCv contentCv;

	//bi-directional many-to-one association to IntervaldtCv
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="interval_")
	private IntervaldtCv intervaldtCv;

	//bi-directional many-to-one association to RefLang
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="code_lang")
	private RefLang refLang;
        
        @Column(name="txt",length=40)
        private String txt;

	public LangageCv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cv getCv() {
		return this.cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public ContentCv getContentCv() {
		return this.contentCv;
	}

	public void setContentCv(ContentCv contentCv) {
		this.contentCv = contentCv;
	}

	public IntervaldtCv getIntervaldtCv() {
		return this.intervaldtCv;
	}

	public void setIntervaldtCv(IntervaldtCv intervaldtCv) {
		this.intervaldtCv = intervaldtCv;
	}

	public RefLang getRefLang() {
		return this.refLang;
	}

	public void setRefLang(RefLang refLang) {
		this.refLang = refLang;
	}

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

        
}