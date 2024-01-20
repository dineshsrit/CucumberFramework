package Cucumber.utils;

import java.beans.PropertyEditor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Properties;

public class Propertyutils
{

    public static Properties propertyLoader(String filepath)
    {
        Properties properties= new Properties();
        BufferedReader reader;

        try {
            reader=new BufferedReader(new FileReader(filepath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load the Properties File:" + filepath);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found:" + filepath);
        }
        return properties;
    }

}
