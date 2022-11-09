package examples.higherorder;

import java.util.ArrayList;
import java.util.List;

// The Consumer interface is Java's way of representing a function that takes a single argument and returns nothing
import java.util.function.Consumer;

public class ListUtils {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        // This 'looks like' passing a lambda expression to a function (but it's not really)
        list.forEach( item -> System.out.println(item) );
        // This 'looks like' passing a function reference to a function (but it's not really)
        list.forEach(System.out::println);

    }

    // By encapsulating the copy-on-write pattern for lists in this function, we can avoid code duplication
    public static <T> List<T> withCopy(List<T> list, Consumer<List<T>> operation) {
        List<T> newList = new ArrayList<T>(list);
        operation.accept(newList);
        return newList;
    }

    // Now these functions can be implemented in terms of the withCopy function
    // Only the operation performed on the copy is different (we pass the operation in as a lambda expression)
    public static <T> List<T> set(List<T> list, int index, T value) {
        return withCopy(list, newList -> newList.set(index, value));
    }

    public static <T> List<T> push(List<T> list, T value) {
        return withCopy(list, newList -> newList.add(value));
    }

    public static <T> List<T> dropLast(List<T> list) {
        return withCopy(list, newList -> newList.remove(list.size() - 1));
    }

    public static <T> List<T> dropFirst(List<T> list) {
        return withCopy(list, newList -> newList.remove(0));
    }
}
