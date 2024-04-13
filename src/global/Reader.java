package global;
import java.util.Scanner;

public class Reader {
    private static Scanner sc;

    private static void scInit() {
        if (Reader.sc == null) {
            Reader.sc = new Scanner(System.in);
        }
    }

    public static void ensureClose() {
        if (Reader.sc == null) {
            Reader.sc.close();
            Reader.sc = null;
        }
    }

    public static String readLine() {
        Reader.scInit();
        return Reader.sc.nextLine();
    }
}
