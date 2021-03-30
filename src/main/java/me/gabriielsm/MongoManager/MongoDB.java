package me.gabriielsm.MongoManager;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * @author Gabriielsm
 * @author Gabriiel#1212
 * @version 1.0
 */
public class MongoDB {

    private MongoClient client;
    private DB database;
    private DBCollection collection;

    /**
     * <h2>This constructor creates a connection to a MongoDB server, with a database and collection defined</h2>
     * @param uriString <p>the uri of the MongoDB server</p>
     * @param databaseName <p>the name of the database of MongoDB server</p>
     * @param collectionName <p>the name of the collection that is inside the database</p>
     */
    public MongoDB(String uriString, String databaseName, String collectionName) {
        try {
            MongoClientURI uri = new MongoClientURI(uriString);
            client = new MongoClient(uri);
        } catch (UnknownHostException e) {
            System.out.println("Could not connect to database!");
            e.printStackTrace();
            return;
        }

        this.database = client.getDB(databaseName);
        this.collection = database.getCollection(collectionName);
    }

    /**
     * <h2>This method closes the connection with the MongoDB server</h2>
     */
    public void close() {
        this.client.close();
    }

    /**
     * <h2>This method get the current connection with the MongoDB server and return it</h2>
     * @return MongoClient
     */
    public MongoClient getMongoClient() {
        return this.client;
    }

    /**
     * <h2>This method changes the database, consequently the collection that is used by MongoDB client</h2>
     * @param databaseName <p>the name of another database</p>
     * @param collectionName <p>the name of the collection inside the changed database</p>
     */
    public void changePath(String databaseName, String collectionName) {
        this.database = this.client.getDB(databaseName);
        this.collection = this.database.getCollection(collectionName);
    }

    /**
     * <h2>This method writes a object in the collection</h2>
     * @param object <p>the DBObject that will be written</p>
     */
    public void write(DBObject object) {
        this.collection.insert(object);
    }

    /**
     * <h2>Search for a key and value and returns it as a MongoDB object</h2>
     * @param key <p>the key of the object to be searched</p>
     * @param value <p>the value of the object should have</p>
     * @return DBObject
     */
    public DBObject read(String key, Object value) {

        DBObject objectFinder = new BasicDBObject(key, value);
        DBObject objectFound = collection.findOne(objectFinder);

        if(objectFound == null){
            System.out.println("Could not find a object with this key and value!");
            return null;
        }

        return objectFound;
    }

    /**
     * <h2>This method updates a object in the collection</h2>
     * @param key <p>the key of the object to be searched</p>
     * @param value <p>the value of the object should have</p>
     * @param object <p>the name of the collection inside the changed database</p>
     */
    public void update(String key, Object value, DBObject object) {

        DBObject objectFinder = new BasicDBObject(key, value);
        DBObject objectFound = collection.findOne(objectFinder);

        if(objectFound == null) {
            System.out.println("Could not find a object with this key and value!");
            return;
        }

        object.removeField("_id");

        this.collection.update(objectFound, object);
    }
}
