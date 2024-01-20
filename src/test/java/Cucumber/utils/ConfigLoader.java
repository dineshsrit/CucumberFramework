package Cucumber.utils;

import Cucumber.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;
    private ConfigLoader()
    {
        String env=System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env))
        {
            case STAGE:properties=Propertyutils.propertyLoader("src/test/resources/stage_config.properties");
            break;
            case PROD:properties=Propertyutils.propertyLoader("src/test/resources/prod_config.properties");
            break;
            default:
                throw new RuntimeException("Invalid environment variable:"+ env);
        }

    }

    public static ConfigLoader getInstance()
    {
        if(configLoader==null)
        {
             configLoader=new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl()
    {
      String url=  properties.getProperty("url");
      if(url!=null)
      {
          return url;
      }
      else throw new RuntimeException("Base url is not specified in the property file");
    }


}
