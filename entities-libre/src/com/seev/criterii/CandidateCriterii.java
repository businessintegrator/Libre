/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii;

import com.seev.web.model.Cndt;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author tiaray
 */
public class CandidateCriterii extends AbstractCriterii {

    private Root<Cndt> rootRecrtr = null;
    //private javax.persistence.criteria.CriteriaQuery cq = null;

    public CandidateCriterii(CriteriaBuilder cb, CriteriaQuery cq) {
        super(cb, cq);
        this.rootRecrtr = cq.from(Cndt.class);
    }

    public Predicate equalUser(CriteriaBuilder cb, String user, boolean like) {
        return like ? cb.like(rootRecrtr.get(com.seev.web.model.Cndt_.email), "%" + user + "%") : cb.equal(rootRecrtr.get(com.seev.web.model.Cndt_.email), user);
    }

    public Predicate equalNom(CriteriaBuilder cb, String nom, boolean like) {
        return like ? cb.like(rootRecrtr.get(com.seev.web.model.Cndt_.nom), "%" + nom + "%") : cb.equal(rootRecrtr.get(com.seev.web.model.Cndt_.nom), nom);
    }

    public Predicate equalCodepostal(CriteriaBuilder cb, String codepostal, boolean like) {
        return like ? cb.like(rootRecrtr.get(com.seev.web.model.Cndt_.codepostal), "%" + codepostal + "%") : cb.equal(rootRecrtr.get(com.seev.web.model.Cndt_.codepostal), codepostal);
    }

    public Predicate equalVille(CriteriaBuilder cb, String ville, boolean like) {
        return like ? cb.like(rootRecrtr.get(com.seev.web.model.Cndt_.ville), "%" + ville + "%") : cb.equal(rootRecrtr.get(com.seev.web.model.Cndt_.codepostal), ville);
    }

}
