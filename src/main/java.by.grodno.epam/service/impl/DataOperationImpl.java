package service.impl;

import lombok.extern.slf4j.Slf4j;
import service.DataOperation;

import java.io.*;
import java.util.Objects;

@Slf4j
public class DataOperationImpl implements DataOperation {
@Override
    public final String readFile(String file) {
        log.info("IN readFromFile");
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String paths = Objects.requireNonNull(classLoader.getResource(file)).getPath();
            reader = new BufferedReader(new FileReader(paths));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            log.info("Reading finished");
        } catch (IOException e) {
            log.error("Error reading file");
        }
        return stringBuilder.toString();
    }
}