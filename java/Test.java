import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("../test.txt"))) {
            String line;
            String input = "";
            int test_count = 0;
            int passed_count = 0;

            while ((line = br.readLine()) != null) {
                if (isTestInput(line)) {
                    input = line;
                } else if (input != "" && line != "") {
                    args = input.split("\\s+");
                    String result = MyCd.myCd(args[2], args[3]);
                    String expected = line;
                    boolean passed = result.equals(expected);

                    System.out.println("INPUT    : " + input);
                    System.out.println("OUTPUT   : " + result);
                    System.out.println("EXPECTED : " + expected);
                    System.out.println("RESULT   : " + (passed ? "OK" : "INCORRECT") );
                    System.out.println();
                    System.out.println();

                    input = "";

                    test_count += 1;
                    if (passed) {
                        passed_count += 1;
                    }
                }
            }

            System.out.println(String.format("PASSED %d/%d TESTS", passed_count, test_count));

        } catch (IOException ex) {
            System.out.println("Could not read test file.");
        }
    }

    private static boolean isTestInput(String line) {
        return line.startsWith("# mycd ") && line.split("\\s+").length >= 4;
    }

}