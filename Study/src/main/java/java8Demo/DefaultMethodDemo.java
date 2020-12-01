package java8Demo;

public class DefaultMethodDemo implements InterfaceA, InterfaceB{

    // this is required as default implementation of show() is present in multiple interfaces.
    @Override
    public void show() {
        System.out.println("in java8Demo.DefaultMethodDemo show");
    }

    @Override
    public void print() {
        System.out.println("in java8Demo.DefaultMethodDemo print");
    }

    public static void main(String[] args) {
        DefaultMethodDemo defaultMethodDemo = new DefaultMethodDemo();
        defaultMethodDemo.print();
        defaultMethodDemo.show();

        InterfaceA interfaceA = new DefaultMethodDemo();
        interfaceA.print();
        interfaceA.show();
    }
}

