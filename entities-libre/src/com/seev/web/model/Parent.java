package com.seev.web.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Parent
 *
 */

@Embeddable
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Parent implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Parent() {
		super();
	}
   
}
