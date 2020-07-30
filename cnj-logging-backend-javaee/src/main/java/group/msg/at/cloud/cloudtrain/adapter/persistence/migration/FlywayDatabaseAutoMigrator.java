package group.msg.at.cloud.cloudtrain.adapter.persistence.migration;

import org.flywaydb.core.Flyway;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

/**
 * Flyway database auto-migrator that performs database migrations on application startup.
 * <p>
 * All migration statements must be located at {@code classpath:db/migration} which might be either
 * packaged with this application or with a utility JAR of this application.
 * </p>
 */
@Startup
@Singleton
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FlywayDatabaseAutoMigrator {

    @Resource(lookup = "jdbc/cnj-postgres-datasource")
    private DataSource dataSource;

    @PostConstruct
    public void migrateDatabase() {
        Flyway flyway = Flyway.configure().dataSource(this.dataSource).load();
        flyway.migrate();
    }
}
