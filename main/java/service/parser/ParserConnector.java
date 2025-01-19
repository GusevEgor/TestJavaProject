package service.parser;

import org.jsoup.nodes.Document;

public interface ParserConnector {
    Document getDocument(String url);
}
