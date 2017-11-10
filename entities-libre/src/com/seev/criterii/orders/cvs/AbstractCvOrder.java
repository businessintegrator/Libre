/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii.orders.cvs;

import com.seev.criterii.orders.AbstractOrder;
import com.seev.web.model.Cv;
import javax.persistence.criteria.Root;

/**
 *
 * @author tiaray
 */
public abstract class AbstractCvOrder extends AbstractOrder{
    private Root<Cv> root = null;

    public AbstractCvOrder(Root<Cv> r) {
        this.root = r;
    }

    public Root<Cv> getRoot() {
        return root;
    }
    
}
