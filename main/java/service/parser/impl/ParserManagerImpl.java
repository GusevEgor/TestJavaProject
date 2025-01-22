package service.parser.impl;

import constant.UrlEnum;
import constant.UrlSet;
import dto.AllDataDto;
import service.parser.ParserConnector;
import service.parser.ParserDataHandler;
import service.parser.ParserManager;
import org.jsoup.nodes.Document;

import java.util.*;
import java.util.logging.Logger;


public class ParserManagerImpl implements ParserManager {

    private final Map<String, String> urlsMap = new HashMap<>();

    public ParserManagerImpl() {
        Arrays.stream(UrlEnum.values())
                .forEach(x -> urlsMap.put(x.name(), UrlSet.getUrl(x)));
    }

    @Override
    public AllDataDto start() {
        List<Document> documents = getDocuments(new ParserConnectorImpl());

        return getAllDataDto(documents, new ParserDataHandlerImpl());

    }

    private List<Document> getDocuments(ParserConnector parserConnector) {

        return urlsMap.values().stream()
                .map(parserConnector::getDocument
                ).filter(Objects::nonNull).toList();
    }

    private AllDataDto getAllDataDto(List<Document> documents, ParserDataHandler parserDataHandler) {

        return parserDataHandler.compute(documents);
    }
}
