import java.io.*;
import java.util.Scanner;
import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Logger logger = Logger.getLogger("My logger");

    public static void main(String[] args) throws IOException {
        //taskOne();
        //taskTwo README.md
        //taskThree();
        //taskFour();
        //taskFive();
    }

    private static void taskFive() {
        Pattern pattern = Pattern.compile("(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[012])-([1-9]\\d{3})");
        Matcher matcher = pattern.matcher("23-03-1999");
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    private static void taskFour() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/Main.java");
        FileOutputStream fileOutputStream = new FileOutputStream("src/copy/copy.txt");

        fileInputStream.transferTo(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void taskThree() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/num.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("src/sum.txt");

        Scanner scanner = new Scanner(fileInputStream);
        Integer sum = 0;
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            sum  += x;
        }
        System.out.println(sum);
        fileOutputStream.write(sum.toString().getBytes());
        fileOutputStream.close();
    }

    private static void taskOne() throws IOException {
        //Task 1
        Handler handler = new ConsoleHandler();
        logger.addHandler(handler);
        logger.info("Some message");
        //Task 2
        handler.setLevel(Level.FINE);
        logger.fine("Zinnurbek");
        //Task 3
        FileHandler fileHandler = new FileHandler("log.txt");
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.info("Some message");
    }
}
