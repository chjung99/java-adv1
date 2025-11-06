package thread.control.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest1Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start(); // 1초 Sleep * 3번 반복
        t1.join(); // t1 종료까지 대기

        t2.start(); // 1초 Sleep * 3번 반복
        t2.join(); // t2 종료까지 대기

        t3.start(); // 1초 Sleep * 3번 반복
        t3.join(); // t3 종료까지 대기
        System.out.println("모든 스레드 실행 완료");
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
            }
        }
    }
}
