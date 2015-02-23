package org.seleniumqa.lesson3_1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.assertTrue;

/**
 * Created by admin on 11.02.2015.
 */
public class EnterPass {
    static int pass_1;

    @BeforeTest
    public void setUp(){
        pass_1 =123;
    }

    @Test
    public void validLoginTest(){
        //all must run
        assertTrue(check());
    }

    static public boolean check(){
        for (int i=0; i<3; i++) {
            Scanner in = new Scanner(System.in);
            int pass = in.nextInt();
            if (pass == pass_1) return true;
            return false;
        }
    }

    @AfterTest

    public void testDown(){
        pass_1 = 0;
    }

}
