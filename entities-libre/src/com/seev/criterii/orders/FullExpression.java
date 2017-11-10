/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii.orders;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.PluralAttribute;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author tiaray
 */
public class FullExpression {
    Root<?> root = null;

    public FullExpression(Root<?> r) {
        this.root = r;
    }
    
    Expression getFull(SingularAttribute ... attrbs){
        Path last = null;
        for (SingularAttribute attrb : attrbs) {
            if (last == null) {
                last = this.root.get(attrb);
            } else {
                last.get(attrb);
            }
        }
        return last;
    }
}
