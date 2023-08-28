/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.swing.SwingUtilities;
import net.sourceforge.marathon.javadriver.JavaDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Snehal
 */
public class AdminTest {
    
   private WebDriver driver;
    private  Home log1;
    
    @Before
    public void setUp() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               log1 = new Home();
               log1.setVisible(true);
            }
        });
        driver = new JavaDriver();
    }
    
    @After
    public void tearDown() throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                log1.dispose();
            }
        });
        driver.close();
    }
    
    @Test
      public void checkAllElements() throws InterruptedException {
         Thread.sleep(500);
         WebElement admin = driver.findElement(By.name("adminbtn"));
         assertTrue(admin.isDisplayed());
         WebElement voter = driver.findElement(By.name("voterbtn"));
         assertTrue(voter.isDisplayed());
      }
      
      @Test 
     public void checkLoginEnabled() throws InterruptedException {
       
        WebElement admin = driver.findElement(By.name("adminbtn"));
        assertTrue(admin.isDisplayed());
        WebElement voter = driver.findElement(By.name("voterbtn"));
        assertTrue(admin.isDisplayed());
        admin.click();
        Thread.sleep(200);
        driver.switchTo().window("Admin Login");
        WebElement id1 = driver.findElement(By.name("id"));
        id1.sendKeys("admin");
        Thread.sleep(200);
        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("admin");
        Thread.sleep(1000);
        WebElement btn1 = driver.findElement(By.name("loginbtn"));
        btn1.click();
        driver.switchTo().window("Message");
        Thread.sleep(1000);
        WebElement btn3 = driver.findElement(By.cssSelector("button[text='OK']"));
        assertTrue(btn3.isDisplayed());
        btn3.click();
        driver.switchTo().window("Admin");
        Thread.sleep(1000);
        WebElement menu = driver.findElement(By.name("menubtn"));
        menu.click();
        WebElement add = driver.findElement(By.name("addelection"));
        add.click();
        Thread.sleep(1000);
        driver.switchTo().window("Add Election");
        WebElement id4 = driver.findElement(By.name("id"));
        id4.sendKeys("6");
        Thread.sleep(500);
        WebElement election = driver.findElement(By.name("election"));
        election.sendKeys("Loksabah");
        Thread.sleep(500);
        WebElement savebtn = driver.findElement(By.name("savebtn"));
        assertTrue(savebtn.isDisplayed());
        savebtn.click();
        Thread.sleep(500);
        driver.switchTo().window("Message");
        Thread.sleep(1000);
        WebElement btn5 = driver.findElement(By.cssSelector("button[text='OK']"));
        assertTrue(btn5.isDisplayed());
        btn5.click();
        Thread.sleep(500);
        driver.switchTo().window("Add Election");
        WebElement viewbtn = driver.findElement(By.name("viewall"));
        assertTrue(viewbtn.isDisplayed());
        viewbtn.click();
        Thread.sleep(800);
        WebElement exitbtn = driver.findElement(By.name("exitbtn"));
        assertTrue(exitbtn.isDisplayed());
        exitbtn.click();
        Thread.sleep(1000);

     }
}
