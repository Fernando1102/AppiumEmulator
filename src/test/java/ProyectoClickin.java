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
            readQRCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void abrirAplicacion() throws Exception {
        DesiredCapabilities clickin = new DesiredCapabilities();
        clickin.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        clickin.setCapability(MobileCapabilityType.DEVICE_NAME, "moto g(8) plus");
        clickin.setCapability(MobileCapabilityType.UDID, "ZY2275X7Q4");
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
    public static BufferedImage generateImage( MobileElement element, File screenshot) throws IOException {
        BufferedImage fullImage = ImageIO.read(screenshot);
        Point imageLocation = element.getLocation();

        int qrCodeImageWidth = element.getSize().getWidth();
        int qrCodeImageHeight = element.getSize().getHeight();

        int pointXPosition = imageLocation.getX();
        int pointYPosition = imageLocation.getY();

        BufferedImage qrCodeImage = fullImage.getSubimage(pointXPosition, pointYPosition, qrCodeImageWidth, qrCodeImageHeight);
        ImageIO.write(qrCodeImage, "png", screenshot);

        return qrCodeImage;
    }
    public static String decodeQRCode(BufferedImage qrCodeImage) throws NotFoundException {
        LuminanceSource source = new BufferedImageLuminanceSource(qrCodeImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }
    public static void readQRCode() throws IOException, NotFoundException {
        MobileElement qrCodeElement = driver.findElement(By.id("mx.alphacredit.clickink:id/imageView11"));

        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        File screenFile = new File("C:\\Users\\fer\\IdeaProjects\\AppiumClickin\\resources\\QR_QA.png");
        FileUtils.copyFile(screenshot, screenFile);
        String content = decodeQRCode(generateImage(qrCodeElement, screenshot));
        //assertThat(content).isEqualTo("f3ce8d4d-074f-483f-9fd0-45c7947fd40c");
    }

}



