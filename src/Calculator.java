import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Введите выражение:");
        int num1 = 0;
        int num2 = 0;

        boolean isNum1 = true;
        boolean isNum2 = true;

        String a = s.next();
        String o = s.next();
        String b = s.next();
        getOper(o);


        for (int x = a.length() - 1;x >= 0;x--){
            char con = a.charAt(x);
            if (Character.isDigit(con)){
                num1 = Integer.parseInt(a);
                isNum1 = true;
                continue;
            }
            else if (Character.isLetter(con)) {
                num1 = Roman(a);
                isNum1 = false;
                break;
            }

        }

        for (int x = b.length() - 1;x >= 0;x--){
            char con2 = b.charAt(x);
            if (Character.isDigit(con2)){
                num2 = Integer.parseInt(b);
                isNum2 = true;
                continue;
            }
            else if (Character.isLetter(con2)){
                num2 = Roman(b);
                isNum2 = false;
                break;
            }

        }

        if (isNum1 == true && isNum2 == true || isNum1 == false && isNum2 == false){
            if (isNum1 == true && isNum2 == true){
                int result = result(num1,num2,o);
                System.out.println("Ваш результат :\n" + result);
            }
            else if (isNum1 == false && isNum2 == false){
                int result = result(num1,num2,o);
                System.out.println("Ваш результат :\n" + integerToRoman(result));
            }
        }
        else {
            System.out.println("Невалидное выражение.");
        }
    }

    public static String integerToRoman(int n) {
        String[] a = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] b = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder s = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            while (n >= b[i]) {
                s.append(a[i]);
                n -= b[i];
            }
        }
        return s.toString();
    }

    public static int Roman(String r) {
        int num = 0;
        int lastNum = 0;
        for (int x = r.length() - 1; x >= 0; x--) {
            char conToNum = r.charAt(x);

            switch (conToNum){
                case 'M':
                    num = processNum(1000, lastNum, num);
                    lastNum = 1000;
                    break;

                case 'D':
                    num = processNum(500, lastNum, num);
                    lastNum = 500;
                    break;

                case 'C':
                    num = processNum(100, lastNum, num);
                    lastNum = 100;
                    break;

                case 'L':
                    num = processNum(50, lastNum, num);
                    lastNum = 50;
                    break;

                case 'X':
                    num = processNum(10, lastNum, num);
                    lastNum = 10;
                    break;

                case 'V':
                    num = processNum(5, lastNum, num);
                    lastNum = 5;
                    break;

                case 'I':
                    num = processNum(1, lastNum, num);
                    lastNum = 1;
                    break;
            }
        }
        return num;
    }

    public static int processNum(int decNum, int lastNumber, int lastDecimal) {
        if (lastNumber > decNum) {
            return lastDecimal - decNum;
        } else {
            return lastDecimal + decNum;
        }

    }



    public static String getOper(String o){

        switch (o){
            case "+":
                return "+";
            case "-":
                return "-";
            case "/":
                return "/";
            case "*":
                return "*";
            default:
                return "Неправильная операция! Повторите ввод!";
        }
    }

    public static int result (int num1, int num2, String o){
        switch (o) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 20;
        }
    }
}
