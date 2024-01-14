
import java.util.Scanner;
public class Main {
    public static void main (String[] args)throws ImputException {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println(stringCalc(scanner.nextLine()));
                }
            }
            public static String stringCalc(String input)throws  ImputException{
                String answer,st3,st2;
                String array = input.replace(" ","");
                String[] arrayAnswer = array.split("\"");
                if (arrayAnswer.length==3 ) {
                    st3 = String.valueOf(arrayAnswer[2].charAt(0));
                    st2 = arrayAnswer[2].substring(1);
                } else if (arrayAnswer.length==4) {
                    st2 = arrayAnswer[3];
                    st3 = arrayAnswer[2];
                    if(array.lastIndexOf("\"")!=array.length()-1){
                        throw new ImputException("st2 не является строкой");
                    }
                }else  throw new ImputException("не допустимое входное выражение");
                String st1 = arrayAnswer[1];
                if(st2.length()>10||st1.length()>10) {
                    throw new ImputException("превышина длинна строки");
                }
                switch (st3) {
                    case "+":if (arrayAnswer.length!=4){
                        throw new ImputException("не допустимое входное выражение при сложении");
                    }
                        answer = "\"" + st1 + st2 + "\"";
                        break;
                    case "-":if (arrayAnswer.length!=4){
                        throw new ImputException("не допустимое входное выражение при вычитании");
                    }
                        answer = "\"" + st1.replaceAll(st2, "") + "\"";
                        break;
                    case "/":try {
                        if(Integer.parseInt(st2)>10||Integer.parseInt(st2)==0){
                            throw new ImputException("не допустимый ввод при делении");
                        }}catch (NumberFormatException e) {
                        throw new ImputException("не допустимый ввод при делении");
                    }
                    answer = "\"" + st1.substring(0, st1.length() / Integer.parseInt(st2)) + "\"";
                        break;
                    case "*":try {
                        if(Integer.parseInt(st2)>10){
                            throw new ImputException("привышение величены числа при умножении");
                        }}catch (NumberFormatException e){
                            throw new ImputException("не допустимый ввод при умножении ");
                    }
                        answer = "\"" + st1.repeat(Integer.parseInt(st2)) + "\"";
                        break;
                    default:
                        throw new ImputException(" отсутствие оператора ");
                }if (answer.length()>40) {
                    return answer.substring(0, 40) + "...";
                }else return answer;
            }
        }
        class ImputException extends Exception{
            ImputException(String st){
               super(st);
            }
}

