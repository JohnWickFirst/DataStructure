package com.hibernateDb.hbdb.Util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class IdGeneratorImpl implements IdentifierGenerator {

    public static final String bankName="ABCBANK";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {

        //for now  as per me this is the highestCusomer number
        int randomNumberFirst=(int)(Math.random()*100000)+1;
        int randomNumberLast=(int)(Math.random()*100000)+1;
        String day=""+LocalDateTime.now().getDayOfWeek();

        String id=""+randomNumberFirst+bankName+randomNumberLast+day;
        return id;
    }

    public IdGeneratorImpl(){

    }



}
