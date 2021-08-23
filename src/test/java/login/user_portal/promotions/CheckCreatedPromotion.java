package login.user_portal.promotions;

import login.main.tsp.TSPPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static variables.admin.Numbers.nmbRptForPromotionAdmin;
import static variables.common.Urls.*;
import static variables.portal.Xpath.*;
import static variables.portal.Collections.*;
import static variables.admin.Strings.*;
import static variables.portal.Strings.*;

public class CheckCreatedPromotion extends TSPPage {

    public void openDiscountsAndPromotions() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpathToPromotionsAndDiscounts)));
        driver.findElement(xpathToPromotionsAndDiscounts).click();
    }

    public void openPromotions() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpathToPromotions)));
        driver.findElement(xpathToPromotions).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathAllPromotions));
        allPromotions = driver.findElements(xpathAllPromotions);
        allPromotionsMainSNames = driver.findElements(xpathAllPromotionsMainSNames);
        allPromotionsMainSCorp = driver.findElements(xpathAllPromotionsMainSCorp);

    }

    public void findCreatedPromotion() {
        for (int i = 0; i < allPromotions.size(); i++) {
            String tempID = allPromotions.get(i).getAttribute("href");
            int slash = tempID.lastIndexOf("/");
            String userPromotionID = tempID.substring(slash + 1, tempID.length());

            if (userPromotionID.equals(promotionID)) {
                Assert.assertEquals("Не совпадает название акции в основном разделе 'Акции'", promotionName, allPromotionsMainSNames.get(i).getText());
                Assert.assertEquals("Не совпадает организация в основном разделе 'Акции'", adminTSPName, allPromotionsMainSCorp.get(i).getText());

                allPromotions.get(i).click();
                break;
            }
        }
    }

    public void checkOpenedPromotion() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathAllPromotionElements));

        Assert.assertEquals("Не совпадает наименование открытой акции", promotionName, driver.findElement(xpathOpenedPromotionHeading).getText());
        Assert.assertEquals("Не совпадает название компании в открытой акции", adminTSPName, driver.findElement(xpathOpenedPromotionCorporation).getText());
        Assert.assertEquals("Не  совпадает ссылка на сайт компании в открытой акции", tspSitePublic, driver.findElement(xpathOpenedPromotionCorpWebsite).getAttribute("href"));
        Assert.assertEquals("Не совпадает email компании в открытой акции", adminTSPEmailPublic, driver.findElement(xpathOpenedPromotionEmailCorp).getText());
        Assert.assertEquals("Не совпадает номер телефона компании в открытой акции", tspPhone, driver.findElement(xpathOpenedPromotionPhoneCorp).getText());

        int colon = driver.findElement(xpathOpenedPromotionDate).getText().lastIndexOf(":");
        String discountDateNow = driver.findElement(xpathOpenedPromotionDate).getText().substring(colon + 2, driver.findElement(xpathOpenedPromotionDate).getText().length());
        Assert.assertEquals("Не совпадает период действия скидки в открытой скидки", convertDate, discountDateNow);

        Assert.assertEquals("Не совпадает дополнительная информация компании по компании в открытой акции", adminTSPOptionalText, driver.findElement(xpathOpenedPromotionAdditionalInfo).getText());
        Assert.assertEquals("Не совпадает ссылка на соц. сеть 'ВК' в открытой акции", urlVK, driver.findElement(xpathOpenedPromotionCorpVk).getAttribute("href"));
        Assert.assertEquals("Не совпадает ссылка на соц. сеть 'Facebook' в открытой акции", urlFacebook, driver.findElement(xpathOpenedPromotionCorpFacebook).getAttribute("href"));
        Assert.assertEquals("Не совпадает ссылка на соц. сеть 'Instagram' в открытой акции", urlInsatgram, driver.findElement(xpathOpenedPromotionCorpInst).getAttribute("href"));
        Assert.assertEquals("Не совпадает ссылка на соц. сеть 'Одноклассники' в открытой акции", urlOK, driver.findElement(xpathOpenedPromotionCorpOdnkl).getAttribute("href"));
        Assert.assertEquals("Не совпадают условия акции в открытой акции", descriptionAndConditionPromotion.repeat(nmbRptForPromotionAdmin), driver.findElement(xpathOpenedPromotionConditions).getText());

    }

}
