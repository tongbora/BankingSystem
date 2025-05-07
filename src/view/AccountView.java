package view;

import controller.CreditAccountController;
import controller.SavingAccountController;
import model.SavingAccount;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class AccountView {
    CreditAccountController creditAccountController = new CreditAccountController();
    SavingAccountController savingAccountController = new SavingAccountController();
    Scanner scanner = new Scanner(System.in);
    public void display() throws InterruptedException {
        System.out.println("--- WELCOME TO ABA BANK ---");
        System.out.println("""
                1.SAVING ACCOUNT
                2.CREDIT ACCOUNT
                3.Exist
                """);
        System.out.println("[+] Please choose the account type to create a new account: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 -> {
                savingAccountController.createAccount();
                while(true){
                    System.out.println("""
                            1. WITHDRAW 
                            2. DEPOSIT 
                            3. SHOW BALANCE
                            4. EXIT
                            """);
                    System.out.println("[+] Enter your choice: ");
                    choice = scanner.nextInt();
                    switch (choice){
                        case 1 -> {
                            savingAccountController.withdraw();
                        }
                        case 2 -> {
                            savingAccountController.deposit();
                        }
                        case 3 -> {
                            savingAccountController.showBalance();
                        }
                        case 4 -> {
                            String goodbye = "Goodbye!";
                            for(char ch : goodbye.toCharArray()){
                                Thread.sleep(400);
                                System.out.print(ch);
                            }
                            return;
                        }
                    }
                }
            }
            case 2 -> {
                creditAccountController.createAccount();
                while(true){
                    System.out.println("""
                            1. WITHDRAW 
                            2. DEPOSIT 
                            3. SHOW BALANCE
                            4. EXIT
                            """);
                    System.out.println("[+] Enter your choice: ");
                    choice = scanner.nextInt();
                    switch (choice){
                        case 1 -> {
                            creditAccountController.withdraw();
                        }
                        case 2 -> {
                            creditAccountController.deposit();
                        }
                        case 3 -> {
                            creditAccountController.showBalance();
                        }
                        case 4 -> {
                            String goodbye = "Goodbye!";
                            for(char ch : goodbye.toCharArray()){
                                Thread.sleep(400);
                                System.out.print(ch);
                            }
                            return;
                        }
                    }
                }
            }
            case 3 -> {
                String goodbye = "Goodbye!";
                for(char ch : goodbye.toCharArray()){
                    Thread.sleep(400);
                    System.out.print(ch);
                }
                return;
            }
        }
    }
}
