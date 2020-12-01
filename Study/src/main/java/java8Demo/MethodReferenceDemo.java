package java8Demo;

interface Parser{
    public String parse(String str);
}
class StringParser{
    public static String convert(String s)
    {
 //       System.out.println(this instanceof java8Demo.Parser);
        if(s.length()<=3)
            s=s.toUpperCase();
        else
            s=s.toLowerCase();
        return s;
    }
}
class MyPrinter{

    public void print(String str, Parser p)
    {
        str=p.parse(str);
        System.out.println(str);
    }
}
public class MethodReferenceDemo {

    public static void main(String[] args) {
        String str="Sumit";
        MyPrinter myPrinter =new MyPrinter();
        myPrinter.print(str,StringParser::convert);

        myPrinter.print(str, new Parser() {
            @Override
            public String parse(String str) {
                return StringParser.convert(str);
            }
        });
    }
}

