package me.gabriielsm.examples;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import me.gabriielsm.MongoManager.MongoDB;

import java.util.Date;

public class WriteData {

    public static void main(String[] args) {

        //This makes a connection to the MongoDB Atlas server, setting the database and the collection
        MongoDB mongo = new MongoDB(
                "uri",
                "rankup",
                "players"
        );

        //Creates a MongoDB object based on <key, value>
        DBObject object = new BasicDBObject("uuid", "65783c41-af8d-439c-a750-f584c130760a");

        //Adds another object based on <key, value> to the principal MongoDB object
        object.put("nickname", "GabriielPlayer");
        object.put("creation_date", new Date().getTime());
        object.put("mysteryboxes", 7);
        object.put("cash", 4000);
        object.put("money", 230953895395L);
        object.put("terrains", 3);
        mongo.write(object);

        //Closes the connection to avoid lagging
        mongo.close();
    }
}
