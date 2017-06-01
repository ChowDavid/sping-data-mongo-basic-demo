package com.david.springData.mongo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class MongoFactoryApplication {

	public static void main(String[] args){
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");) {
			MongoDbFactory factory =context.getBean(MongoDbFactory.class);
			DB db = factory.getDb();
			DBCollection collection = db.getCollection("book");
			collection.insert(new BasicDBObject().append("name", "David"));
			System.out.println("db.collection.find(david)");
			collection.find(new BasicDBObject("name","David")).forEach(b->System.out.println(b));
			System.out.println("db.collection.count");
			System.out.println(collection.count());
			System.out.println("db.collection.find()");
			collection.find().forEach(b->System.out.println(b));
		}
	}
}
