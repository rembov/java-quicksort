import java.util.Random;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("res.txt", false);
        int[] ch = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            ch[i] = rand.nextInt(100);
            writer.append(ch[i] + ",");

            writer.flush();
        }
        writer.append("\n");

        writer.append("---------------------------------------------"
                + "------------------------------------------------"
                + "---------------------------------------------------"
                + "----------------------------------------------------"
                + "---------------------------");
        writer.append("\n");
        writer.flush();
        int low = 0;
        int high = ch.length - 1;

        quickSort(ch, low, high);
        for (int i = 0; i < 100; i++) {
            writer.append(ch[i] + ",");

            writer.flush();

        }
        writer.append("\n");
        System.out.println("ok");

        try (FileReader reader = new FileReader("res.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }

        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];


        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}