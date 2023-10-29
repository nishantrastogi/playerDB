package com.nishant.playerDB.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nishant.playerDB.controller.PlayerController;
import com.nishant.playerDB.model.entity.Player;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PlayerController.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;


    @Test
    public void retrieveSingleUser(){
        String jsonString = "{\n" +
                "    \"playerID\": \"hernanju01\",\n" +
                "    \"birthYear\": 1990,\n" +
                "    \"birthMonth\": 11,\n" +
                "    \"birthDay\": 20,\n" +
                "    \"birthCountry\": \"Puerto Rico\",\n" +
                "    \"birthState\": \"Ponce\",\n" +
                "    \"birthCity\": \"Ponce\",\n" +
                "    \"deathYear\": null,\n" +
                "    \"deathMonth\": null,\n" +
                "    \"deathDay\": null,\n" +
                "    \"deathCountry\": \"\",\n" +
                "    \"deathState\": \"\",\n" +
                "    \"deathCity\": \"\",\n" +
                "    \"nameFirst\": \"Julio\",\n" +
                "    \"nameLast\": \"Hernandez\",\n" +
                "    \"nameGiven\": \"Julio Alejandro\",\n" +
                "    \"weight\": 215,\n" +
                "    \"height\": 74,\n" +
                "    \"bats\": \"R\",\n" +
                "    \"doesThrows\": \"R\",\n" +
                "    \"debut\": \"2012-06-03\",\n" +
                "    \"finalGame\": \"2020-09-30\",\n" +
                "    \"retroID\": \"hermj012\",\n" +
                "    \"bbrefID\": \"hernanju01\"\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        Player MockplPlayer = null;

        try {
            MockplPlayer = mapper.readValue(jsonString,Player.class);
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }

        Mockito.when(playerService.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(MockplPlayer));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "http://localhost:8080/api/players/hernanju01").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = null;
        try {
            result = mockMvc.perform(requestBuilder).andReturn();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            JSONAssert.assertEquals(jsonString, result.getResponse().getContentAsString(), false);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        } catch (JSONException e) {
            System.out.println(e);
        }
    }


}
