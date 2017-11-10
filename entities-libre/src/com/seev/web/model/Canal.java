package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the canal database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="canal")

@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Canal extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="CANAL_ID_GENERATOR", sequenceName="canal_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CANAL_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=7)
	private String nm;

	public Canal() {
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

}