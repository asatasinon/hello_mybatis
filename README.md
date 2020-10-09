# 1.springboot_mybatis
 使用AOP+注解，创建 springboot + mybatis 的 多数据源配置 项目

# 2.init project
初始化 项目 -master

# 3.正确的配置流程:

  1.先在 application-{profile}.xml 文件下，配置好对应的 jdbc 数据库连接， 
  并根据配置的 主库（master-datasource-count.num） 与 从库 （slave-datasource-count.num）的数量，分别填写 对应的 num。
  
  2.根据配置的数据源 是 主库 还是 从库， 在 DataBaseType 配置到对应的 数据源类型。
  
  3.在 DynamicDataSourceConfig 中 配置对应的 bean 创建的路径。
  
  4.将 创建的 bean 添加到 routingDataSource 的参数，并 加入 targetDataSources 。
  
  5.在需要的使用主库的位置使用 `@MasterDataSource()` , 在需要的使用主库的位置则使用 `@SlaveDataSource()`

# 4.优化项目
## 4.1
添加对应的注释说明，并添加了负载均衡的启用与关闭.

## 4.2
1. 定义 负载均衡策略类型：BalanceTypeEnum
2. 创建 负载均衡策略工场：DataSourceLoadBalanceFactory 
3. 实现：轮询策略、随机访问策略。


