package Utils;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    private Properties prop;

    public LoadProperties(){
        try{
            Gson gson = new Gson();
            FileReader fl = new FileReader("src/test/java/Utils/Data/user.json");
            prop = gson.fromJson(fl, Properties.class);
            fl.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getProperty(String property){
        return prop.getProperty(property);
    }
}
