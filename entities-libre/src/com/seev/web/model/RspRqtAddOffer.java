package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rsp_rqt_add_offer database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rsp_rqt_add_offer")
//@NamedQuery(name="RspRqtAddOffer.findAll", query="SELECT r FROM RspRqtAddOffer r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RspRqtAddOffer extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RSP_RQT_ADD_OFFER_ID_GENERATOR", sequenceName="addoffer_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RSP_RQT_ADD_OFFER_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(name="added_offer")
	private Long addedOffer;

	private Long requester;

	public RspRqtAddOffer() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAddedOffer() {
		return this.addedOffer;
	}

	public void setAddedOffer(Long addedOffer) {
		this.addedOffer = addedOffer;
	}

	public Long getRequester() {
		return this.requester;
	}

	public void setRequester(Long requester) {
		this.requester = requester;
	}

}