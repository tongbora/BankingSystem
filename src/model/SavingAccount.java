package model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SavingAccount extends Account {
    public SavingAccount() {}
    public SavingAccount(Integer id, String uuid, BigDecimal balance, String username, char[] pin, LocalDateTime createdAt, LocalDateTime expiresAt) {
        super(id, uuid, balance, username, pin, createdAt, expiresAt);
    }
}
