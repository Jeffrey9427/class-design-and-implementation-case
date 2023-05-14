package week9;

public class Driver {
    static SalesPerson[] salesPeople;
    public static String highest(SalesPerson[] salesPeople) {
        //returns the ID of the salesPerson whose sales have the largest value
        String id = "";
        double highest = salesPeople[0].calcTotalSales();

        for (SalesPerson salesPerson : salesPeople) {
            if (salesPerson != null && salesPerson.calcTotalSales() > highest) {
                highest = salesPerson.calcTotalSales();
                id = salesPerson.getId();
            }
        }

        return id;
    }

    public static void addSales(Sales s, String id) {
        //add a new Sales object s, to the salesPerson with a specified ID (valid ID)
        for (SalesPerson salesPerson : salesPeople) {
            if (salesPerson != null && salesPerson.getId().equals(id)) {
                salesPerson.setSalesHistory(s);
                return;
            }
        }
    }

    public static void main(String[] args){
        salesPeople = new SalesPerson[6];

        salesPeople[0] = new SalesPerson("100");
        salesPeople[1] = new SalesPerson("101");
        salesPeople[2] = new SalesPerson("102");

        salesPeople[0].setSalesHistory(new Sales("A100",300.00,10));
        salesPeople[0].setSalesHistory(new Sales("A200",1000.00,2));
        salesPeople[1].setSalesHistory(new Sales("A300",2550.40,10));

        System.out.println(salesPeople[2].getId());
        System.out.println(salesPeople[0].getCount());
        System.out.println(salesPeople[1].getSalesHistory(0).getValue());
        System.out.println(salesPeople[0].calcTotalSales());

        System.out.println(highest(salesPeople));   //will print out 101
        addSales(new Sales("A400", 100000.00, 20), "102");
        System.out.println(highest(salesPeople));   //will print out 102
    }
}
