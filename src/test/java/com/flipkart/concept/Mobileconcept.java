package com.flipkart.concept;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Mobileconcept {
	static WebDriver driver;
	static long start;
	static String text;
	static String text1;
	static File f;
	@BeforeClass
	public static void browserLaunching(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\eclipse-workspace\\Junit-task\\driver\\chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.navigate().to("http://www.flipkart.com");
	}
	public static void browserQuit() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	public void startTime() {
		start =System.currentTimeMillis();
	}
	public void endTime() {
		long end =System.currentTimeMillis();
		System.out.println("time taken:"+(end-start));
	}
	@Test
	public void flipkart1(){
		WebElement element = driver.findElement(By.xpath("//button[text()='✕']"));
		element.click();
	}
	@Test
	public void flipkart2(){
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("Realme Mobiles",Keys.ENTER);
	}
	@Test
	public void flipkart3() throws Exception{
		Thread.sleep(2000);
		WebElement mobile1 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		text = mobile1.getText();
		System.out.println(text);
	}
	@Test
	public void flipkart4() throws Exception{
		Thread.sleep(2000);
		WebElement mobile1 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		mobile1.click();
		Thread.sleep(2000);
		WebElement mobile2 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
		mobile2.click();
		Thread.sleep(2000);
		WebElement mobile3 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
		mobile3.click();
	}
	@Test
	public void flipkart5() throws Exception {
		Set<String>window =driver.getWindowHandles();
		List<String> window1 =new ArrayList<String>(window);
		for (String x :window1) {
			driver.switchTo().window(x);
			driver.switchTo().window(window1.get(3));
			}
		WebElement mobile = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		text1=mobile.getText();
		System.out.println(text1);
		f=new File("C:\\Users\\ASUS\\eclipse-workspace\\Junit-task\\src\\test\\resources\\Mobile1.xlsx");
		Workbook wb=new XSSFWorkbook();
		Sheet s =wb.createSheet("Mobile1");
		for(int i=0;i<1;i++) {
			Row r =s.createRow(i);
	    for (int j = 0; j < 2; j++) {
			Cell c= r.createCell(j);
		if (j==0) {
			c.setCellValue(text1);}
		if (i==0) {
			c.setCellValue(text1);}
		}
		}
		FileOutputStream f2= new FileOutputStream(f);
		wb.write(f2);
	}
		@Test
		public void flipkart6() throws Exception {
			TakesScreenshot tk =(TakesScreenshot)driver;
	        File filetype =tk.getScreenshotAs(OutputType.FILE);
	        File Location = new File("C:\\Users\\ASUS\\eclipse-workspace\\Junit-task\\src\\test\\resources\\Mobiless");
	        FileUtils.copyFile(filetype,Location);	
		}
		public void flipkart7() {
			if (text.equals(text1)) {
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			} 
		}
}









