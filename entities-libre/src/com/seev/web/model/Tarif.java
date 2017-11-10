package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the tarif database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="tarif")
//@NamedQuery(name="Tarif.findAll", query="SELECT t FROM Tarif t")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Tarif extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="TARIF_ID_GENERATOR", sequenceName="trf_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TARIF_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Temporal(TemporalType.DATE)
	private Date applicationdt;

	private Integer maxduration;

	private Integer minduration;

	private Boolean nopenalite;

	private Boolean nrf;

	private double penalite;

	private Integer pfifty;

	private double prixapplique;

	private Integer reducrate;

	private Integer roe;

	//bi-directional many-to-one association to Clzreza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_clreza")
	private Clzreza clzreza;

	//bi-directional many-to-one association to Note
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="note_id")
	private Note note;

	public Tarif() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getApplicationdt() {
		return this.applicationdt;
	}

	public void setApplicationdt(Date applicationdt) {
		this.applicationdt = applicationdt;
	}

	public Integer getMaxduration() {
		return this.maxduration;
	}

	public void setMaxduration(Integer maxduration) {
		this.maxduration = maxduration;
	}

	public Integer getMinduration() {
		return this.minduration;
	}

	public void setMinduration(Integer minduration) {
		this.minduration = minduration;
	}

	public Boolean getNopenalite() {
		return this.nopenalite;
	}

	public void setNopenalite(Boolean nopenalite) {
		this.nopenalite = nopenalite;
	}

	public Boolean getNrf() {
		return this.nrf;
	}

	public void setNrf(Boolean nrf) {
		this.nrf = nrf;
	}

	public double getPenalite() {
		return this.penalite;
	}

	public void setPenalite(double penalite) {
		this.penalite = penalite;
	}

	public Integer getPfifty() {
		return this.pfifty;
	}

	public void setPfifty(Integer pfifty) {
		this.pfifty = pfifty;
	}

	public double getPrixapplique() {
		return this.prixapplique;
	}

	public void setPrixapplique(double prixapplique) {
		this.prixapplique = prixapplique;
	}

	public Integer getReducrate() {
		return this.reducrate;
	}

	public void setReducrate(Integer reducrate) {
		this.reducrate = reducrate;
	}

	public Integer getRoe() {
		return this.roe;
	}

	public void setRoe(Integer roe) {
		this.roe = roe;
	}

	public Clzreza getClzreza() {
		return this.clzreza;
	}

	public void setClzreza(Clzreza clzreza) {
		this.clzreza = clzreza;
	}

	public Note getNote() {
		return this.note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

}