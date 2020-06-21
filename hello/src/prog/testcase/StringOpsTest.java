package prog.testcase;
import junit.framework.*;
import prog.StringOps;

public class StringOpsTest extends TestCase {
    public void testReverse()
    {
        StringOps stringOps = new StringOps();
        String input="abc";
       String reverse ="cba";
       String output= stringOps.reverseString(input);
       assertEquals(reverse, output);

    }
}
