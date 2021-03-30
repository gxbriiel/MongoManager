package me.gabriielsm.examples;

import com.mongodb.DBObject;
import me.gabriielsm.MongoManager.MongoDB;

public class UpdateData {

    public static void main(String[] args) {

        //This makes a connection to the MongoDB Atlas server, setting the database and the collection
        MongoDB mongo = new MongoDB(
                "uri",
                "rankup",
                "players"
        );

        //Set the update object
        DBObject updatedObject = mongo.read("uuid", "65783c41-af8d-439c-a750-f584c130760a666666666");
        updatedObject.put("mysteryboxes", 4);
        updatedObject.put("terrains", 6);

        //Update the object
        mongo.update("uuid", "65783c41-af8d-439c-a750-f584c130760a666666666", updatedObject);

        //Closes the connection to avoid lagging
        mongo.close();
    }

}
