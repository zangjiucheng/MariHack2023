package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author manas
 */

public class JsonParser {

    public static String getJSONFromFile(String filename) {
        String jsonText = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file");
        }
        return jsonText;
    }

    public static Food_Attribute createFoodAttribute() {
        String strJson = getJSONFromFile("data.json");
        JSONObject json = new JSONObject(strJson);
        Food_Attribute food = new Food_Attribute(
                Integer.parseInt(json.get("Calories").toString()),
                Integer.parseInt(json.get("Fat").toString()),
                Integer.parseInt(json.get("Sodium").toString()),
                Integer.parseInt(json.get("Sugars").toString()),
                Integer.parseInt(json.get("Protein").toString()));
        return food;

    }

}