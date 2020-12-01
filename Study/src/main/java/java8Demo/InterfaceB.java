package java8Demo;

public interface InterfaceB {
    default void show() {
        System.out.println("in interface java8Demo.B");
    }

    void print();
}
