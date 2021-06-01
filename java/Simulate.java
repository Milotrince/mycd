import java.util.Scanner;

public class Simulate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        while (!line.equals("exit")) {
            System.out.print("# ");
            line = scanner.nextLine();
            args = line.split("\\s+");
            if (args.length > 2 && args[0].equals("mycd")) {
                System.out.println(MyCd.myCd(args[1], args[2]));
                System.out.println();
            }
        }
        scanner.close();
    }

}
