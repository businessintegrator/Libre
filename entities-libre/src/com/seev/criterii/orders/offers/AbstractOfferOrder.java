/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii.orders.offers;

import com.seev.criterii.orders.AbstractOrder;
import com.seev.web.model.Offrmpl;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

/**
 *
 * @author tiaray
 */
public abstract class AbstractOfferOrder extends  AbstractOrder{
    private Root<Offrmpl> root = null;

    public AbstractOfferOrder(Root<Offrmpl> r) {
        this.root = r;
    }

    public Root<Offrmpl> getRoot() {
        return root;
    }
    
}
