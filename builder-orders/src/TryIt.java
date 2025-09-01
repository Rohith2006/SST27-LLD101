import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        // OrderLine l1 = new OrderLine("A", 1, 200);
        // OrderLine l2 = new OrderLine("B", 3, 100);
        // Order o = new Order("o2", "a@b.com");
        // o.addLine(l1);
        // o.addLine(l2);
        // o.setDiscountPercent(10);
        // System.out.println("Before: " + o.totalAfterDiscount());
        // l1.setQuantity(999); // demonstrates mutability leak
        // System.out.println("After:  " + o.totalAfterDiscount());
        // System.out.println("=> In the solution, totals remain stable due to defensive copies.");
        Order o2 = new Order.OrderBuilder()
                .withId("o2")
                .withLine(new OrderLine("A", 1, 200))
                .withLine(new OrderLine("B", 3, 100))
                .withCustomerEmail("a@b.com")
                .withDiscountPercent(10)
                .build();

        System.out.println(o2);
        System.out.println("Total before discount: " + o2.totalBeforeDiscount());
        System.out.println("Total after discount:  " + o2.totalAfterDiscount());
        // o2.setDiscountPercent(20); // throws IllegalArgumentException
    }
}
