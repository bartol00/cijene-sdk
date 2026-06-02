package com.cijene.sdk.helpers;

import java.util.List;

public class StringHelper {

    public static String getQueryParamFromList(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : list) {
            stringBuilder.append(element).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

}
