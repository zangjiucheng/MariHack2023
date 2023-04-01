
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manas
 */
public class JsonParser {
    
    public static String getJSONFromFile(String filename)
    {
        String jsonText = "";
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                jsonText += line + "\n";
            }
            bufferedReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return jsonText;
    }
    
    public static String getJSONFromURL(String strUrl)
    {
        String jsonText = "";
        
        try
        {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                jsonText += line + "\n";
            }
            is.close();
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return jsonText;
    }
    
    public static void main(String[] args) {
        String strJson = getJSONFromFile("C:\\Users\\manas\\Downloads\\data.json");
        System.out.println(strJson);
    }

}
