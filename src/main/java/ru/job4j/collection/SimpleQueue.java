package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.getSize() == 0) {
            while (in.getSize() != 0) {
                out.pushLast(in.pop());
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.pushLast(value);
    }
}
