package examples.java.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class App {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three");

        // Using an explicit implementation of the Consumer interface
        list.forEach(new MyConsumer<String>());

        // Using an anonymous class
        // The curly braces syntax here effectively creates a new class that implements the Consumer interface
        // AND instantiates an instance of that class
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // Using a lambda expression
        // The lambda expression syntax here effectively creates a new class that implements the Consumer interface
        // AND uses the lambda expression as the implementation of the ONE method in the functional interface
        list.forEach( item -> System.out.println(item) );
    }


}
