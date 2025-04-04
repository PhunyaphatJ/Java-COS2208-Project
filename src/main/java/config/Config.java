package config;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;

public class Config {

    static Config configInstance;
    String db_name;
    String db_user;
    String db_password;
    String db_port;

    private Config(String db_name, String db_user, String db_password, String db_port) {
        this.db_name = db_name;
        this.db_user = db_user;
        this.db_password = db_password;
        this.db_port = db_port;
    }

    public static Config getInstance() {
        if (configInstance == null) {
            Dotenv dotenv = Dotenv.configure()
                    .directory("src/main/java/config") 
                    .filename(".env") 
                    .load();
            String db_name = dotenv.get("DB_NAME");
            String db_user = dotenv.get("DB_USER");
            String db_password = dotenv.get("DB_PASSWORD");
            String db_port = dotenv.get("DB_PORT");
            configInstance = new Config(db_name, db_user, db_password, db_port);
        }
        return configInstance;
    }

    public String getDbName() {
        return db_name;
    }

    public String getDbUser() {
        return db_user;
    }

    public String getDbPassword() {
        return db_password;
    }

    public String getDbPort() {
        return db_port;
    }

}
