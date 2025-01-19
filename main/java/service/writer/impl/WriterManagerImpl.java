package service.writer.impl;


import dto.AllDataDto;
import exception.WriterException;
import service.writer.WriterManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

public class WriterManagerImpl implements WriterManager {
    private static final Logger logger = Logger.getLogger(WriterManagerImpl.class.getName());

    @Override
    public void write(AllDataDto allDataDto) {
        DirectoryManagerImpl directoryManager = new DirectoryManagerImpl();
        String pathDirectory = directoryManager.getPathDirectory();

        directoryManager.createDirectory(Path.of(pathDirectory));

        try {
            allDataDto.getData().forEach((key, list) -> {
                String filePath = pathDirectory + File.separator + key + ".txt";
                List<String> content = list.stream().map(
                        x -> "Title: " + x.getTitle() + "\n" + "Count votes: "
                                + x.getCountVotes() + " URL: " + x.getContent() + "\n").toList();

                Path path = Path.of(filePath);
                wtireFile(path, content, directoryManager);
            });
        } catch (NullPointerException e) {
            logger.severe("Error while writing file");
            throw new WriterException(e.getMessage());
        }

    }

    private void wtireFile(Path path, List<String> content, DirectoryManagerImpl directoryManager) {
        try {
            directoryManager.createFile(path);
            Files.write(path, content);
            logger.info("Data was written to file " + path);
        } catch (IOException e) {
            logger.severe("Error while writing file");
            throw new WriterException(e.getMessage());
        }
    }
}
