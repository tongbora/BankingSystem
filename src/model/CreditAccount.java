package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreditAccount extends Account {
    public CreditAccount() {}
    public CreditAccount(Integer id, String uuid, BigDecimal balance, String username, Integer pin, LocalDateTime createdAt, LocalDateTime expiresAt) {
        super(id, uuid, balance, username, pin, createdAt, expiresAt);
    }
}
