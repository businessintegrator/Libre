package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the content_cv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="content_cv")
//@NamedQuery(name="ContentCv.findAll", query="SELECT c FROM ContentCv c")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class ContentCv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 50,allocationSize=1,schema="activeimage2",name="CONTENT_CV_ID_GENERATOR", sequenceName="cntntcv_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTENT_CV_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	private Boolean editable;

	private Boolean metadesc;

	@Column(length=40)
	private String titre;

	@Column(length=2000)
	private String txt;

	private Boolean visible;

	//bi-directional many-to-one association to ExperienceCv
	@OneToMany(mappedBy="contentCv")
	@XmlTransient
        private List<ExperienceCv> experienceCvs;

	//bi-directional many-to-one association to FormationCv
	@OneToMany(mappedBy="contentCv")
	@XmlTransient
        private List<FormationCv> formationCvs;

	//bi-directional many-to-one association to LangageCv
	@OneToMany(mappedBy="contentCv")
	@XmlTransient
        private List<LangageCv> langageCvs;

	public ContentCv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getEditable() {
		return this.editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Boolean getMetadesc() {
		return this.metadesc;
	}

	public void setMetadesc(Boolean metadesc) {
		this.metadesc = metadesc;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTxt() {
		return this.txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Boolean getVisible() {
		return this.visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

    @XmlTransient
	public List<ExperienceCv> getExperienceCvs() {
		return this.experienceCvs;
	}

	public void setExperienceCvs(List<ExperienceCv> experienceCvs) {
		this.experienceCvs = experienceCvs;
	}

	public ExperienceCv addExperienceCv(ExperienceCv experienceCv) {
		getExperienceCvs().add(experienceCv);
		experienceCv.setContentCv(this);

		return experienceCv;
	}

	public ExperienceCv removeExperienceCv(ExperienceCv experienceCv) {
		getExperienceCvs().remove(experienceCv);
		experienceCv.setContentCv(null);

		return experienceCv;
	}

    @XmlTransient
	public List<FormationCv> getFormationCvs() {
		return this.formationCvs;
	}

	public void setFormationCvs(List<FormationCv> formationCvs) {
		this.formationCvs = formationCvs;
	}

	public FormationCv addFormationCv(FormationCv formationCv) {
		getFormationCvs().add(formationCv);
		formationCv.setContentCv(this);

		return formationCv;
	}

	public FormationCv removeFormationCv(FormationCv formationCv) {
		getFormationCvs().remove(formationCv);
		formationCv.setContentCv(null);

		return formationCv;
	}

    @XmlTransient
	public List<LangageCv> getLangageCvs() {
		return this.langageCvs;
	}

	public void setLangageCvs(List<LangageCv> langageCvs) {
		this.langageCvs = langageCvs;
	}

	public LangageCv addLangageCv(LangageCv langageCv) {
		getLangageCvs().add(langageCv);
		langageCv.setContentCv(this);

		return langageCv;
	}

	public LangageCv removeLangageCv(LangageCv langageCv) {
		getLangageCvs().remove(langageCv);
		langageCv.setContentCv(null);

		return langageCv;
	}

}