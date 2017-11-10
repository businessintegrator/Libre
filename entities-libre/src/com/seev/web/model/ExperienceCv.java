package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the experience_cv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="experience_cv")
//@NamedQuery(name="ExperienceCv.findAll", query="SELECT e FROM ExperienceCv e")
 @XmlAccessorType(XmlAccessType.FIELD)
public class ExperienceCv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="EXPERIENCE_CV_ID_GENERATOR2", sequenceName="exp_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXPERIENCE_CV_ID_GENERATOR2")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

        @XmlAttribute
        @Column(name="displayorder")
        
	private Integer displayorder;
        @XmlTransient
	private Long societe;
        
        @Column(name = "extractedsociete",length = 80)
        private String extractedsociete;

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
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="interval_")
	private IntervaldtCv intervaldtCv;

        @Column(name="txt")
        private String txt;
        
	public ExperienceCv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}

	public Long getSociete() {
		return this.societe;
	}

	public void setSociete(Long societe) {
		this.societe = societe;
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

    public String getExtractedsociete() {
        return extractedsociete;
    }

    public void setExtractedsociete(String extractedsociete) {
        this.extractedsociete = extractedsociete;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

        
}