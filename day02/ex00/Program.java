import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private static final String signaturesFileName = "signatures.txt";
    private static final String outputFileName = "result.txt";

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(signaturesFileName);
        } catch (java.io.FileNotFoundException fileNotFoundException) {
            System.out.println("Signature file not found");
            System.exit(-1);
        }

        ArrayList<Signature> signatures = new ArrayList<>();
        try {
            while (true) {
                signatures.add(Signature.createFromSignatureFile(fileInputStream));
            }
        } catch (SignatureScannerFormatException signatureScannerFormatException) {
            System.out.println("Wrong signature file format");
            System.exit(-1);
        } catch (SignatureScannerEOFException signatureScannerEOFException) {
        }
        try {
            fileInputStream.close();
        } catch (java.io.IOException ioException) {
            throw new RuntimeException(ioException);
        }
        if (signatures.size() == 0) {
            System.out.println("Empty signature file");
            System.exit(-1);
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputFileName);
        } catch (java.io.FileNotFoundException fileNotFoundException) {
            System.out.println("Can't create file");
            System.exit(-1);
        }
        Scanner console = new Scanner(System.in);
        String currentInput = new String("");
        while (!currentInput.equals("42")) {
            currentInput = console.nextLine();
            try {
                fileInputStream = new FileInputStream(currentInput);
            } catch (java.io.FileNotFoundException fileNotFoundException) {
                System.out.println("File not found");
                continue;
            }
            boolean isSignatureFound = false;
            SignatureChecker signatureChecker = new SignatureChecker(fileInputStream);
            for (int counter = 0; counter < signatures.size(); ++counter) {
                if (signatureChecker.checkSignature(signatures.get(counter))) {
                    signatures.get(counter).putToOutput(fileOutputStream);
                    System.out.println("PROCESSED");
                    isSignatureFound = true;
                    break;
                }
            }
            if (!isSignatureFound) {
                System.out.println("UNDEFINED");
            }
            try {
                fileInputStream.close();
            } catch (java.io.IOException ioException) {
                throw new RuntimeException(ioException);
            }
        }
    }
}