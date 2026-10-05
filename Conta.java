public class Conta {
    private int number;
    private String holder;
    private double balance;

    public Conta(int number, String holder) {
        this.number = number;
        this.holder = holder;
        this.balance = 0.0;
    }

    public int getNumero() {
        return number;
    }

    public String getTitular() {
        return holder;
    }

    public double getSaldo() {
        return balance;
    }

    public void depositar(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void sacar(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
    }

    public void transferirPara(Conta destination, double amount) {
        if
