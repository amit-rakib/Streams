import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//th[1]")).click();

		List<WebElement> elementList = driver.findElements(By.xpath("//td[1]"));
	List<String> OrginalList =	elementList.stream().map(s->s.getText()).collect(Collectors.toList());
	System.out.println(OrginalList);
	
    List<String> SortedList = OrginalList.stream().sorted().collect(Collectors.toList());
	System.out.println(SortedList);
	
	Assert.assertEquals(OrginalList, SortedList);
	
	
	List<String> price;
	
	
	do {
		
		price = driver.findElements(By.xpath("//tr/td[1]")).stream().filter(s->s.getText().contains("Rice"))
				.map(s->getPrice(s)).collect(Collectors.toList());
		
        price.forEach(a->System.out.println(a));
        
        if(price.size()<1) {
       	 driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
        }
		
	} while(price.size()<1);
	


	}
	
	public static String getPrice(WebElement s) {
		
		String p = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return p;
		
	}

}
