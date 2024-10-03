package cleancode.day4.asis;

public class Customer {
    private final CustomerInfo customerInfo;

    public Customer(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public boolean hasCustomerInfo() {
        return customerInfo != null;
    }
}
