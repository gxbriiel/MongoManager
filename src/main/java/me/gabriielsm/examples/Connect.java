package me.gabriielsm.examples;

import me.gabriielsm.MongoManager.MongoDB;

import java.net.UnknownHostException;

public class Connect {

    public static void main(String[] args) {

        //This makes a connection to the MongoDB Atlas server, setting the database and the collection
        MongoDB mongo = new MongoDB(
                "uri",
                "rankup",
                "players"
        );

        //Closes the connection to avoid lagging
        mongo.close();
    }

}
