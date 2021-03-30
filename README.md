# MongoManager
## _A simple way to use MongoDB driver with Java_

MongoManager is a simple way to integrate your MongoDB server with you Java Application with less stress to make it work.

## Features

- [All methods documentated](https://github.com/Gabriielsm/MongoManager/blob/main/src/main/java/me/gabriielsm/MongoManager/MongoDB.java)
- [Commented examples](https://github.com/Gabriielsm/MongoManager/tree/main/src/main/java/me/gabriielsm/examples) to learn how to use
- Don't need to have much knowledge to understand the use it
 
## Installation

Since the way this repository isn't integrated with Maven yet, you will need to copy the [MongoDB Class](https://github.com/Gabriielsm/MongoManager/blob/main/src/main/java/me/gabriielsm/MongoManager/MongoDB.java) to your project.

Before copying the class, make sure that you declared Maven dependencies and plugins in pom.xml.

```xml
    <dependencies>
        <dependency>
            <groupId>org.mongodb</groupId>
            <artifactId>mongo-java-driver</artifactId>
            <version>2.13.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.4</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <artifactSet>
                                <includes>
                                    <include>org.mongodb</include>
                                </includes>
                            </artifactSet>
                            <createDependencyReducedPom>false</createDependencyReducedPom>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

Then reload the pom.xml file to download the dependencies...

## How to use?

#### I have declared the dependencies and plugins in pom.xml and copied the class to my project, what should I do now?

Now you need to construct the MongoDB class at the class you want to integrates, connect to the server and do use it as you wish.
In [this example](https://github.com/Gabriielsm/MongoManager/blob/main/src/main/java/me/gabriielsm/examples/Connect.java), I connect with the MongoDB server and close the connection.

You can see on line 12 how I construct the MongoDB object. You will need the URI of your MongoDB server, the database name and the collection name. 
If you don't know what this is, please read the [MongoDB Documentation](https://docs.mongodb.com/drivers/java/).

In other examples you can learn the basic use of the MongoDB, as write data, read data and update data.
Feel free to modify any method and make it work by your way for the better functionality of your application.
