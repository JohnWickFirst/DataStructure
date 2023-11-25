package com.hibernateDb.hbdb.Repository;

import com.hibernateDb.hbdb.Entity.Payment;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
@Transactional
public class PaymentRepo {

    private EntityManager entityManager;

    @Autowired
    private void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public void savePayment(Payment payment){
        if(payment.getDate()==null)
        payment.setDate(LocalDateTime.now());
        if(payment.getBlueTick()==null)
        payment.setBlueTick(true);
        entityManager.persist(payment);
        entityManager.close();
        return;
    }

    public Payment getPaymentInfo(String shortName){
        Payment payment=entityManager.createNamedQuery("getBlueTickInfo", Payment.class)
                .setParameter("shortName", shortName).getSingleResult();
        return payment;
    }

    public void updateBlueTick(Payment payment){
        entityManager.merge(payment);
        entityManager.close();
    }

    public List<Payment> getPaymentList(){
        List<Payment> paymentsList= entityManager.createNamedQuery("findAllPayment",Payment.class)
                .getResultList();
        return paymentsList;
    }
}
