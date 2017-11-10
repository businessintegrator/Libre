/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.*;

/**
 *
 * @author tiaray
 */
@Entity
@Table(schema = "activeimage2", name = "prntn")
@XmlType  @XmlAccessorType(XmlAccessType.FIELD)
public class Pretention implements Serializable {
 private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, schema = "activeimage2", name = "PRTND_ID_GENERATOR", sequenceName = "prndt_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRTND_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    @XmlAttribute(name="sId") private Long id;
    
  @Column(name="mins")
  private Integer minimumSalary;
  @Column(name="maxs")
  private Integer maxsimumSalary;
  
  @Temporal(TemporalType.DATE)
  @Column(name="dispo")
  private Date dateDispo;
  
  @Column(name="preavis")
  private Boolean preavis = false;
  
  @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
  @JoinColumn(name="cndt_id")
  private Cndt candidate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(Integer minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public Integer getMaxsimumSalary() {
        return maxsimumSalary;
    }

    public void setMaxsimumSalary(Integer maxsimumSalary) {
        this.maxsimumSalary = maxsimumSalary;
    }

    public Date getDateDispo() {
        return dateDispo;
    }

    public void setDateDispo(Date dateDispo) {
        this.dateDispo = dateDispo;
    }

    public Boolean getPreavis() {
        return preavis;
    }

    public void setPreavis(Boolean preavis) {
        this.preavis = preavis;
    }

    public Cndt getCandidate() {
        return candidate;
    }

    public void setCandidate(Cndt candidate) {
        this.candidate = candidate;
    }
   
  
}
