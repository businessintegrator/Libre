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
abstract class AbstractXchOrder extends  org.eclipse.persistence.internal.jpa.querydef.OrderImpl {
    
    private Boolean bodtrqt = false;
    private Boolean bodtrsp = false;
    private Boolean titre = false;
    private Boolean ref = false;
    private Boolean dt = false;

    public AbstractXchOrder(Expression expression, boolean isAscending) {
        super(expression, isAscending);
        
    }

    
    public boolean isAsc() {
        return super.isAscending(); 
    }
    
    

   

    public Boolean getBodtrqt() {
        return bodtrqt;
    }

    public void setBodtrqt(Boolean bodtrqt) {
        this.bodtrqt = bodtrqt;
    }

    public Boolean getBodtrsp() {
        return bodtrsp;
    }

    public void setBodtrsp(Boolean bodtrsp) {
        this.bodtrsp = bodtrsp;
    }

    public Boolean getTitre() {
        return titre;
    }

    public void setTitre(Boolean titre) {
        this.titre = titre;
    }

    public Boolean getRef() {
        return ref;
    }

    public void setRef(Boolean ref) {
        this.ref = ref;
    }

    public Boolean getDt() {
        return dt;
    }

    public void setDt(Boolean dt) {
        this.dt = dt;
    }

    
    
    
}
