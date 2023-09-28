package EcommeraceFrameworks.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtendReporterNG {
public static ExtentReports getReportObjejct() {
	String path = System.getProperty("user.dir")+"\\Reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports extent = new  ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Ahmed Mohamed Abdelsayed");
	return extent;
}
}
