package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the societe database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="societe")
//@NamedQuery(name="Societe.findAll", query="SELECT s FROM Societe s")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Societe extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="SOCIETE_ID_GENERATOR", sequenceName="cnpy_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOCIETE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

        @Column(length=255,name = "refclient")
	private String refClient;
                
	@Column(length=255)
	private String cd;
        
        @Column(length=252)
	private String mailext;

	@Column(length=255)
	private String cmname;

	private double rate;

	@Column(length=9)
	private String siret;
        @Column(length=5,unique=true)
	private String siren;

	@Column(length=255)
	private String tvanumber;

	//bi-directional many-to-one association to Adr
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="adr_soc_id")
	private Adr adr;

	public Societe() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCd() {
		return this.cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCmname() {
		return this.cmname;
	}

	public void setCmname(String cmname) {
		this.cmname = cmname;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getSiret() {
		return this.siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getTvanumber() {
		return this.tvanumber;
	}

	public void setTvanumber(String tvanumber) {
		this.tvanumber = tvanumber;
	}

	public Adr getAdr() {
		return this.adr;
	}

	public void setAdr(Adr adr) {
		this.adr = adr;
	}

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }

    public String getMailext() {
        return mailext;
    }

    public void setMailext(String mailext) {
        this.mailext = mailext;
    }

    public String getRefClient() {
        return refClient;
    }

    public void setRefClient(String refClient) {
        this.refClient = refClient;
    }

        
}