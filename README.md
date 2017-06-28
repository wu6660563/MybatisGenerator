# MybatisGenerator
MyBatis代码生成器，生成Model、Dao、*Mapper.xml等

借鉴Mybatis官网下载地址如下：
http://repo1.maven.org/maven2/org/mybatis/generator/mybatis-generator-core/

使用方法：
http://mbg.cndocs.tk/running/running.html


## 启动方式

### org.mybatis.generator.api.ShellRunner

![IDEA下面图片](http://os9eopjop.bkt.clouddn.com/1.png)



从命令行运行MGB时您必须指定 XML 配置文件。如果文件的名字是"generatorConfig.xml",可以用下面任意的命令执行:
```
   java -jar mybatis-generator-core-x.x.x.jar -configfile generatorConfig.xml
   java -jar mybatis-generator-core-x.x.x.jar -configfile generatorConfig.xml -overwrite
   java -cp mybatis-generator-core-x.x.x.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml
   java -cp mybatis-generator-core-x.x.x.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite
```

## 说明

修改记录：

见update.txt文件
