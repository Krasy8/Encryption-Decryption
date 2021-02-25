import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        EncryptDecrypt ED_shift = new EncryptDecryptShift();
        EncryptDecrypt ED_unicode = new EncryptDecryptUnicode();

        String mode = "enc";
        String input = "";
        String inputIn = "";
        String inputData = "";
        int key = 0;
        String in = "";
        String out = "";
        String alg = "shift";

        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                inputData = args[i + 1];
                System.out.println("The input is: " + inputData);
            }
            if (args[i].equals("-in")) {
                in = args[i + 1];
                File fileIn = new File(in);

                try (Scanner scanner = new Scanner(fileIn)) {
                    while (scanner.hasNext()) {
                        inputIn = scanner.nextLine();
                    }
                    System.out.println("The input to encrypt is: " + inputIn);
                } catch (FileNotFoundException e) {
                    System.out.println("Error : No file found: " + fileIn);
                }
            }
            if (args[i].equals("-out")) {
                out = args[i + 1];
            }
            if (args[i].equals("-alg")) {
                alg = args[i +1];
            }
        }

        if (Arrays.asList(args).contains("-data") || !Arrays.asList(args).contains("-in")) {
            input = inputData;
        } else if (!Arrays.asList(args).contains("-data") && Arrays.asList(args).contains("-in")) {
            input = inputIn;
        }
//        System.out.println("input to decrypt is: " + input);

        if (alg.equals("shift")) {

            processEncOrDec(args, ED_shift, mode, input, key, out);
        } else if (alg.equals("unicode")) {

            processEncOrDec(args, ED_unicode, mode, input, key, out);

        } else {
            System.out.println("The algorithm parameter can be only shift or unicode, " +
                    "please choose one of them");
        }
    }

    private static void processEncOrDec(String[] args, EncryptDecrypt encryptDecrypt, String mode, String input, int key, String out) {
        if (!Arrays.asList(args).contains("-out")) {
            switch (mode) {
                case "enc":
                    System.out.println("The result is: " + encryptDecrypt.encrypt(input, key));
                    break;
                case "dec":
                    System.out.println("The result is: " + encryptDecrypt.decrypt(input, key));
                    break;
                default:
            }
        } else {
            File fileOut = new File(out);
            switch (mode) {
                case "enc":
                    try (FileWriter writer = new FileWriter(fileOut)) {
                        writer.write(encryptDecrypt.encrypt(input, key));
                    } catch (IOException e) {
                        System.out.printf("Error : An exception occurs %s", e.getMessage());
                    }
                    break;
                case "dec":
                    try (FileWriter writer = new FileWriter(fileOut)) {
                        writer.write(encryptDecrypt.decrypt(input, key));
                    } catch (IOException e) {
                        System.out.printf("Error : An exception occurs %s", e.getMessage());
                    }
                    break;
                default:
            }
            try (Scanner scanner = new Scanner(fileOut)) {
                String result = "";
                while (scanner.hasNext()) {
                    result = scanner.nextLine();
                }
                System.out.println("The result is: " + result);
            } catch (FileNotFoundException e) {
                System.out.println("Error : The output file found: " + fileOut);
            }
        }
    }
}
