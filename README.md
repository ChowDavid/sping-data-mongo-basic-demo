# sping-data-mongo-basic-demo

## mongodb.cfg
```
systemLog:
   destination: file
   path: /Users/david/Desktop/mongodb/mongod.log
storage:
   dbPath: /Users/david/Desktop/data/db
security:
   authorization: enabled
   ```
   
## mongo security comment to create use and password
```
use admin
db.createUser({user:"admin",pwd:"password",roles:[{role:"root",db:"admin"}]});
use sandbox
db.createUser({user:"books",pwd:"password",roles:[{role:"dbAdmin",db:"sandbox"}]});
db.grantRolesToUser("books",[{role:"readWrite",db:"sandbox"}]);
db.auth()
```

## Spring add credential
```
<mongo:mongo-client id="mongoClient" credentials="books:password@sandbox"></mongo:mongo-client>
```