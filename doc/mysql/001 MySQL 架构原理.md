### 2.网络连接必须让线程来处理

网络连接必须得分配给一个线程去进行处理，由一个线程来监听请求以及读取数据，比如从网络连接中读取和解析出来一条SQL 语句

### 3.SQL 接口，负责处理接受到的 SQL 语句

MySQL 内部提供了一个组件就是 SQL 接口，他是一套执行 SQL 语句的接口，MySQL 的工作线程接收到 SQL 语句之后，就会转交给 SQL 接口执行。

### 4.查询解析器

查询解析器按照 SQL 语法规则进行解析，解析出 SQL 要干什么事情

### 5.查询优化器

查询优化器会选择最佳的查询路径

### 6.调用存储引擎

最后一步，MySQL 会把查询优化器选择的最佳查询路径，也就是应该按照什么样的步骤去执行这个 SQL 语句的计划，把这个计划交给存储引擎去执行。存储引擎会把数据从磁盘上读取出来，返回给客户端

### 7 执行器

调用存储引擎的过程是由执行器来执行的。


## 总结

MySQL 的工作线程拿到 SQL 语句之后，会经过 SQL接口 --> SQL 解析器  --> SQL 优化器 --> 由执行器调用存储引擎
