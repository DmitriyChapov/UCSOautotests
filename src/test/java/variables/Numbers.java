package variables;

public class Numbers {
    public static int nmbAutoTest = (int) (Math.random() * 8999 + 1000);
    public static int bankBIC = (int) (Math.random() * 899999999 + 100000000);
    public static int nmbBranch = (int) (Math.random() *5 + 2);
    public static int nmbDesign = (int) (Math.random() *3 + 1);
    public static int codeDesign()
    { int codeDesign = (int) (Math.random() * 89999999 + 10000000);
        return codeDesign;}
    public static int nmbLocations = (int) (Math.random() *3 + 3);
    public static int nmbSocialCode = (int) (Math.random()*3 + 1);
    public static int age = (int) (Math.random() * 98 + 1);
    public static int maxSymbolShortNumber = (int) (Math.random() * 239 + 1);
    public static int maxSymbolShortDouble = (int) (Math.random() * 239 + 1);
    public static int maxSymbolShortSymbol = (int) (Math.random() * 239 + 1);
    public static int maxSymbolShortNoValid = (int) (Math.random() * 239 + 1);
    public static int maxSymbolLong = (int) (Math.random() * 239 + 1);
    public static int nmbOneVar = (int) (Math.random() *4 + 2);
    public static int nmbSomeVar = (int) (Math.random() *4 + 2);
    public static int nmbDropDown = (int) (Math.random() *4 + 2);
    public static int rndScale = (int) (Math.random()*2 + 1);
    public static int maxFilesJPEG = 2;
    public static int maxFilesPNG = 1;
    public static int maxFilesPDF = 1;
    public static int maxFilesDOC = 4;
    public static int maxFilesXLS = 2;
    public static int maxFilesALL = (int) (Math.random()*4 + 3);
    public static int ogrnrnd = (int) (Math.random()*100);
    public static int nmbRptForPromotion = (int) (Math.random() * 5 + 10 );
    public static int nmbAddressForPromotion = (int) (Math.random() * 8 + 1 );
    public static int nmbRptForDiscount = (int) (Math.random() * 5 + 10 );
    public static int nmbAddressForDiscount = (int) (Math.random() * 8 + 1 );
    public static int nmbDiscount = (int) (Math.random() * 98 + 1);
    public static int nmbColor = (int) (Math.random() * 9 + 1);
}
