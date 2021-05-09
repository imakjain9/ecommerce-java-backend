package com.ecommerce.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static Date stringToDate(String date){
        try {
            DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
            return format.parse(date);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
