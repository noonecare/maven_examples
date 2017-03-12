maven plugins

maven 很像是标记语言，你只要给出 configuration 声明一下配置。具体的任务是 plugin 负责去执行的，但是对于具体的 plugin 你需要知道如何去配置。不同的 plugin 就像是 python 中不同的包一样，具体怎么用，你需要去查看文档的。常用的 plugin 都在 http://maven.apache.org/plugins/index.html 和 http://mojo.codehaus.org/plugins.html 中。


常用的 plugin:

- org.eclipse.
- jetty-maven-plugin
> - web 开发时， 执行 mvn jetty:run 会直接运行服务器。


- surefire
> - maven 中用于 test 的 plugin 就是 surefire。

- compiler
> - 从名字就可以知道这是个编译器
> - source 我觉得是 source 的版本，比如 python 有 Python2, python3, java 语言也不是一层不变的，java 语言本身也有版本号
> - target  指的是 JVM 虚拟机版本号
> - 我认为 compiler plugin 现在还只能编译 java, 特别的它不能编译 scala。就来complier plugin 用于指定 实际 compiler 的选项也名为 forceJavaCompilerUse, 怎么看都不想是 scala 的编译器。
> - 

- archetype 常用的就是 mvn archetype:generate 可以根据别人的骨架结构快速的生成一个 project。
> - 我一直想自己写个 archetype, 包含操作 spark, hive, kafka 的常用包（相当于是个模板）。 但是我一直不会写。


- help
> - 给出项目的很多信息

- dependency
> - mvn dependency:list
> - mvn dependency:tree
> - mvn dependency:copy-dependencies


- deploy
> - deploy 是默认绑定到 deploy lifecycle 的，所以一般我们执行 mvn deploy 就可以把生成的 jar 包发布到 仓库中。
具体需要做的配置，就是一下源。这个 元素是 <distributionManage> 这个元素中主要就是配置一下，要把 jar 把发布到那个 repository 中。
源的账号和密码信息常常放在 settings.xml 文件的 servers 中。下面我给一个例子：

```xml
<distributionManagement>
	<repositories>
    	<repository>
        	<id>3rd_party</id>
            <name>third party</name>
            <url>http://localhost:8081/repository/3rd_party</url>
        </repository>
    </repositories>
</distributionManagement>
```

settings.xml 中需要配置 servers

```xml
<servers>
	<server>
    	<id>3rd_party</id>
        <username>admin</username>
        <password>admin123</password>
    </server>
</servers>
```

除此之外，deploy plugin 中的 deploy-file 也很常用。这个命令，常常在命令行中直接执行（不需要写配置文件，直接使用），下面是个例子：

```shell
mvn deploy:deploy-file DgroupId=org.sonatype.mavenbook.multi -DartifactId=simple-weather -Dversion=0.8-SNAPSHOT -Dpackaging=jar -Dfile=/home/wangmeng/maven-example/target/simple-weather-0.8-SNAPSHOT.jar -Durl=http://localhost:8081/repository/3rd_party -DrepositoryId=3rd_party
```

构建maven 库，也非常简单，下载 nexus ,运行即可。


- enforcer

> - shade
```xml
<build>
	<plugins>
    	<plugin>
        	<groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>2.3</version>
            <executions>
            	<execution>
                	<phase>package</phase>
                    <goals>
                    	<goal>shade</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

maven-shade-plugin 的 shade goal 用于打 uber 包。



- resources
> - 

- version
> - 

- build-helper-maven-plugin
> - 

- release
> - 不理解




- assembly

- net.alchim31.maven::scala-maven-plugin
> - 这个 plugin 是个常用的编译 scala 的 plugin, 其中重要的 goal 有 compile testcompile
> - 特别说一句，编译 scala 时需不需要 org.scala-lang::scala-library 这个 构件。这个构件，相当于是在 IDEA 中指明 scala SDK。



maven 中的 pluginManagement 元素有什么作用，感觉加不加没有什么区别。
> - pluginManagement 一定会被继承

? maven compiler 插件中的 target 指的是什么？
- 项目的 profile 指的是什么
> - 项目的配置，详见http://elim.iteye.com/blog/1900568

? maven 中的 classifier 指的是什么？


？maven 中的 plugin 也是 一个依赖


(马尔科夫机制转移向量自回归模型
MSR)

737,738,898

csv 表中有一行的记录是错的。为怎么样。


一些重要的 dependency
