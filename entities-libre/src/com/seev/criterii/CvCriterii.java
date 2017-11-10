/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii;

import com.seev.web.model.Cv;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author tiaray
 */
public class CvCriterii extends AbstractCriterii {

    private Root<Cv> rootRecrtr = null;

    public CvCriterii(CriteriaBuilder cb, CriteriaQuery cq) {
        super(cb, cq);
        this.rootRecrtr = cq.from(Cv.class);
    }

    public Predicate tech(CriteriaBuilder cb, String tech, boolean like) {
        return like ? cb.like(rootRecrtr.get(com.seev.web.model.Cv_.titre), tech) : cb.equal(rootRecrtr.get(com.seev.web.model.Cv_.titre), tech);
    }

}
