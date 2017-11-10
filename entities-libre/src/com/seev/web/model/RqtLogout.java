package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the rqt_logout database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="rqt_logout")
//@NamedQuery(name="RqtLogout.findAll", query="SELECT r FROM RqtLogout r")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class RqtLogout extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="RQT_LOGOUT_ID_GENERATOR", sequenceName="lgt_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RQT_LOGOUT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	@Column(length=256)
	private String sesstoken;

	public RqtLogout() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSesstoken() {
		return this.sesstoken;
	}

	public void setSesstoken(String sesstoken) {
		this.sesstoken = sesstoken;
	}

}