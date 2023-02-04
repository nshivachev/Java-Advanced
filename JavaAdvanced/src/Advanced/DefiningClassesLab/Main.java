package Advanced.DefiningClassesLab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] tokens = command.split("\\s+");

            String currentCommand = tokens[0];

            String output = null;
            if (currentCommand.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccountMap.put(BankAccount.getId(), bankAccount);
                output = String.format("Account ID%d created", BankAccount.getId());
            } else if (currentCommand.equals("Deposit")) {
                int banAccId = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);
                if (bankAccountMap.get(banAccId) != null) {
                    BankAccount bankAccount = bankAccountMap.get(banAccId);
                    bankAccount.deposit(amount);
                    output = String.format("Deposited %d to ID%d", amount, banAccId);
                } else {
                    output = "Account does not exist";
                }
            } else if (currentCommand.equals("SetInterest")) {
                double interest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(interest);
            } else if (currentCommand.equals("GetInterest")) {
                int banAccId = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);
                if (bankAccountMap.get(banAccId) != null) {
                    BankAccount bankAccount = bankAccountMap.get(banAccId);
                    output = String.format("%.2f", bankAccount.getInterest(years));
                } else {
                    output = "Account does not exist";
                }
            }

            if (output != null) {
                System.out.println(output);
            }

            command = scanner.nextLine();
        }
    }
}
