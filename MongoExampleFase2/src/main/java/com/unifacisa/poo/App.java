package com.unifacisa.poo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.unifacisa.poo.model.Product;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.client.model.Updates.set;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class App {
    public static void main(String[] args) {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );

        MongoClient mongoClient = new MongoClient(
                "localhost:27017",
                MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build()
        );

        MongoDatabase database = mongoClient.getDatabase("mongo_poo")
                .withCodecRegistry(pojoCodecRegistry);

        MongoCollection<Product> collection = database.getCollection("Product", Product.class);

        // Inserindo produtos no banco de dados
        collection.insertOne(new Product(1, "Galaxy A51", 1200));
        collection.insertOne(new Product(2, "Mouse Redragon", 150));
        collection.insertOne(new Product(3, "Monitor Samsung 24''", 650));

        // Atualizando um produto
        collection.updateOne(new Document("_id", 1), set("price", 949.90));

        // Apagando um produto
        collection.deleteOne(new Document("description", "Mouse Redragon"));
        mongoClient.close();     
   }
}
