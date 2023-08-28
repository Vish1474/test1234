
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


public class TestHome {
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
        assertTrue(voter.isDisplayed());
        voter.click();
        Thread.sleep(200);
        driver.switchTo().window("Voter");
        WebElement aadhar = driver.findElement(By.name("aadhar"));
        aadhar.sendKeys("123456789012");
        Thread.sleep(1000);
        WebElement btn1 = driver.findElement(By.name("loginbtn"));
        btn1.click();
        driver.switchTo().window("VoterHome");
        Thread.sleep(1000);
        WebElement cid = driver.findElement(By.name("cid"));
        cid.sendKeys("1");
        WebElement btn2 = driver.findElement(By.name("votebtn"));
        btn2.click();   
        driver.switchTo().window("Message");
        Thread.sleep(1000);
        WebElement btn3 = driver.findElement(By.cssSelector("button[text='OK']"));
        assertTrue(btn3.isDisplayed());
        btn3.click();
        Thread.sleep(1000);
     }

   
}
