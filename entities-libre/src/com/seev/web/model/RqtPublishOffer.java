package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_publish_offer database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_publish_offer")
//@NamedQuery(name="RqtPublishOffer.findAll", query="SELECT r FROM RqtPublishOffer r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtPublishOffer extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_PUBLISH_OFFER_OFFERREF_GENERATOR", sequenceName="publish_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_PUBLISH_OFFER_OFFERREF_GENERATOR")
	@Column(name="offer_ref", unique=true, nullable=false)
	private Long offerRef;

	@XmlAttribute(name="sId") private Long id;

	private Boolean publish;

	private Boolean unpublish;

	public RqtPublishOffer() {
	}

	public Long getOfferRef() {
		return this.offerRef;
	}

	public void setOfferRef(Long offerRef) {
		this.offerRef = offerRef;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getPublish() {
		return this.publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}

	public Boolean getUnpublish() {
		return this.unpublish;
	}

	public void setUnpublish(Boolean unpublish) {
		this.unpublish = unpublish;
	}

}