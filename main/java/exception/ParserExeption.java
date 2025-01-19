package exception;

public class ParserExeption extends RuntimeException{

    public ParserExeption(String message) {
        super("Error while parsing: " + message);
    }
}
