package muiltthread;

/**
 * @crea : Created by intelliJ IDEA 16.1.3
 * @auth : Gopan
 * @mail : 15923508369@163.com
 * @date : 2017/4/13 12:01
 * @desc : synchronized的重入
 */
public class SyncDubbo1 {
    public synchronized void method1(){
        System.out.println("method1..");
        method2();
    }
    public synchronized void method2(){
        System.out.println("method2..");
        method3();
    }
    public synchronized void method3(){
        System.out.println("method3..");
    }

    public static void main(String[] args) {
        final SyncDubbo1 sd = new SyncDubbo1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sd.method1();
            }
        });
        t1.start();
    }
}

