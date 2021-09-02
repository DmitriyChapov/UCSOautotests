package variables.admin;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static variables.admin.Numbers.countVariantsForCheck;

public class Collections {

    public static List<WebElement> documentList;
    public static List<WebElement> documentListCheck;

    //Новости и Афиши
    public static List<WebElement> newsList;
    public static List<WebElement> posterList;

    //Опросы
    public static List<WebElement> questionOneVarVariants;
    public static List<WebElement> questionVariantsNameForCheck;
    public static ArrayList<String> questionOneVarVariantsNames = new ArrayList<>();
    public static List<WebElement> questionSomeVarVariants;
    public static ArrayList<String> questionSomeVarVariantsNames = new ArrayList<>();
    public static List<WebElement> questionDropDownVariants;
    public static ArrayList<String> questionDropDownVariantsNames = new ArrayList<>();
    public static List<WebElement> questionTypesWeb;
    public static ArrayList<String> questionTypes = new ArrayList<>();
    public static List<WebElement> questionNamesWeb;
    public static ArrayList<String> questionNames = new ArrayList<>();
    public static ArrayList<String> questionComments = new ArrayList<>();
    public static List<WebElement> openedSurveyNamesNow;
    public static List<WebElement> openedSurveyDescriptionsNow;
    public static List<WebElement> interviewsList;
    public static List<WebElement> questionsList;
    public static ArrayList[] contentOfQuestion = new ArrayList[9];
    public static ArrayList[] contentOfQuestionForCheck = new ArrayList[9];
    public static ArrayList<String> questionNameForCheck = new ArrayList<>();
    public static ArrayList<String> questionCommentForCheck = new ArrayList<>();
    public static ArrayList<String> questionTypeForCheck = new ArrayList<>();
    public static ArrayList<String> questionValidationForCheck = new ArrayList<>();
    public static ArrayList<String> questionMaxSymbolForCheck = new ArrayList<>();
    public static ArrayList<String> questionAnswerForCheck = new ArrayList<>();
    public static ArrayList<String> questionScaleForCheck = new ArrayList<>();
    public static ArrayList<String> questionFilesTypeForCheck = new ArrayList<>();
    public static ArrayList<String> questionNmbFilesForCheck = new ArrayList<>();
    public static ArrayList<String> questionNameArr = new ArrayList<>();
    public static ArrayList<String> questionCommentArr = new ArrayList<>();
    public static ArrayList<String> questionTypeArr = new ArrayList<>();
    public static ArrayList<String> questionValidationArr = new ArrayList<>();
    public static ArrayList<String> questionMaxSymbolArr = new ArrayList<>();
    public static ArrayList<ArrayList<String>> questionAnswerArr = new ArrayList<>();
    public static ArrayList<String> questionScaleArr = new ArrayList<>();
    public static ArrayList<String> questionFilesTypeArr = new ArrayList<>();
    public static ArrayList<String> questionNmbFilesArr = new ArrayList<>();
    public static ArrayList<String> questionAllNames = new ArrayList<>();

    //ТСП
    public static List<WebElement> chosenAddressForPromotion;
    public static List<WebElement> chosenAddressForDiscount;
    public static List<WebElement> promotionsList;

    public static List<WebElement> datepicker;
    public static List<WebElement> timepicker;
}