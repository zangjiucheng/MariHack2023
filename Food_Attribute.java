
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author manas
 */
class Food_Attribute {

    public static String getJSONFromFile(String filename) {
        String jsonText = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText;
    }

    public static void main(String[] args) {
        ArrayList<Integer> parameter = new ArrayList<Integer>();
        String strJson = getJSONFromFile("C:\\Users\\manas\\Downloads\\data.json");
        Scanner input = new Scanner(strJson);
        System.out.println(strJson);



        input.nextLine();

        for (int i = 0; i < 3; i++) {
            
            String line = input.nextLine();
            
            if (line.indexOf(",") > 0) {

                int startPos = line.indexOf(":") + 1;
                int comaPos = line.indexOf(",");
//                System.out.println(line.substring(startPos, comaPos));
                parameter.add(Integer.parseInt(line.substring(startPos, comaPos).strip()));

            } else {
                
                int startPos = line.indexOf(":") + 1;
//                System.out.println(line.substring(startPos));
                parameter.add(Integer.parseInt(line.substring(startPos).strip()));

            }
//            System.out.println(parameter.get(i));
            
        }
        
        System.out.println(parameter.toString());
        JsonParser f1 = new JsonParser(parameter.get(0),parameter.get(1),parameter.get(2),parameter.get(3) );

    }

}
Food_Attribute
class Food_Attribute {

    protected int calories, fat, sodium, sugar;

    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return this.fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return this.sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getSugar() {
        return this.sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof JsonParser)) {
            return false;
        }
        JsonParser food_Attribute = (JsonParser) o;
        return calories == food_Attribute.calories && fat == food_Attribute.fat && sodium == food_Attribute.sodium && sugar == food_Attribute.sugar;
    }

    public Food_Attribute() {
    }

    public Food_Attribute(int calories, int fat, int sodium, int sugar) {
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "{"
                + " calories='" + getCalories() + "'"
                + ", fat='" + getFat() + "'"
                + ", sodium='" + getSodium() + "'"
                + ", sugar='" + getSugar() + "'"
                + "}";
    }

}
