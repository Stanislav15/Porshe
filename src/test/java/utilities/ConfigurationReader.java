package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    //read the pro[erties file
    static{
        //this the path to the location of the file
        String path = "configuration.properties";

        try {
            //reader for the file,java cannot read files directly,in needs inputStream to read files
            //inputstream takes the locations of the file as a constructor
            FileInputStream fileInputStream = new FileInputStream(path);


            //Properties is used to read specifiaclly propertios files,files with key value pairs
            properties = new Properties();

            //file contents are load to properties from the inputstream
            properties.load(fileInputStream);

            //all input streams must be closed
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //return the value of specific property

    public static String  getProperty(String property) {
        return properties.getProperty(property);
    }
}
