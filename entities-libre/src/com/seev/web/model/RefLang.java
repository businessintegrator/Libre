package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the ref_lang database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="ref_lang")
//@NamedQuery(name="RefLang.findAll", query="SELECT r FROM RefLang r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RefLang extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="REF_LANG_ID_GENERATOR", sequenceName="reflang_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REF_LANG_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=40)
	private String desc;

	@Column(length=3)
	private String locale;

	//bi-directional many-to-one association to LangageCv
	@OneToMany(mappedBy="refLang")
	private List<LangageCv> langageCvs;

	public RefLang() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
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
		langageCv.setRefLang(this);

		return langageCv;
	}

	public LangageCv removeLangageCv(LangageCv langageCv) {
		getLangageCvs().remove(langageCv);
		langageCv.setRefLang(null);

		return langageCv;
	}

}