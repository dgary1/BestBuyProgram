// BasicReceipt class that implements Receipt

public class BasicReceipt implements Receipt {
    private String storeInfo;
    protected String stateCode;
    private PurchasedItems items;
    private Date date;
    private TaxComputation tc;

    public BasicReceipt(PurchasedItems items, Date date, String storeInfo, String stateCode) {
        this.items = items;
        this.date = date;
        this.storeInfo = storeInfo;
        this.stateCode = stateCode;
    }

    // sets TacComputation state object separately because TaxComputation and String are incompatible types that cannot be
    // assigned to each other
    public void setTaxComputation(TaxComputation tc) {
        this.tc = tc;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // method prints out the basic receipt with all the extra added on the AddOn objects
    public void prtReceipt() {
        double total = items.getTotalCost();
        double tax = tc.computeTax(items, date);
        double totalWithTax = tax + total;
        System.out.print("\n" + date.getDate());
        System.out.println("\n" + storeInfo);
        items.print();
        System.out.format("\nItems Total: $%.2f\n", total);
        System.out.format("Tax: $%.2f\n",  tax);
        System.out.format("Total: $%.2f\n", totalWithTax);
    }
}
