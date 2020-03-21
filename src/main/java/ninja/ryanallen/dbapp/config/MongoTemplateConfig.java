package ninja.ryanallen.dbapp.config;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
public class MongoTemplateConfig {

    @Autowired
    private MongoClient mongoClient;

    @Bean
    @Qualifier("accounts")
    public ReactiveMongoTemplate accountsMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient, "accounts");
    }

    @Bean
    @Qualifier("games")
    public ReactiveMongoTemplate gamesMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient, "games");
    }
}
