package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the cpt_recrut database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="cpt_recrut")
//@NamedQuery(name="CptRecrut.findAll", query="SELECT c FROM CptRecrut c")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class CptRecrut extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="CPT_RECRUT_ID_GENERATOR", sequenceName="cpt_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CPT_RECRUT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(name="classedereza_id")
	private Long classederezaId;

	private Integer nbcvonsult;

	private Integer nbjourdedroit;

	public CptRecrut() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassederezaId() {
		return this.classederezaId;
	}

	public void setClassederezaId(Long classederezaId) {
		this.classederezaId = classederezaId;
	}

	public Integer getNbcvonsult() {
		return this.nbcvonsult;
	}

	public void setNbcvonsult(Integer nbcvonsult) {
		this.nbcvonsult = nbcvonsult;
	}

	public Integer getNbjourdedroit() {
		return this.nbjourdedroit;
	}

	public void setNbjourdedroit(Integer nbjourdedroit) {
		this.nbjourdedroit = nbjourdedroit;
	}

}