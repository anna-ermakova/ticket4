import java.util.Arrays;


public class Main {
    //Напишите код, с помощью которого можно разделить строку на части.
    static String str = "Задача билета №4. Skypro";
    static String delimiter = "№";
    static int partSize = 11;
    static int parts = 2;
    static int length = str.length();
    static int partLength = length / parts;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(splitWithDelimiter(str, delimiter)));
        System.out.println(Arrays.toString(splitWithPartSize(str, partSize)));
        System.out.println(Arrays.toString(splitWithParts(str, parts)));
    }

    public static String[] splitWithDelimiter(String str, String delimiter) {
        return str.split(delimiter);
    }

    public static String[] splitWithPartSize(String str, int partSize) {
        return str.split("(?<=\\G.{" + partSize + "})");
    }

    public static String[] splitWithParts(String str, int parts) {
        String[] partsArray = new String[parts];
        int startIndex = 0;
        int endIndex = partLength;
        for (int i = 0; i < parts; i++) {
            if (i == parts - 1) {
                endIndex = length;
            }
            partsArray[i] = str.substring(startIndex, endIndex);
            startIndex = endIndex;
            endIndex += partLength;
        }
        return partsArray;
    }
}

