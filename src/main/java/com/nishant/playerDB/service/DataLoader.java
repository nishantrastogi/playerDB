package com.nishant.playerDB.service;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.nishant.playerDB.model.Player;
import com.nishant.playerDB.repository.PlayerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DataLoader {
    PlayerRepository playerRepository;
    private static final String PATH = "src/main/resources/static/data.csv";

    @Autowired
    public DataLoader(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void addPlayersToDb(File csvFile) throws Exception{
        CsvMapper mapper = new CsvMapper();
        mapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        CsvSchema schema = mapper.schemaFor(Player.class).withSkipFirstDataRow(true).withColumnSeparator(',');
        MappingIterator<Player> playerMappingIterator = mapper.readerFor(Player.class).with(schema).readValues(csvFile);

        while(playerMappingIterator.hasNext()){
            Player temp = playerMappingIterator.next();
            System.out.println(temp.toString());
            playerRepository.save(temp);
        }
    }

    @PostConstruct
    public void loadData(){
        File csvFile = new File(PATH);
        try {
            addPlayersToDb(csvFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
