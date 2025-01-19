import exception.ComputerException;
import exception.ParserExeption;
import exception.WriterException;
import service.computer.Computer;
import service.computer.ComputerImpl;
import dto.AllDataDto;
import service.parser.ParserManager;
import service.parser.impl.ParserManagerImpl;
import service.writer.WriterManager;
import service.writer.impl.WriterManagerImpl;

import java.util.logging.Logger;

public class MainManager {
    private static final Logger logger = Logger.getLogger(MainManager.class.getName());

    public static void start() {

        logger.info("Start program");

        ParserManager parserManager = new ParserManagerImpl();
        Computer computer = new ComputerImpl();
        WriterManager writerManager = new WriterManagerImpl();

        AllDataDto allDataDto = new AllDataDto();

        logger.info("Start parsing");
        try {
            allDataDto = parserManager.start();
        } catch (ParserExeption e) {
            logger.severe("Error while parsing" + e.getMessage());
        }

        logger.info("Start processing");
        try {
            allDataDto = computer.compute(allDataDto);
        } catch (ComputerException e) {
            logger.severe("Error while processing" + e.getMessage());
        }

        logger.info("Start writing");
        try {
            writerManager.write(allDataDto);
        } catch (WriterException e) {
            logger.severe("Error while writing" + e.getMessage());
        }

        logger.info("End program");

    }
}
