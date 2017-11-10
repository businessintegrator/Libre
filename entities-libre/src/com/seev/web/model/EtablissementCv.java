package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the etablissement_cv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="etablissement_cv")
//@NamedQuery(name="EtablissementCv.findAll", query="SELECT e FROM EtablissementCv e")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class EtablissementCv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="ETABLISSEMENT_CV_ID_GENERATOR", sequenceName="etsb_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ETABLISSEMENT_CV_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=100)
	private String nm;

	@Column(length=255)
	private String url;

	//bi-directional many-to-one association to FormationCv
	@OneToMany(mappedBy="etablissementCv")
        @XmlTransient
	private List<FormationCv> formationCvs;

	public EtablissementCv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNm() {
		return this.nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		formationCv.setEtablissementCv(this);

		return formationCv;
	}

	public FormationCv removeFormationCv(FormationCv formationCv) {
		getFormationCvs().remove(formationCv);
		formationCv.setEtablissementCv(null);

		return formationCv;
	}

}