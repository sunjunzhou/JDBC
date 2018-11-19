###       终端操作数据库mysql

Mysql -uroot -p;—>输入密码进入数据库

Create database 数据库名; —-创建数据库

Show database; ——显示数据库

Use 数据库名;——-使用数据库

Show tables;——显示表

Create table 表名(id int, primary key auto increment ,varvchar(32),pwd varchar(32));创建表，设置字段

Desc 表名;——查看表结构

Insert into tb_(username,pwd) values (‘lisi’,’123’);——插入值

select *from tb_ where username =‘’ and pwd=‘’；——按条件查找

Select *from 表名；——查看表内容

注：每句语句后都有 ；结束

###         终端操作 Tomcat 服务器



 cd /Users/sunjunzhou/Downloads/Tomcat/bin  ——进入jdbc驱动bin目录



:chmod u+x *.sh  —-启用执行权限操作

./startup.sh    启用。  ./shutdown.sh——停用

<http://localhost:8080>----浏览器输入， 验证成功 

  

URL：协议http+协议分隔符：//+ip：port + /内容路径



  Mysql:   alter user ‘root’@‘localhost’ identified by ‘sjz12345’ password expire never;

​	alter user ‘root’@‘localhost’ identified with mysql_native_password by ‘sjz12345’;

​	flush privileges;

  sql注入：’ Or ‘1’ =‘1





### 贾（加载数据库）莲（链接数据库）欲（预执行数据库）执（执行数据库）事（释放数据库）

##### //1.通过反射加载数据库驱动

Class.forName(“com.mysql.cj.jdbc.Driver");

##### //2.链接数据库

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", “sjz12345”);

##### //3.预执行数据库语句

String sql = "insert into tb_user(username,pwd) values(?,?)”;

PreparedStatement ps = conn.prepareStatement(sql);

##### //4.执行数据库

ps.setString(1, username);

ps.setString(2, pwd);

ps.executeUpdate();

##### //5.释放链接

conn.close();
