package variables.admin;

public class Numbers {

    //Справочники
    public static int bankBIC = (int) (Math.random() * 899999999 + 100000000);
    public static int bankNmbLatitudeXX(){
    int bankNmbLatitudeXX = (int) (Math.random() * 6 + 49);
    return bankNmbLatitudeXX;}
    public static int bankNmbLatitudexx() {
    int bankNmbLatitudexx = (int) (Math.random() * 899999 + 100000);
    return bankNmbLatitudexx;}
    public static int bankNmbLatitudeYY() {
    int bankNmbLatitudeYY = (int) (Math.random() * 11 + 44);
    return bankNmbLatitudeYY;}
    public static int bankNmbLatitudeyy(){
    int bankNmbLatitudeyy = (int) (Math.random() * 899999 + 100000);
    return bankNmbLatitudeyy;}
    public static int nmbBranch = (int) (Math.random() *5 + 2);
    public static int nmbDesign = (int) (Math.random() *3 + 1);
    public static int codeDesign()
    { int codeDesign = (int) (Math.random() * 89999999 + 10000000);
        return codeDesign;}
    public static int nmbLocations = (int) (Math.random() *3 + 3);
    public static int nmbSocialCode = (int) (Math.random()*3 + 1);

    //Новости и Афиши
    public static int age = (int) (Math.random() * 98 + 1);
    public static int countImage;

    //Опросы
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
    public static int countQuestions;
    public static int countVariantsForCheck;

    //ТСП, Скидки, Акции
    public static int ogrnRndAdmin = (int) (Math.random()*100);
    public static long[] ogrnAdmin = {6147413876241L,8045324322024L,3080943190688L, 6077761483145L, 8137370898976L, 1158492827987L, 9049244850382L, 2024985052563L, 3118077701167L, 7092553350630L, 4165810263516L, 4104108260043L, 2062653499654L, 3083051238806L, 7011317857687L, 4058458598711L, 1141927856498L, 2057203338432L, 4025060315342L, 2116404254954L, 5164126127765L, 2160806481801L, 5032843827000L, 2057005485007L, 9159129097525L, 2154743165861L, 2012071621439L, 4124935157134L, 9013922757114L, 8116301972812L, 1165298995630L, 3071487333838L, 8051904728901L, 1055566256646L, 5022053161961L, 7070805764198L, 4058897758784L, 5135330432232L, 7144202407067L, 4014610377349L, 6106106653152L, 6064486171360L, 3091698887332L, 1094469347312L, 7155930346125L, 4168788508434L, 8033925979035L, 3089286323574L, 1160576967980L, 6048962522900L, 5037332454088L, 6115579671916L, 6068218105268L, 8166483387986L, 7083537372527L, 7133272382797L, 8141675956051L, 2143503420531L, 9152926388067L, 6043035638640L, 9012733405434L, 4113787448023L, 3060734599395L, 4040562190170L, 6049044973323L, 3104725897845L, 2152209209139L, 7122942714261L, 6125820526694L, 4146351228063L, 8164777557728L, 7114764557494L, 7135271083303L, 8094673201901L, 6146792269651L, 7121924813476L, 4084529668461L, 4105997910355L, 7157128593527L, 2112188456169L, 7070257157051L, 1113791570562L, 9070540698120L, 3132650663813L, 3148645011380L, 1136161378055L, 8067429660060L, 8082920416527L, 8044583537232L, 2127949927576L, 6062925019767L, 3012805440524L, 6030670087850L, 8117260695456L, 3056106999990L, 9027471526645L, 1126387412788L, 8116372538758L, 2037283885175L};
    public static long adminOGRN = ogrnAdmin[ogrnRndAdmin];
    public static int nmbRptForPromotionAdmin = (int) (Math.random() * 5 + 10 );
    public static int nmbAddressForPromotionAdmin = (int) (Math.random() * 8 + 1 );
    public static int nmbRptForDiscountAdmin = (int) (Math.random() * 5 + 10 );
    public static int nmbAddressForDiscountAdmin = (int) (Math.random() * 8 + 1 );
    public static int nmbDiscountAdmin = (int) (Math.random() * 98 + 1);

    //Руководства и регламенты

    //Настройки сайта
    public static int nmbColor = (int) (Math.random() * 9 + 1);

}
