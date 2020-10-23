# Read Me First


### Cassandra

#### Running

Docker Run
```shell script
docker run --name cassandra -p 9042:9042 -d cassandra
```

CQLSH
```shell script
docker exec -it cassandra bash

root@9b16fa32a25b:/# cqlsh
```

Create Keyspace
```sql
cqlsh> create keyspace lirio with replication={'class':'SimpleStrategy', 'replication_factor':1};
```

```sql
cqlsh> describe keyspaces;
```
> lirio  system_schema  system_auth  system  system_distributed  system_traces


```sql
use lirio;
```

Create Table
```sql
CREATE TABLE customer(
   id timeuuid PRIMARY KEY,
   firstname text,
   lastname text,
   confirmed boolean
);
```

```sql
describe tables;
```
> customer

```sql
SELECT * from customer;
```
> Output:
```table
 id                                   | confirmed | firstname | lastname
--------------------------------------+-----------+-----------+----------
                                      |           |           |    
```

## API

CURL
```shell script
$ curl -vvv http://localhost:8080/customers
```
Output:
```
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /customers HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.68.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Fri, 23 Oct 2020 00:49:54 GMT
< 
* Connection #0 to host localhost left intact
[{"id":"4a8a1470-14c8-11eb-834d-53401e3b7a20","firstname":"Diego","lastname":"Lirio"},{"id":"4225cb80-14c8-11eb-834d-53401e3b7a20","firstname":"Diego","lastname":"Lirio"},{"id":"4a320960-14c8-11eb-834d-53401e3b7a20","firstname":"Diego","lastname":"Lirio"},{"id":"4ac6f660-14c8-11eb-834d-53401e3b7a20","firstname":"Diego","lastname":"Lirio"},{"id":"4ae6b360-14c8-11eb-834d-53401e3b7a20","firstname":"Diego","lastname":"Lirio"},{"id":"4b042670-14c8-11eb-834d-53401e3b7a20","firstname":"Diego","lastname":"Lirio"}]%
```

