package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private String id;
    private String customerEmail;
    private List<OrderLine> lines = new ArrayList<>();
    private Integer discountPercent;
    private boolean expedited;
    private String notes;

    private Order() {}

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return new ArrayList<>(lines); } // deep copy
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", lines=" + lines +
                ", discountPercent=" + discountPercent +
                ", expedited=" + expedited +
                ", notes='" + notes + '\'' +
                '}';
    }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    public static class OrderBuilder {
        private String id;
        private String customerEmail;
        private Integer discountPercent;
        private boolean expedited;
        private String notes;
        private final List<OrderLine> lines = new ArrayList<>();

        public OrderBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public OrderBuilder withCustomerEmail(String customerEmail) {
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email");
            }
            this.customerEmail = customerEmail;
            return this;
        }

        public OrderBuilder withDiscountPercent(Integer discountPercent) {
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Invalid discount percent");
            }
            this.discountPercent = discountPercent;
            return this;
        }

        public OrderBuilder withExpedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public OrderBuilder withNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public OrderBuilder withLine(OrderLine line) {
            lines.add(line);
            return this;
        }

        public OrderBuilder withLines(List<OrderLine> lines) {
            if (lines != null) this.lines.addAll(lines);
            return this;
        }

        public Order build() {
            if (id == null || customerEmail == null) {
                throw new IllegalStateException("Missing required fields");
            }
            Order order = new Order();
            order.id = this.id;
            order.customerEmail = this.customerEmail;
            order.discountPercent = this.discountPercent;
            order.expedited = this.expedited;
            order.notes = this.notes;
            order.lines = new ArrayList<>(this.lines);
            return order;
        }
    }
}
