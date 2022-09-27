package com.knubisoft.tasks.algorithm.collection;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.file.PathUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.NotDirectoryException;
import java.nio.file.Paths;
import java.util.List;

public class FilesImpl implements Files {
    @Override
    public boolean contentEquals(File file1, File file2) throws IOException {
        if (!file1.isFile() || !file2.isFile()) {
            throw new IllegalArgumentException();
        }
        return PathUtils.fileContentEquals(file1.toPath(), file2.toPath());
    }

    @Override
    public void copyDirectoryToDirectory(File sourceDir, File destinationDir) throws IOException {
        if (sourceDir == null || destinationDir == null || !sourceDir.isDirectory() || !destinationDir.isDirectory()) {
            throw new IllegalArgumentException();
        }
        FileUtils.copyDirectoryToDirectory(sourceDir, destinationDir);
    }

    @SneakyThrows
    @Override
    public String toString(URL url, Charset encoding) throws IOException {
        if (url == null) {
            throw new IllegalArgumentException();
        }
        return FileUtils.readFileToString(new File(url.toURI()), encoding);
    }

    @Override
    public String toString(InputStream input, Charset charset) throws IOException {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        return IOUtils.toString(input, charset);
    }

    @SneakyThrows
    @Override
    public byte[] toByteArray(URL url) throws IOException {
        if (url == null) {
            throw new IllegalArgumentException();
        }
        return FileUtils.readFileToByteArray(new File(url.toURI()));
    }

    @Override
    public String normalize(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException();
        }
        return Paths.get(fileName).normalize().toString();
    }

    @Override
    public List<String> readLines(File file, Charset charset) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException();
        }
        return FileUtils.readLines(file, charset);
    }

    @SneakyThrows
    @Override
    public boolean isEmptyDirectory(File directory) {
        if (directory == null) {
            throw new IllegalArgumentException();
        }
        if (!directory.isDirectory()) {
            throw new NotDirectoryException(directory.getName());
        }
        return directory.list().length == 0;
    }
}
