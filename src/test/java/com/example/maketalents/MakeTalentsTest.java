package com.example.maketalents;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static com.example.maketalents.Link_pages.Main_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MakeTalentsTest {

    private WebDriver driver;
    private MakeTalentsMain makeTalentsMain;
    LocalDate date = LocalDate.now();

    @BeforeEach
    public void setUp() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(15000, TimeUnit.MILLISECONDS);
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver.get(Main_URL);

        makeTalentsMain = new MakeTalentsMain(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Flow_Test() {
        makeTalentsMain.buttonCustomerLogin.click();
        Select Harry_Potter = new Select(makeTalentsMain.selectUser);
        Harry_Potter.selectByVisibleText("Harry Potter");
        makeTalentsMain.buttonLogin.click();
        String Name = makeTalentsMain.spanHarryPotter.getText();
        assertEquals("Harry Potter", Name);
        int day_next = date.plusDays(1).getDayOfMonth();
        int a = 0;
        int b = 1;
        for (int i = 3; i <= day_next; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println("\n" + b);
        String result = String.valueOf(b);
        System.out.println(result);
        makeTalentsMain.buttonDeposit.click();
        makeTalentsMain.FieldDeposit.sendKeys(result);
        makeTalentsMain.buttonDepositSubmit.click();
        String Text_Deposit_success = makeTalentsMain.spanDepositSuccessful.getText();
        assertEquals("Deposit Successful", Text_Deposit_success);
        makeTalentsMain.buttonWithdrawl.click();
        makeTalentsMain.FieldWithdrawl.sendKeys(result);
        makeTalentsMain.buttonWithdrawSubmit.click();
        String Text_Withdraw_success = makeTalentsMain.spanTransactionSuccessful.getText();
        assertEquals("Transaction successful", Text_Withdraw_success);
        String Balance = makeTalentsMain.Balance.getText();
        assertEquals("0", Balance);
        makeTalentsMain.buttonTransactions.click();
        String TableView0 = makeTalentsMain.trAnchor.getText();
        String TableView1 = makeTalentsMain.trAnchor2.getText();
        assertNotEquals(TableView0, TableView1);
        makeTalentsMain.WtiteTable();
    }
}
