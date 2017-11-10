package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the ref_cntry database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="ref_cntry")
//@NamedQuery(name="RefCntry.findAll", query="SELECT r FROM RefCntry r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RefCntry extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="REF_CNTRY_ID_GENERATOR", sequenceName="refcntry_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REF_CNTRY_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=3)
	private String iso;

	public RefCntry() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

}