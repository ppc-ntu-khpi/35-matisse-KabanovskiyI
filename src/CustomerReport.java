/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matisse;

import com.mybank.domain.*;
import javax.swing.JTextArea;
/**
 *
 * @author kaban
 */
public class CustomerReport {
    private JTextArea textArea;

    public CustomerReport(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void generateReport() {
        // Очистим поле перед выводом
        textArea.setText("");

        // Заголовок
        textArea.append("\t\t\tCUSTOMERS REPORT\n");
        textArea.append("\t\t\t================\n");

        for (int cust_idx = 0; cust_idx < Bank.getNumberOfCustomers(); cust_idx++) {
            Customer customer = Bank.getCustomer(cust_idx);

            textArea.append("\nCustomer: " +
                    customer.getLastName() + ", " +
                    customer.getFirstName() + "\n");

            for (int acct_idx = 0; acct_idx < customer.getNumberOfAccounts(); acct_idx++) {
                Account account = customer.getAccount(acct_idx);
                String account_type;

                if (account instanceof SavingsAccount) {
                    account_type = "Savings Account";
                } else if (account instanceof CheckingAccount) {
                    account_type = "Checking Account";
                } else {
                    account_type = "Unknown Account Type";
                }

                textArea.append("    " + account_type + ": current balance is "
                        + account.getBalance() + "\n");
            }
        }
    }
}

