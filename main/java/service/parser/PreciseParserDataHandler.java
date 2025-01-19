package service.parser;

import dto.DataDto;
import org.jsoup.nodes.Document;

import java.util.List;

public interface PreciseParserDataHandler {

    List<DataDto> preciseCompute(Document document);
}
