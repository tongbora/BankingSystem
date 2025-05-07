package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String uuid;
    private BigDecimal balance;
    private String username;
    private char[] pin;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}
