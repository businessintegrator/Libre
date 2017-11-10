package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_select_candidate database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_select_candidate")
//@NamedQuery(name="RqtSelectCandidate.findAll", query="SELECT r FROM RqtSelectCandidate r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtSelectCandidate extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_SELECT_CANDIDATE_ID_GENERATOR", sequenceName="slctc_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_SELECT_CANDIDATE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	private Long recruter;

	private Boolean selected;

	@Column(name="selected_cv")
	private Long selectedCv;

	public RqtSelectCandidate() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRecruter() {
		return this.recruter;
	}

	public void setRecruter(Long recruter) {
		this.recruter = recruter;
	}

	public Boolean getSelected() {
		return this.selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Long getSelectedCv() {
		return this.selectedCv;
	}

	public void setSelectedCv(Long selectedCv) {
		this.selectedCv = selectedCv;
	}

}