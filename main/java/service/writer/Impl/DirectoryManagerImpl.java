package service.writer.Impl;

import exception.WriterException;
import service.writer.DirectoryManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.logging.Logger;

public class DirectoryManagerImpl implements DirectoryManager {
    private static final Logger logger = Logger.getLogger(DirectoryManagerImpl.class.getName());
    private final String pathDirectory = "files";

    @Override
    public String getPathDirectory() {
        return pathDirectory;
    }

    @Override
    public void createFile(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                logger.severe("Error while creating file");
                throw new WriterException(e.getMessage());
            }
        }
    }

    @Override
    public void createDirectory(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (Exception e) {
                logger.severe("Error while creating directory");
                throw new WriterException(e.getMessage());
            }
        } else {
            for (String file : Objects.requireNonNull(path.toFile().list())) {
                Path pathFile = Path.of(pathDirectory + File.separator + file);
                try {
                    Files.delete(pathFile);
                } catch (Exception e) {
                    logger.severe("Error while deleting file");
                    throw new WriterException(e.getMessage());
                }
            }

            Path pathDirectory = Path.of(this.pathDirectory);
            try {
                Files.delete(pathDirectory);
            } catch (Exception e) {
                logger.severe("Error while deleting directory");
                throw new WriterException(e.getMessage());
            }

            createDirectory(path);
        }
    }
}
