package cleancode.day4.tobe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Order {

    private final Items items;
    private final Customer customer;

    public Order(Items items, Customer customer) throws OrderException {
        if (isInvalid(items, customer)) {
            throw new OrderException("유효하지 않은 주문 생성 요청입니다.");
        }
        this.items = items;
        this.customer = customer;
    }

    public boolean isInvalid(Items items, Customer customer) {
        if (items.isEmpty()) {
            log.info("주문 항목이 없습니다.");
            return true;
        }

        if (items.isTotalPriceNonPositive()) {
            log.info("올바르지 않은 총 가격입니다.");
            return true;
        }

        if (customer.hasNotCustomerInfo()) {
            log.info("사용자 정보가 없습니다.");
            return true;
        }

        return false;
    }
}
