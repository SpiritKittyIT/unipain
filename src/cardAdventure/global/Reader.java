package cardAdventure.global;
import java.util.Scanner;

/**
* Class to gold a global instance of Scanner.
*/
public class Reader {
    private static Scanner sc;

    /**
    * initialise the global instance of Scanner.
    */
    private static void scInit() {
        if (Reader.sc == null) {
            Reader.sc = new Scanner(System.in);
        }
    }

    /**
    * close the global instance of Scanner if it is initialised.
    */
    public static void ensureClose() {
        if (Reader.sc == null) {
            Reader.sc.close();
            Reader.sc = null;
        }
    }

    /**
    * use the global instance of Scanner to read as line from standard input
    * @return String, the line read from standard input
    */
    public static String readLine() {
        Reader.scInit();
        return Reader.sc.nextLine();
    }
}
