package main.java.com.epul.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;
 
public class DateFormater extends XmlAdapter<String, Date> {
 
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
 
    @Override
    public String marshal(Date date) throws Exception {
        if(date == null) { return null; }
        return SIMPLE_DATE_FORMAT.format(date);
    }
 
    @Override
    public Date unmarshal(String date) throws Exception {
        if(date == null) { return null; }
        try {
            Date returnDate = SIMPLE_DATE_FORMAT.parse(date);
            return new Date(returnDate.getTime());
        } catch (ParseException e) {
            throw new RuntimeException("The given date format " + date + " is incorrect.", e);
        }
    }
}