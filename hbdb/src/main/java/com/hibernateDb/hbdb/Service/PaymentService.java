package com.hibernateDb.hbdb.Service;

import com.hibernateDb.hbdb.Entity.Payment;
import com.hibernateDb.hbdb.Repository.PaymentRepo;
import com.hibernateDb.hbdb.Util.PaymentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentService {



    private PaymentRepo repo;

    private PaymentUtil util;

    @Autowired
    private void setRepo(PaymentRepo repo){
        this.repo=repo;
    }

    @Autowired
    private void setUtil(PaymentUtil util){
        this.util=util;
    }


    public void savePayment(Payment payment){
        repo.savePayment(payment);
    }

    @Scheduled(initialDelay=50000,fixedRate = 100000)
    private void blueTickAutoCheck(){
        List<Payment> paymentList=repo.getPaymentList();
        for (Payment p:paymentList){
            if(p!=null){
                System.out.println(p.toString());
                setBlueTick(p);
            } else if (p==null) {
                break;

            }
        }
    }
    private void setBlueTick(Payment payment){

        Boolean isValid=util.isBlueTickStillApplicable(payment.getDate());
        System.out.println(payment.getShortName()+" "+isValid);
        if(!isValid){
            try {
                updateBlueTick(payment);
                repo.updateBlueTick(payment);
            }catch (ArithmeticException e){
                e.printStackTrace();
            }catch (RuntimeException e){

                    e.printStackTrace();

            }
        }

    }


    public Payment getPayment(String shortName){
        return repo.getPaymentInfo(shortName);
    }

    private void updateBlueTick(Payment payment) {
        BigDecimal amount=payment.getAmount();
        try{
            if(amount.compareTo(new BigDecimal("10"))>0){
                amount=amount.subtract(new BigDecimal("10"));
                payment.setAmount(amount);
                payment.setPaid(true);
                payment.setBlueTick(true);
                System.out.println(payment.toString());
            }else {
                payment.setBlueTick(false);
                payment.setPaid(false);
            }
        }catch (Exception e){
            throw  new RuntimeException("Internal Server Error");
        }

    }


}
