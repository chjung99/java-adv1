package thread.executor.test;

import java.util.concurrent.ExecutionException;

public class NewOrderServiceTestMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String orderNo = "Order#1234"; // 예시 주문 번호 OldOrderService orderService = new OldOrderService(); orderService.order(orderNo);
        NewOrderService orderService = new NewOrderService();
        orderService.order(orderNo);
    }
}