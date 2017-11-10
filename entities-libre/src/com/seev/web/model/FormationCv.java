package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the formation_cv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="formation_cv")
//@NamedQuery(name="FormationCv.findAll", query="SELECT f FROM FormationCv f")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class FormationCv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="FORMATION_CV_ID_GENERATOR", sequenceName="forma_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMATION_CV_ID_GENERATOR")
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

	//bi-directional many-to-one association to EtablissementCv
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="etablissement")
	private EtablissementCv etablissementCv;

	//bi-directional many-to-one association to IntervaldtCv
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="interval_")
	private IntervaldtCv intervaldtCv;

        @Column(name="txt")
        private String txt;
        
	public FormationCv() {
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

	public EtablissementCv getEtablissementCv() {
		return this.etablissementCv;
	}

	public void setEtablissementCv(EtablissementCv etablissementCv) {
		this.etablissementCv = etablissementCv;
	}

	public IntervaldtCv getIntervaldtCv() {
		return this.intervaldtCv;
	}

	public void setIntervaldtCv(IntervaldtCv intervaldtCv) {
		this.intervaldtCv = intervaldtCv;
	}

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
        

}