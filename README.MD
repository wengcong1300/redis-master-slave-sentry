## 主从复制和哨兵模式

### 赋予权限
```shell
chmod -R 777 ./logs
```

### 部署主从复制+哨兵模式
```shell
docker-compose up -d
```

> redis.conf是官方配置文件
> sentinel.conf是官方配置文件
