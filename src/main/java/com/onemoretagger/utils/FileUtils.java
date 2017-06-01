package com.onemoretagger.utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Set of utilities to work with files
 */
public class FileUtils {

	static void listFilesInDirectory(Path path) throws IOException {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
			for (Path entry : stream) {
				System.out.println(entry);
			}
		}
	}

	static void collectFiles(Path path, List<Path> files) throws IOException {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
			for (Path entry : stream) {
				if (Files.isDirectory(entry)) {
					collectFiles(entry, files);
				}
				files.add(entry);
			}
		}
	}

}
