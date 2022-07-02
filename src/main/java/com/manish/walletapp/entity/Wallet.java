package com.manish.walletapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name can't be blank")
    @Size(min = 2, max = 30)
    private String name;
    private String accountNumber;
    private String description;
    private Integer priority;
    private Double currentBalance;
    @PrePersist

    public void setBalance()
    {
        this.currentBalance = new Double(0);
    }


}
