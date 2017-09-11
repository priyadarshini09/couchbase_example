package guru.springframework.couchbasedbexample.dataaccess.factory;

import guru.springframework.couchbasedbexample.dataaccess.DataAccessAPI;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataAccessFactory {
    static Map<String, DataAccessAPI> supportedDatabase = new HashMap<>();

    public enum SupportedDatabase{
        COUCHBASESERVER
    }

    public void register(SupportedDatabase type, DataAccessAPI dataAccessAPI){
        supportedDatabase.put(type.name(), dataAccessAPI);
    }

    public DataAccessAPI getPlatformDatabase(){
        String database = "COUCHBASESERVER";
        if(database.equalsIgnoreCase(SupportedDatabase.COUCHBASESERVER.name())){
            return supportedDatabase.get(SupportedDatabase.COUCHBASESERVER.name());
        }
        return null;
    }
}