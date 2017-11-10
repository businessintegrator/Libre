package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the comptence_cv database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="comptence_cv")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class ComptenceCv extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="COMPTENCE_CV_ID_GENERATOR", sequenceName="ccv_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPTENCE_CV_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	
        @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cv_ref")
	private Cv cvRef;

	private Integer rank;

	//bi-directional many-to-one association to RefTechno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="comptence")
	private RefTechno refTechno;
        
        @Column(name="extracted",length = 8)
        private String extracted;

	public ComptenceCv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cv getCvRef() {
		return this.cvRef;
	}

	public void setCvRef(Cv cvRef) {
		this.cvRef = cvRef;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public RefTechno getRefTechno() {
		return this.refTechno;
	}

	public void setRefTechno(RefTechno refTechno) {
		this.refTechno = refTechno;
	}

    public String getExtracted() {
        return extracted;
    }

    public void setExtracted(String extracted) {
        this.extracted = extracted;
    }
        

}