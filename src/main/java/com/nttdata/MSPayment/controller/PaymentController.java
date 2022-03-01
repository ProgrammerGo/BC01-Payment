package com.nttdata.MSPayment.controller;

import com.nttdata.MSPayment.model.Payment;
import com.nttdata.MSPayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/payment")
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Payment> createPayment(@RequestBody Payment p){
        return paymentService.createPayment(p);
    }

    @GetMapping(value = "get/credit/{idCredit}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Flux<Payment> findByCreditId(@PathVariable("idCredit") Integer id){
        return paymentService.findAllByCreditId(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Mono<Payment>> findById(@PathVariable("id") Integer id){
        Mono<Payment> paymentMono = paymentService.findByPaymentId(id);
        return new ResponseEntity<Mono<Payment>>(paymentMono, paymentMono != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Payment> updatePayment(@RequestBody Payment p){
        return paymentService.updatePayment(p);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteById(@PathVariable("id") Integer id){
        return paymentService.deletePayment(id);
    }
}
