package dto;

public class DataDto {
    private String topic;
    private String title;
    private Integer countVotes;
    private String content;


    public DataDto(String topic, String title, Integer countVotes, String content) {
        this.topic = topic;
        this.title = title;
        this.countVotes = countVotes;
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCountVotes() {
        return countVotes;
    }

    public void setCountVotes(Integer countVotes) {
        this.countVotes = countVotes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
