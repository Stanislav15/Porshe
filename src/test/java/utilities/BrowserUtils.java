package utilities;

import org.testng.Assert;

public class BrowserUtils {


    public static void verifyTextMatches(String str1, String str2){

        Assert.assertEquals(str1, str2);
        System.out.println("EQUAL");

    }

    public static void verifyTextContains (String str1, String str2){

        if(str1.contains(str2)){
            System.out.println("Contains");
        }else{
            System.out.println("FAIL");
        }

    }

}





