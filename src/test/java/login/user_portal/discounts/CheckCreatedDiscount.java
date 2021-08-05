package login.user_portal.discounts;

import jdk.jshell.spi.ExecutionControlProvider;
import login.main.tsp.TSPPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static variables.admin.Numbers.*;
import static variables.common.Urls.*;
import static variables.portal.Collections.*;
import static variables.portal.Strings.tspPhone;
import static variables.portal.Xpath.*;
import static variables.admin.Strings.*;

public class CheckCreatedDiscount extends TSPPage {

    public void openDiscountsAndPromotions() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpathToPromotionsAndDiscounts)));
        driver.findElement(xpathToPromotionsAndDiscounts).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathMainSDiscounts));
        allDiscounts = driver.findElements(xpathMainSDiscounts);
        allDiscountPercentages = driver.findElements(xpathMainSDiscountPercentage);
        allDiscountMainSNames = driver.findElements(xpathMainSDiscountName);
        allDiscountMainSCorp = driver.findElements(xpathMainSDiscountCorp);
    }

    public void findCreatedDiscount() {
        for (int i = 0; i < allDiscounts.size(); i++) {
            int slash = allDiscounts.get(i).getAttribute("href").lastIndexOf("/");
            String userDiscountID = allDiscounts.get(i).getAttribute("href").substring(slash + 1, allDiscounts.get(i).getAttribute("href").length());

            if (userDiscountID.equals(discountID)) {
                if (discountName.length() > 34) {
                    Assert.assertEquals("Не совпадает название созданной скидки в общем разделе 'Скидки'", discountName.substring(0, 34), allDiscountMainSNames.get(i).getText().substring(0, 34));
                } else {
                    Assert.assertEquals("Не совпадает название созданной скидки в общем разделе 'Скидки'", discountName, allDiscountMainSNames.get(i).getText());
                }
                Assert.assertEquals("Не совпадает название организации у созданной скидки в общем разделе 'Скидки'", adminTSPName, allDiscountMainSCorp.get(i).getText());
                Assert.assertEquals("Не совпадает процент скидки в обшем разделе 'Скидки'", discount, allDiscountPercentages.get(i).getText());
                allDiscounts.get(i).click();
                break;
            }
        }
    }

    public void checkOpenedDiscount() throws ParseException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathAllDiscountElements));

        Assert.assertEquals("Не совпадает наименование открытой скидки", discountName, driver.findElement(xpathOpenedDiscountHeading).getText());
        Assert.assertEquals("Не совпадает название компании в открытой скидке", adminTSPName, driver.findElement(xpathOpenedDiscountCorporation).getText());
        Assert.assertEquals("Не совпадет размер скидки в открытой скидке", discount, driver.findElement(xpathOpenedDiscountPercentage).getText());
        Assert.assertEquals("Не  совпадает ссылка на сайт компании в открытой скидке", tspSitePublic, driver.findElement(xpathOpenedDiscountCorpWebsite).getAttribute("href"));
        Assert.assertEquals("Не совпадает email компании в открытой скидке", adminTSPEmailPublic, driver.findElement(xpathOpenedDiscountEmailCorp).getText());
        Assert.assertEquals("Не совпадает номер телефона компании в открытой скидке", tspPhone, driver.findElement(xpathOpenedDiscountPhoneCorp).getText());

        int colon = driver.findElement(xpathOpenedDiscountDate).getText().lastIndexOf(":");
        String discountDateNow = driver.findElement(xpathOpenedDiscountDate).getText().substring(colon + 2, driver.findElement(xpathOpenedDiscountDate).getText().length());
        Assert.assertEquals("Не совпадает период действия скидки в открытой скидки", convertDate(dateNow), discountDateNow);

        Assert.assertEquals("Не совпадает дополнительная информация компании по компании в открытой скидке", adminTSPOptionalText, driver.findElement(xpathOpenedDiscountAdditionalInfo).getText());
        Assert.assertEquals("Не совпадает ссылка на соц. сеть 'ВК' в открытой скидке", urlVK, driver.findElement(xpathOpenedDiscountCorpVk).getAttribute("href"));
        Assert.assertEquals("Не совпадает ссылка на соц. сеть 'Facebook' в открытой скидке", urlFacebook, driver.findElement(xpathOpenedDiscountCorpFacebook).getAttribute("href"));
        Assert.assertEquals("Не совпадает ссылка на соц. сеть 'Instagram' в открытой скидке", urlInsatgram, driver.findElement(xpathOpenedDiscountCorpInst).getAttribute("href"));
        Assert.assertEquals("Не совпадает ссылка на соц. сеть 'Одноклассники' в открытой скидке", urlOK, driver.findElement(xpathOpenedDiscountCorpOdnkl).getAttribute("href"));
        //Repeat (optional)
        Assert.assertEquals("Не совпадают условия акции в открытой скидке", descriptionAndConditionDiscount.repeat(nmbRptForDiscountAdmin), driver.findElement(xpathOpenedDiscountConditions).getText());
    }


    public String convertDate(String dateOldString) throws ParseException {
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());

        Date date = oldDateFormat.parse(dateOldString);
        String result = newDateFormat.format(date);

        return result;
    }

}
