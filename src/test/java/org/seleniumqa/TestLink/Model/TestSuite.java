package org.seleniumqa.TestLink.Model;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by gadget on 19.04.2015.
 */
public class TestSuite {

    public String name = getCorrectName();
    public String details = "Some details";
    public String description = "Test case description";

    public String testStepDescription = "1. Open Test Link";

    public String getCorrectName(){
        name = "Test"+RandomStringUtils.randomAlphabetic(10);
        return name;
    }

}
