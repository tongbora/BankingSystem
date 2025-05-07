package controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import services.CreditAccountService;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditAccountController {
    CreditAccountService creditAccountService = new CreditAccountService();
    public void withdraw() {
        creditAccountService.withdraw();
    }
    public void deposit() {
        creditAccountService.deposit();
    }
    public void showBalance() {
        creditAccountService.showBalance();
    }
    public void createAccount() {
        creditAccountService.createAccount();
    }
}
