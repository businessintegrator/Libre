package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the ref_comptence database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="ref_comptence")
//@NamedQuery(name="RefComptence.findAll", query="SELECT r FROM RefComptence r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RefComptence extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="REF_COMPTENCE_ID_GENERATOR", sequenceName="rfcmptnc_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REF_COMPTENCE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=20)
	private String competence;

	public RefComptence() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompetence() {
		return this.competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
	}

}