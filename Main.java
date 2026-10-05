import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco bank = new Banco();

        while (true) {
            System.out.println("\n=== JAVA BANK CLI ===");
            System.out.println("1) Create account");
            System.out.println("2) List accounts");
            System.out.println("3) Deposit");
            System.out.println("4) Withdraw");
            System.out.println("5) Transfer");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            String option = sc.nextLine().trim();

            try {
                if (option.equals("1")) {
                    System.out.print("Account holder name: ");
                    String name = sc.nextLine();
                    Conta account = bank.criarConta(name);
                    System.out.println("Account created! Number: " + account.getNumero());

                } else if (option.equals("2")) {
                    if (bank.listarContas().isEmpty()) {
                        System.out.println("No accounts registered.");
                    } else {
                        for (Conta c : bank.listarContas()) {
                            System.out.println(c);
                        }
                    }

                } else if (option.equals("3")) {
                    Conta account = askForAccount(sc, bank);
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(sc.nextLine().replace(",", "."));
                    account.depositar(amount);
                    System.out.println("Deposit successful. Balance: " + String.format("%.2f", account.getSaldo()));

                } else if (option.equals("4")) {
                    Conta account = askForAccount(sc, bank);
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(sc.nextLine().replace(",", "."));
                    account.sacar(amount);
                    System.out.println("Withdrawal successful. Balance: " + String.format("%.2f", account.getSaldo()));

                } else if (option.equals("5")) {
                    System.out.println("SOURCE account:");
                    Conta source = askForAccount(sc, bank);

                    System.out.println("DESTINATION account:");
                    Conta destination = askForAccount(sc, bank);

                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(sc.nextLine().replace(",", "."));

                    source.transferirPara(destination, amount);
                    System.out.println("Transfer successful.");
                    System.out.println("Source balance: " + String.format("%.2f", source.getSaldo()));
                    System.out.println("Destination balance: " + String.format("%.2f", destination.getSaldo()));

                } else if (option.equals("0")) {
                    System.out.println("Goodbye.");
                    break;

                } else {
                    System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }

    private static Conta askForAccount(Scanner sc, Banco bank) {
        System.out.print("Account number: ");
        int number = Integer.parseInt(sc.nextLine().trim());
