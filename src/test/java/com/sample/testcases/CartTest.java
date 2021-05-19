package com.sample.testcases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import screens.cartscreen;

public class CartTest extends BaseTest{
    @Test
    public void testprice(){
        cartscreen cartpage = homeScreen.gotocart();

    }

}
