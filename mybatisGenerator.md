# MyBatis Generator 快速入门指南

详细见：
mybatis配置说明：http://generator.sturgeon.mopaas.com/index.html
大象修改博客：http://www.blogjava.net/bolo/archive/2015/03/25/423826.html

## 启动说明

java -jar mybatis-generator-core-x.x.x.jar -configfile \temp\generatorConfig.xml -overwrite

源码方式：运行ShellRunner文件

## 源码修改记录
update.txt

## 源码修改之后，使用说明
+ <property name="suppressAllComments" value="false"/>配置生成注释，默认注释已经修改
+ javaModelGenerator里面targetProject可以配置非src，以便于区分源码和业务代码，如：targetProject="target"
+ table里面配置集成的父类可用<property name="rootClass" value="com.geeku.model.BaseModel"/>，该属性也可以再javaModelGenerator里面配置公用
+ table里面配置插入返回主键配置<generatedKey column="id" sqlStatement="MySql" identity="true"/>
    
