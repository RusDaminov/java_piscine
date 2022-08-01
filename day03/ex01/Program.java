
import ex01.ProducerConsumer;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        String[] str = args[0].split("=");

        int numberOfRepeat = 0;

        if (str[1].matches("[+-]?\\d+")) {
            numberOfRepeat = Integer.parseInt(str[1]);
        }

        ProducerConsumer pc = new ProducerConsumer(numberOfRepeat);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}

