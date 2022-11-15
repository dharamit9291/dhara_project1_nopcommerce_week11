package com_nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowserTest {
    public static void main(String[] args) throws InterruptedException {
        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //Launch the URL
        driver.get(baseUrl);
        //Maximise Window
        driver.manage().window().maximize();
        //We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println("page title is :" + title);

        // Get current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Get page source
        System.out.println("Page source : " + driver.getPageSource());

        //Find the email field element and send the email
        WebElement emailField  = driver.findElement(By.id("Email"));
        emailField.sendKeys("test123@gmail.com");

        //Find the password field element and send the password
        WebElement passwordField  = driver.findElement(By.name("Password"));
        passwordField.sendKeys("test1234");

        //Click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        Thread.sleep(10000);
        // Close the browser
        driver.quit();
    }

}
