package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser user;
    HelperAddContact addContact;

    public HelperUser getUser() {
        return user;
    }

    public HelperAddContact getAddContact() {
        return addContact;
    }



    @BeforeSuite
    public void init(){
        wd = new ChromeDriver();
        user = new HelperUser(wd);
        addContact = new HelperAddContact(wd);
       // wd.manage().window().maximize();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        wd.quit();
    }
}
