package games.adlsv.mongoDBAPI.Enum;

import com.mongodb.client.MongoCollection;
import games.adlsv.mongoDBAPI.MongoDBCollections;

public interface EnumCollections {
    enum Path {
        A(null,null);
        Path(String colName, EnumDatabase.Path database) {
            collections = new MongoDBCollections(database.getDatabase(), colName);
        }
        private final MongoDBCollections collections;
        public MongoDBCollections getCollection() {
            return collections;
        }
    }
}
