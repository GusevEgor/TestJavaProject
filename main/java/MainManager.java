import service.computer.Computer;
import service.computer.ComputerImpl;
import dto.AllDataDto;
import service.parser.ParserManager;
import service.parser.Impl.ParserManagerImpl;
import service.writer.WriterManager;
import service.writer.Impl.WriterManagerImpl;

import java.util.logging.Logger;

public class MainManager {
    private static final Logger logger = Logger.getLogger(MainManager.class.getName());

    public static void start() {

        logger.info("Start program");

        ParserManager parserManager = new ParserManagerImpl();
        Computer computer = new ComputerImpl();
        WriterManager writerManager = new WriterManagerImpl();

        logger.info("Start parsing");
        AllDataDto allDataDto = parserManager.start();

        logger.info("Start processing");
        AllDataDto allDataDtoAfterProcessing = computer.compute(allDataDto);

        logger.info("Start writing");
        writerManager.write(allDataDtoAfterProcessing);

        logger.info("End program");

    }
}
