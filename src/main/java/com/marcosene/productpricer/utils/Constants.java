package com.marcosene.productpricer.utils;

import java.time.format.DateTimeFormatter;

public final class Constants {

    private Constants() {}

    public static String DATE_TIME_FORMAT = "yyyy-MM-dd-HH.mm.ss";

    public static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

}
