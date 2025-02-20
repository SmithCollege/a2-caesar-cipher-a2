// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class YourTests {
    // Edge case 1: message with punction points
    @Test 
    public void punctionTest(){

        CaesarCipher classUnderTest = new CaesarCipher(1); // h-> g, e-> d, l-> k...
        System.out.println(classUnderTest.encode("hello, world!")); 
        assertEquals("gdkkn, vnqkc!", classUnderTest.encode("hello, world!"));

        
        System.out.println(classUnderTest.decode("gdkkn, vnqkc!"));
        assertEquals("hello, world!", classUnderTest.decode("gdkkn, vnqkc!"));
    }

    //Edge case 2: offset greater than 26
    @Test
    public void largeOffsetTest(){
        CaesarCipher classUnderTest = new CaesarCipher(30); // 30 offset -> 4 offset

        System.out.println(classUnderTest.encode("red table")); //r -> n, e-> a, d->a...
        assertEquals("naz pwxha", classUnderTest.encode("red table"));

        System.out.println(classUnderTest.decode("naz pwxha"));
        assertEquals("red table", classUnderTest.decode("naz pwxha"));
        

    }

}