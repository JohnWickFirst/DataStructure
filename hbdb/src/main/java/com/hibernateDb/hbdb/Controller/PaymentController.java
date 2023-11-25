package com.hibernateDb.hbdb.Controller;

import com.hibernateDb.hbdb.Entity.Payment;
import com.hibernateDb.hbdb.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/add")
    public String addPayment(@RequestBody Payment payment){
        service.savePayment(payment);
        return "Success :)";
    }

    @GetMapping("/get/{shortName}")
    public Payment getPayment(@PathVariable String shortName){
        return service.getPayment(shortName);
    }

}
