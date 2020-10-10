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

# 5.使用Redis缓存
1.配置文件添加对应参数
2.创建RedisConfig配置类
3.创建RedisUtil工具类
4.在Main文件 添加 @EnableCaching 启用缓存
5.对应的service添加对应的@CacheConfig，如AnnouncementService添加@CacheConfig(cacheNames = "announcement")，
  则指定 使用的缓存空间名为announcement。
6.对应的方法则使用 @Cacheable(key = "#id")，@Cacheable()内使用 SpEL表达式。

# 6.Cache注解详解
## @CacheConfig
  @CacheConfig：主要用于配置该类中会用到的一些共用的缓存配置。
    在这里@CacheConfig(cacheNames = "announcement")：配置了该数据访问对象中返回的内容将存储于名为announcement的缓存对象中，我
    们也可以不使用该注解，直接通过@Cacheable自己配置缓存集的名字来定义。
 
 ## @Cacheable 
  @Cacheable：配置了findByName函数的返回值将被加入缓存。
    同时在查询时，会先从缓存中获取，若不存在才再发起对数据库的访问。该注解主要有下面几个参数：
  
  value、cacheNames：两个等同的参数（cacheNames为Spring 4新增，作为value的别名），用于指定缓存存储的集合名。
    由于Spring 4中新增了@CacheConfig，因此在Spring 3中原本必须有的value属性，也成为非必需项了.
  
  key：缓存对象存储在Map集合中的key值，非必需，缺省按照函数的所有参数组合作为key值，
    若自己配置需使用SpEL表达式，比如：@Cacheable(key = "#p0")：使用函数第一个参数作为缓存的key值
  
  condition：缓存对象的条件，非必需，也需使用SpEL表达式，
    只有满足表达式条件的内容才会被缓存，比如：@Cacheable(key = "#p0", condition = "#p0.length() < 3")，
    表示只有当第一个参数的长度小于3的时候才会被缓存，若做此配置上面的AAA用户就不会被缓存，读者可自行实验尝试。
 
  unless：另外一个缓存条件参数，非必需，需使用SpEL表达式。
    它不同于condition参数的地方在于它的判断时机，该条件是在函数被调用之后才做判断的，所以它可以通过对result进行判断。
  
  keyGenerator：用于指定key生成器，非必需。
    若需要指定一个自定义的key生成器，我们需要去实现org.springframework.cache.interceptor.KeyGenerator接口，
    并使用该参数来指定。需要注意的是：该参数与key是互斥的.
 
  cacheManager：用于指定使用哪个缓存管理器，非必需。只有当有多个时才需要使用
  
  cacheResolver：用于指定使用那个缓存解析器，非必需。
    需通过org.springframework.cache.interceptor.CacheResolver接口来实现自己的缓存解析器，并用该参数指定。

## @CachePut
  @CachePut：配置于函数上，能够根据参数定义条件来进行缓存，
    它与@Cacheable不同的是，它每次都会真是调用函数，所以主要用于数据新增和修改操作上。
    它的参数与@Cacheable类似，具体功能可参考上面对@Cacheable参数的解析

## @CacheEvict
  @CacheEvict：配置于函数上，通常用在删除方法上，用来从缓存中移除相应数据。
    除了同@Cacheable一样的参数之外，它还有下面两个参数：
    allEntries：非必需，默认为false。当为true时，会移除所有数据
    beforeInvocation：非必需，默认为false，会在调用方法之后移除数据。当为true时，会在调用方法之前移除数据。


