import java.io.InputStream;
import java.util.ArrayList;


public class SignatureChecker {
    private InputStream inputStream;
    private char [] signatureBuffer;

    private SignatureChecker() {}

    public SignatureChecker(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    public boolean checkSignature(Signature signature) {
        try {

            if (signatureBuffer == null) {
                if (inputStream.available() < Signature.MAX_SIGNATURE_SIZE) {
                    signatureBuffer = new char[inputStream.available()];
                } else {
                    signatureBuffer = new char[Signature.MAX_SIGNATURE_SIZE];
                }
                for (int counter = 0; counter < signatureBuffer.length; ++counter) {
                    signatureBuffer[counter] = (char)inputStream.read();
                }
            }
        } catch (java.io.IOException ioException) {
            throw new RuntimeException();
        }
        if (signature.signature.length() > signatureBuffer.length) {
            return false;
        }
        for (int counter = 0; counter < signature.signature.length(); ++counter) {
            if (signature.signature.toCharArray()[counter] != signatureBuffer[counter]) {
                return false;
            }
        }
        return true;
    }
}