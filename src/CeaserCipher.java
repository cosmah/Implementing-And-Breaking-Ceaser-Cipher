import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CeaserCipher {
    public String encrypt(String input, int key){
        //make a StringBuilder with a message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //write alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        //count from 0 to < length of encrypted (i)
        for (int i = 0;i < encrypted.length(); i++) {
            //Look at the ith character of the encrypted (currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is inthe alphabet
            if (idx != -1) {
                //Get the idxth character of the shiftedAlphabet(newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of the encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }

            //Otherwise:do nothing

        }
        //the answer is String inside encrypted
        return encrypted.toString();
    }

//    public void testCeaser() {
//        int key = 17;
//        FileResource fr = new FileResource();
//        String message = fr.asString();
//        String encrypted = encrypt(message, key);
//        System.out.println(encrypted);
//        String decrypted = encrypt(encrypted, 26-key);
//        System.out.println(decrypted);
//    }
    public void testCeaser() {
        int key = 17;
        String filePath = "C:\\Users\\Administrator\\Desktop\\ceaser.txt"; // replace with your file path
        try {
            String message = new String(Files.readAllBytes(Paths.get(filePath)));
            String encrypted = encrypt(message, key);
            System.out.println(encrypted);
            String decrypted = encrypt(encrypted, 26-key);
            System.out.println(decrypted);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CeaserCipher cipher = new CeaserCipher();
        cipher.testCeaser();
    }

}
