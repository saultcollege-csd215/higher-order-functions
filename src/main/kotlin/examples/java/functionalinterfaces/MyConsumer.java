package examples.java.functionalinterfaces;

// This class implements the Consumer functional interface
class MyConsumer <T> implements java.util.function.Consumer<T> {
    @Override
    public void accept(T s) {
        System.out.println(s);
    }
}