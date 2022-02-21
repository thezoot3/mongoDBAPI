package games.adlsv.mongoDBAPI;

import com.google.gson.JsonElement;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;
import java.util.ArrayList;


public class MongoDBDocumentUtil {
    private MongoDBCollections collection;
    private Bson default_filter;
    private MongoDBDocument document;
    public MongoDBDocumentUtil(MongoDBCollections collections, Bson filter) {
        collection = collections;
        document = new MongoDBDocument(collections, filter);
        this.default_filter = filter;
        if(document.element == null) {
            throw new RuntimeException();
        }
    }
    public JsonElement get(MongoDBDocumentPath path) {
        if(path.getMongoDBCollection() == collection) {
            document = new MongoDBDocument(collection, default_filter);
            return document.get(path.getPath());
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void addValueToArray(MongoDBDocumentPath path, Object value) {
        try {
            this.get(path).getAsJsonArray();
            Bson update = Updates.push(path.getPath(), value);
            path.getMongoDBCollection().getCollection().updateOne(default_filter, update);
        } catch(IllegalStateException e) {
            throw e;
        }
    }
    public void removeValueFromArray(MongoDBDocumentPath path, Object value) {
        try {
            ArrayList<String> list = new ArrayList<>();
            for(JsonElement e: this.get(path).getAsJsonArray()) {
                list.add(e.getAsString());
            }
            if(list.contains(value)) {
                list.remove(value);
                Bson update = Updates.set(path.getPath(), list);
                path.getMongoDBCollection().getCollection().updateOne(default_filter, update);
            }
        } catch(IllegalStateException e) {
            throw e;
        }
    }
    public void setValue(MongoDBDocumentPath path, Object value) {
        try {
            Bson update = Updates.set(path.getPath(), value);
            path.getMongoDBCollection().getCollection().updateOne(default_filter, update);
        } catch(IllegalStateException e) {
            throw e;
        }
    }

}
