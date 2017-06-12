package com.onemoretagger;

import com.mpatric.mp3agic.*;
import com.onemoretagger.utils.TrackUtils;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Will be removed after basic view implementation
 */
public class Program {
	private static final Path PATH_TO_TRACK =
			Paths.get(System.getProperty("user.home"), "tmp", "track.mp3");

	private static final Path PATH_TO_CHANGED_TRACK =
			Paths.get(System.getProperty("user.home"), "tmp", "changed_track.mp3");


	public static void main(String[] args) {
		Mp3File mp3file = null;
		try {
			mp3file = new Mp3File(PATH_TO_TRACK.toString());

			TrackUtils.printTrackInfo(mp3file);
			TrackUtils.printID3v1(mp3file);
			TrackUtils.printID3v2(mp3file);

			if (mp3file.hasId3v2Tag()) {
				System.out.println("\nTrying to change Comment Id3v2Tag and save to new file...");
				if (Files.deleteIfExists(PATH_TO_CHANGED_TRACK)) {
					System.out.println("Previously changed file found and deleted!");
				}

				System.out.println("Comment in current track: " + mp3file.getId3v2Tag().getComment());
				mp3file.getId3v2Tag().setComment(UUID.randomUUID().toString());

				try {
					mp3file.save(PATH_TO_CHANGED_TRACK.toString());
					System.out.println("Comment in new track: "
							+ new Mp3File(PATH_TO_CHANGED_TRACK.toString()).getId3v2Tag().getComment());
				} catch (NotSupportedException e) {
					System.out.println("Comment change failed!");
					e.printStackTrace();
				}
			}
		} catch (IOException | UnsupportedTagException | InvalidDataException e) {
			e.printStackTrace();
			//
		}
		FolderList();
	}

	public static void FolderList() {
		File fld = new File(PATH_TO_TRACK.toString());
		File parentFolder = new File (fld.getParent());

		String[] lst = parentFolder.list(new FilenameFilter() {

			@Override
			public boolean accept(File fld, String name) {
				return name.endsWith(".mp3");
			}
		});
		System.out.println("This files are in directory: ");
		for(String fileName: lst){
			System.out.println(fileName);
		}

	}
}




