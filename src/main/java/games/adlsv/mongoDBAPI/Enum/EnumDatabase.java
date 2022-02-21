package games.adlsv.mongoDBAPI.Enum;

import games.adlsv.mongoDBAPI.MongoDBConnection;
import games.adlsv.mongoDBAPI.MongoDBDatabase;

public interface EnumDatabase {
    enum Path {
        A(null,null);
        Path(String dbName, MongoDBConnection connection) {
            db = new MongoDBDatabase(connection, dbName);
        }
        private MongoDBDatabase db;
        public MongoDBDatabase getDatabase() {
            return db;
        }
    }
}
