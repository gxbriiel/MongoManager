package me.gabriielsm.examples;

import com.mongodb.DBObject;
import me.gabriielsm.MongoManager.MongoDB;

public class ReadData {

    public static void main(String[] args) {

        //This makes a connection to the MongoDB Atlas server, setting the database and the collection
        MongoDB mongo = new MongoDB(
                "uri",
                "rankup",
                "players"
        );

        //Reads the player and return the DBObject
        DBObject player = mongo.read("uuid", "65783c41-af8d-439c-a750-f584c130760a");

        //Closes the connection to avoid lagging
        mongo.close();
    }

}
