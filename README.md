# MybatisGenerator
此代码是基于官方的MybatisGenerator(http://repo1.maven.org/maven2/org/mybatis/generator/mybatis-generator-core/)作了二次开发修改

MyBatis代码生成器，生成Model、Dao、*Mapper.xml等

借鉴Mybatis官网下载地址如下：
http://repo1.maven.org/maven2/org/mybatis/generator/mybatis-generator-core/

使用方法：
http://mbg.cndocs.tk/running/running.html


## 启动方式

### 执行org.mybatis.generator.api.ShellRunner

![IDEA下面图片](http://os9eopjop.bkt.clouddn.com/1.png)

### 推荐同类工具
https://github.com/astarring/mybatis-generator-gui

### 命令行
从命令行运行MGB时您必须指定 XML 配置文件。如果文件的名字是"generatorConfig.xml",可以用下面任意的命令执行:
```
   java -jar mybatis-generator-core-x.x.x.jar -configfile generatorConfig.xml
   java -jar mybatis-generator-core-x.x.x.jar -configfile generatorConfig.xml -overwrite
   java -cp mybatis-generator-core-x.x.x.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml
   java -cp mybatis-generator-core-x.x.x.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite
```

## XML配置解析
http://mbg.cndocs.tk/configreference/xmlconfig.html

### <sqlMapGenerator> 元素

此元素指定我们总希望生成的SQL映射文件在"text.model'包中，并且我们希望使用基于schema和catalog的子包。 它还指定了我们想使用为MyBatis3的XML配置文件的mapper接口。

```
<sqlMapGenerator targetPackage="test.model"
     targetProject="\MyProject\src">
  <property name="enableSubPackages" value="true" />
</sqlMapGenerator>
```


## 源码修改

### Mapper.xml由两个空格改成四个空格
`org.mybatis.generator.api.dom.OutputUtilities`

mybatis-generator 里面我觉得首先最应该改的就是 OutputUtilities 这个类，它里面有个 xmlIndent 方法是用来控制生成的 xml 文件中空格的缩进，默认是两个空格
但四个空格对于我们来说已经深入骨髓了，所以必须改。 在 sb.append( "  " ) 里面增加两个空格就可以了。

### 修改Dao包下的名称，原来的XXXMapper改成XXXDao
`org.mybatis.generator.api.IntrospectedTable`

```
calculateJavaClientAttributes方法(大概820行)
 sb.append("Mapper");注释掉改成 sb.append("Dao");
```

### 修改Mybatis的Model生成JavaDoc注释内容

```
org.mybatis.generator.internal.DefaultCommentGenerator里面的添加注释代码去掉，改成

------------------------------ code start ----------------------------------------
field.addJavaDocLine("/**");
field.addJavaDocLine(" * @Fields "+field.getName()+" "+introspectedColumn.getRemarks());
field.addJavaDocLine(" */");

------------------------------ code end ---------------------------------------------
```

### 注释修改
```
org.mybatis.generator.internal.DefaultCommentGenerator修改XXXDao.java(XXXMapper.java)的接口方法的Javadoc注释

搜索org.mybatis.generator.internal.DefaultCommentGenerator如下方法，并注释方法里面内容，
public void addGeneralMethodComment(Method method,
            IntrospectedTable introspectedTable)

改成：

method.addJavaDocLine("/**");
method.addJavaDocLine(" * @Title " + method.getName());
for (Parameter parameter : method.getParameters()) {
	 method.addJavaDocLine(" * @param " + parameter.getName());
}
String returnType = method.getReturnType().toString();
returnType = returnType.lastIndexOf(".") != -1 ? returnType.substring(returnType.lastIndexOf(".") + 1) : returnType;
method.addJavaDocLine(" * @return " + returnType);
method.addJavaDocLine(" */");

```
### 注释掉Model里面Getter和Setter方法的注释，根据需要自己加上
```
搜索org.mybatis.generator.internal.DefaultCommentGenerator如下方法：
public void addGetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn)

public void addSetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn)

### 注释掉Mapper.xml里面的注释,实际使用未用到
搜索org.mybatis.generator.internal.DefaultCommentGenerator如下方法：
public void addComment(XmlElement xmlElement)

### XML里面每个SQL增加一个换行
org.mybatis.generator.api.dom.xml.XmlElement里面getFormattedContent里面加上：
if(indentLevel == 1) {
	//每个insert/update/select之间插入一个空行
	OutputUtilities.newLine(sb);
}
```
### 修改mybatis的mapper.xml文件里面insert和update不根据字段判断的非动态SQL
```
org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator
里面的getSqlMapElement方法

注释掉：
addInsertElement(answer);
addUpdateByPrimaryKeyWithoutBLOBsElement(answer);

对应的是mapper.xml里面的
<insert id="insert" parameterType="com.geeku.model.exhibition.Likes" ></insert>
<update id="updateByPrimaryKey" parameterType="com.geeku.model.exhibition.Likes" ></update>
```






