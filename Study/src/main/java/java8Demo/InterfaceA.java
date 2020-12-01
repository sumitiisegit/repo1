package java8Demo;

public interface InterfaceA {
    default void show(){
        System.out.println("in interface java8Demo.A");
    }
    void print();
}
