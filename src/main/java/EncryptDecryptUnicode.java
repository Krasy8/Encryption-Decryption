public class EncryptDecryptUnicode implements EncryptDecrypt {
    @Override
    public String encrypt(String input, int key) {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = (char)((int)input.charAt(i) + key);
            output.append(c);
        }
        return output.toString();
    }

    @Override
    public String decrypt(String input, int key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = (char)((int)input.charAt(i) - key);
            output.append(c);
        }
        return output.toString();
    }
}
