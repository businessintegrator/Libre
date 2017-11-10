/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.AttributeConverter;

/**
 *
 * @author tiaray
 */
//@Converter
public class DateConverter implements AttributeConverter<Date, String> {

    private ThreadLocal<SimpleDateFormat> internalddMMAAAA;
    private ThreadLocal<SimpleDateFormat> internalAAAAMMdd;

    static {

    }

    public DateConverter() {
        internalddMMAAAA = new ThreadLocal<>();
        internalAAAAMMdd = new ThreadLocal<>();
        internalddMMAAAA.set(new SimpleDateFormat("dd/MM/yy mm:ss"));
        internalAAAAMMdd.set(new SimpleDateFormat("yyyy-MM-dd"));
    }

    @Override
    public String convertToDatabaseColumn(Date attribute) {
        if (attribute == null) {
            return null;
        }
        return internalddMMAAAA.get().format(attribute);
    }

    @Override
    public Date convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {

            if (dbData.matches("\\d+/\\d+/\\d+")) {
                return internalddMMAAAA.get().parse(dbData);
            }
            if (dbData.matches("\\d+-\\d+-\\d+")) {
                return internalAAAAMMdd.get().parse(dbData);
            }
        } catch (Exception e) {
            throw new RuntimeException(dbData, e);
        }
        throw new RuntimeException(dbData);
    }

}
