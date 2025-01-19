package service.computer;

import dto.AllDataDto;
import dto.DataDto;

import java.util.*;

public class ComputerImpl implements Computer {

    private final Comparator<DataDto> comparator = (o1, o2) -> o2.getCountVotes().compareTo(o1.getCountVotes());

    @Override
    public AllDataDto compute(AllDataDto data) {

        Map<String, List<DataDto>> map = new HashMap<>();

        data.getData().forEach((key, list) -> {
            List<DataDto> newList = new ArrayList<>(list);
            newList.sort(comparator);
            map.put(key, newList);
        });

        return new AllDataDto(map);
    }
}
