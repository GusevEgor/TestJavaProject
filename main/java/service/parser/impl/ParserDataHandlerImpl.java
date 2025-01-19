package service.parser.impl;

import dto.AllDataDto;
import dto.DataDto;
import service.parser.ParserDataHandler;
import service.parser.PreciseParserDataHandler;
import org.jsoup.nodes.Document;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class ParserDataHandlerImpl implements ParserDataHandler {

    private static final Logger logger = Logger.getLogger(ParserDataHandlerImpl.class.getName());


    public AllDataDto compute(List<Document> documents) {
        Map<String, List<DataDto>> map = new HashMap<>();
        PreciseParserDataHandler preciseParserDataHandler = new PreciseParserDataHandlerImpl();

        documents.stream()
                .map(preciseParserDataHandler::preciseCompute)
                .toList()
                .forEach(x -> map.put(x.getFirst().getTopic(), x));

        logger.info("Data received, count elements " + map.values().stream().map(List::size).toList().stream().mapToInt(x -> x).sum());
        return new AllDataDto(map);
    }
}
