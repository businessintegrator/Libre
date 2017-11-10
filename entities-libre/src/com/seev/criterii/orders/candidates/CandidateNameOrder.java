/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii.orders.candidates;

import com.seev.web.model.Cndt;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
/**
 *
 * @author tiaray
 */
public class CandidateNameOrder extends AbstractCandidateOrder {

    public CandidateNameOrder(Root<Cndt> r) {
        super(r);
    }

    @Override
    public Expression<?> getExpression() {
        return getRoot().get(com.seev.web.model.Cndt_.nom);
    }
    
    
}
