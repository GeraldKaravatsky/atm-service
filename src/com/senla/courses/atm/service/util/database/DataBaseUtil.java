package com.senla.courses.atm.service.util.database;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataBaseUtil {

    public static List<List<String>> getDataFromList(List<?> list) {
        List<List<String>> data = new ArrayList<>();

        data.add(getFieldsNames(list));
        list.forEach(object -> data.add(getFieldsFromObject(object)));

        return data;
    }

    private static List<String> getFieldsNames(List<?> list) {
        return Arrays.stream(list.get(0).getClass().getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    private static List<String> getFieldsFromObject(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .peek(field -> field.setAccessible(true))
                .map(field -> getStringValueFromField(field, object))
                .collect(Collectors.toList());
    }

    private static String getStringValueFromField(Field field, Object object) {
        try {
            return String.valueOf(field.get(object));
        } catch (IllegalAccessException e) {
            return null;
        }
    }

}
