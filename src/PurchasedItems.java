// **********************************
// David Gary
// COSC 436 - OOP Design
// Assignment 5 - Decorator Pattern
// Dr. Dierbach
// PurchasedItems class
// **********************************

import java.util.*;
public class PurchasedItems {
    private ArrayList<StoreItem> items;

    public PurchasedItems() {
        items = new ArrayList<StoreItem>();
    }

    public void addItems(StoreItem item) {
        items.add(item);
    }
    public double getTotalCost() {
        double total = 0.0;
        for (int i = 0; i < items.size(); i++) {
            // converting the string price to a double price
            total = total + Double.parseDouble(items.get(i).getPrice());
        }
        return total;
    }
    public boolean containsItem(String itemCode) {
        for(int i = 0; i < items.size(); i++) {
            // as soon as the method finds the item its looking for, returns a true boolean. If not, returns false
            if (items.get(i).getCode().equals(itemCode))
                return true;
        }
        return false;
    }
    // method used to display all the items that are being purchased
    public void print() {
        String id = "Item ID", name = "Name", price = "Price";
        System.out.print(id);
        System.out.format("%15s", name);
        System.out.format("%27s", price);
        System.out.println("\n_________________________________________________");
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i).getCode());
            System.out.format("%25s", items.get(i).getDescription());
            System.out.format("%20s", items.get(i).getPrice());
            System.out.println();
        }
    }
}
