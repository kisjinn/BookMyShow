package bms.com.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity (name = "payments")
public class Payment extends Base{
    private int amount;
    private String referenceNunber;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    //Ordinal means we will use id like 0,1,2.. for enums
    @Enumerated(EnumType.ORDINAL)
    //ordinal means numerical value
    private PaymentStatus paymentStatus;

    @ManyToOne
    private Booking booking;
}
