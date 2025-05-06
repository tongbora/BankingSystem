package services;

import model.CreditAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreditAccountService implements AccountService {
    Scanner scanner = new Scanner(System.in);
    CreditAccount creditAccount = new CreditAccount();
    @Override
    public void withdraw() {
        BigDecimal amount;
        while (true) {
            System.out.println("[+] Insert amount to withdraw: ");
            amount = scanner.nextBigDecimal();
            if (amount.compareTo(BigDecimal.ZERO) <= 0 && amount.compareTo(creditAccount.getBalance()) > 0 ) {
                System.out.println("[+] Amount must be greater than or equal to zero and must be less than or equal to your current balance.");
            }
            else{
                break;
            }
        }
       creditAccount.getBalance().subtract(amount);
    }

    @Override
    public void deposit() {
        BigDecimal amount;
        while (true) {
            System.out.println("[+] Insert amount to deposit: ");
            amount = scanner.nextBigDecimal();
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("[+] Amount must be greater than to zero.");
            }
            else{
                break;
            }
        }
        creditAccount.setBalance(creditAccount.getBalance().add(amount));
        System.out.println("[+] Deposit successful.");
        System.out.println("[+] Your current balance is: " + "$" + creditAccount.getBalance());
    }

    @Override
    public void showBalance() {
        System.out.println("[+] Your current balance is: " + "$" + creditAccount.getBalance());
    }
}
