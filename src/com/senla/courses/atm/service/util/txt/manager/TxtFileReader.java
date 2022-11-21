package com.senla.courses.atm.service.util.txt.manager;

import com.senla.courses.atm.service.exception.TxtFileReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TxtFileReader {

    private static final String DEFAULT_DELIMITER = " ";

    private TxtFileReader() {

    }

    public static List<List<String>> readDataFromFile(String pathToFile) {
        try {
            return Files.readAllLines(Paths.get(pathToFile))
                    .stream()
                    .map(fields -> fields.split(DEFAULT_DELIMITER))
                    .map(Arrays::asList)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new TxtFileReaderException(e);
        }
    }

    public static String readSimpleDataFromFile(String pathToFile) {
        try {
            return Files.readAllLines(Paths.get(pathToFile)).get(0);
        } catch (IOException e) {
            throw new TxtFileReaderException(e);
        }
    }

}
