package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the note database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="note")
//@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Note extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="NOTE_ID_GENERATOR", sequenceName="nt_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=4000)
	private String note;

	//bi-directional many-to-one association to Tarif
	@OneToMany(mappedBy="note")
	private List<Tarif> tarifs;

	public Note() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

    @XmlTransient
	public List<Tarif> getTarifs() {
		return this.tarifs;
	}

	public void setTarifs(List<Tarif> tarifs) {
		this.tarifs = tarifs;
	}

	public Tarif addTarif(Tarif tarif) {
		getTarifs().add(tarif);
		tarif.setNote(this);

		return tarif;
	}

	public Tarif removeTarif(Tarif tarif) {
		getTarifs().remove(tarif);
		tarif.setNote(null);

		return tarif;
	}

}