package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the intervaldt_cv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="intervaldt_cv")
//@NamedQuery(name="IntervaldtCv.findAll", query="SELECT i FROM IntervaldtCv i")
@XmlType(name="Segment",propOrder = {"nd", "st"})  @XmlAccessorType(XmlAccessType.FIELD)
public class IntervaldtCv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="INTERVALDT_CV_ID_GENERATOR", sequenceName="intervaldt_cv_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INTERVALDT_CV_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Temporal(TemporalType.DATE)
	private Date nd;

	@Temporal(TemporalType.DATE)
	private Date st;

	//bi-directional many-to-one association to ExperienceCv
        @XmlTransient
	@OneToMany(mappedBy="intervaldtCv")
	private List<ExperienceCv> experienceCvs;

	//bi-directional many-to-one association to FormationCv
	@OneToMany(mappedBy="intervaldtCv")
        @XmlTransient
	private List<FormationCv> formationCvs;

	//bi-directional many-to-one association to LangageCv
	@OneToMany(mappedBy="intervaldtCv")
        @XmlTransient
	private List<LangageCv> langageCvs;

	public IntervaldtCv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getNd() {
		return this.nd;
	}

	public void setNd(Date nd) {
		this.nd = nd;
	}

	public Date getSt() {
		return this.st;
	}

	public void setSt(Date st) {
		this.st = st;
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
		experienceCv.setIntervaldtCv(this);

		return experienceCv;
	}

	public ExperienceCv removeExperienceCv(ExperienceCv experienceCv) {
		getExperienceCvs().remove(experienceCv);
		experienceCv.setIntervaldtCv(null);

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
		formationCv.setIntervaldtCv(this);

		return formationCv;
	}

	public FormationCv removeFormationCv(FormationCv formationCv) {
		getFormationCvs().remove(formationCv);
		formationCv.setIntervaldtCv(null);

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
		langageCv.setIntervaldtCv(this);

		return langageCv;
	}

	public LangageCv removeLangageCv(LangageCv langageCv) {
		getLangageCvs().remove(langageCv);
		langageCv.setIntervaldtCv(null);

		return langageCv;
	}

}