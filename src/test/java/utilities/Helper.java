package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

   public static void takeScreenShot(WebDriver driver , String screenShotName) throws IOException {
       Path dest = Paths.get("./Screenshots",screenShotName+".png") ;
        Files.createDirectories(dest.getParent()) ;
        FileOutputStream out = new FileOutputStream(dest.toString()) ;
        out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        out.close();





   }
}
