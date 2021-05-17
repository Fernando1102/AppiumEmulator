import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class ProyectoClickin {

/*    @BeforeClass
    public void openMovil() throws MalformedURLException {




    }
    @AfterClass
    public void closeMovil(){
        //driver.quit();
    }*/

    WebDriver driver;

    @Test
    public void Flujo1() throws Exception {
        DesiredCapabilities clickin = new DesiredCapabilities();
        //clickin.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        //clickin.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        clickin.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        clickin.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        clickin.setCapability(MobileCapabilityType.NO_RESET,true);
        clickin.setCapability(MobileCapabilityType.APP, "ClickInk-QA-3.0.9-2.apk");
        clickin.setCapability("appPackage", "mx.alphacredit.clickink");
        clickin.setCapability("appActivity", "mx.alphacredit.clickink.Splash");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new RemoteWebDriver(url, clickin);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
        Thread.sleep(5000);

        //driver.findElement(By.id("mx.alphacredit.clickink:id/btn_TerminarTutorial")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

        driver.findElement(By.id("mx.alphacredit.clickink:id/btn_TerminarTutorial")).click();

        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();


        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        driver.findElement(By.id("mx.alphacredit.clickink:id/img_qrCode")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

        driver.findElement(By.id("mx.alphacredit.clickink:id/btn_EmpezarFirma")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.findElement(By.id("mx.alphacredit.clickink:id/numberSMS222")).sendKeys("456643");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);




                //sección de numeros de sms
        // mx.alphacredit.clickink:id/numberSMS222
        // sms 456643
    }
/*public void  imagen() throws IOException {
             // Read the file from the classpath and transform it to a base64 string
            String qrCodeImage = Base64.getEncoder().encodeToString(
            toByteArray(getClass().getResourceAsStream("qr-code.png")));
            System.out.println(qrCodeImage);

             // Provide the transformed image to the device
            ((JavascriptExecutor)driver).executeScript("sauce:inject-image=" + qrCodeImage);
}*/
}







