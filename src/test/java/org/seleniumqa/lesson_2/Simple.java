package org.seleniumqa.lesson_2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Simple {
    int number;

    @BeforeTest
    public void setUp(){
        number =13;

    }

    @Test
    public void isPrimeTest(){
        //all must run
        assertTrue(isPrime(number));
    }

    public static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }

    @AfterTest

    public void testDown(){
        number = 0;
    }


}
