package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the distributor database table.
 * 
 */
@Embeddable
@Table(schema = "activeimage2",name="distributor")
public class Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

        protected static final long START_CUSTOM_ID = 4611686018427387904L;
	
	@Column(name="vnd_name", length=35)
	private String vndName;

	@Column(name="vnd_url", length=35)
	private String vndUrl;

	public Distributor() {
	}

	
	public String getVndName() {
		return this.vndName;
	}

	public void setVndName(String vndName) {
		this.vndName = vndName;
	}

	public String getVndUrl() {
		return this.vndUrl;
	}

	public void setVndUrl(String vndUrl) {
		this.vndUrl = vndUrl;
	}

}