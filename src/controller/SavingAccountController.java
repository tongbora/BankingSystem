package controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.SavingAccount;
import services.SavingAccountService;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SavingAccountController {
    SavingAccountService savingAccountService = new SavingAccountService();
    public void withdrawal() {
        savingAccountService.withdraw();
    }

    public void deposit() {
        savingAccountService.deposit();
    }

    public void createAccount() {
        savingAccountService.createAccount();
    }

    public void showBalance() {
        savingAccountService.showBalance();
    }
}
