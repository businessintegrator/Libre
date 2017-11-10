/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii;

import com.seev.web.model.Offrmpl;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

/**
 *
 * @author tiaray
 */
abstract class AbstractCriterii {
    
    private final CriteriaBuilder criteriaBuilder;
    private final CriteriaQuery criteriaQuery;

   
    
    public AbstractCriterii(CriteriaBuilder criteriaBuilder,CriteriaQuery cq) {
        this.criteriaBuilder = criteriaBuilder;
        this.criteriaQuery = cq;
    }
    
     
    
    public  Predicate et(CriteriaBuilder cb,Predicate ... predicates) {
        return cb.and(predicates);
    }
   
   public  Predicate ou(CriteriaBuilder cb,Predicate ... predicates) {
        return cb.or(predicates);
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return criteriaBuilder;
    }

    public CriteriaQuery getCriteriaQuery() {
        return criteriaQuery;
    }
   
   
}
