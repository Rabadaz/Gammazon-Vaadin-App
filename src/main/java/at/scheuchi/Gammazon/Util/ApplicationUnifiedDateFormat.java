package at.scheuchi.Gammazon.Util;

import lombok.Getter;

import java.text.SimpleDateFormat;

public class ApplicationUnifiedDateFormat {
    private static ApplicationUnifiedDateFormat _instance = new ApplicationUnifiedDateFormat();

    public static ApplicationUnifiedDateFormat getInstance() {
        return _instance;
    }
    @Getter
    private final  SimpleDateFormat primaryDateFormat = new SimpleDateFormat("dd.MM.yyyy");



}
