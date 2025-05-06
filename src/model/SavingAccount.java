package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

//@NoArgsConstructor
//@AllArgsConstructor

public class SavingAccount extends Account {
    public SavingAccount() {}
    public SavingAccount(Integer id, String uuid, BigDecimal balance, String username, Integer pin, LocalDateTime createdAt, LocalDateTime expiresAt) {
        super(id, uuid, balance, username, pin, createdAt, expiresAt);
    }
}
