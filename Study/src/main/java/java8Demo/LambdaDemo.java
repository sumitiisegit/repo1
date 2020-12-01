package java8Demo;

interface A {
    void show();
}
interface B {
    void show(int i);
}

// this class is used only to provide definition of java8Demo.A:show()
//class AImpl implements java8Demo.A {
//
//    @Override
//    public void show() {
//        System.out.println("in AImpl show");
//    }
//
//}

public class LambdaDemo {

    public static void main(String[] args) {
        //     java8Demo.A a = new AImpl();

//        java8Demo.A a = new java8Demo.A() {
//            @Override
//            public void show() {
//                System.out.println("print java8Demo.A from annonymous inner class");
//            }
//        };
//

        A a = () -> System.out.println("print java8Demo.A from lambda expression");
        a.show();

       // java8Demo.B b = (int i) -> System.out.println("print java8Demo.B from lambda expression:" + i);
       // java8Demo.B b = (i) -> System.out.println("print java8Demo.B from lambda expression:" + i);
        B b = i -> System.out.println("print java8Demo.B from lambda expression:" + i);

        b.show(7);

    }
}

