## 主从复制和哨兵模式

> 下面命令都是在redis-master-slave-sentry目录下执行
### 赋予权限
```shell
chmod -R 777 logs
chmod -R 777 sentinel-cp.conf
```

### 部署主从复制+哨兵模式
```shell
docker-compose up -d
```

> redis.conf是官方配置文件
> sentinel.conf是官方配置文件
