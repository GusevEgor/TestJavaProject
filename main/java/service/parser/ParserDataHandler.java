package service.parser;

import dto.AllDataDto;
import org.jsoup.nodes.Document;

import java.util.List;

public interface ParserDataHandler {

    AllDataDto compute(List<Document> documents);

}
