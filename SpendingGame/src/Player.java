public class Player {
    private long balance;

    public Player(long balance) {
        this.balance = balance;
    }

    public boolean purchaseItem(Item item) {
        if (balance >= item.getPrice()) {
            balance -= item.getPrice();
            return true;
        }
        return false;
    }

    public long getBalance() {
        return balance;
    }
}
