import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String ans = calc(input);
        System.out.println(ans);
    }
    public static String calc (String input) throws Exception {
        String[] arr = input.split("\\s+");

        if (arr.length != 3) {
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        Number num1 = new Number();
        Number num2 = new Number();
        num1.literalValue = arr[0];
        num2.literalValue = arr[2];

        if (num1.isRoman() != num2.isRoman()) {
            throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
        }

        int a = num1.trueValue();
        int b = num2.trueValue();
        if (a<0 || a>10 || b<0 || b>10){
            throw new Exception("throws Exception // вне диапазона от 0 до 10");
        }

        int res = 0;
        String operator = arr[1];
        switch (operator) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
            default:
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String answer = new String();
        if (num1.isRoman() == true) {
            if (res < 1) {
                throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
            } else {
                Number numFin = new Number();
                answer = numFin.getRomanValue(res);
            }
        } else {
            answer = Integer.toString(res);
        }
        return answer;
    }
}

class Number {
    String literalValue;

    boolean isRoman() {
        return Pattern.matches("[IVX]*", literalValue);
    }
    int trueValue () {
        switch (literalValue) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return Integer.parseInt(literalValue);
            }
        }
    String getRomanValue(int num){
        int firstHalf = num / 10;
        int secondHalf = num % 10;
        String firstHalfRoman = new String();
        String secondHalfRoman = new String();
        switch (firstHalf) {
            case 0:
                firstHalfRoman = "";
                break;
            case 1:
                firstHalfRoman = "X";
                break;
            case 2:
                firstHalfRoman = "XX";
                break;
            case 3:
                firstHalfRoman = "XXX";
                break;
            case 4:
                firstHalfRoman = "XL";
                break;
            case 5:
                firstHalfRoman = "L";
                break;
            case 6:
                firstHalfRoman = "LX";
                break;
            case 7:
                firstHalfRoman = "LXX";
                break;
            case 8:
                firstHalfRoman = "LXXX";
                break;
            case 9:
                firstHalfRoman = "XC";
                break;
            case 10:
                firstHalfRoman = "C";
                break;
        }
        switch (secondHalf) {
            case 0:
                secondHalfRoman = "";
                break;
            case 1:
                secondHalfRoman = "I";
                break;
            case 2:
                secondHalfRoman = "II";
                break;
            case 3:
                secondHalfRoman = "III";
                break;
            case 4:
                secondHalfRoman = "IV";
                break;
            case 5:
                secondHalfRoman = "V";
                break;
            case 6:
                secondHalfRoman = "VI";
                break;
            case 7:
                secondHalfRoman = "VII";
                break;
            case 8:
                secondHalfRoman = "VIII";
                break;
            case 9:
                secondHalfRoman = "IX";
                break;
        }
        return firstHalfRoman + secondHalfRoman;
    }
}