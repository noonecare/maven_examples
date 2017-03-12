maven 的使用：

学习任何 包，最好的办法就是找实例代码(可以从 github 上找到实例代码)先运行一下。

在使用 maven 安装包时，因为中国长城防火墙的关系， maven 下包下的非常慢。导致你想安装运行一下实例代码需要花很长时间。

为了解决这个问题，需要做两件事儿：

- 1. 可以把 maven 的源改成国内源
- 2. 国内源包含的 jar 包可能不全


对于问题1：

要做的是 修改 .m2 下的 settings.xml 文件(下面的 settings.xml 文件就是这样的一个例子)，

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <!--
    	localRepository: 配置本地仓库的路径， 服务器上下载下来的JAR包也会缓存到此路径，为了避免C盘过度膨胀， 我们可以将其放到其他磁盘空间较为充裕的路径下
    <localRepository>your_local_repository_path</localRepository>
    -->
    <servers>
    	<server>
        	<id>XXX</id>
            <username>developer</username>
            <password>developer</password>
        </server>
    </servers>
    <mirrors>
    	<mirror>
        <id>XXX</id>
        <mirrorOf>*</mirrorOf>
        <url>http://XXX:8081/nexus/content/groups/public/</url>
        </mirror>
    </mirrors>
    </settings>
```

或者在 pom.xml 文件中指定源

```xml
<repositories>
	<repository>
    	<name>mvnrepository</name>
        <url>http://www.mvnrepository</url>
        <layout>default</layout>
        <releases>
        	<enabled>true</enabled>
        </releases>
        <snapshots>
        	<enabled>false</enabled>
        </snapshots>
    </repository>
</repositories>
```

如果一个源不够，可以多添加几个 repository.
对于 dependency 同样可以直接指明源，去下载。
最后所有源都是下载到本地 repository， 你可以去google 上找到这个源，然后下载到本地 repository 指定的目录下。