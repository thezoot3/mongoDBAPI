package games.adlsv.mongoDBAPI;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBCollections {
    private final MongoCollection collection;
    public MongoDBCollections(MongoDBDatabase database, String collectionName) {
        MongoDatabase db = database.getDatabase();
        this.collection = db.getCollection(collectionName);
    }
    public MongoCollection getCollection() {
        return this.collection;
    }
}
