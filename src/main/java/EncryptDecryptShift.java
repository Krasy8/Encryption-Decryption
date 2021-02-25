public class EncryptDecryptShift implements EncryptDecrypt {

    char aLower = 'a';
    char zLower = 'z';
    char aUpper = 'A';
    char zUpper = 'Z';
    int size = 26;

    @Override
    public String encrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        char[] inputToChars = input.toCharArray();

        for (char item : inputToChars) {
            if (item >= aLower && item <= zLower) {
                char shiftItem = (char)(((item - aLower + key) % size) + aLower);
                output.append(shiftItem);
            } else if (item >= aUpper && item <= zUpper) {
                char shiftItem = (char)(((item - aUpper + key) % size) + aUpper);
                output.append(shiftItem);
            } else {
                output.append(item);
            }
        }
        return output.toString();
    }

    @Override
    public String decrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        char[] inputToChars = input.toCharArray();

        for (char item : inputToChars) {
            if (item >= aLower && item <= zLower) {
                char shiftItem = (char) (zLower - ((zLower - item + key) % size));
                output.append(shiftItem);
            } else if (item >= aUpper && item <= zUpper) {
                char shiftItem = (char) (zUpper - ((zUpper - item + key) % size));
                output.append(shiftItem);
            } else {
                output.append(item);
            }
        }
        return output.toString();

    }
}
