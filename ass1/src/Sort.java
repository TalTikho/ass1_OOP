//215275512 Tal Tikhonov
/**
 * Sorting.
 */
public class Sort {
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
     * Copying the array.
     * @param array represents the array
     * @return the copied array
     */
    public static int[] copyArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Printing the array.
     * @param array represents the array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Printing the reversed array.
     * @param array represents the array
     */
    public static void printReversedArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Bubble sorting - Ascending.
     * @param array representing the array
     * @return the sorted array
     */
    public static int[] bubbleSort(int[] array) {
        //Setting variables:
        int temp = 0;
        int[] tempArray = copyArray(array);
        //Output:
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = i + 1; j < tempArray.length; j++) {
                if (tempArray[i] > tempArray[j]) {
                    temp = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = temp;
                }
            }
        }
        return tempArray;
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Sorting the array by ascending order.
     * @param numbers represents the array.
     */
    public static void sortAscendingOrder(int[] numbers) {
        int[] tempArray = bubbleSort(numbers);
        printArray(tempArray);
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Sorting the array by descending order.
     * @param numbers represetns the array.
     */
    public static void sortDescendingOrder(int[] numbers) {
        int[] tempArray = bubbleSort(numbers);
        printReversedArray(tempArray);
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
        String[] str = new String[args.length - 1];
        String way = args[0];
        //Output:
        //inserting arguments
        for (int i = 0; i < args.length - 1; i++) {
            str[i] = args[i + 1];
        }
        //converting to int
        int[] nums =  stringsToInts(str);
        if (nums == null) {
            System.out.println("Please provide only numbers as a command-line argument.");
        } else {
            if (way.equals("asc")) {
                sortAscendingOrder(nums);
            } else if (way.equals("desc")) {
                sortDescendingOrder(nums);
            } else {
                System.out.println("Wrong printing way chosen");
            }
        }
    }
}
