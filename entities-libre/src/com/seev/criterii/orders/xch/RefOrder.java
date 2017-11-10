/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii.orders.xch;


import javax.persistence.criteria.Expression;

/**
 *
 * @author tiaray
 */
public class RefOrder extends AbstractXchOrder{

    public RefOrder(Expression expression, boolean isAscending) {
        super(expression, isAscending);
    }

  
}
