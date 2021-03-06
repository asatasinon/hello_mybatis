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
## 6.1 @CacheConfig
  @CacheConfig：主要用于配置该类中会用到的一些共用的缓存配置。
    在这里@CacheConfig(cacheNames = "announcement")：配置了该数据访问对象中返回的内容将存储于名为announcement的缓存对象中，我
    们也可以不使用该注解，直接通过@Cacheable自己配置缓存集的名字来定义。
 
## 6.2 @Cacheable 
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

## 6.3 @CachePut
  @CachePut：配置于函数上，能够根据参数定义条件来进行缓存，
    它与@Cacheable不同的是，它每次都会真是调用函数，所以主要用于数据新增和修改操作上。
    它的参数与@Cacheable类似，具体功能可参考上面对@Cacheable参数的解析

## 6.4 @CacheEvict
  @CacheEvict：配置于函数上，通常用在删除方法上，用来从缓存中移除相应数据。
    除了同@Cacheable一样的参数之外，它还有下面两个参数：
    allEntries：非必需，默认为false。当为true时，会移除所有数据
    beforeInvocation：非必需，默认为false，会在调用方法之后移除数据。当为true时，会在调用方法之前移除数据。

# 7. 定时任务
1.在Main文件 添加 @EnableScheduling 启用定时任务

2.在对应需要定时执行的方法上添加注解 @Scheduled(cron = "*/1 * * * * ?") ，内容使用cron表达式

# 8. Cron表达式
Cron表达式是一个字符串，字符串以5或6个空格隔开，分为6或7个域，每一个域代表一个含义，Cron有如下两种语法格式：

（1）Seconds Minutes Hours DayOfMonth Month DayOfWeek Year

（2）Seconds Minutes Hours DayOfMonth Month DayOfWeek
 
## 8.1 结构
 corn从左到右（用空格隔开）：秒 分 小时 月份中的日期 月份 星期中的日期 年份
## 8.2 各字段的含义
| 字段 | 允许值 | 允许的特殊字符 |
|:--- |:--- |:---  |
| 秒（Seconds） | 0~59的整数 | , - * /    四个字符 |
| 分（Minutes） | 0~59的整数 | , - * /    四个字符 |
| 小时（Hours） | 0~23的整数 | , - * /    四个字符 |
| 日期（DayOfMonth） | 1~31的整数（但是你需要考虑你月的天数） | ,- * ? / L W C     八个字符 |
| 月份（Month） | 1~12的整数或者 JAN-DEC | , - * /    四个字符 |
| 星期（DayOfWeek） | 1~7的整数或者 SUN-SAT （1=SUN） | , - * ? / L C #     八个字符 |
| 年(可选，留空)（Year） | 1970~2099 | , - * /    四个字符 |

## 8.3 特殊字符说明
（1）`*`：表示匹配该域的任意值。假如在Minutes域使用*, 即表示每分钟都会触发事件。

（2）`?`：只能用在DayOfMonth和DayOfWeek两个域。它也匹配域的任意值，但实际不会。因为DayofMonth和DayofWeek会相互影响。例如想在每月的20日触发调度，不管20日到底是星期几，则只能使用如下写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发，实际上并不是这样。

（3）`-`：表示范围。例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次 

（4）`/`：表示起始时间开始触发，然后每隔固定时间触发一次。例如在Minutes域使用5/20,则意味着5分钟触发一次，而25，45等分别触发一次. 

（5）`,`：表示列出枚举值。例如：在Minutes域使用5,20，则意味着在5和20分每分钟触发一次。 

（6）`L`：表示最后，只能出现在DayOfWeek和DayOfMonth域。如果在DayOfWeek域使用5L,意味着在最后的一个星期四触发。 

（7）`W`:表示有效工作日(周一到周五),只能出现在DayOfMonth域，系统将在离指定日期的最近的有效工作日触发事件。例如：在 DayOfMonth使用5W，如果5日是星期六，则将在最近的工作日：星期五，即4日触发。如果5日是星期天，则在6日(周一)触发；如果5日在星期一到星期五中的一天，则就在5日触发。另外一点，W的最近寻找不会跨过月份 。

（8）`LW`:这两个字符可以连用，表示在某个月最后一个工作日。 

（9）`#`:用于确定每个月第几个星期几，只能出现在DayOfMonth域。例如在4#2，表示某月的第二个星期三。

# 9. AOP优化
## 9.1 利用 @Around+反射 将 @Before 与 @After 糅合在一起
```
/*
1.利用 @Around+反射 将 @Before 与 @After 糅合在一起, 减少重复代码。
2.要使用AnnotatedElementUtils
  如果还是用AnnotationUtils会发现继承不起作用，
  这个在AnnotationUtils类的英文文档中也有说明.
*/
```

## 9.2 添加类级别的切点
1.先判断方法上的主从库注解是否存在；
2.如果存在，则使用方法注解的库连接；
3.如果方法上不存在主从库注解,则使用 类上的主从库注解；
4.如果都不存在，则不会进入切点，会使用默认配置的数据库连接,具体位置在 DataBaseContextHolder.getDataBaseType()里有注释

## 9.3 使用堆栈
 使用 Stack<DataBaseTypeEnum>，保存同一线程内多次切换的数据源，
 每次AOP切点完成后，会将栈顶元素出栈。保证数据源正确。
 防止AOP切点执行完后执行清空数据源配置，将数据源配置变成了 DataBaseTypeEnum.MASTER
 
## 9.4 使用deque
DataSourceContextHolder的数据源集合由stack优化为deque；优化threadlocal初始值逻辑；优化设置数据源以及清空数据源的逻辑。

# 10.负载均衡策略优化
## 10.1 负载均衡策略工厂抽象为接口类
负载均衡策略工厂抽象为接口类：IDataSourceLoadBalance
## 10.2 负载均衡策略接口实现类为 NoneDataSourceLoadBalanceImpl
负载均衡策略接口实现类为 NoneDataSourceLoadBalanceImpl
意思为 不使用负载均衡
## 10.3 负载均衡策略接口实现类为 RoundRobinDataSourceLoadBalanceImpl
负载均衡策略接口实现类为 RoundRobinDataSourceLoadBalanceImpl
意思为 使用轮询负载


# 参考网址
> [项目配置](https://blog.csdn.net/iku5200/article/details/82856621)

> [Spring Boot 多环境配置](https://www.cnblogs.com/fishpro/p/11154872.html)

> [多数据源配置](https://zhuanlan.zhihu.com/p/83923714)

> [Redis缓存](https://www.cnblogs.com/yixianyixian/p/7427878.html)

> [cron表达式](https://www.cnblogs.com/javahr/p/8318728.html)

> [AOP中使用反射](https://blog.csdn.net/u013259361/article/details/102913329)
