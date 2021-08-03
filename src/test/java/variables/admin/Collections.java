package variables.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Collections {

    public static List<WebElement> documentList;
    public static List<WebElement> documentListCheck;

    //Опросы
    public static List<WebElement> questionOneVarVariants;
    public static ArrayList<String> questionOneVarVariantsNames = new ArrayList<>();
    public static List<WebElement> questionSomeVarVariants;
    public static ArrayList<String> questionSomeVarVariantsNames = new ArrayList<>();
    public static List<WebElement> questionDropDownVariants;
    public static ArrayList<String> questionDropDownVariantsNames = new ArrayList<>();
    public static List<WebElement> questionTypesWeb;
    public static ArrayList<String> questionTypes = new ArrayList<>();
    public static List<WebElement> questionNamesWeb;
    public static ArrayList<String> questionNames = new ArrayList<>();
    public static ArrayList<String> questionDescriptions = new ArrayList<>();
    public static List<WebElement> openedSurveyNamesNow;
    public static List<WebElement> openedSurveyDescriptionsNow;

}