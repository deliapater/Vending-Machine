import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    VendingMachine vm;
    Item item1;
    Item item2;

    @BeforeEach
    void setup() {
        vm = new VendingMachine();
        item1 = new Item("cola", 1.00);
        item2 = new Item("kitkat", 0.5);
    }

    @Test
    void vmCanStoreItems() {
        assertEquals(0, vm.getStock());
    }

    @Test
    void vmCanAddItems() {
        vm.addItem(item1);
        assertEquals(1, vm.getStock());
    }

    @Test
    void vmCanStoreMultipleItems() {
        vm.addItem(item1);
        vm.addItem(item2);
        assertEquals(2, vm.getStock());
    }

    @Test
    void vmCanAcceptMoney() {
        assertEquals(0, vm.getBalance());
        vm.addMoney(2);
        assertEquals(2, vm.getBalance());
    }

    @Test
    void vmItemHasPrice() {
        vm.addItem(item1);
        assertEquals(1, vm.getFirstItem().getPrice());
    }

    @Test
    void vmCanSell() {
        vm.addItem(item1);
        vm.addMoney(2);
        vm.sellItem();

        assertEquals(0, vm.getStock());
        assertEquals(1, vm.getBalance());
    }

}