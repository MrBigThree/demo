###  binlog

binlog 叫做归档日志，记录的是偏向于逻辑性的日志。类似于"对 user 表中的id = 10 的一行数据做了更新做操，之后的值是什么"。    
binlog 并不是 InnoDB 特有的，而是属于 mysql server 自己的日志文件。 

###  提交事务的时候，同时会写入binlog 

执行器会在提交事务的时候，会同时写入 binlog 日志文件。

### binlog 刷盘策略

binlog 的刷盘策略通过 sync_binlog 参数来控制  
-- 0 ，默认值，此时不会直接进入磁盘，而是进入 os cache 里面。
-- 1 , 提交事务之后，会强制写入磁盘。

### 基于 binlog 和 redo log 完成事务的提交

把 binlog 写入磁盘之后，接着就是完成最终的事务提交，此时会把本次更新对应的 binlog 文件名和这次更新的 binlog 日志在文件里的未知，都写入到 redo log 日志
文件里去，同时在redo log 里面记录一个commit 标记。

### 后台线程刷盘

后台的IO 线程会不定时的将 buffer pool 里面的数据刷入到磁盘里面。   
如果还没刷入磁盘 MySQL 就宕机了，当服务重启之后，会根据 redo log 里面的记录进行数据恢复。



