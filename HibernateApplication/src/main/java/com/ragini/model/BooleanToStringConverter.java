package com.ragini.model;

import jakarta.persistence.AttributeConverter;

public class BooleanToStringConverter implements AttributeConverter<Boolean ,String> {


    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {

        if (aBoolean == null) {

            return null ;
        }

        if (aBoolean){

            return "Yes";
        }
        return "No" ;             //  return aBoolean ? "Yes" :"No";

    }

    @Override
    public Boolean convertToEntityAttribute(String s) {

        if (s == null) {

            return null ;
        }

        if (s.equals("Yes")){

            return true ;
        }
        return false ;  //  return "Yes".equals(s);

    }
}
