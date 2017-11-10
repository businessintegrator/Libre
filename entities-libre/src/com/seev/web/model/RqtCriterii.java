package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the rqt_criterii database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_criterii")
//@NamedQuery(name="RqtCriterii.findAll", query="SELECT r FROM RqtCriterii r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtCriterii extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_CRITERII_ID_GENERATOR", sequenceName="crtrii_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_CRITERII_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=20)
	private String ckey;

	@Column(length=20)
	private String cval;

	//bi-directional many-to-one association to RqtCriterii
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="next")
	private RqtCriterii rqtCriterii;

	//bi-directional many-to-one association to RqtCriterii
	/*@OneToMany(mappedBy="rqtCriterii")
	private List<RqtCriterii> rqtCriteriis;*/

	//bi-directional many-to-one association to RqtSearchCandidate
	/*@OneToMany(mappedBy="rqtCriterii")
	private List<RqtSearchCandidate> rqtSearchCandidates;*/

	//bi-directional many-to-one association to RqtSearchJob
	/*@OneToMany(mappedBy="rqtCriterii1")
	private List<RqtSearchJob> rqtSearchJobs1;*/

	//bi-directional many-to-one association to RqtSearchJob
	/*@OneToMany(mappedBy="rqtCriterii2")
	private List<RqtSearchJob> rqtSearchJobs2;*/

	public RqtCriterii() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCkey() {
		return this.ckey;
	}

	public void setCkey(String ckey) {
		this.ckey = ckey;
	}

	public String getCval() {
		return this.cval;
	}

	public void setCval(String cval) {
		this.cval = cval;
	}

	public RqtCriterii getRqtCriterii() {
		return this.rqtCriterii;
	}

	public void setRqtCriterii(RqtCriterii rqtCriterii) {
		this.rqtCriterii = rqtCriterii;
	}

   /* @XmlTransient
	public List<RqtCriterii> getRqtCriteriis() {
		return this.rqtCriteriis;
	}

	public void setRqtCriteriis(List<RqtCriterii> rqtCriteriis) {
		this.rqtCriteriis = rqtCriteriis;
	}*/

	/*public RqtCriterii addRqtCriterii(RqtCriterii rqtCriterii) {
		getRqtCriteriis().add(rqtCriterii);
		rqtCriterii.setRqtCriterii(this);

		return rqtCriterii;
	}

	public RqtCriterii removeRqtCriterii(RqtCriterii rqtCriterii) {
		getRqtCriteriis().remove(rqtCriterii);
		rqtCriterii.setRqtCriterii(null);

		return rqtCriterii;
	}*/

  /*  @XmlTransient
	public List<RqtSearchCandidate> getRqtSearchCandidates() {
		return this.rqtSearchCandidates;
	}

	public void setRqtSearchCandidates(List<RqtSearchCandidate> rqtSearchCandidates) {
		this.rqtSearchCandidates = rqtSearchCandidates;
	}*/

	/*public RqtSearchCandidate addRqtSearchCandidate(RqtSearchCandidate rqtSearchCandidate) {
		getRqtSearchCandidates().add(rqtSearchCandidate);
		rqtSearchCandidate.setRqtCriterii(this);

		return rqtSearchCandidate;
	}

	public RqtSearchCandidate removeRqtSearchCandidate(RqtSearchCandidate rqtSearchCandidate) {
		getRqtSearchCandidates().remove(rqtSearchCandidate);
		rqtSearchCandidate.setRqtCriterii(null);

		return rqtSearchCandidate;
	}*/

   /* @XmlTransient
	public List<RqtSearchJob> getRqtSearchJobs1() {
		return this.rqtSearchJobs1;
	}

	public void setRqtSearchJobs1(List<RqtSearchJob> rqtSearchJobs1) {
		this.rqtSearchJobs1 = rqtSearchJobs1;
	}*/

	/*public RqtSearchJob addRqtSearchJobs1(RqtSearchJob rqtSearchJobs1) {
		getRqtSearchJobs1().add(rqtSearchJobs1);
		rqtSearchJobs1.setRqtCriterii1(this);

		return rqtSearchJobs1;
	}

	public RqtSearchJob removeRqtSearchJobs1(RqtSearchJob rqtSearchJobs1) {
		getRqtSearchJobs1().remove(rqtSearchJobs1);
		rqtSearchJobs1.setRqtCriterii1(null);

		return rqtSearchJobs1;
	}*/

   /* @XmlTransient
	public List<RqtSearchJob> getRqtSearchJobs2() {
		return this.rqtSearchJobs2;
	}

	public void setRqtSearchJobs2(List<RqtSearchJob> rqtSearchJobs2) {
		this.rqtSearchJobs2 = rqtSearchJobs2;
	}*/

	/*public RqtSearchJob addRqtSearchJobs2(RqtSearchJob rqtSearchJobs2) {
		getRqtSearchJobs2().add(rqtSearchJobs2);
		rqtSearchJobs2.setRqtCriterii2(this);

		return rqtSearchJobs2;
	}*/

	/*public RqtSearchJob removeRqtSearchJobs2(RqtSearchJob rqtSearchJobs2) {
		getRqtSearchJobs2().remove(rqtSearchJobs2);
		rqtSearchJobs2.setRqtCriterii2(null);

		return rqtSearchJobs2;
	}*/

}