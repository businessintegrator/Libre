package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rsp_search_job database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rsp_search_job")
//@NamedQuery(name="RspSearchJob.findAll", query="SELECT r FROM RspSearchJob r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RspSearchJob extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RSP_SEARCH_JOB_ID_GENERATOR", sequenceName="rspfjob_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RSP_SEARCH_JOB_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	//bi-directional many-to-one association to Offrmpl
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idjob")
	private Offrmpl offrmpl;

	//bi-directional many-to-one association to RqtSearchJob
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rqt")
	private RqtSearchJob rqtSearchJob;

	public RspSearchJob() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Offrmpl getOffrmpl() {
		return this.offrmpl;
	}

	public void setOffrmpl(Offrmpl offrmpl) {
		this.offrmpl = offrmpl;
	}

	public RqtSearchJob getRqtSearchJob() {
		return this.rqtSearchJob;
	}

	public void setRqtSearchJob(RqtSearchJob rqtSearchJob) {
		this.rqtSearchJob = rqtSearchJob;
	}

}