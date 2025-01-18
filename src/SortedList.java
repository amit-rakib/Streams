import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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


	}

}
