package com.redyhire.application.utils;

import com.redyhire.application.utils.file.FileNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static String read(String filePath) {
        Path path = Path.of(filePath);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            log.error("Error reading file at path: {}", path.toAbsolutePath());
            throw new FileNotFound("Could not read file at path: "+path.toAbsolutePath(), e);
        }
    }
}
