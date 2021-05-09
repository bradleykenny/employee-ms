package com.bradleykenny.personms.config;

import com.mongodb.*;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Configuration
@PropertySource("classpath:mongo.properties")
public class MongoConfig {

    @Value("${mongo.url}")
    private String DB_HOST;

    public static final int DB_PORT = 27017;
    public static final String DB_NAME = "person-ms";

    @Bean
    public Datastore datastore() {
        MongoClientOptions.Builder mongoOptions = MongoClientOptions.builder()
                .socketTimeout(60000) // Wait 1m for a query to finish, https://jira.mongodb.org/browse/JAVA-1076
                .connectTimeout(15000) // Try the initial connection for 15s, http://blog.mongolab.com/2013/10/do-you-want-a-timeout/
                .maxConnectionIdleTime(600000) // Keep idle connections for 10m, so we discard failed connections quickly
                .readPreference(ReadPreference.primaryPreferred()); // Read from the primary, if not available use a secondary

        MongoClientURI uri = new MongoClientURI(DB_HOST, mongoOptions);
        MongoClient mongoClient = new MongoClient(uri);

        var datastore = new Morphia().createDatastore(mongoClient, DB_NAME);
        datastore.ensureIndexes();
        datastore.ensureCaps();

        System.out.println("Connection to database '" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "' initialised");

        return datastore;
    }
}
