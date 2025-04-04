/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.Migration;

import config.Config;
import org.flywaydb.core.Flyway;


/**
 *
 * @author black
 */
public class Migration {

    public static void main(String[]args) {

        Config config = Config.getInstance();
        String url = String.format("jdbc:postgresql://localhost:%s/%s", config.getDbPort(), config.getDbName());

        Flyway flyway = Flyway.configure()
                .dataSource(url, config.getDbUser(), config.getDbPassword())
                .schemas("public")
                .locations("filesystem:src/main/java/database/Migration")
                .load();

        flyway.migrate();

    }
}
