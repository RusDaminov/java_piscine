package ex01;

public class ProducerConsumer {

    private final int count;

    private Boolean flag = true;

    private final Object lock = new Object();

    public ProducerConsumer(int count) {
        this.count = count;
    }

    public void produce() throws InterruptedException {

        for (int i = 0; i < count; i++) {
            synchronized (lock) {
                if(!flag) {
                    lock.wait();
                }
                System.out.println("Egg");
                flag = false;
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {

        for (int i = 0; i < count; i++) {
            synchronized (lock) {
                if(flag) {
                    lock.wait();
                }
                System.out.println("Hen");
                flag = true;
                lock.notify();
            }
        }
    }
}
