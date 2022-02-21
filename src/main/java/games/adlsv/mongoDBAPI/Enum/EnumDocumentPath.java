package games.adlsv.mongoDBAPI.Enum;

import games.adlsv.mongoDBAPI.MongoDBDocumentPath;

public interface EnumDocumentPath {
    enum Path{
        A(null,null);
        Path(String path, EnumCollections.Path collection) {
            dpath = new MongoDBDocumentPath(path, collection.getCollection());
        }
        private final MongoDBDocumentPath dpath;
        public MongoDBDocumentPath getPath() {
            return dpath;
        }
    }
}
