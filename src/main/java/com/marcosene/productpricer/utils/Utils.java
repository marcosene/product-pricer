package com.marcosene.productpricer.utils;

import java.time.LocalDateTime;

public final class Utils {

    private Utils() {}

    public static LocalDateTime parseDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, Constants.DATE_TIME_FORMATTER);
    }
}
