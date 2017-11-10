package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_offerctrl database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_offerctrl")
//@NamedQuery(name="RqtOfferctrl.findAll", query="SELECT r FROM RqtOfferctrl r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtOfferctrl extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_OFFERCTRL_ID_GENERATOR", sequenceName="rqtoffer_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_OFFERCTRL_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(name="offer_id")
	private Long offerId;

	@Column(length=80)
	private String reason;

	@Temporal(TemporalType.DATE)
	private Date updt;

	private Boolean valid;

	public RqtOfferctrl() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOfferId() {
		return this.offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getUpdt() {
		return this.updt;
	}

	public void setUpdt(Date updt) {
		this.updt = updt;
	}

	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

}