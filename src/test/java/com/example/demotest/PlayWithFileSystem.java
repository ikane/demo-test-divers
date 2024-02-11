package com.example.demotest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PlayWithFileSystem {

	@Test
	public void test() throws IOException {

			final var key = buildFile("key");

			assertThat(key).isNotNull();

		log.info(key.getURL().getPath());

	}

	@Test
	public void testTempFile() throws IOException {

		final var tempFile = Files.createTempFile("hello", ".txt");


		assertThat(tempFile).isNotNull();

		log.info("Temp file: {}", tempFile);

	}

	@Test
	public void testFilePath() throws IOException {

		final var tempFile = Files.createTempFile("hello", ".txt");

		final var file = tempFile.toFile();

		assertThat(file).isNotNull();

		final var filePath = file.getPath();
		log.info("\nTemp file path: {}", filePath);
		log.info("\nTemp file path absolute: {}", file.getAbsolutePath());

		final var fileFromPath = Path.of(filePath).toFile();
		assertThat(fileFromPath).isNotNull();
		log.info("\nFile from path: {}", fileFromPath);

	}

	private static Resource buildFile(final String content) {
		final var fileName = "sftpPrivateKey";

		try(final var bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
			bufferedWriter.write(content);
			bufferedWriter.flush();
		} catch (IOException ioException) {
			log.error(format("An error occured during sftp file creation %s", ioException.getMessage()));
		}
		return new FileSystemResource(fileName);
	}
}
