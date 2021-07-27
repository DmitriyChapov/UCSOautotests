package login.main.administration.interviews.archive;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static variables.admin.Selector.*;
import static variables.admin.Xpath.*;

public class InterviewsArchivePage extends Login {

    public void sectionInterviewsArchive() throws InterruptedException {
        loginAdmin();
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionInterviews = driver.findElement(xpathInterviews);
        Actions actionchange = new Actions(driver);
        actionchange.moveToElement(sectionAdmin);
        Thread.sleep(2000);
        actionchange.moveToElement(subsectionInterviews).click();
        actionchange.perform();
        Thread.sleep(3000);
        driver.findElement(xpathInterviewsArchive).click();
        System.out.println("Go to section: Interviews Archive");
        Thread.sleep(2000);
        String InterviewsArchiveUrl = driver.getCurrentUrl();
        String InterviewsArchivePageName = driver.findElement(headingInterviewsPage).getText();
        Assert.assertEquals(InterviewsArchiveUrl, "https://ucso-test.opencode.su/votes/polls?type=ARCHIVE&blockView=false");
        Assert.assertEquals("Архив опросов не работает", InterviewsArchivePageName, "Архив");
    }
}
