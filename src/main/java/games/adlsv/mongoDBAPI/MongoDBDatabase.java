package games.adlsv.mongoDBAPI;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBDatabase {
    private MongoDatabase db;
    public MongoDBDatabase(MongoDBConnection client, String dbName) {
        db = client.getClient().getDatabase(dbName);
    }
    public MongoDatabase getDatabase() {
        return db;
    }
    public String getName() {
        return db.getName();
    }
 }
