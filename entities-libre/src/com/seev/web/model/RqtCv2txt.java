package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_cv2txt database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_cv2txt")
//@NamedQuery(name="RqtCv2txt.findAll", query="SELECT r FROM RqtCv2txt r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtCv2txt extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_CV2TXT_ID_GENERATOR", sequenceName="cvtxt_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_CV2TXT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=255)
	private String fromuri;

	@Column(length=255)
	private String tourisuffix;

	//bi-directional many-to-one association to Cndt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="requester")
	private Cndt cndt;

	public RqtCv2txt() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromuri() {
		return this.fromuri;
	}

	public void setFromuri(String fromuri) {
		this.fromuri = fromuri;
	}

	public String getTourisuffix() {
		return this.tourisuffix;
	}

	public void setTourisuffix(String tourisuffix) {
		this.tourisuffix = tourisuffix;
	}

	public Cndt getCndt() {
		return this.cndt;
	}

	public void setCndt(Cndt cndt) {
		this.cndt = cndt;
	}

}