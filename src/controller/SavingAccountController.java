package controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import services.SavingAccountService;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SavingAccountController {
    SavingAccountService savingAccountService = new SavingAccountService();
    public void withdraw() {
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
