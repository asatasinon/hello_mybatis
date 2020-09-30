# springboot_mybatis
 使用AOP+注解，创建 springboot + mybatis 的 多数据源配置 项目

# init project
初始化 项目 -master

# 优化项目
添加对应的注释说明，并添加了负载均衡的启用与关闭.

正确的配置流程:
  1.先在 application-{profile}.xml 文件下，配置好对应的 jdbc 数据库连接， 并根据配置的 主库 与 从库的数量，分别填写 对应的 num。
  2.根据配置的数据源 是 主库 还是 从库， 在 DataBaseType 配置到对应的 数据源类型。
  3.在 DynamicDataSourceConfig 中 配置对应的 bean 创建的路径。
  4.将 创建的 bean 添加到 routingDataSource 的参数，并 加入 targetDataSources 。
  5.在需要的使用主库的位置使用 `@MasterDataSource()` , 在需要的使用主库的位置则使用 `@SlaveDataSource()`
