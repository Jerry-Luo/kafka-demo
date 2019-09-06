package javabase.test;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * System.CurrentTimeMillis() 在高并发下会有性能问题
 * https://mp.weixin.qq.com/s/HHSdCAGgMjaPtVrOyce2TA
 *
 * @author <a href="mailto:luojianwei@qiancangkeji.cn">LuoJianwei</a>
 * @since 1.0.0
 */
public class SystemCurrentTimeMillisTest {

    private static final int COUNT = 100;


    @Test
    public void currentTimeMillis() throws InterruptedException {
        long beginTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            System.currentTimeMillis();
        }
        long elapsedTime = System.nanoTime() - beginTime;
        System.out.println("100 System.currentTimeMillis() serial calls: " + elapsedTime + " ns");

        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
            new Thread(()->{
                try {
                    startLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    endLatch.countDown();
                }
            }).start();
        }
        beginTime = System.nanoTime();
        startLatch.countDown();
        endLatch.await();
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("100 System.currentTimeMillis() parallel calls " + elapsedTime+ " ns");
    }
}
