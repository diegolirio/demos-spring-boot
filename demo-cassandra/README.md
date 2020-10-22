# Read Me First


### Cassandra

#### Running

```shell script
docker run --name cassandra -d cassandra
```

```shell script
docker exec -it cassandra bash
```

```shell script
cqlsh
```

```sql
create keyspace lirio with replication={'class':'SimpleStrategy', 'replication_factor':1};
```

```sql
use lirio;
```

```sql
CREATE TABLE customer(
   id timeuuid PRIMARY KEY,
   firstname text,
   lastname text,
   confirmed boolean
);
```