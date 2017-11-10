package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the bloc database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="bloc")

@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Bloc extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="BLOC_ID_GENERATOR", sequenceName="bloc_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLOC_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=2000)
	private String b;

	@Column(length=40)
	private String t;

	public Bloc() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getT() {
		return this.t;
	}

	public void setT(String t) {
		this.t = t;
	}

}