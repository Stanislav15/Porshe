package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CaymanS extends TestBase {

    @Test
    public void MainCar() throws InterruptedException {
    //2.
        driver.get("https://www.porsche.com/usa/modelstart/");
    //3.
        driver.findElement(By.xpath("//a//div//span")).click();
    //4.
        String expectPrice = driver.findElement(By.xpath("//div[contains(text(),'69')]")).getText();//From $ 69,300.00*


    //5
        driver.findElement(By.xpath("//div[contains(text(),'69')]")).click();



        String parent = driver.getWindowHandle();

        Thread.sleep(5000);

        Set<String> all = driver.getWindowHandles();

        for(String my : all){
            if(! my.equals(parent)){
                driver.switchTo().window(my);
                break;
            }
        }


        String baseprice =driver.findElement(By.xpath("(//div[contains(text(),'69')])[2]")).getText();//69,300

        //System.out.println("this is base" +baseprice);

        Assert.assertTrue(baseprice.contains("$69,300"),expectPrice);

       String equipment = driver.findElement(By.xpath("(//*[@class='ccaPrice'])[6]")).getText();//0

       Assert.assertTrue(equipment.contains("0"),"0");

      String fee =  driver.findElement(By.xpath("(//*[@class='ccaPrice'])[7]")).getText();//1,250
        //System.out.println("this is fee " + fee);

      String total = driver.findElement(By.xpath("(//*[@class='ccaPrice'])[8]")).getText();//70,550

        String b = baseprice.substring(1,baseprice.length());

        String bb = b.substring(0, 2) + b.substring(2+1);



        String f = fee.substring(1,fee.length());

        String ff = f.substring(0,1) + f.substring(1+1);


        String t = total.substring(1,total.length());
        String tt = t.substring(0,2) + t.substring(2+1);


      int n1 = Integer.parseInt(bb);//69300
       int n2 = Integer.parseInt(ff);//1250
       int tot = Integer.parseInt(tt);//70550


        int sum = n1+n2;

        Assert.assertEquals(tot,sum);

        driver.findElement(By.id("s_exterieur_x_FJ5")).click();

        WebElement blue = driver.findElement(By.id("s_exterieur_x_FJ5"));

        Thread.sleep(1000);


        String bluePrice = driver.findElement(By.xpath("//*[@class='tt_price tt_cell']")).getText();//$2,580


        String da = driver.findElement(By.xpath("(//*[@class='ccaPrice'])[6]")).getText();//$2,580

        Thread.sleep(1000);


        String net = driver.findElement(By.xpath("(//*[@class='ccaPrice'])[8]")).getText();//73,130

        String nt = net.substring(1,total.length());
        String ntt = nt.substring(0,2) + nt.substring(2+1);
        int totalBase = Integer.parseInt(ntt); //73,130


        Assert.assertTrue(bluePrice.contains("$2,580"),da);

        Assert.assertEquals(totalBase,totalsum(baseprice,da,fee));


        Thread.sleep(2000);


        driver.findElement(By.id("scrollIndicator")).click();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("(//span[@class='img-element'])[11]")); //20 wheels
        Thread.sleep(2000);


        actions.moveToElement(element).click(element);
        actions.perform();





        String wheel = driver.findElement(By.xpath("(//*[@class='tt_price tt_cell'])[2]")).getText(); //2560




        String sWeel = wheel.substring(1,wheel.length()); //$2,560 pass
        String Ssweel = sWeel.substring(0,1)+ sWeel.substring(1+1);
        int Wheel = Integer.parseInt(Ssweel);//2560



        String bBlue = bluePrice.substring(1,bluePrice.length()); //$2,580 pass
        String Bblue = bBlue.substring(0,1)+ bBlue.substring(1+1);
        int Blue = Integer.parseInt(Bblue);//2580


        int WhBlue = Blue+Wheel;//5140 pass




        String newEquipment = driver.findElement(By.xpath("(//*[@class='ccaPrice'])[6]")).getText();//5140 (!)
        String nE = newEquipment.substring(1,newEquipment.length());
        String nEE = nE.substring(0,1) + nE.substring(1+1);
        int NewEq = Integer.parseInt(nEE);


        Assert.assertEquals(NewEq,WhBlue);

        int su = WhBlue+n1+n2;

        Assert.assertEquals(tot(total),su);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

        driver.findElement(By.id("s_interieur_x_PP06")).click();

        String seats = driver.findElement(By.xpath("(//*[@class='pBox'])[8]")).getText();//2330
        String newSeats = seats.substring(1,seats.length());
        String News = newSeats.substring(0,1) + newSeats.substring(1+1);
        int NewSea = Integer.parseInt(News);


        int Bum = NewSea + Blue + Wheel; //7470

        int nu = Bum + n2 +n1;

        Assert.assertEquals(Bum,price(equipment));

        Assert.assertEquals(tot(total),nu);//778020

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);


        driver.findElement(By.id("IIC_subHdl")).click();
        Thread.sleep(800);
        driver.findElement(By.id("vs_table_IIC_x_PEKH_x_c01_PEKH")).click();

        String Interior = driver.findElement(By.xpath("(//*[@class='pBox'])[117]")).getText();//1540
        String newIn = Interior.substring(1,Interior.length());
        String newInter = newIn.substring(0,1) + newIn.substring(1+1);
        int NewI = Integer.parseInt(newInter);//1540

        int sumInter = Bum + NewI;//9010

        Assert.assertEquals(price(equipment),sumInter); //79560

        int newsum = sumInter +n1+n2;

        Assert.assertEquals(tot(total),newsum); //step 21

        driver.findElement(By.id("navigation_main_x_mainsuboffer_x_individual")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("IMG_subHdl")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("vs_table_IMG_x_M250_x_c11_M250")).click();

        String PDK = driver.findElement(By.xpath("(//*[@class='pBox'])[41]")).getText();//3210
        String pdk = PDK.substring(1,PDK.length());
        String newPDK = pdk.substring(0,1) + pdk.substring(1+1);
        int newpdk = Integer.parseInt(newPDK);//3210

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

        driver.findElement(By.id("vs_table_IMG_x_M450_x_c81_M450")).click();
        Thread.sleep(1000);

        String PCCB = driver.findElement(By.xpath("(//*[@class='pBox'])[48]")).getText();//7410
        String pccb = PCCB.substring(1,PCCB.length());
        String newPCCB = pccb.substring(0,1) + pccb.substring(1+1);
        int newpcb = Integer.parseInt(newPCCB);//7410
                    //3200   //7410
        int pccdk = newpdk + newpcb + sumInter;//10620 exp-->19630

        int finnal = pccdk + n1+n2;

        Assert.assertEquals(dv(equipment),pccdk);

        Assert.assertEquals(tot(total),finnal); //step 26
        
    }



    public int totalsum(String baseprice,String equipment,String fee){

        String b = baseprice.substring(1,baseprice.length());
        String bb = b.substring(0, 2) + b.substring(2+1);

        String e = equipment.substring(1,equipment.length());
        String ee = e.substring(0,1)+ e.substring(1+1);

        String f = fee.substring(1,fee.length());
        String ff = f.substring(0,1) + f.substring(1+1);

        int n1 = Integer.parseInt(bb);
        int n2 = Integer.parseInt(ee);
        int n3 = Integer.parseInt(ff);


        int sum = n1+n2+n3;

        return sum;

    }

    public int tot(String total){
        String net = driver.findElement(By.xpath("(//*[@class='ccaPrice'])[8]")).getText();

        String nt = net.substring(1,total.length());
        String ntt = nt.substring(0,2) + nt.substring(2+1);
        int totalBase = Integer.parseInt(ntt);

        return totalBase;
    }

    public int price(String unique){

        String newEquipment = driver.findElement(By.xpath("(//*[@class='ccaPrice'])[6]")).getText();
        String nE = newEquipment.substring(1,newEquipment.length());
        String nEE = nE.substring(0,1) + nE.substring(1+1);
        int NewEq = Integer.parseInt(nEE);

        return NewEq;

    }

    public int dv(String num){
        String newEquipment = driver.findElement(By.xpath("(//*[@class='ccaPrice'])[6]")).getText();
        String nt = newEquipment.substring(1,newEquipment.length());
        String ntt = nt.substring(0,2) + nt.substring(2+1);
        int totalBase = Integer.parseInt(ntt);

        return totalBase;

    }

}
