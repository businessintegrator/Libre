/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii;

import com.seev.web.model.Offrmpl;

import java.util.Date;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author tiaray
 */
public class OffreCriterii extends AbstractCriterii {

    private Root<Offrmpl> rootRecrtr = null;

    public OffreCriterii(CriteriaBuilder cb, CriteriaQuery cq) {
        super(cb, cq);
        this.rootRecrtr = super.getCriteriaQuery().from(Offrmpl.class);
    }

    public Predicate equalLieu(CriteriaBuilder cb, String lieu, boolean like) {
        return like ? cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.lieu), "%" + lieu + "%") : cb.equal(rootRecrtr.get(com.seev.web.model.Offrmpl_.lieu), lieu);
    }

    public Predicate salairePlus(CriteriaBuilder cb, Integer salaire) {
        return cb.greaterThan(rootRecrtr.get(com.seev.web.model.Offrmpl_.mins), salaire);
    }

    public Predicate dateRecent(CriteriaBuilder cb, Date dateRef) {
        return cb.greaterThan(rootRecrtr.get(com.seev.web.model.Offrmpl_.pbldt), dateRef);
    }

    public Predicate domaineTech(CriteriaBuilder cb, String domaine) {
        return ou(cb,
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.t), domaine),
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.t1), domaine),
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.t2), domaine),
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.t3), domaine),
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.t4), domaine),
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.b), domaine),
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.b1), domaine),
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.b2), domaine),
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.b3), domaine),
                cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.b4), domaine)
        );
    }

    public Predicate typeContrat(CriteriaBuilder cb, String contrat, boolean like) {
        return like ? cb.like(rootRecrtr.get(com.seev.web.model.Offrmpl_.typcontrat), contrat) : cb.equal(rootRecrtr.get(com.seev.web.model.Offrmpl_.typcontrat), contrat);
    }

}
