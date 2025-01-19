package dto;

import java.util.List;
import java.util.Map;

public class AllDataDto {
    private Map<String, List<DataDto>> data; // <topic, <title, content>>

    public AllDataDto() {
        this.data = null;
    }

    public AllDataDto(Map<String, List<DataDto>> data) {
        this.data = data;
    }

    public Map<String, List<DataDto>> getData() {
        return data;
    }

    public void setData(Map<String, List<DataDto>> data) {
        this.data = data;
    }
}
