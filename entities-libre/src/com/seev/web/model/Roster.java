/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.web.model;

import com.bi.tea.crypt.DolardMe;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author tiaray
 */
@Converter
public class Roster implements AttributeConverter<String,String>,Serializable  {
    private final static String KEY = System.getProperty("key_cnil","0101QAd1231215sdfqdqDFQFqsdf");
    private DolardMe e = null;

    public Roster() {
        e = new DolardMe();
    }
    
    
    @Override
    public String convertToDatabaseColumn(String attribute) {
        
        if (attribute == null){
            return null;
        }
        return e.crypt(attribute,KEY);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
       if (dbData == null){
            return null;
        }
        try {
            return e.decrypt(dbData,KEY);
        } catch (Exception ex) {
            Logger.getLogger(Iconv.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("conversion", ex);
        }
    }
    
}
