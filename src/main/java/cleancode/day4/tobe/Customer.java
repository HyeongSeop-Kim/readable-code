package cleancode.day4.tobe;

public class Customer {
    private final CustomerInfo customerInfo;

    public Customer(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public boolean hasNotCustomerInfo() {
        return customerInfo == null;
    }
}
