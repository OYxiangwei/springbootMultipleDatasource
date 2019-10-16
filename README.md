# springbootMultipleDatasource
springboot多数据源配置
1、建立两个数据库和两个表
2、建DataSourceConfig.java配置数据源 @Bean@Primary@ConfigurationProperties
3、分别根据两张表建立两个实体类@Table@Entity @Id@GeneratedValue @Column
4、分别对两个数据源进行配置，设置Repository所在位置、设置entityManager工厂、设置事务管理器
5、分别建两个User???Repository extends CrudRepository作为 Dao 层
6、分别建User???Service.java，该类作为 Service 层。
7、编写application.properties和SpringbootApplication.java
8、 ApplicationRunner接口可以让在SpringBoot启动后马上执行想要执行的方法
