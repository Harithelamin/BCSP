package com.bcsp.project.converter;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 8/12/2018.
 */
public class StringConverter {

    //
    private String convertListToDelimitedString(List<String> list) {

        String result = "";
        if (list != null) {
            result = StringUtils.arrayToCommaDelimitedString(list.toArray());
        }
        return result;

    }
    private static List<String> convertDelimitedStringToList(String delimitedString) {

        List<String> result = new ArrayList<String>();

        if (!StringUtils.isEmpty(delimitedString)) {
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
        }
        return result;

    }
    //

}
