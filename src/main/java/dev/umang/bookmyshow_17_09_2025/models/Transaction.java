package dev.umang.bookmyshow_17_09_2025.models;

import dev.umang.bookmyshow_17_09_2025.models.enums.PaymentMode;
import dev.umang.bookmyshow_17_09_2025.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transaction extends BaseModel{
    private String referenceId;
    private Long amount;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
