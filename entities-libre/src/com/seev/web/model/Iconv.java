/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.web.model;


import com.bi.tea.crypt.TeaDecryptor;
import com.bi.tea.crypt.TeaEncryptor;
import com.bi.tea.crypt.TooLongMessageException;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author tiaray
 */
@Converter
public class Iconv implements AttributeConverter<String,String>,Serializable {
     public static  String CONST ="0123456789MLKJHGFDSQWXCVBNAZERTYUIOPQSDFGHJKazivnslfoeertyuiopmlkjhgfdsqwxcvbn9874564532515AZERTYUIOPMLKJHGFDSQWXCVBNAZERTYUIOPQSDFGHJKLMWXCVBNazertyuiopmlkjhgfdsqwxcvbn98745645325151";
 
    private final static int PAD_LENGTH = 100;
    private TeaDecryptor d;
    private TeaEncryptor e;
    
    public Iconv() {
        d = new TeaDecryptor();
        e = new TeaEncryptor();
        
        d.init();
        e.init();
        
    }
    
     
    @Override
    public String convertToDatabaseColumn(String attribute) {
        //byte []  attrb = attribute.getBytes();
        //return new String (i.form(attrb));
        if (attribute == null){
            return null;
        }
        
         try {
             return e.crypt(format()+attribute);
         } catch (TooLongMessageException ex) {
             Logger.getLogger(Iconv.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }

  
    @Override
    public String convertToEntityAttribute(String dbData) {
       if (dbData == null){
            return null;
        }
        try {
            String res = d.decrypt(dbData).substring(PAD_LENGTH);
            //Logger.getLogger(Iconv.class.getName()).log(Level.INFO,""+res);
            return res;
        } catch (Exception ex) {
            Logger.getLogger(Iconv.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("conversion", ex);
        }
    }

      private String format(){
        String str = (UUID.randomUUID().toString()+System.currentTimeMillis()+hashCode())+CONST;
        String pad =  str.substring(0,PAD_LENGTH);
        return pad;
    }
}
