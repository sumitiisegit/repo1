package prog;

public class StringOps {

    public static void main(String a[])
    {
        StringOps stringOps = new StringOps();
        System.out.println(stringOps.reverseString("abcdef"));
        System.out.println(stringOps.reverseString("abc def"));
        System.out.println(stringOps.reverseString("abc d ef"));
        System.out.println(stringOps.reverseString(" ab0 12 c d ef"));
    }


    public String reverseString(String str){

        String rev;
        char[] array = str.toCharArray();
        char[] tempArray = new char[array.length];

        for(int i=0; i<str.length();i++)
        {
            tempArray[i] = array[str.length()-i-1];
        }
        System.out.println(tempArray);
        rev = new String(tempArray);
        return rev;
    }

}
