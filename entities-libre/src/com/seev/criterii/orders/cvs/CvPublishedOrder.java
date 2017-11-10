/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii.orders.cvs;




import com.seev.web.model.Cv;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

/**
 *
 * @author tiaray
 */
public class CvPublishedOrder extends  AbstractCvOrder  {
    public CvPublishedOrder(Root<Cv> r) {
        super(r);
    }
    @Override
    public Expression<?> getExpression() {
        return getRoot().get(com.seev.web.model.Cv_.pdt);
    }
}
  

