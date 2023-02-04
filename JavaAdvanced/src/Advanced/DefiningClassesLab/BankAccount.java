package Advanced.DefiningClassesLab;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int id = 0;
    private double balance;

    public BankAccount() {
        id++;
    }
    public static void setInterestRate(double interest) {
        interestRate = interest;
    }
    public double getInterest(int years) {
        return interestRate * years * balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public static int getId() {
        return id;
    }
}
