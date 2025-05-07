
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
        System.out.print("Enter account id: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        while (true){
            System.out.println("Enter pin code (4 digits)");
            System.out.print("Enter pin code 1: ");
            char pin1 = scanner.next().charAt(0);
            System.out.print("Enter pin code 2: ");
            char pin2 = scanner.next().charAt(0);
            System.out.print("Enter pin code 3: ");
            char pin3 = scanner.next().charAt(0);
            System.out.print("Enter pin code 4: ");
            char pin4 = scanner.next().charAt(0);
            char[] pins = {pin1, pin2, pin3, pin4};
            if(pins.length == 4){
                scanner.nextLine();
                savingAccount = new SavingAccount(1, UUID.randomUUID().toString(), BigDecimal.ZERO, username,pins, LocalDateTime.now(),LocalDateTime.now());
                System.out.println("Saving account created.");
                break;
            }
            else{
                System.out.println("Pin code must be 4 digits!");
            }
        }
    }
    @Override
    public void withdraw() {
        while (true) {
            System.out.print("[+] Insert amount to withdraw: ");
            amount = scanner.nextBigDecimal();
            if (amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(savingAccount.getBalance()) > 0 ) {
                System.out.println("[+] Amount must be greater than or equal to zero and must be less than or equal to your current balance.");
                scanner.nextLine();
                System.out.print("Would you like to continue? (y/n): ");
                String response = scanner.nextLine().toLowerCase();
                if (response.equals("n")) {
                    break;
                }
            }
            else{
                savingAccount.setBalance(savingAccount.getBalance().subtract(amount));
                System.out.println("[+] Withdraw successful.");
                break;
            }
        }
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
                savingAccount.setBalance(savingAccount.getBalance().add(amount));
                System.out.println("[+] Deposit successful.");
                break;
            }
        }
    }

    @Override
    public void showBalance() {
        System.out.println("[+] Your current balance is: " + "$" + savingAccount.getBalance());
    }
}