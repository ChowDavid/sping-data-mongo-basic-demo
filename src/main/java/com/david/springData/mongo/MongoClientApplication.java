package com.david.springData.mongo;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoClientApplication {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");) {
			MongoClient client = (MongoClient) context.getBean("mongoClient");
			DB db = client.getDB("sandbox");
			DBCollection collection = db.getCollection("book");
			for (int i=0;i<5000;i++){
				collection.insert(new BasicDBObject().append("title", "Harry Potter "+new Date()));
			}
			collection.insert(new BasicDBObject().append("name", "David"));
			System.out.println("db.collection.find(david)");
			collection.find(new BasicDBObject("name","David")).forEach(b->System.out.println(b));
			System.out.println("db.collection.count");
			System.out.println(collection.count());
			System.out.println("db.collection.find()");
			collection.find().forEach(b->System.out.println(b));
			//System.out.println("db.collection.drop");
			//collection.drop();
			
		}

	}

}
