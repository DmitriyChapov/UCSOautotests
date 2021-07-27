package login.user_portal.cabinetTSP;

import login.Login;
import login.main.tsp.TSPPage;
import static variables.portal.Numbers.*;
import static variables.admin.Xpath.*;
import static variables.portal.Xpath.*;
import static variables.portal.Selector.*;
import static variables.portal.Strings.*;
import static variables.portal.FilesForAdd.*;
import static variables.portal.Urls.*;
import static variables.common.Urls.*;

public class CreateTSP extends Login {

    TSPPage adminTSP = new TSPPage();

    public void openPartnersPage() throws InterruptedException {
        loginPortal();
        Thread.sleep(2000);
        driver.findElement(xpathPartner).click();
    }

    public void createTSPofUser() throws InterruptedException {
        driver.findElement(xpathPartnersAdd).click();
        driver.findElement(selectorUserTSPName).sendKeys(userTSPName);
        driver.findElement(selectorUserTSPDescription).sendKeys(userTSPDescription);
        driver.findElement(selectorUserTSPAddress).sendKeys(userTSPAddress);
        driver.findElement(selectorUserTSPLogo).sendKeys(imageTSPLogoPortal);
        driver.findElement(xpathConfirmButton).click();
        driver.findElement(selectorUserTSPOGRN).sendKeys(String.valueOf(portalOGRN));
        driver.findElement(selectorUserTSPEmail).sendKeys(email);
        driver.findElement(selectorUserTSPMSS_code).sendKeys(mss_code);
        Thread.sleep(1000);
        driver.findElement(xpathMSS_CodeConfirm).click();
        driver.findElement(selectorUserTSPWebPublic).sendKeys(tspSitePublic);
        driver.findElement(selectorUserTSPEmailPublic).sendKeys(userTSPEmailPublic);
        driver.findElement(selectorUserTSPPhonePublic).sendKeys(userTSPPhonePublic);
        driver.findElement(selectorUserTSPVK).sendKeys(urlVK);
        driver.findElement(selectorUserTSPFB).sendKeys(urlFacebook);
        driver.findElement(selectorUserTSPIG).sendKeys(urlInsatgram);
        driver.findElement(selectorUserTSPOK).sendKeys(urlOK);
        driver.findElement(selectorUserTSPAdditional).sendKeys(userTSPOptionalText.repeat(5));
        driver.findElement(xpathTSPSendButton).click();
    }



    public void tspUserAvailable() throws InterruptedException {
        adminTSP.openTSPCard(userTSPName);
        driver.findElement(xpathTSPAvailableSlide).click();
        Thread.sleep(1000);
        driver.findElement(xpathButtonSave).click();
        Thread.sleep(1000);
    }

    public void tspUserOpenCabinet() throws InterruptedException{
        driver.get(sitePortal);
        Thread.sleep(1000);
        driver.findElement(xpathPartner).click();
        driver.findElement(xpathPartnersOpen).click();
    }

    public void tspUserAddPromotion() throws InterruptedException {
        driver.findElement(selectorUserTSPButtonAddPromotion).click();
        driver.findElement(selectorUserTSPOfferName).sendKeys(userTSPPromotionName);
        driver.findElement(selectorUserTSPOfferFromDate).sendKeys(dateNow);
        driver.findElement(selectorUserTSPOfferToDate).sendKeys(dateNow);
        driver.findElement(selectorUserTSPOfferDescription).sendKeys(userTSPDescriptionAndConditionPromotion);
        driver.findElement(selectorUserTSPOfferImage).sendKeys(imagePromotionPortal);
        Thread.sleep(1000);
        driver.findElement(xpathConfirmButton).click();
        for (int i = 0; i < nmbAddressForPromotionPortal; i ++) {
            driver.findElement(TSPOfferAddress(i)).sendKeys("Адрес предоставления № " + (i+1));
            Thread.sleep(2000);
            if (i == (nmbAddressForPromotionPortal -1))
                break;
            else
            driver.findElement(xpathTSPUserAddress).click();
        }
        driver.findElement(selectorUserTSPOfferButtonSave).click();
    }

    public void tspUserAddDiscount() throws InterruptedException {
        driver.findElement(selectorUserTSPButtonAddDiscount).click();
        driver.findElement(selectorUserTSPOfferName).sendKeys(userTSPDiscountName);
        driver.findElement(selectorUserTSPOfferFromDate).sendKeys(dateNow);
        driver.findElement(selectorUserTSPOfferToDate).sendKeys(dateNow);
        driver.findElement(selectorUserTSPOfferDescription).sendKeys(userTSPDescriptionAndConditionDiscount);
        driver.findElement(selectorUserTSPOfferImage).sendKeys(imageDiscountPortal);
        Thread.sleep(1000);
        driver.findElement(xpathConfirmButton).click();
        for (int i = 0; i < nmbAddressForDiscountPortal; i ++) {
            driver.findElement(TSPOfferAddress(i)).sendKeys("Адрес предоставления № " + (i+1));
            Thread.sleep(2000);
            if (i == (nmbAddressForDiscountPortal -1))
                break;
            else
                driver.findElement(xpathTSPUserAddress).click();
        }
        driver.findElement(selectorUserTSPOfferDiscount).sendKeys(userTSPDiscount);
        driver.findElement(selectorUserTSPOfferButtonSave).click();
    }

}
