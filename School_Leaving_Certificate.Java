import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SchoolLeavingCertificateAutomation {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path of chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Login
        driver.get("https://abcschool.com/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("username");
        passwordField.sendKeys("password");
        loginButton.click();

        // Navigate to certificates
        driver.get("https:// abcschool.com/certificates");

        // Select the certificate type
        WebElement certificateTypeDropdown = driver.findElement(By.id("certificate-type"));
        certificateTypeDropdown.click();
        WebElement schoolLeavingCertificateOption = driver.findElement(By.xpath("//option[text()='School Leaving Certificate']"));
        schoolLeavingCertificateOption.click();

        // Search and select the student
        WebElement searchField = driver.findElement(By.id("student-search"));
        searchField.sendKeys("Sam");
        WebElement studentResult = driver.findElement(By.xpath("//td[text()='Sam'] /input"));
        studentResult.click();

        // Click on generate
        WebElement generateButton = driver.findElement(By.id("generate-certificate"));
        generateButton.click();

        // Update remarks
        WebElement remarksField = driver.findElement(By.id("remarks"));
        remarksField.sendKeys("Completed education with __________ grades.");

        // Generate and download
        WebElement downloadButton = driver.findElement(By.id("download-certificate"));
        downloadButton.click();

        // Validate the history of certificates
        driver.get("https://abcschool.com/certificate-history");
        WebElement certificateHistoryTable = driver.findElement(By.id("certificate-history-table"));
        boolean isCertificatePresent = certificateHistoryTable.getText().contains("Sam");
        if (isCertificatePresent) {
            System.out.println("School Leaving Certificate for Sam has been generated and is present in the history.");
        } else {
            System.out.println("School Leaving Certificate for Sam is not present in the history.");
        }

        // Close the browser
        driver.quit();
    }
}
