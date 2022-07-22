package com.basic.elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base {

	WebDriver driver = null;
	static String baseURL = "https://jqueryui.com/";

	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void openURL() {
		driver.get(baseURL);
	}

	public void navigateSlider() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 250)", "");
	}

	public void clickSlider() {
		driver.findElement(By.linkText("Slider")).click();
	}

	public void dragSlider() {

		// Switch Frame
		// driver.switchTo().frame(0);

		// Check Slider Visiblity
		// if (driver.findElement(By.id("slider")).isDisplayed()) {
		// System.out.println("Slider Visible");
		// } else {
		// System.out.println("Not Visible");
		// }

		// WebElement slider = driver.findElement(By.id("slider"));
		// WebElement target = driver.findElement(By.xpath("//*[@id=\'slider\']/span"));

		/*
		 * Dimension sliderSize = slider.getSize(); int sliderWidth =
		 * sliderSize.getWidth(); int xCoord = slider.getLocation().getX();
		 */

		Actions actions = new Actions(driver);

		// actions.dragAndDrop(slider, target).build().perform();
		// actions.dragAndDropBy(slider, 0, 75).build().perform();
		// actions.dragAndDropBy(slider, 100, 0).build().perform();
		// actions.moveToElement(slider, xCoord + sliderWidth, 0).build().perform();
		driver.findElement(By.linkText("Colorpicker")).click();
		driver.switchTo().frame(0);
		if (driver.findElement(By.xpath("//*[@id=\'green\']/div")).isDisplayed()) {
			System.out.println("Green Slider Visible");
		} else {
			System.out.println("Not Visible");
		}

		WebElement slider = driver.findElement(By.xpath("//*[@id=\'green\']/span"));
		actions.dragAndDropBy(slider, 100, 0).build().perform();
	}

	@Test(priority = 1)
	public void draggableEle() {
		driver.findElement(By.linkText("Draggable")).click();
		driver.switchTo().frame(0);
		if (driver.findElement(By.id("draggable")).isDisplayed()) {
			System.out.println("Element is Present!");
		} else {
			System.out.println("Not Present");
		}

		WebElement dragger = driver.findElement(By.xpath("//*[@id=\'draggable\']"));
		//WebElement target = driver.findElement(By.xpath("//*[@id=\'droppable\']"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(dragger, 300, 200).build().perform();
	}
}
