### InnoDB 中的重要内存结构：缓冲池

缓冲池（Buffer Pool）里面会缓存一些数据，以便查询，更新操作。查询操作、更新操作都是基于 Buffer Pool 来进行的。

### undo 日志文件

undo 日志会记录旧版本的数据，以便数据进行回滚。

### redo log buffer 

对数据的更新操作，是在 Buffer Pool 内存里面进行的，同时会把数据的操作记录的 redo buffer log 里面，也是一个内存的缓冲区。   
redo 日志记录的是当前数据的变化,比如 "对哪个数据页中的什么记录，做了什么修改"

### 提交事务
当事务提交的时候，就会根据一定的策略把 redo buffer log 刷到磁盘里面，进行持久化。

刷盘策略通过 innodb_flush_log_at_trx_commit 参数来设置 : 
-- 0 当事务提交的时候，不会把 redo log buffer 里的数据刷入磁盘。此时数据有丢失的可能
-- 1 当事务提交的时候，把 redo log buffer 刷入磁盘。不会丢失数据，只要事务提交成功，redo log 一定在磁盘上了
-- 2 当事务提交的时候，会把 redo log buffer 写入 os cache 里面，而不是进入磁盘。这种情况下也有可能会丢失数据。



