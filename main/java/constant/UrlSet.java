package constant;

public class UrlSet {

    public static final String developUrl = "https://habr.com/ru/flows/develop/articles/";
    public static final String adminUrl = "https://habr.com/ru/flows/admin/articles/";
    public static final String designUrl = "https://habr.com/ru/flows/design/articles/";
    public static final String managementUrl = "https://habr.com/ru/flows/management/articles/";
    public static final String marketingUrl = "https://habr.com/ru/flows/marketing/articles/";
    public static final String popsciUrl = "https://habr.com/ru/flows/popsci/articles/";

    public static String getUrl(UrlEnum url) {
        return switch (url) {
            case developUrl -> UrlSet.developUrl;
            case adminUrl -> UrlSet.adminUrl;
            case designUrl -> UrlSet.designUrl;
            case managementUrl -> UrlSet.managementUrl;
            case marketingUrl -> UrlSet.marketingUrl;
            case popsciUrl -> UrlSet.popsciUrl;
        };
    }
}
