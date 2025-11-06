package thread.control.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest2Main {
    public static void main(String[] args) throws InterruptedException {
        log("main 스레드 시작");

        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start(); // 1초 Sleep * 3번 반복
        t2.start(); // 1초 Sleep * 3번 반복
        t3.start(); // 1초 Sleep * 3번 반복

        t1.join();
        t2.join();
        t3.join();

        log("main 스레드 종료");
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            log(Thread.currentThread().getName() + " 시작");

            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
            }

            log(Thread.currentThread().getName() + " 종료");

        }
    }
}
