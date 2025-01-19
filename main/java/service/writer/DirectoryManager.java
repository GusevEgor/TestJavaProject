package service.writer;

import java.nio.file.Path;

public interface DirectoryManager {

    String getPathDirectory();

    void createFile(Path path);
    void createDirectory(Path path);
}
