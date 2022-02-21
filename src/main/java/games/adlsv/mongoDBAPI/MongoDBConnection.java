package games.adlsv.mongoDBAPI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
public class MongoDBConnection {
    public MongoClient client;
    public MongoDBConnection(String user, String passwd, String cluster) {
            String uri = "mongodb+srv://" + user + ":"+ passwd +"@" + cluster;
            this.client = MongoClients.create(uri);
    }
    public MongoClient getClient() {
        return client;
    }
}
