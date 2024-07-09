import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaFunctions {

    public static void main(String[] args){

        // forEach() example
        List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(9);
        numbers.add(10);
        numbers.add(17);
        System.out.println("Example of lambda using forEach - ");
        numbers.forEach(n -> System.out.println(n)); // can also be written as - numbers.forEach(System.out::println);

        // Using Consumer interface
        System.out.println("Example of lambda using Consumer interface and forEach - ");
        Consumer<Integer> method = n -> System.out.println(n*n);
        numbers.forEach(method);

        // To use a lambda in a method, the lambda should have a parameter with single interface with single method as its type.
        // Calling the method of the interface will call the lambda

        System.out.println("Using lambda in a method - ");
        StringOperation addExcalim = n -> n + "?";
        printProcessedString("Hello", addExcalim);
    }

    interface StringOperation{
        String process(String name);
    }

    public static void printProcessedString(String name, StringOperation stringOperation){
        String result = stringOperation.process(name);
        System.out.println(result);
    }
}
