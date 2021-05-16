### DevOps

```sh
docker-compose -f docker-compose-kong-yml up -d
docker exec -it redis bash
root@0adc5016ac39:/data# redis-cli
127.0.0.1:6379> select 10
127.0.0.1:6379[10]> smembers productss
127.0.0.1:6379[10]> keys *
```

