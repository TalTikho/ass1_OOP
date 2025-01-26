// 215275512 Tal Tikhonov
/**
 * Calculating the factorial function.
 */
public class Factorial {
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Checks if a given string represents a number.
     * @param str The string to be checked.
     * @return 1 if the string represents a number, 0 otherwise.
     */
    public static int checkIfNum(String str) {
        if (str.charAt(0) == '-') {
            //converting from string to int
            for (int i = 1; i < str.length(); i++) {
                //checking if there is a "problem" with the number
                if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) {
                    System.out.println("Invalid Input");
                    return 0;
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                //checking if there is a "problem" with the number
                if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) {
                    System.out.println("Invalid Input");
                    return 0;
                }
            }
        }
        return 1;
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Converting the string to num.
     * @param str represents the num we ot from the command line.
     * @return out num
     */
    public static long createNum(String str) {
        //Setting variables:
        int num = 0;
        //Output:
        //if num is negative, else num is positive
        if (str.charAt(0) == '-') {
            //converting from string to int
            for (int i = 1; i < str.length(); i++) {
                num = num * 10 + str.charAt(i) - '0';
            }
            return num * -1;
        } else {
            for (int i = 0; i < str.length(); i++) {
                num = num * 10 + str.charAt(i) - '0';
            }
            return num;
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Calculating the factorial of num recursively.
     * @param num represents the num
     * @return the factorial number
     */
    public static long recursiveFactorial(long num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * recursiveFactorial(num - 1);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Calculating the factorial of num iteratively.
     * @param num represents the num
     * @return the factorial number
     */
    public static long iterativeFactorial(long num) {
        //Setting variables:
        int result = 1;
        //Output:
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Main.
     * @param args the arguments we get.
     */
    public static void main(String[] args) {
        // Read the number n from the command line
        if (args.length < 1) {
            System.out.println("Please provide a number as a command-line argument.");
            return;
        }
        /*
         * Not sure if we can use the parse int so ill convert the string to int.
         * int num = Integer.parseInt(args[0]);
         */
        //Setting variables:
        long num = 0;
        int flag = 0;
        /*
         * Output:
         */
        flag = checkIfNum(args[0]);
        //checking the flag, 0=F,1=T
        if (flag == 0) {
            System.out.println("please provide a number as a command-line argument.");
        } else {
          num = createNum(args[0]);
            // Calculate factorial using recursive method
            long recursiveResult = recursiveFactorial(num);
            System.out.println("Factorial of " + num + " (recursive): " + recursiveResult);

            // Calculate factorial using iterative method
            long iterativeResult = iterativeFactorial(num);
            System.out.println("Factorial of " + num + " (iterative): " + iterativeResult);
        }
    }
}
