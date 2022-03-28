package test.day08;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test //(priority = 9)
    public void youtubeTest(){
        System.out.println("youtube testi calisti");
    }

    @Test (priority = 8)
    public void amazonTest(){  //priority atanmazsa priority= 0 kabul edilir
        System.out.println("amazon testi calisti");
    }

    @Test (priority = 5)
    public void bestbuyTest(){
        System.out.println("bestBuy testi calisti");
    }

}
