import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input:");
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
        System.out.println("Output:");

    }

    public static String calc(String input) {
        String[] operations = {"+", "-", "*", "/"};
        String currentOperation = "";
        String[] numbersArray = null;
        Converter converter = new Converter();
        String result;
        for (String operation : operations) {
            if (input.contains(operation)) {
                numbersArray = input.split("\\" + operation);
                currentOperation = operation;
            }
        }
        if (numbersArray != null) {
            if (numbersArray.length > 2) throw new CalulatorException("There should be only two numbers");
            int convertedNumber1 = converter.romanToArabic(numbersArray[0].trim());
            int convertedNumber2 = converter.romanToArabic(numbersArray[1].trim());
            if (convertedNumber1 > 0 & convertedNumber2 > 0) {
                //roman numbers
                int arabic = calcByOperation(convertedNumber1, convertedNumber2, currentOperation);
                result = converter.arabicToRoman(arabic);
            } else {
                //arabic numbers
                int firstNumber;
                int secondNumber;
                try {
                    firstNumber = Integer.parseInt(numbersArray[0].trim());
                    secondNumber = Integer.parseInt(numbersArray[1].trim());
                } catch (NumberFormatException e) {
                    throw new CalulatorException("Numbers must be integer");
                }

                result = String.valueOf(calcByOperation(firstNumber, secondNumber, currentOperation));
            }

        } else {
            throw new CalulatorException("Unsupported operation");
        }
        return result;
    }

    private static int calcByOperation(int first, int second, String operation) {
        if (first > 10 || first <= 0 || second > 10 || second <= 0) {
            throw new CalulatorException("Numbers must be in range 1-10");
        }
        int result;
        switch (operation) {
            case ("+"):
                result = first + second;
                break;
            case ("-"):
                result = first - second;
                break;
            case ("*"):
                result = first * second;
                break;
            default:
                result = first / second;
                break;
        }
        return result;
    }
}