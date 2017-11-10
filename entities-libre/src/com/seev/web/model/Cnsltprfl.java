package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the cnsltprfl database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="cnsltprfl")
//@NamedQuery(name="Cnsltprfl.findAll", query="SELECT c FROM Cnsltprfl c")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Cnsltprfl extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="CNSLTPRFL_ID_GENERATOR", sequenceName="cnsltprfl_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CNSLTPRFL_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Temporal(TemporalType.DATE)
	private Date dtcns;

	//bi-directional many-to-one association to Cv
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cv_id")
        @XmlTransient
	private Cv cv;

	//bi-directional many-to-one association to Recrtr
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rcrtr_id")
        @XmlElement
	private Recrtr recrtr;

	public Cnsltprfl() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtcns() {
		return this.dtcns;
	}

	public void setDtcns(Date dtcns) {
		this.dtcns = dtcns;
	}

	public Cv getCv() {
		return this.cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public Recrtr getRecrtr() {
		return this.recrtr;
	}

	public void setRecrtr(Recrtr recrtr) {
		this.recrtr = recrtr;
	}

}