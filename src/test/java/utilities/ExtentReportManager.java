package utilities;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports getReportInstance() {
		if(extent == null) {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
			String timestamp = now.format(formatter);

            // Ensure reports directory exists
            String reportDir = "reports";
            new File(reportDir).mkdirs();
//			String reportPath = reportDir + "/ExtentReport_" + timestamp + ".html";
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";
			System.out.println("Generating report at: " + reportPath);
			
			File reportsFolder = new File(reportDir);
	        if (!reportsFolder.exists()) {
	            reportsFolder.mkdirs(); // creates the folder(s)
	        }
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setReportName("Test Execution Report");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
	
	public static ExtentTest createTest(String testName) {
		test = getReportInstance().createTest(testName);
		return test;
	}

}
