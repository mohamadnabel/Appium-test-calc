package myTestCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class myTestCases {
	DesiredCapabilities caps = new DesiredCapabilities();

	AndroidDriver driver;

	Assertion myAssert = new Assertion();

	@BeforeTest
	public void mySetup() throws MalformedURLException {

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "appTest");

		File myApplicationCalcu = new File("src/myApplication/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, myApplicationCalcu.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	}

	@Test(enabled = true)
	public void myTestcases() throws MalformedURLException {
		// how to cofiger between caps with driver

		WebElement num9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
		WebElement multiply = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
		WebElement num5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));

		WebElement results = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));

		System.out.println(results.getText());

		num9.click();
		multiply.click();
		num5.click();
		myAssert.assertEquals(results.getText(), "45", "this is for check result");

	}

	@Test(enabled = true)
	public void pressOnAllNumber() {
		System.out.println("main test");

		List<WebElement> allNumber = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0; i < allNumber.size(); i++) {
			System.out.println("for loop");

			if (allNumber.get(i).getAttribute("resource-id").contains("digit")) {
				System.out.println("first if statment");

				String numberText = allNumber.get(i).getText();
				int number = Integer.parseInt(numberText);
//
//				if (number % 2 == 0) {
//					allNumber.get(i).click();
//				} else {
//					System.out.println("hello");
//				}

			}
		}
	}

}
