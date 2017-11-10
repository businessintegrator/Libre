package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rsp_search_candidate database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rsp_search_candidate")
//@NamedQuery(name="RspSearchCandidate.findAll", query="SELECT r FROM RspSearchCandidate r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RspSearchCandidate extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RSP_SEARCH_CANDIDATE_ID_GENERATOR", sequenceName="rspcnt_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RSP_SEARCH_CANDIDATE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	private Long rqt;

	//bi-directional many-to-one association to RqtSearchCandidate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcv")
	private RqtSearchCandidate rqtSearchCandidate;

	public RspSearchCandidate() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRqt() {
		return this.rqt;
	}

	public void setRqt(Long rqt) {
		this.rqt = rqt;
	}

	public RqtSearchCandidate getRqtSearchCandidate() {
		return this.rqtSearchCandidate;
	}

	public void setRqtSearchCandidate(RqtSearchCandidate rqtSearchCandidate) {
		this.rqtSearchCandidate = rqtSearchCandidate;
	}

}