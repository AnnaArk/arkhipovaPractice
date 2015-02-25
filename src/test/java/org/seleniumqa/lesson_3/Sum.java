package org.seleniumqa.lesson_3;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by admin on 25.02.2015.
 */
public class Sum {

    @Test
    public void valid_Sum(){
        Assert.assertEquals(sum(2,4),6,"Sum passed");

    }

    static public int sum(int a, int b){
        int c;
        c = a+b;
        return c;
    }

}
