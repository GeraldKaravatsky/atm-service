package com.senla.courses.atm.service.util.database;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataBaseUtil {

    public static<T> List<T> getListFromData(Class<T> classType, List<List<String>> data) {
        return data.stream().map(fields -> getObjectFromData(classType, fields)).collect(Collectors.toList());
    }

    public static List<List<String>> getDataFromList(List<?> list) {
        return list.stream().map(DataBaseUtil::getFieldListFromObject).collect(Collectors.toList());
    }

    private static<T> T getObjectFromData(Class<T> classType, List<String> fields) {
        try {
            return classType.getConstructor(classType).newInstance(fields.toArray());
        } catch (InstantiationException | IllegalAccessException |  InvocationTargetException | NoSuchMethodException e) {
            return null;
        }
    }

    private static List<String> getFieldListFromObject(Object object) {
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
