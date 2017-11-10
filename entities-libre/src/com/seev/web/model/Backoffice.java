/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.web.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tiaray
 */
@Entity
@Table(name = "backoffice", catalog = "seev", schema = "activeimage2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Backoffice.findAll", query = "SELECT b FROM Backoffice b"),
    @NamedQuery(name = "Backoffice.findById", query = "SELECT b FROM Backoffice b WHERE b.id = :id"),
    @NamedQuery(name = "Backoffice.findByUsr", query = "SELECT b FROM Backoffice b WHERE b.usr = :usr"),
    @NamedQuery(name = "Backoffice.findByPasswd", query = "SELECT b FROM Backoffice b WHERE b.passwd = :passwd"),
    @NamedQuery(name = "Backoffice.findBySalt", query = "SELECT b FROM Backoffice b WHERE b.salt = :salt")})
public class Backoffice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false,unique=true)
    @SequenceGenerator(initialValue = 1,allocationSize=1,schema="activeimage2",name="BO_ID_GENERATOR", sequenceName="z_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BO_ID_GENERATOR")
    private Long id;
    @Column(name = "usr", length = 40)
    private String usr;
    @Column(name = "passwd", length = 40000)
    @Convert(converter = Iconv.class)
    private String passwd;
    @Column(name = "salt", length = 255)
    private String salt;
    @Column(name = "f", length = 255)
    private String file;

    public Backoffice() {
    }

    public Backoffice(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Backoffice)) {
            return false;
        }
        Backoffice other = (Backoffice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seev.web.model.Backoffice[ id=" + id + " ]";
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setBackoffice(Backoffice cndt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
