/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii.orders.candidates;

import com.seev.criterii.orders.AbstractOrder;
import com.seev.web.model.Cndt;
import javax.persistence.criteria.Root;

/**
 *
 * @author tiaray
 */
public abstract class AbstractCandidateOrder extends AbstractOrder {
    private Root<Cndt> root = null;

    public AbstractCandidateOrder(Root<Cndt> r) {
        this.root = r;
    }

    public Root<Cndt> getRoot() {
        return root;
    }
   
     
    
}
