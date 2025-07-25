package com.uqai.capacitacion.utils;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
public final class FileUtils {


    private FileUtils() {
    }

    public static String getRepositoryFileName(String path, String fileName) {
        Path repositoryFile = Paths.get(path);
        if (!Files.isDirectory(repositoryFile)) {
            return "";
        }
        try (Stream<Path> files = Files.list(repositoryFile)) {
            return files
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(file -> compareFiles(fileName, file))
                    .findFirst()
                    .orElse("");
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        }
    }

    public static String getExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return fileName.substring(dotIndex + 1);
    }

    public static String getFileName(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return fileName.substring(0, dotIndex);
    }

    public static boolean compareFiles(String fileName, String compareFile) {
        return Objects.equals(getFileName(fileName), getFileName(compareFile)) &&
                getExtension(fileName).equalsIgnoreCase(getExtension(compareFile));

    }


}
