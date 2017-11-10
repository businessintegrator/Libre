package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the ref_techno database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="ref_techno")
//@NamedQuery(name="RefTechno.findAll", query="SELECT r FROM RefTechno r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RefTechno extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="REF_TECHNO_ID_GENERATOR", sequenceName="reftechno_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REF_TECHNO_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	//bi-directional many-to-one association to ComptenceCv
	@OneToMany(mappedBy="refTechno")
	private List<ComptenceCv> comptenceCvs;

        @Column(name="techno")
        private String techno;
        
	public RefTechno() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @XmlTransient
	public List<ComptenceCv> getComptenceCvs() {
		return this.comptenceCvs;
	}

	public void setComptenceCvs(List<ComptenceCv> comptenceCvs) {
		this.comptenceCvs = comptenceCvs;
	}

	public ComptenceCv addComptenceCv(ComptenceCv comptenceCv) {
		getComptenceCvs().add(comptenceCv);
		comptenceCv.setRefTechno(this);

		return comptenceCv;
	}

	public ComptenceCv removeComptenceCv(ComptenceCv comptenceCv) {
		getComptenceCvs().remove(comptenceCv);
		comptenceCv.setRefTechno(null);

		return comptenceCv;
	}

    public String getTechno() {
        return techno;
    }

    public void setTechno(String techno) {
        this.techno = techno;
    }
        
        

}