package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the rqt_search_candidate database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_search_candidate")
//@NamedQuery(name="RqtSearchCandidate.findAll", query="SELECT r FROM RqtSearchCandidate r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtSearchCandidate extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_SEARCH_CANDIDATE_ID_GENERATOR", sequenceName="search_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_SEARCH_CANDIDATE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	//bi-directional many-to-one association to RqtCriterii
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="root_criteria")
	private RqtCriterii rqtCriterii;

	//bi-directional many-to-one association to RspSearchCandidate
	@OneToMany(mappedBy="rqtSearchCandidate")
	private List<RspSearchCandidate> rspSearchCandidates;

	public RqtSearchCandidate() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RqtCriterii getRqtCriterii() {
		return this.rqtCriterii;
	}

	public void setRqtCriterii(RqtCriterii rqtCriterii) {
		this.rqtCriterii = rqtCriterii;
	}

    @XmlTransient
	public List<RspSearchCandidate> getRspSearchCandidates() {
		return this.rspSearchCandidates;
	}

	public void setRspSearchCandidates(List<RspSearchCandidate> rspSearchCandidates) {
		this.rspSearchCandidates = rspSearchCandidates;
	}

	public RspSearchCandidate addRspSearchCandidate(RspSearchCandidate rspSearchCandidate) {
		getRspSearchCandidates().add(rspSearchCandidate);
		rspSearchCandidate.setRqtSearchCandidate(this);

		return rspSearchCandidate;
	}

	public RspSearchCandidate removeRspSearchCandidate(RspSearchCandidate rspSearchCandidate) {
		getRspSearchCandidates().remove(rspSearchCandidate);
		rspSearchCandidate.setRqtSearchCandidate(null);

		return rspSearchCandidate;
	}

}