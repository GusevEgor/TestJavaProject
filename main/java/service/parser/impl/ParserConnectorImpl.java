package service.parser.impl;

import exception.ParserExeption;
import org.jsoup.Connection;
import service.parser.ParserConnector;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.logging.Logger;


public class ParserConnectorImpl implements ParserConnector {

    private final Logger logger = Logger.getLogger(ParserConnectorImpl.class.getName());


    @Override
    public Document getDocument(String url) {
        Document document;
        Connection connection = getConnection(url);

        try {
            document = connection.get();
        } catch (IOException e) {
            logger.severe("Error while getting document" + e.getMessage());
            throw new ParserExeption(e.getMessage());
        }
        return document;
    }

    private Connection getConnection(String url) {
        Connection connection;
        try {
            connection = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");

        } catch (NullPointerException e) {
            logger.severe("Error connection" + e.getMessage());
            throw new ParserExeption(e.getMessage());
        }

        return connection;
    }
}
