package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    private Properties prop;

    public LoadProperties(){
        try{
            FileInputStream fl = new FileInputStream("src/test/java/Utils/Data/user.properties");
            prop = new Properties();
            prop.load(fl);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getProperty(String property){
        return prop.getProperty(property);
    }
}
