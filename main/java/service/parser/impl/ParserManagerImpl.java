package service.parser.impl;

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
        urlsMap.put("developUrl", "https://habr.com/ru/flows/develop/articles/");
        urlsMap.put("adminUrl", "https://habr.com/ru/flows/admin/articles/");
        urlsMap.put("designUrl", "https://habr.com/ru/flows/design/articles/");
        urlsMap.put("managementUrl", "https://habr.com/ru/flows/management/articles/");
        urlsMap.put("marketingUrl", "https://habr.com/ru/flows/marketing/articles/");
        urlsMap.put("popsciUrl", "https://habr.com/ru/flows/popsci/articles/");
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
