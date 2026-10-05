import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> accounts;
    private int nextNumber;

    public Banco() {
        accounts = new ArrayList<>();
        nextNumber = 1001;
    }

    public Conta criarConta(String holder) {
        if (holder == null || holder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }
        Conta account = new Conta(nextNumber, holder.trim());
        accounts.add(account);
        nextNumber++;
        return account;
    }

    public ArrayList<Conta> listarContas() {
        return accounts;
    }

    public Conta buscarContaPorNumero(int number) {
        for (Conta c : accounts) {
            if (c.getNumero() == number) return c;
        }
        return null;
    }
}
