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
    public void display(){
        System.out.println("--- WELCOME TO ABA BANK ---");
        System.out.println("""
                1.SAVING ACCOUNT
                2.CREDIT ACCOUNT
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
                            """);
                    System.out.println("[+] Enter your choice: ");
                    choice = scanner.nextInt();
                    switch (choice){
                        case 1 -> {
                            savingAccountController.withdrawal();
                        }
                        case 2 -> {
                            savingAccountController.deposit();
                        }
                        case 3 -> {
                            savingAccountController.showBalance();
                        }
                    }
                }
            }
        }
    }
    void createAccount() {
        System.out.println("Enter account id: ");
        int id = scanner.nextInt();
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter pin code (4 digits): ");
        int pin = scanner.nextInt();
    }
}
