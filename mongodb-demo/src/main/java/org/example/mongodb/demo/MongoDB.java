package org.example.mongodb.demo;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/25
 */
public class MongoDB {

    public static void main(String[] args) {
        MongoClient client = new MongoClient("20.21.1.151", 27017);
        MongoDatabase database = client.getDatabase("yapi");
        MongoCollection<Document> collection = database.getCollection("interface");

        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> iterator = documents.iterator();
        iterator.forEachRemaining(document -> {
            System.out.println(document);
        });
    }
}
