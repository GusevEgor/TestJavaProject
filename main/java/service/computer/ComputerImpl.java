package service.computer;

import dto.AllDataDto;
import dto.DataDto;
import exception.ComputerException;

import java.util.*;
import java.util.logging.Logger;

public class ComputerImpl implements Computer {

    private final Comparator<DataDto> comparator = (o1, o2) -> o2.getCountVotes().compareTo(o1.getCountVotes());
    private static final Logger logger = Logger.getLogger(ComputerImpl.class.getName());

    @Override
    public AllDataDto compute(AllDataDto data) {

        Map<String, List<DataDto>> map = new HashMap<>();

        try {
            data.getData().forEach((key, list) -> {
                List<DataDto> newList = new ArrayList<>(list);
                newList.sort(comparator);
                map.put(key, newList);
            });
        } catch (NullPointerException e) {
            logger.severe("Error computing" + e.getMessage());
            throw new ComputerException(e.getMessage());
        }

        return new AllDataDto(map);
    }
}
