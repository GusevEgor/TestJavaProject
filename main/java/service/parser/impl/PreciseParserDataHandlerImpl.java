package service.parser.impl;

import dto.DataDto;
import exception.ParserExeption;
import service.parser.PreciseParserDataHandler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.logging.Logger;

public class PreciseParserDataHandlerImpl implements PreciseParserDataHandler {
    private final Logger logger = Logger.getLogger(PreciseParserDataHandlerImpl.class.getName());


    public List<DataDto> preciseCompute(Document document) {
        String sectionTitle = getTitle(document);
        Elements elements = document.select(".tm-articles-list__item");

        return elements.stream().map(x -> preciseElementCompute(x, sectionTitle)).toList();

    }

    private DataDto preciseElementCompute(Element element, String sectionTitle) {
        String title = element.select("h2").text();

        String urlPage = "https://habr.com" + element.select(".tm-article-snippet__readmore").attr("href");

        Integer countVotesInt = 0;

        try {
            String countVotes = element.selectFirst(".tm-articles-list__item-footer span").text();
            countVotesInt = !countVotes.isEmpty() ? Integer.parseInt(countVotes) : 0;
        } catch (NullPointerException e) {
            logger.warning("Error while getting count votes: " + e.getMessage());
        }

        return new DataDto(sectionTitle, title, countVotesInt, urlPage);
    }

    private String getTitle(Document document) {

        try {
            Element mainElement = document.selectFirst(".tm-layout__container");
            return mainElement.select(".tm-section-name__text").text();
        } catch (NullPointerException e) {
            logger.severe("Error while getting title");
            throw new ParserExeption(e.getMessage());
        }
    }
}
