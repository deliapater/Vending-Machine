import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<Item> items;
    private double balance;


    public VendingMachine() {
        this.items = new ArrayList<Item>();
        this.balance = 0.0;
    }


    public int getStock() {
        return items.size();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getBalance() {
        return this.balance;
    }

    public void addMoney(double money) {
        this.balance += money;
    }

    public Item getFirstItem() {
        return this.items.get(0);
    }

    public void sellItem() {
        double soldPrice = this.items.get(0).getPrice();

        if (this.balance >= soldPrice) {
            this.balance -= soldPrice;
            this.items.remove(0);
        } else {
            System.out.println("Not Enough money");
        }
    }

}
