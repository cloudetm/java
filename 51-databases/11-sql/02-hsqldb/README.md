# HSQLDB - Installation

https://www.tutorialspoint.com/hsqldb/hsqldb_installation.htm

> download

http://hsqldb.org/

> location

/Users/whan/hsqldb-2.4.0/hsqldb

## running database

> prepare server.properties

```
$ cat hsqldb/server.properties 
server.database.0 = file:hsqldb/demodb
server.dbname.0 = testdb
```

> create a default database

```
$ java -classpath lib/hsqldb.jar org.hsqldb.server.Server
```

> start database

```
$ java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/demodb --dbname.0 testdb
```

> database manager

```
$ java -cp lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
```

URL: jdbc:hsqldb:hsql:localhost/testdb

> sql

Simple

```
DROP TABLE IF EXISTS Customers
CREATE TABLE IF NOT EXISTS Customers (name VARCHAR (20), age INT);
INSERT INTO Customers (name,age) VALUES ('Tom', 28 );
SELECT * FROM Customers;
```

```
CREATE TABLE Customers(
   id   INT              NOT NULL,
   name VARCHAR (20)     NOT NULL,
   age  INT              NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO Customers (id,name,age)
VALUES (1, 'Tom', 28 );

INSERT INTO Customers (id,name,age)
VALUES (2, 'Dick', 18 );

INSERT INTO Customers (id,name,age)
VALUES (3, 'Harry', 38 );

SELECT * FROM Customers;

DROP TABLE Customers;
```
