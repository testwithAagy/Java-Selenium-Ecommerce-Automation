package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Selenium E-Commerce Automation");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Application", "SauceDemo");
            extentReports.setSystemInfo("Automation Tool", "Selenium WebDriver");
            extentReports.setSystemInfo("Language", "Java");
            extentReports.setSystemInfo("Test Framework", "TestNG");
        }

        return extentReports;
    }
}