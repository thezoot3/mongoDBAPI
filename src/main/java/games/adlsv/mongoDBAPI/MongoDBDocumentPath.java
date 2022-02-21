package games.adlsv.mongoDBAPI;

import com.mongodb.client.MongoCollection;

public class MongoDBDocumentPath {
    private MongoDBCollections col;
    private String path;
    public MongoDBDocumentPath(String path, MongoDBCollections collection) {
        this.path = path;
        this.col = collection;
    }
    public MongoDBCollections getMongoDBCollection() {
        return col;
    }
    public MongoCollection getCollection() {
        return col.getCollection();
    }
    public String getPath() {
        return path;
    }
}
