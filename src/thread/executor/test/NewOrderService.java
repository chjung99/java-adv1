package thread.executor.test;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class NewOrderService {
    public void order(String orderNo) throws ExecutionException, InterruptedException {
        CallableWork inventoryWork = new CallableWork(orderNo, "재고 업데이트");
        CallableWork shippingWork = new CallableWork(orderNo, "배송 시스템 알림");
        CallableWork accountingWork = new CallableWork(orderNo, "회계 시스템 업데이트");
// 작업 요청
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Boolean> futureInventoryWork = es.submit(inventoryWork);
        Future<Boolean> futureShippingWork = es.submit(shippingWork);
        Future<Boolean> futureAccountingWork = es.submit(accountingWork);

        Boolean inventoryResult = futureInventoryWork.get();
        Boolean shippingResult = futureShippingWork.get();
        Boolean accountingResult = futureAccountingWork.get();
// 결과 확인
        if (inventoryResult && shippingResult && accountingResult) {
            log("모든 주문 처리가 성공적으로 완료되었습니다.");
        } else {
            log("일부 작업이 실패했습니다.");
        }
        es.close();
    }

    static class CallableWork implements Callable<Boolean> {
        private final String orderNo;
        private final String message;

        public CallableWork(String orderNo, String message) {
            this.orderNo = orderNo;
            this.message = message;
        }

        @Override
        public Boolean call() throws Exception {
            log(message + ": " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
