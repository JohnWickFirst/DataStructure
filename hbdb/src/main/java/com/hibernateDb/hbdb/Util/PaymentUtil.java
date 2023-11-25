package com.hibernateDb.hbdb.Util;

import com.hibernateDb.hbdb.Entity.Payment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Component
public class PaymentUtil {

    public Boolean isBlueTickStillApplicable(LocalDateTime date){
//        LocalTime currentDate= LocalTime.now();
//        long days= ChronoUnit.SECONDS.between(currentDate,date);
//        if(days>10){
//            return false;
//        }
//        return  true;
        return  false;
    }




}
