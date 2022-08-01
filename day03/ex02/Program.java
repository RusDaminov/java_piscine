
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static volatile int sumAll = 0;
    public static void main(String[] args) throws InterruptedException {
        if(args.length != 2) {
            System.err.println("Please enter args --arraySize and --threadSize");
            System.exit(-1);
        }

        if(!args[0].matches("--arraySize=\\d+") || !args[1].matches("--threadSize=\\d+")) {
            System.err.println("Wrong arguments");
            System.exit(-1);
        }

        int arraySize = Integer.parseInt(args[0].split("=")[1]);
        int threadSize = Integer.parseInt(args[1].split("=")[1]);

        if(arraySize > 2000000 || arraySize < 1) {
            System.err.println("Array size can't be greater than 2000000 and less than 1");
            System.exit(-1);
        }
        if(threadSize > arraySize) {
            System.err.println("Thread size can't be greater than array size");
            System.exit(-1);
        }

        List<Thread> threads = new ArrayList<>();
        int[] array = new int[arraySize];
        int sum = 0;

        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(2000) - 1000;
        }

        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println("Sum: " + sum);

        int cellSize = arraySize / (threadSize);

        int start = 0;
        int end = cellSize - 1;
        for (int i = 0; i < threadSize - 1; i++) {
            threads.add(new Thread(new Sum(i, start, end, array)));
            start += cellSize;
            end += cellSize;
        }
        threads.add(new Thread(new Sum(threadSize - 1, start, arraySize - 1, array)));

        for (Thread th: threads) {
            th.start();
        }

        for (Thread th: threads) {
            th.join();
        }
        System.out.println("Sum by threads: " + sumAll);
    }
}
class Sum implements Runnable {
    private int index;
    private int from;
    private int to;
    private int sum;
    private int[] array;

    public Sum(int index, int from, int to, int[] array) {
        this.index = index;
        this.from = from;
        this.to = to;
        this.sum = 0;
        this.array = array;
    }

    @Override
    public void run() {
        for(int i = from; i <= to; i++) {
            sum += array[i];
        }
        System.out.println("Thread " + (index + 1) + ": from " + from + " to " + to + " sum is " + sum);
        synchronized (this) {
            Program.sumAll += sum;
        }
    }
}
