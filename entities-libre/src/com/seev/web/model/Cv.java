package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the cv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="cv")
@XmlRootElement(name="Cv") 
@XmlAccessorType(XmlAccessType.FIELD)
public class Cv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="CV_ID_GENERATOR", sequenceName="cv_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CV_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;
        @Column(name="actif")
        @XmlElement(name="Actif")
	private Boolean actif = false;
        
        @Column(name="titre",length=255)
        @XmlElement(name="Title")
        private String titre;
        
        @Column(name="metacategory",length=255)
        @XmlElement(name="Metacategory")
        private String metacategory;
        
	@Temporal(TemporalType.DATE)
        @Column(name="pdt")
        @XmlElement(name = "PublishedDate")
	private Date pdt;

        @Column(name="rang")
        @XmlElement(name="Rank")
	private Integer rang;

	@Column(name="storage",length=255)
        @XmlElement(name="Storage")
	private String storage;

        @Column(length=255,name="mtype")
        @XmlElement(name="MType")
        private String mtype;
	//bi-directional many-to-one association to Cnsltprfl
	@OneToMany(mappedBy="cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @XmlElement(name="Consultations")
	private List<Cnsltprfl> cnsltprfls = null;

	//bi-directional many-to-one association to Cndt
        @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="owner_id")
        @XmlElement(name="Candidate")
	private Cndt cndt;

	//bi-directional many-to-one association to ExperienceCv
	@OneToMany(mappedBy="cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @XmlElement(name="Experience")
	private List<ExperienceCv> experienceCvs = null;

	//bi-directional many-to-one association to FormationCv
	@OneToMany(mappedBy="cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @XmlElement(name="Formation")
	private List<FormationCv> formationCvs= null;

	//bi-directional many-to-one association to LangageCv
	@OneToMany(mappedBy="cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @XmlElement(name="Lang")
	private List<LangageCv> langageCvs= null;

	//bi-directional many-to-one association to Pstltn
	@OneToMany(mappedBy="cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @XmlElement(name="Postulations")
	private List<Pstltn> pstltns= null;

	public Cv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActif() {
		return this.actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Date getPdt() {
		return this.pdt;
	}

	public void setPdt(Date pdt) {
		this.pdt = pdt;
	}

	public Integer getRang() {
		return this.rang;
	}

	public void setRang(Integer rang) {
		this.rang = rang;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

    
	public List<Cnsltprfl> getCnsltprfls() {
		return this.cnsltprfls;
	}

	public void setCnsltprfls(List<Cnsltprfl> cnsltprfls) {
		this.cnsltprfls = cnsltprfls;
	}

	public Cnsltprfl addCnsltprfl(Cnsltprfl cnsltprfl) {
		getCnsltprfls().add(cnsltprfl);
		cnsltprfl.setCv(this);

		return cnsltprfl;
	}

	public Cnsltprfl removeCnsltprfl(Cnsltprfl cnsltprfl) {
		getCnsltprfls().remove(cnsltprfl);
		cnsltprfl.setCv(null);

		return cnsltprfl;
	}

	public Cndt getCndt() {
		return this.cndt;
	}

	public void setCndt(Cndt cndt) {
		this.cndt = cndt;
	}

    
	public List<ExperienceCv> getExperienceCvs() {
		return this.experienceCvs;
	}

	public void setExperienceCvs(List<ExperienceCv> experienceCvs) {
		this.experienceCvs = experienceCvs;
	}

	public ExperienceCv addExperienceCv(ExperienceCv experienceCv) {
		getExperienceCvs().add(experienceCv);
		experienceCv.setCv(this);

		return experienceCv;
	}

	public ExperienceCv removeExperienceCv(ExperienceCv experienceCv) {
		getExperienceCvs().remove(experienceCv);
		experienceCv.setCv(null);

		return experienceCv;
	}

    
	public List<FormationCv> getFormationCvs() {
		return this.formationCvs;
	}

	public void setFormationCvs(List<FormationCv> formationCvs) {
		this.formationCvs = formationCvs;
	}

	public FormationCv addFormationCv(FormationCv formationCv) {
		getFormationCvs().add(formationCv);
		formationCv.setCv(this);

		return formationCv;
	}

	public FormationCv removeFormationCv(FormationCv formationCv) {
		getFormationCvs().remove(formationCv);
		formationCv.setCv(null);

		return formationCv;
	}

    
	public List<LangageCv> getLangageCvs() {
		return this.langageCvs;
	}

	public void setLangageCvs(List<LangageCv> langageCvs) {
		this.langageCvs = langageCvs;
	}

	public LangageCv addLangageCv(LangageCv langageCv) {
		getLangageCvs().add(langageCv);
		langageCv.setCv(this);

		return langageCv;
	}

	public LangageCv removeLangageCv(LangageCv langageCv) {
		getLangageCvs().remove(langageCv);
		langageCv.setCv(null);

		return langageCv;
	}

    
	public List<Pstltn> getPstltns() {
		return this.pstltns;
	}

	public void setPstltns(List<Pstltn> pstltns) {
		this.pstltns = pstltns;
	}

	public Pstltn addPstltn(Pstltn pstltn) {
		getPstltns().add(pstltn);
		pstltn.setCv(this);

		return pstltn;
	}

	public Pstltn removePstltn(Pstltn pstltn) {
		getPstltns().remove(pstltn);
		pstltn.setCv(null);

		return pstltn;
	}

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMetacategory() {
        return metacategory;
    }

    public void setMetacategory(String metacategory) {
        this.metacategory = metacategory;
    }

    
}