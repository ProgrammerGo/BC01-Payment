package com.nttdata.MSPayment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("payment")
public class Payment {
    @Id
    Integer id;
    Integer idCredit;
    Float amount;
    String date;
    PaymentType paymentType;
}
