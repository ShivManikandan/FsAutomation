/*
 * package utilities;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Set;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.chrome.ChromeOptions;
 * 
 * public class util {
 * 
 * 
 * static List<String> winList; static Set<String> windows;
 * 
 * public static String getLastWindow(WebDriver driver) {
 * windows=driver.getWindowHandles(); winList= new ArrayList<String>();
 * winList.addAll(windows); return (winList.get(winList.size()-1)); }
 * 
 * 
 * 
 * public static void CloseTab() {
 * 
 * 
 * 
 * 
 * List<WebElement> listItem = driver.findElements(By.
 * xpath("//ul[contains(@class,'tabBarItems slds-grid') and @role='presentation']/li[contains(@class,'oneConsoleTabItem')]//button[contains(@title,'Close')]"
 * )); System.out.println(listItem.size()); if(listItem.size()>0) { for
 * (WebElement item : listItem) { item.click(); } } } }
 */