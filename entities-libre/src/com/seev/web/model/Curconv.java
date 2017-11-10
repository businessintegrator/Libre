package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the curconv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="curconv")
//@NamedQuery(name="Curconv.findAll", query="SELECT c FROM Curconv c")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Curconv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="CURCONV_ID_GENERATOR", sequenceName="cur_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CURCONV_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	private double internal;

	//bi-directional many-to-one association to Adr
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ccy_id")
	private Adr adr;

	public Curconv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getInternal() {
		return this.internal;
	}

	public void setInternal(double internal) {
		this.internal = internal;
	}

	public Adr getAdr() {
		return this.adr;
	}

	public void setAdr(Adr adr) {
		this.adr = adr;
	}

}