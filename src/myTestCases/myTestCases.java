package myTestCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class myTestCases {
	DesiredCapabilities caps = new DesiredCapabilities();

	AndroidDriver driver;

	@BeforeTest
	public void mySetup() {

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "appTest");

		File myApplicationCalcu = new File("src/myApplication/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, myApplicationCalcu.getAbsolutePath());
	}

	@Test
	public void myTestcases() throws MalformedURLException {
		// how to cofiger between caps with driver

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	}

}
