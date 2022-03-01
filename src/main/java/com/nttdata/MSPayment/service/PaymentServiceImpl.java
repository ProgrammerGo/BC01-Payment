package com.nttdata.MSPayment.service;

import com.nttdata.MSPayment.model.Payment;
import com.nttdata.MSPayment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Mono<Payment> createPayment(Payment p) {
        return paymentRepository.save(p);
    }

    @Override
    public Mono<Payment> updatePayment(Payment p) {
        return paymentRepository.save(p);
    }

    @Override
    public Mono<Payment> findByPaymentId(Integer id) {
        return paymentRepository.findById(id).switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Payment> findAllByCreditId(Integer id) {
        return paymentRepository.findAll(Sort.by(String.valueOf(id)));
    }

    @Override
    public Mono<Void> deletePayment(Integer id) {
        return paymentRepository.deleteById(id);
    }
}
