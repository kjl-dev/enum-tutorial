package a.JavaApi;

import java.util.Objects;

public class Main {

    public static void main(String ... args) {
        Order orderA = new Order("A", OrderStatus.CANCELLED);

        System.out.println(OrderStatus.CANCELLED.equals(orderA.getOrderStatus())); //true
        System.out.println(Objects.equals(OrderStatus.CANCELLED, orderA.getOrderStatus())); //true
        System.out.println(OrderStatus.CANCELLED == orderA.getOrderStatus()); //true

        System.out.println(OrderStatus.CANCELLED.toString()); //OrderStatus.CANCELLED
        System.out.println(OrderStatus.CANCELLED.name()); // CANCELLED

        System.out.println(OrderStatus.CANCELLED.ordinal()); // 0 -- Avoid this
        System.out.println(OrderStatus.CANCELLED.compareTo(OrderStatus.REFUNDED)); // -3  -- Avoid this too

        System.out.println(OrderStatus.valueOf("CANCELLED")); //OrderStatus.CANCELLED
        System.out.println(OrderStatus.valueOf("cancelled")); // IllegalArgumentException
        System.out.println(OrderStatus.valueOf("???")); // IllegalArgumentException


    }
}
