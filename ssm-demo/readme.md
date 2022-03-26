## 技术点

    基础框架-ssm(SpringMVC+Spring+MyBatis)
    数据库-MySQL
    前端框架-bootstrap快速搭建简洁美观的界面
    项目的依赖管理-maven
    分页-pagehelper
    逆向工程-MyBatis Generator

## 基础环境搭建

1.创建一个maven工程

2.引入项目依赖的jar包
    
- spring
- springmvc
- mybatis
- 数据库连接池，驱动包
- 其它

3.引入Bootstrap，前端框架 
- 下载bootstrap 和jquery模板
- 新建index.jsp，引入jquery和bootstrap.

4.编写ssm整合的关键配置文件
- web.xml,spring,springmvc,mybatis,使用mybatis的逆向工程生成对应的bean以及mapper

 mybatis逆向工程
    
1.引入jar包 mybatis-generator-core
2.添加配置文件.注意:配置文件路径有问题，就生成不了文件
3.生成
