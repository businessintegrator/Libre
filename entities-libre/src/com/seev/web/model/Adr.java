package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the adr database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="adr")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Adr extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="ADR_ID_GENERATOR", sequenceName="adr_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADR_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=255)
	private String codepostal;

	@Column(length=255)
	private String email;

	private Boolean emailvalid;

	@Column(length=255)
	private String line1;

	@Column(length=255)
	private String line2;

	@Column(length=255)
	private String line3;

	@Column(length=255)
	private String pays;

	@Column(length=255)
	private String telephone;

        @Column(length=255)
	private String fax;
	@Column(length=255)
	private String ville;

	

	//bi-directional many-to-one association to Curconv
	@OneToMany(mappedBy="adr")
	private List<Curconv> curconvs;

	public Adr() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodepostal() {
		return this.codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailvalid() {
		return this.emailvalid;
	}

	public void setEmailvalid(Boolean emailvalid) {
		this.emailvalid = emailvalid;
	}

	public String getLine1() {
		return this.line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return this.line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return this.line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

   
    @XmlTransient
	public List<Curconv> getCurconvs() {
		return this.curconvs;
	}

	public void setCurconvs(List<Curconv> curconvs) {
		this.curconvs = curconvs;
	}

	public Curconv addCurconv(Curconv curconv) {
		getCurconvs().add(curconv);
		curconv.setAdr(this);

		return curconv;
	}

	public Curconv removeCurconv(Curconv curconv) {
		getCurconvs().remove(curconv);
		curconv.setAdr(null);

		return curconv;
	}

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

}