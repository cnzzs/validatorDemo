# validatorDemo
对valdate校验器的基本实现,Spring MVC校验器的扩展,可进行对方法参数单个校验 实例

对valdate校验器的基本实现,Spring MVC校验器的扩展（这里只实现json的处理）,可进行对方法参数单个校验 下面是简单的实现：

```java
    @Valid
    public Map<String, Object> set(@QQ String qq) {
        System.out.println(qq);
        return successData();
    }
    public Map<String, Object> add(@Valid User user) {
        System.out.println(user.getName());
        System.out.println(user.getQq());
        System.out.println(user.getIdCard());
        return successData();
    }
```
maven 配置
```xml
<dependency>
  <groupId>net.zz</groupId>
  <artifactId>validator</artifactId>
  <version>1.0</version>
</dependency>
```
对应的maven的依赖
```xml
 <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <type>jar</type>
            <scope>compile</scope>
        </dependency>
        <!--这个东西不用的，因为net.zz.validator.web.SupportController的问题.-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
            <type>jar</type>
            <scope>compile</scope>
        </dependency>
```


在mvc-servlet-context.xml里面加入一下支持
```xml
    <!-- 注解式AOP -->
	<aop:aspectj-autoproxy />
	<!-- 代理模式用CGLIB，针对类的代理 -->
	<aop:aspectj-autoproxy proxy-target-class="true" />
	<!-- 引入ZZValidate-->
	<bean class="net.zz.validator.ZZValidate"/>
```
