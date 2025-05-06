
package services;

import model.SavingAccount;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class SavingAccountService implements AccountService {
    SavingAccount savingAccount = new SavingAccount();
    Scanner scanner = new Scanner(System.in);
    BigDecimal amount;

    public void createAccount(){
        System.out.println("Enter account id: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter pin code (4 digits): ");
        Integer pin = scanner.nextInt();
        scanner.nextLine();
        savingAccount = new SavingAccount(1, UUID.randomUUID().toString(), BigDecimal.ZERO, username,pin, LocalDateTime.now(),LocalDateTime.now());
        System.out.println("Saving account created.");
    }
    @Override
    public void withdraw() {
        while (true) {
            System.out.println("[+] Insert amount to withdraw: ");
            amount = scanner.nextBigDecimal();
            if (amount.compareTo(BigDecimal.ZERO) <= 0 && amount.compareTo(savingAccount.getBalance()) > 0 ) {
                System.out.println("[+] Amount must be greater than or equal to zero and must be less than or equal to your current balance.");
            }
            else{
                break;
            }
        }
        savingAccount.setBalance(savingAccount.getBalance().subtract(amount));
    }

    @Override
    public void deposit() {
        while (true){
            System.out.println("[+] Insert amount to deposit: ");
            amount = scanner.nextBigDecimal();
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("[+] Amount must be greater than to zero.");
            }
            else{
                break;
            }
        }
        savingAccount.setBalance(savingAccount.getBalance().add(amount));
        System.out.println("[+] Deposit successful.");
        System.out.println("[+] Your current balance is: " + "$" + savingAccount.getBalance());
    }

    @Override
    public void showBalance() {
        System.out.println("[+] Your current balance is: " + "$" + savingAccount.getBalance());
    }
}