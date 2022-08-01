import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program {

    public static final String FILE_URLS_NAME = "ex03/files_urls.txt";
    public static ConcurrentLinkedQueue<String> uris = new ConcurrentLinkedQueue<>();
    public static HashMap<String, Integer> keys = new HashMap<>();

    public static void main(String[] args) throws IOException {

        if(args.length != 1) {
            System.err.println("Wrong arguments count");
            System.exit(-1);
        }

        if(!args[0].matches("--threadsCount=\\d+")) {
            System.err.println("Wrong arguments count");
            System.exit(-1);
        }

        int threadsCount = Integer.parseInt(args[0].split("=")[1]);
        File file = new File(FILE_URLS_NAME);

        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);


        try(Scanner scanner = new Scanner(file)) {

            int k = 1;

            while(scanner.hasNext()) {
                String str = scanner.nextLine();
                uris.add(str);
                keys.put(str, k);
                k++;
            }

            for (int i = 0; i < threadsCount; i++) {
                executorService.submit(new Download(i, uris, keys));
            }
            executorService.shutdown();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class Download implements Runnable {
    private int index;
    private ConcurrentLinkedQueue<String> uris;
    private HashMap<String, Integer> keys;

    Download(int index, ConcurrentLinkedQueue<String> uris, HashMap<String, Integer> keys) {
        this.uris = uris;
        this.keys = keys;
        this.index = index + 1;
    }
    @Override
    public void run() {
        while (!uris.isEmpty()) {
            String url = uris.poll();
            Integer fileNumber = keys.get(url);
            System.out.printf("Thread-%d start download file number %d\n", index, fileNumber);
            String fileName = url.substring(url.lastIndexOf('/') + 1);
            try (InputStream in = URI.create(url).toURL().openStream()) {
                Files.copy(in, Paths.get(fileName));
            } catch (FileAlreadyExistsException e) {
                System.err.println("File already exist");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.printf("Thread-%d finish download file number %d\n", index, fileNumber);
        }
    }
}
