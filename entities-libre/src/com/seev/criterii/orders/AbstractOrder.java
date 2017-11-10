/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii.orders;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;

/**
 *
 * @author tiaray
 */
public abstract class AbstractOrder  implements Order,Cloneable {

    private Expression expression;
    private boolean isAscending;
    public AbstractOrder( ) {
    }
  
    @Override
    public Order reverse() {
      
        try {
            return (Order)this.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(AbstractOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

   
    protected void toggle() {
      //get =!asc;    
    }

    @Override
    public  Expression<?> getExpression(){
        return this.expression;
    }

    @Override
    public boolean isAscending(){
        return this.isAscending;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public void setIsAscending(boolean isAscending) {
        this.isAscending = isAscending;
    }

   


}
