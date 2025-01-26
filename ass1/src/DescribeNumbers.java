//215275512 Tal Tikhonov
/**
 * Gets a list of numbers in the commandline, and prints their minimum,
 * maximum, and average values.
 */
public class DescribeNumbers {
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
    public static int createNum(String str) {
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
     * Converting the array of strings to array of nums.
     * @param numbers represents the array of strings.
     * @return array of nums
     */
    public static int[] stringsToInts(String[] numbers) {
        //Setting variables:
        int[] nums = new int[numbers.length];
        //Output:
        for (int i = 0; i < numbers.length; i++) {
            //checking validity
            if (checkIfNum(numbers[i]) == 1) {
                nums[i] = createNum(numbers[i]);
            } else {
                System.out.println("there is an argument that is not a number");
                return null;
            }
        }
        return nums;
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Finding the min value.
     * @param numbers represents the array of numbers
     * @return the min value
     */
    public static int min(int[] numbers) {
        //Setting variables:
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Finding the max value.
     * @param numbers represents the array of numbers
     * @return the max value
     */
    public static int max(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Finding the average of the array.
     * @param numbers represents the array of numbers
     * @return the average
     */
    public static float avg(int[] numbers) {
        //Setting variables:
        int sum = 0;
        float avg = 0;
        //Output:
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        avg = (float) sum / (float) numbers.length;
        return avg;
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Main.
     * @param args represents the command line arguments
     */
    public static void main(String[] args) {
        // Read the number n from the command line
        if (args.length < 1) {
            System.out.println("Please provide a number as a command-line argument.");
            return;
        }
        //Setting variables:
        String[] str = new String[args.length];
        //Output:
        //inserting arguments
        for (int i = 0; i < args.length; i++) {
            str[i] = args[i];
        }
        //converting to int
        int[] nums =  stringsToInts(str);
        if (nums == null) {
            System.out.println("Please provide only numbers as a command-line argument.");
        } else {
            System.out.println("The following numbers were found:");
            System.out.println("min: " + min(nums));
            System.out.println("max: " + max(nums));
            System.out.println("avg: " + avg(nums));
        }
    }
}
