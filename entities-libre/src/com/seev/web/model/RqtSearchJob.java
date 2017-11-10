package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the rqt_search_job database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_search_job")
//@NamedQuery(name="RqtSearchJob.findAll", query="SELECT r FROM RqtSearchJob r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtSearchJob extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_SEARCH_JOB_ID_GENERATOR", sequenceName="sjob_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_SEARCH_JOB_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=7)
	private String searchname;

	//bi-directional many-to-one association to RqtCriterii
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="root_crirteria")
	private RqtCriterii rqtCriterii1;

	//bi-directional many-to-one association to RqtCriterii
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="root_crirteria")
	private RqtCriterii rqtCriterii2;*/

	//bi-directional many-to-one association to RspSearchJob
	@OneToMany(mappedBy="rqtSearchJob")
	private List<RspSearchJob> rspSearchJobs;

	public RqtSearchJob() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSearchname() {
		return this.searchname;
	}

	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}

	public RqtCriterii getRqtCriterii1() {
		return this.rqtCriterii1;
	}

	public void setRqtCriterii1(RqtCriterii rqtCriterii1) {
		this.rqtCriterii1 = rqtCriterii1;
	}

	/*public RqtCriterii getRqtCriterii2() {
		return this.rqtCriterii2;
	}

	public void setRqtCriterii2(RqtCriterii rqtCriterii2) {
		this.rqtCriterii2 = rqtCriterii2;
	}*/

    @XmlTransient
	public List<RspSearchJob> getRspSearchJobs() {
		return this.rspSearchJobs;
	}

	public void setRspSearchJobs(List<RspSearchJob> rspSearchJobs) {
		this.rspSearchJobs = rspSearchJobs;
	}

	public RspSearchJob addRspSearchJob(RspSearchJob rspSearchJob) {
		getRspSearchJobs().add(rspSearchJob);
		rspSearchJob.setRqtSearchJob(this);

		return rspSearchJob;
	}

	public RspSearchJob removeRspSearchJob(RspSearchJob rspSearchJob) {
		getRspSearchJobs().remove(rspSearchJob);
		rspSearchJob.setRqtSearchJob(null);

		return rspSearchJob;
	}

}