package com.example.maketalents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

// page_url = https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login;
public class MakeTalentsMain {
    LocalDate date = LocalDate.now();


    public MakeTalentsMain(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[ng-click='customer()']")
    public WebElement buttonCustomerLogin;

    @FindBy(css = "select[id='userSelect']")
    public WebElement selectUser;

    @FindBy(css = "option[value='2']")
    public WebElement optionHarryPotter;

    @FindBy(css = "button[class$='btn-default']")
    public WebElement buttonLogin;

    @FindBy(css = "span[class^='fontBig']")
    public WebElement spanHarryPotter;

    @FindBy(css = "button[ng-class='btnClass2']")
    public WebElement buttonDeposit;

    @FindBy(css = "button[ng-class='btnClass3']")
    public WebElement buttonWithdrawl;

    @FindBy(xpath = "//button[contains(@ng-class, 'btnClass1')]")
    public WebElement buttonTransactions;

    @FindBy(css = "input[class*='ng-pristine']")
    public WebElement FieldDeposit;

    @FindBy(css = "input[class*='ng-pristine']")
    public WebElement FieldWithdrawl;

    @FindBy(css = "button[class$='btn-default']")
    public WebElement buttonDepositSubmit;

    @FindBy(css = "button[class$='btn-default']")
    public WebElement buttonWithdrawSubmit;

    @FindBy(css = "span[class^='error']")
    public WebElement spanDepositSuccessful;

    @FindBy(css = "span[class^='error']")
    public WebElement spanTransactionSuccessful;


    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[2]")
    public WebElement Balance;

    @FindBy(css = "tr[id='anchor0']")
    public WebElement trAnchor;

    @FindBy(css = "tr[id='anchor1']")
    public WebElement trAnchor2;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]")
    public WebElement tdCredit;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[3]")
    public WebElement tdDebit;

    @FindBy(xpath = "//table")
    public WebElement tableDateTimeAmountTransaction;

    @FindBy(css = "html > body > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)")
    public WebElement tdApr;

    @FindBy(css = "html > body > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)")
    public WebElement tdApr2;

    @FindBy(css = "html > body > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)")
    public WebElement tdBinding;

    @FindBy(css = "html > body > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(2)")
    public WebElement tdBinding2;

    @FindBy(css = "html > body > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(3)")
    public WebElement tdCredit2;

    @FindBy(css = "html > body > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(3)")
    public WebElement tdDebit2;


    public void WtiteTable() {
        try {
            String Data1 = tdApr.getText();
            String NewData1 = Data1.replace(",", "");
            String Data2 = tdApr2.getText();
            String NewData2 = Data2.replace(",", "");
            String Amount1 = tdBinding.getText();
            String Amount2 = tdBinding2.getText();
            String Type1 = tdCredit2.getText();
            String Type2 = tdDebit2.getText();
            PrintWriter pw = new PrintWriter(new File("target/allure-results/Report.csv"));
            StringBuilder sb = new StringBuilder();

            sb.append("Date-Time");
            sb.append(",");
            sb.append("Amount");
            sb.append(",");
            sb.append("Transaction Type");
            sb.append("\n");

            sb.append(NewData1);
            sb.append(",");
            sb.append(Amount1);
            sb.append(",");
            sb.append(Type1);
            sb.append("\n");

            sb.append(NewData2);
            sb.append(",");
            sb.append(Amount2);
            sb.append(",");
            sb.append(Type2);
            sb.append("\n");


            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    







    

}