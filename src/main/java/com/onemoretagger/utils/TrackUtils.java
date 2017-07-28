package com.onemoretagger.utils;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

public class TrackUtils {

	public static String getFullTrackInfo (Mp3File mp3file) {
		/* Метод для передачи всей информации о треке в виде строки.
		используется для вывода через сервлетgetFullT
		 */
		String trackInfo = "File name: " + mp3file.getFilename() + " seconds <br/>" +
				"Length: " + mp3file.getLengthInSeconds() + " seconds <br />" +
				"Bitrate: " + mp3file.getBitrate() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)") + "<br />" +
				"Sample rate: " + mp3file.getSampleRate() + " Hz <br />" +
				"Has ID3v1 tag?: " + (mp3file.hasId3v1Tag() ? "YES" : "NO") + "<br />" +
				"Has ID3v2 tag?: " + (mp3file.hasId3v2Tag() ? "YES" : "NO") + "<br />" +
				"Has custom tag?: " + (mp3file.hasCustomTag() ? "YES" : "NO") + "<br />";
		if (mp3file.hasId3v1Tag()) {
			ID3v1 id3v1Tag = mp3file.getId3v1Tag();
			trackInfo += "<br />--- ID3v1 ---" +
					"Track: " + id3v1Tag.getTrack() + "<br />" +
					"Artist: " + id3v1Tag.getArtist() + "<br />" +
					"Title: " + id3v1Tag.getTitle() + "<br />" +
					"Album: " + id3v1Tag.getAlbum() + "<br />" +
					"Year: " + id3v1Tag.getYear() + "<br />" +
					"Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")" + "<br />" +
					"Comment: " + id3v1Tag.getComment() + "<br />" +
					"--- ID3v1 ---<br />";
		}
		if (mp3file.hasId3v2Tag()) {
			ID3v2 id3v2Tag = mp3file.getId3v2Tag();
			trackInfo += "<br />--- ID3v2 ---" +
			"Track: " + id3v2Tag.getTrack() + "<br />" +
			"Artist: " + id3v2Tag.getArtist() + "<br />" +
			"Title: " + id3v2Tag.getTitle() + "<br />" +
			"Album: " + id3v2Tag.getAlbum() + "<br />" +
			"Year: " + id3v2Tag.getYear() + "<br />" +
			"Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")" + "<br />" +
			"Comment: " + id3v2Tag.getComment() + "<br />" +
			"Lyrics: " + id3v2Tag.getLyrics() + "<br />" +
			"Composer: " + id3v2Tag.getComposer() + "<br />" +
			"Publisher: " + id3v2Tag.getPublisher() + "<br />" +
			"Original artist: " + id3v2Tag.getOriginalArtist() + "<br />" +
			"Album artist: " + id3v2Tag.getAlbumArtist() + "<br />" +
			"Copyright: " + id3v2Tag.getCopyright() + "<br />" +
			"URL: " + id3v2Tag.getUrl() + "<br />" +
			"Encoder: " + id3v2Tag.getEncoder()+"<br />";
			byte[] albumImageData = id3v2Tag.getAlbumImage();
			if (albumImageData != null) {
				trackInfo += "Have album image data, length: " + albumImageData.length + " bytes" + "<br />" +
							"Album image mime type: " + id3v2Tag.getAlbumImageMimeType() + "<br />";
			}
			trackInfo += "--- ID3v2 ---<br />";
		}
		return trackInfo;
	}

	public static void printTrackInfo(Mp3File mp3file) {
		System.out.println("File name: " + mp3file.getFilename() + " seconds");
		System.out.println("Length: " + mp3file.getLengthInSeconds() + " seconds");
		System.out.println("Bitrate: " + mp3file.getBitrate() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)"));
		System.out.println("Sample rate: " + mp3file.getSampleRate() + " Hz");
		System.out.println("Has ID3v1 tag?: " + (mp3file.hasId3v1Tag() ? "YES" : "NO"));
		System.out.println("Has ID3v2 tag?: " + (mp3file.hasId3v2Tag() ? "YES" : "NO"));
		System.out.println("Has custom tag?: " + (mp3file.hasCustomTag() ? "YES" : "NO"));
	}

	public static void printID3v1(Mp3File mp3file) {
		if (mp3file.hasId3v1Tag()) {
			ID3v1 id3v1Tag = mp3file.getId3v1Tag();
			System.out.println("\n--- ID3v1 ---");
			System.out.println("Track: " + id3v1Tag.getTrack());
			System.out.println("Artist: " + id3v1Tag.getArtist());
			System.out.println("Title: " + id3v1Tag.getTitle());
			System.out.println("Album: " + id3v1Tag.getAlbum());
			System.out.println("Year: " + id3v1Tag.getYear());
			System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
			System.out.println("Comment: " + id3v1Tag.getComment());
			System.out.println("--- ID3v1 ---\n");
		}
	}

	public static void printID3v2(Mp3File mp3file) {
		if (mp3file.hasId3v2Tag()) {
			ID3v2 id3v2Tag = mp3file.getId3v2Tag();
			System.out.println("\n--- ID3v2 ---");
			System.out.println("Track: " + id3v2Tag.getTrack());
			System.out.println("Artist: " + id3v2Tag.getArtist());
			System.out.println("Title: " + id3v2Tag.getTitle());
			System.out.println("Album: " + id3v2Tag.getAlbum());
			System.out.println("Year: " + id3v2Tag.getYear());
			System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
			System.out.println("Comment: " + id3v2Tag.getComment());
			System.out.println("Lyrics: " + id3v2Tag.getLyrics());
			System.out.println("Composer: " + id3v2Tag.getComposer());
			System.out.println("Publisher: " + id3v2Tag.getPublisher());
			System.out.println("Original artist: " + id3v2Tag.getOriginalArtist());
			System.out.println("Album artist: " + id3v2Tag.getAlbumArtist());
			System.out.println("Copyright: " + id3v2Tag.getCopyright());
			System.out.println("URL: " + id3v2Tag.getUrl());
			System.out.println("Encoder: " + id3v2Tag.getEncoder());
			byte[] albumImageData = id3v2Tag.getAlbumImage();
			if (albumImageData != null) {
				System.out.println("Have album image data, length: " + albumImageData.length + " bytes");
				System.out.println("Album image mime type: " + id3v2Tag.getAlbumImageMimeType());
			}
			System.out.println("--- ID3v2 ---\n");
		}
	}
}
