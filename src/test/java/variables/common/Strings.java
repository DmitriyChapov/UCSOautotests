package variables.common;

import static variables.admin.Numbers.age;
import static variables.admin.Strings.newsText;
import static variables.admin.Strings.posterText;

public class Strings {
    public static String agePlus = age + "+";
    public static String fullPosterText = posterText.repeat(20).substring(0,posterText.repeat(20).length()-1);
    public static String fullNewsText = newsText.repeat(20).substring(0,newsText.repeat(20).length()-1);
}
