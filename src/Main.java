import java.util.Scanner; // do wpisywania kwoty

// klasa - wyjątek za mało środków
class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

// klasa - konto bankowe
class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    // konstruktor
    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    // getter owner
    public String getOwner() {
        return owner;
    }

    // setter owner
    public void setOwner(String owner) {
        this.owner = owner;
    }

    // getter balance
    public int getBalance() {
        return balance;
    }

    // setter balance
    public void setBalance(int balance) {
        this.balance = balance;
    }

    // getter accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // setter accountNumber
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Metoda do wykonania przelewu
    public void transfer(int amount) throws NotEnoughMoneyException {
        // if (błąd)
        if (amount > balance) {
            throw new NotEnoughMoneyException("Brak środków na koncie.");
        }
        balance -= amount;
        System.out.println("Przelew wykonany na kwotę: " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        // konto bankowe
        Account account = new Account("Bartek", 100, "123456789");

        // wczytywanie danych od użytkownika
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Podaj kwotę przelewu: "); // pytanie o kwotę przelewu
            int transferAmount = scanner.nextInt(); // wczytanie kwoty
            account.transfer(transferAmount); // próba wykonania przelewu
        } catch (NotEnoughMoneyException e) {
            System.out.println("Błąd: " + e.getMessage()); // obsługa wyjątku NotEnoughMoneyException
        } catch (Exception e) {
            System.out.println("Błąd innego typu2: " + e.getMessage()); // obsługa innych wyjątków
        } finally {
            System.out.println("Aktualny stan konta: " + account.getBalance()); // aktualne saldo
        }

        scanner.close(); // zamknięcie skanera
    }
}
