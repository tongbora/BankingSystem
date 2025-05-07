package services;

import model.CreditAccount;
import model.SavingAccount;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class CreditAccountService implements AccountService {
    Scanner scanner = new Scanner(System.in);
    CreditAccount creditAccount = new CreditAccount();

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
                creditAccount = new CreditAccount(1, UUID.randomUUID().toString(), BigDecimal.ZERO, username,pins, LocalDateTime.now(),LocalDateTime.now());
                System.out.println("Saving account created.");
                break;
            }
            else{
                System.out.println("Pin code must be 4 digits! ");
            }
        }
    }

    @Override
    public void withdraw() {
        BigDecimal amount;
        while (true) {
            System.out.print("[+] Insert amount to withdraw: ");
            amount = scanner.nextBigDecimal();
            if (amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(creditAccount.getBalance()) > 0 ) {
                System.out.println("[+] Amount must be greater than or equal to zero and must be less than or equal to your current balance.");
                scanner.nextLine();
                System.out.print("Would you like to continue? (y/n): ");
                String response = scanner.nextLine().toLowerCase();
                if (response.equals("n")) {
                    break;
                }
            }
            else{
                creditAccount.setBalance(creditAccount.getBalance().subtract(amount));
                System.out.println("[+] Withdrawal successful.");
                break;
            }
        }
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
                creditAccount.setBalance(creditAccount.getBalance().add(amount));
                System.out.println("[+] Deposit successful.");
                break;
            }
        }
    }

    @Override
    public void showBalance() {
        System.out.println("[+] Your current balance is: " + "$" + creditAccount.getBalance());
    }
}
