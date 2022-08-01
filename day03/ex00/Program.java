public class Program {
    public static void main(String[] args) throws InterruptedException {

        int numberOfRepeat = 0;

        if(args.length < 1) {
            System.err.println("Wrong argument");
            System.exit(-1);
        }
        if(args[0].matches("--count=\\d+")) {
            numberOfRepeat = Integer.parseInt(args[0].split("=")[1]);
        }

        int finalNumberOfRepeat = numberOfRepeat;
        Thread myThread1 = new Thread(new Runnable(){

            @Override
            public void run() {

                for (int i = 0; i < finalNumberOfRepeat; i++) {
                    System.out.println("Egg");
                }

            }
        });

        Thread myThread2 = new Thread(new Runnable(){

            @Override
            public void run() {

                for (int i = 0; i < finalNumberOfRepeat; i++) {
                    System.out.println("Hen");
                }

            }
        });

        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();

        for (int i = 0; i < finalNumberOfRepeat; i++) {
            System.out.println("Human");
        }
    }
}
