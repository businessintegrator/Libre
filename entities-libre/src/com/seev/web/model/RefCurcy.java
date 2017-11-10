package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the ref_curcy database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="ref_curcy")
//@NamedQuery(name="RefCurcy.findAll", query="SELECT r FROM RefCurcy r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RefCurcy extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="REF_CURCY_ID_GENERATOR", sequenceName="refccy_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REF_CURCY_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=5)
	private String ccycd;

	public RefCurcy() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCcycd() {
		return this.ccycd;
	}

	public void setCcycd(String ccycd) {
		this.ccycd = ccycd;
	}

}