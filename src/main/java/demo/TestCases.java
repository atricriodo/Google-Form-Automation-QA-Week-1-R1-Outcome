package demo;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;
    static int error_call = 0;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: Google Form");
        // Navigate to gogle form
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        Thread.sleep(5000);
        try {
            // Fill in name in 1st text box
            writeText(driver, By.xpath("//div['Xb9hP']/input[@type='text']"), "Atri Biswas");
            // Write down "I want to be the best QA Engineer! 1710572021" where 1710572021
            // is variable
            writeText(driver, By.xpath("//textarea[@aria-label='Your answer']"),
                    "I want to be the best QA Engineer! " + calculateEpochTimeToString(0));
            // Enter your Automation Testing experience in the next radio button
            clickCheckBox(driver, By.xpath(
                    "(//span[normalize-space(text()) = 'How much experience do you have in Automation Testing?']/ancestor::div[4]//div[@class='AB7Lab Id5V1'])[2]"));
            // Select Java, Selenium and TestNG from the next check-box
            clickCheckBox(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[4]//div[@class='uHMk6b fsHoPb'])[1]"));
            clickCheckBox(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[4]//div[@class='uHMk6b fsHoPb'])[2]"));
            clickCheckBox(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[4]//div[@class='uHMk6b fsHoPb'])[4]"));
            // Provide how you would like to be addressed in the next dropdown
            selectFromDropdown(driver, By.xpath(
                    "//*[normalize-space(text()) = 'How should you be addressed?']/ancestor::div[4]//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']"),
                    "Mr");
            // Provided the current date minus 7 days in the next date field
            writeText(driver, By.xpath(
                    "//*[normalize-space(text()) = 'What was the date 7 days ago?']/ancestor::div[4]//input[@class='whsOnd zHQkBf']"),
                    calculateDateTimeToString("dd/MM/YYYY", (long) 6.048e+8));
            // Provide the current time
            writeText(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'What is the time right now?']/ancestor::div[4]//input[@class='whsOnd zHQkBf'])[1]"),
                    calculateDateTimeToString("HH", 0));
            writeText(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'What is the time right now?']/ancestor::div[4]//input[@class='whsOnd zHQkBf'])[2]"),
                    calculateDateTimeToString("mm", 0));
            // Try going to another website (amazon.in) and you will find the pop up. Click
            driver.get("https://amazon.in");
            Thread.sleep(2000);
            // on cancel
            handleAlert(driver, false);
            // Submit the form
            driver.findElement(By.xpath("//*[normalize-space(text())='Submit']/ancestor::div[1]")).click();
            // Print the message upon successful completion
            System.out.println(driver.findElement(By.xpath("//div[@role='heading']/../div[3]")).getText());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failure!");
            return;
        }
        System.out.println("end Test case: Google Form");

    }

    private static void writeText(ChromeDriver driver, By selector, String textToSend) throws Exception {
        // Initialize the webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait till the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        // Find the element
        WebElement element = driver.findElement(selector);
        // Clear the element text, if already present and send the text
        element.clear();
        element.sendKeys(textToSend);
        Thread.sleep(2000);
    }

    private static String calculateDateTimeToString(String formatString, long offsetInMs) {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Add the offset in milliseconds to the current date and time
        long seconds = offsetInMs / 1000;
        long nanos = (offsetInMs % 1000) * 1000000;
        LocalDateTime newDateTime = now.minus(Duration.ofSeconds(seconds, nanos));

        // Format the new date and time according to the provided format string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString);
        String formattedDateTime = newDateTime.format(formatter);

        // Print the formatted date and time
        return formattedDateTime;
    }

    private static String calculateEpochTimeToString(int offsetInMs) {
        // Get the current date and time as an Instant
        Instant now = Instant.now();

        // Apply the offset in milliseconds to the current instant
        Instant newInstant = now.plusMillis(offsetInMs);

        // Convert the Instant to epoch time in milliseconds
        long epochMilli = newInstant.toEpochMilli();

        // Return the epoch time as a string
        return String.valueOf(epochMilli);
    }

    private static void clickCheckBox(ChromeDriver driver, By selector) throws Exception {
        // Initialize the webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait till the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        // Click the button
        WebElement element = driver.findElement(selector);
        element.click();
        Thread.sleep(2000);
    }

    private static void selectFromDropdown(ChromeDriver driver, By dropDownSelector, String textToSelect)
            throws Exception {
        // Find Dropdown
        WebElement dropdownElement = driver.findElement(dropDownSelector);

        // Create a Select instance
        dropdownElement.click();
        Thread.sleep(2000);

        // Select the option by visible text
        driver.findElement(By.xpath("(//div[@data-value='" + textToSelect + "'])[2]")).click();
        Thread.sleep(2000);
    }

    private static void handleAlert(ChromeDriver driver, Boolean confirm) throws InterruptedException {
        // Wait for the alert to be present and switch to it
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        if (confirm) {
            // Accept the alert (click OK)
            alert.accept();
        } else {
            // Dismiss the alert (click Cancel)
            alert.dismiss();
        }
    }
}