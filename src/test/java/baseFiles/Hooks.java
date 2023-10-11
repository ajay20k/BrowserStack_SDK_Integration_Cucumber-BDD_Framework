package baseFiles;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.WebUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Hooks extends CommonUtil {
    int count = 1;
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

    @Before
    public void beforeScenario(Scenario scenario) throws InterruptedException, IOException {
        driver = WebUtil.initWebDriver();
        wait = WebUtil.initWebWait();
    }

    @AfterStep
    public void captureScreenshot(Scenario scenario) throws IOException {
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src\\TestResults\\Screenshots_" + timeStamp + "\\" + scenario.getSourceTagNames().toString().split("@")[1].split("]")[0] + "_" + count + ".jpg");
        FileUtils.copyFile(sourceFile, destinationFile);
        count++;
    }

    @After
    public void afterScenario() {
        WebUtil.quitDriver();
    }
}
