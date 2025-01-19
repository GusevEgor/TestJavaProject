package service.parser.Impl;

import dto.AllDataDto;
import dto.DataDto;
import service.parser.ParserDataHandler;
import service.parser.PreciseParserDataHandler;
import org.jsoup.nodes.Document;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParserDataHandlerImpl implements ParserDataHandler {

    public AllDataDto compute(List<Document> documents) {
        Map<String, List<DataDto>> map = new HashMap<>();
        PreciseParserDataHandler preciseParserDataHandler = new PreciseParserDataHandlerImpl();

        documents.stream()
                .map(preciseParserDataHandler::preciseCompute)
                .toList()
                .forEach(x -> map.put(x.getFirst().getTopic(), x));

        return new AllDataDto(map);
    }
}
