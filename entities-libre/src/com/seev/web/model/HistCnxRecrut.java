package com.seev.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * The persistent class for the hist_cnx_recrut database table.
 * 
 */
@Entity
@Table(schema = "activeimage2",name="hist_cnx_recrut")
//@NamedQuery(name="HistCnxRecrut.findAll", query="SELECT h FROM HistCnxRecrut h")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class HistCnxRecrut extends Distributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="HIST_CNX_RECRUT_ID_GENERATOR", sequenceName="hist_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HIST_CNX_RECRUT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	@XmlAttribute(name="sId") private Long id;

	private Long idcptrecrut;
        
        @Column(name="dt")
        @Temporal(TemporalType.TIMESTAMP)
        private Date dt;

	public HistCnxRecrut() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdcptrecrut() {
		return this.idcptrecrut;
	}

	public void setIdcptrecrut(Long idcptrecrut) {
		this.idcptrecrut = idcptrecrut;
	}

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

        
}