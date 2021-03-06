package variables.admin;

public class FilesForAdd {

    //Справочники
    public static String imageDesignName(int i)
    { String imageDesignName = "C:\\Image for AutoTest\\BankDesign\\Design" + (i + 1) + ".png";
        return imageDesignName;}

    //Новости и Афиши
    public static String imageNewsPrev = "C:\\Image for AutoTest\\News prev.png";
    public static String imageNewsGallery(int i)
    { String imageNewsGallery = "C:\\Image for AutoTest\\News gallery" + (i + 1) + ".jpg";
        return imageNewsGallery;}
    public static String imagePosterPrev = "C:\\Image for AutoTest\\Afisha prev.jpg";
    public static String imagePosterMain = "C:\\Image for AutoTest\\Afisha main.jpg";
    public static String imagePosterGallery(int i)
    { String imageNewsGallery = "C:\\Image for AutoTest\\Afisha gallery " + (i + 1) + ".png";
        return imageNewsGallery;}

    //Опросы
    public static String imageQuestionShortNumber = "C:\\Image for AutoTest\\Questions\\Number.jpg";
    public static String imageQuestionShortDouble = "C:\\Image for AutoTest\\Questions\\Double.jpg";
    public static String imageQuestionShortPhone = "C:\\Image for AutoTest\\Questions\\Phone.jpg";
    public static String imageQuestionShortSymbol = "C:\\Image for AutoTest\\Questions\\Symbol.jpg";
    public static String imageQuestionShortNoValid = "C:\\Image for AutoTest\\Questions\\NoValid.jpg";
    public static String imageQuestionLong = "C:\\Image for AutoTest\\Questions\\Long.jpg";
    public static String imageQuestionVarName(int i)
    { String imageQuestionVarName = "C:\\Image for AutoTest\\Questions\\Options\\Option" + (i + 1) + ".jpg";
        return imageQuestionVarName;}
    public static String imageQuestionDropDown = "C:\\Image for AutoTest\\Questions\\DropDown.jpg";
    public static String imageQuestionScale = "C:\\Image for AutoTest\\Questions\\Scale.jpg";
    public static String imageQuestionDownloadJPEG = "C:\\Image for AutoTest\\Questions\\JPEG.png";
    public static String imageQuestionDownloadPNG = "C:\\Image for AutoTest\\Questions\\PNG.jpg";
    public static String imageQuestionDownloadPDF = "C:\\Image for AutoTest\\Questions\\PDF.jpg";
    public static String imageQuestionDownloadDOC = "C:\\Image for AutoTest\\Questions\\DOC.jpg";
    public static String imageQuestionDownloadXLS = "C:\\Image for AutoTest\\Questions\\XLS.jpg";
    public static String imageQuestionDownloadALL = "C:\\Image for AutoTest\\Questions\\AllFILES.jpg";
    public static String imageQuestionText ="C:\\Image for AutoTest\\Questions\\Text.png";

    //ТСП, Скидки, Акции
    public static String imageTSPLogoAdmin = "C:\\Image for AutoTest\\TSPAdmin.jpg";
    public static String imagePromotionAdmin = "C:\\Image for AutoTest\\PromotionAdmin.png";
    public static String imageDiscountAdmin = "C:\\Image for AutoTest\\DiscountAdmin.jpg";

    //Руководства и регламенты
    public static String fileDocument = "C:\\Image for AutoTest\\Files\\AutoTest.pdf";

    //Настройки сайта
    public static String imageBanner = "C:\\Image for AutoTest\\Banner.png";
    public static String imageLogo = "C:\\Image for AutoTest\\Logo.svg";

}
