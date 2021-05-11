import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ProyectoClickin {
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {
        try {
            abrirAplicacion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void abrirAplicacion() throws Exception {
        DesiredCapabilities clickin = new DesiredCapabilities();
        clickin.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        clickin.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        clickin.setCapability(MobileCapabilityType.APP, "C:\\Users\\fer\\Desktop\\AppiumClickin\\resources\\ClickInk-QA-3.0.9-2.apk");
        clickin.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        clickin.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        clickin.setCapability("appPackage", "mx.alphacredit.clickink");
        clickin.setCapability("appActivity", "mx.alphacredit.clickink.Splash");


        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, clickin);
        System.out.println("Application Started Successfully....");
        Thread.sleep(5000);


        MobileElement btn_TerminarTutorial = driver.findElement(By.id("mx.alphacredit.clickink:id/btn_TerminarTutorial"));
        btn_TerminarTutorial.click();
        Thread.sleep(3000);
        btn_TerminarTutorial.click();
        MobileElement permiso = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
        permiso.click();
        permiso.click();
        MobileElement permiso1 = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
        permiso1.click();
        permiso.click();
        permiso.click();
        MobileElement btnQR = driver.findElement(By.id("mx.alphacredit.clickink:id/img_qrCode"));
        btnQR.click();
        MobileElement btn_EmpezarFirma = driver.findElement(By.id("mx.alphacredit.clickink:id/btn_EmpezarFirma"));
        btn_EmpezarFirma.click();


        //sección de numeros de sms
        // mx.alphacredit.clickink:id/numberSMS222
        // sms 464852
    }

}



