package com.senla.courses.atm.service.util.txt.manager;

import com.senla.courses.atm.service.util.exception.TxtFileWriterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TxtFileWriter {

    private static final String DEFAULT_DELIMITER = " ";

    private TxtFileWriter() {

    }

    public static void writeDataToFile(String pathToFile, List<List<String>> data) {
        final List<String> convertedData = data
                .stream()
                .map(fields -> String.join(DEFAULT_DELIMITER, fields))
                .collect(Collectors.toList());

        try {
            Files.write(Paths.get(pathToFile), convertedData);
        } catch (IOException e) {
            throw new TxtFileWriterException(e);
        }
    }

}
