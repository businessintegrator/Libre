package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the cmnd database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="cmnd")
//@NamedQuery(name="Cmnd.findAll", query="SELECT c FROM Cmnd c")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Cmnd extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="CMND_ID_GENERATOR", sequenceName="cmnd_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CMND_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Temporal(TemporalType.DATE)
	private Date dtcmd;
        
        @Temporal(TemporalType.DATE)
	private Date usedt;
        
        @Column(name="ddt")
        @Temporal(TemporalType.DATE)
	private Date dueDate;
        
        @Column(name="cdt")
        @Temporal(TemporalType.DATE)
	private Date cancelDate;
       
	@Column(length=1)
	private String stscmd;

        @Column(length=110,name="e2e")
	private String e2e;
	//bi-directional many-to-one association to Produit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prd_id")
	private Produit produit;

	//bi-directional many-to-one association to Recrtr
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rctr_id")
	private Recrtr recrtr;

	public Cmnd() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtcmd() {
		return this.dtcmd;
	}

	public void setDtcmd(Date dtcmd) {
		this.dtcmd = dtcmd;
	}

	public String getStscmd() {
		return this.stscmd;
	}

	public void setStscmd(String stscmd) {
		this.stscmd = stscmd;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Recrtr getRecrtr() {
		return this.recrtr;
	}

	public void setRecrtr(Recrtr recrtr) {
		this.recrtr = recrtr;
	}

    public String getE2e() {
        return e2e;
    }

    public void setE2e(String e2e) {
        this.e2e = e2e;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Date getUsedt() {
        return usedt;
    }

    public void setUsedt(Date usedt) {
        this.usedt = usedt;
    }

    
 
    
}