package com.global.card.creditcardapp.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.global.card.creditcardapp.validation.Luhn10;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

interface First {
}

interface Second {
}

interface Third {
}

/**
 * This class is CardDetails entity class with field validation.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CardDetails", uniqueConstraints = @UniqueConstraint(columnNames = {"creditCardNumber"}))
@GroupSequence({CardDetails.class, First.class, Second.class, Third.class})

public class CardDetails {

    @Id
    @NotBlank(message = "Credit card number field should not be empty", groups = First.class)
    @Size(min = 1, max = 19, message = "Credit card number should have maximum 19 digit", groups = Second.class)
    @Pattern(regexp = "[0-9]+", message = "Credit card number should have digit only", groups = Second.class)
    @Luhn10(message = "Invalid card number as per Luhn-10 algorithm", groups = Third.class)
    private String creditCardNumber;


    @NotBlank(message = "Name field should not be empty", groups = First.class)
    private String name;

    @NotNull(message = "Card limit field should not be empty", groups = First.class)
    private Double cardLimit;

    @Column(name = "Balance", columnDefinition = "decimal(10,2) default '0.00' ")
    @JsonView
    private BigDecimal balance = BigDecimal.ZERO;
}
