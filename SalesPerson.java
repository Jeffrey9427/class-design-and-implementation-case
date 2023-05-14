package week9;

public class SalesPerson {
    // each object contains details of one salesperson
    private String id;
    private Sales[] salesHistory; // details of the different sales
    private int count = 0; // number of sales made

    //constructor for a new salesperson
    public SalesPerson(String id) {
        this.id = id;
        this.salesHistory = new Sales[100];
    }

    // constructor for a salesperson transferred (together with their sales details) from 			another branch
    public SalesPerson(String id, Sales[] s, int c) {
        this.id = id;
        this.salesHistory = s;
        this.count = c;
    }

    public int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public void setSalesHistory(Sales s) {
        salesHistory[count] = s;
        count += 1;
    }

    public Sales getSalesHistory(int index) {
        if (this.count == 0) {
            return null;
        }

        return salesHistory[index];
    }

    public double calcTotalSales() {
        // calculates total sales for the salesperson
        double totalSales = 0;
        for (Sales sales : salesHistory) {
            if (sales != null) {
                totalSales += sales.getValue() * sales.getQuantity();
            }
        }
        return totalSales;
    }

    public Sales largestSale() {
        // calculates the sale with the largest value
        if (this.count == 0) {
            return null;
        }

        Sales largestSale = salesHistory[0];
        for (Sales sale : salesHistory) {
            largestSale = (largestSale.getValue() > sale.getValue()) ? largestSale : sale;
        }
        return largestSale;
    }
}
