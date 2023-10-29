package com.nishant.playerDB.service;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.nishant.playerDB.model.entity.Player;
import com.nishant.playerDB.repository.PlayerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;

@EnableCaching
@Service
public class DataLoader {
    PlayerRepository playerRepository;
    Environment env;

    @Autowired
    public DataLoader(PlayerRepository playerRepository, Environment env) {
        this.playerRepository = playerRepository;
        this.env = env;
    }

    @CacheEvict(cacheNames="playerCache", allEntries=true)
    public void addPlayersToDb(File csvFile) throws Exception {
        CsvMapper mapper = new CsvMapper();
        mapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        CsvSchema schema = mapper
                .schemaFor(Player.class)
                .withSkipFirstDataRow(true)
                .withColumnSeparator(',');
        MappingIterator<Player> playerMappingIterator = mapper
                .readerFor(Player.class)
                .with(schema)
                .readValues(csvFile);

        while (playerMappingIterator.hasNext()) {
            playerRepository.save(playerMappingIterator.next());
        }
    }

    @PostConstruct
    public void loadData() {
        try {
            File csvFile = new File(env.getProperty("spring.data.path"));
            addPlayersToDb(csvFile);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
