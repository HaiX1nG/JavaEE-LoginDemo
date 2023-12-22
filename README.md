# 这是期末考试的基于JavaEE开发的用户登录的WebAPP
## 这是捡起大一学习的servlet+jsp+tomcat的项目开发的回忆项目
<hr />
用户登录:<br>
1. 数据库创建对应的表`user`(MySQL)
2. 前台界面:<br>
登录界面:login.jsp
    用户登录 JS校验
    登录表单验证
    1. 给登录按钮绑定点击事件<br>
    2. 判断用户名和密码是否为空,并给span赋值,并且return<br>
    3.如果都不为空则手动提交表单<br>
首页 index.jsp<br>
<hr />
3. 后端实现<br>
登录功能<br>
分层思想<br>
controller层<br>
请求接受(调用service层,返回结果)
service层<br>
业务逻辑层<br>
mapper层
接口类<br>
mapper.xml mybatis的操作
util<br>
工具类(通用的类和方法储存的地方)<br>
test<br>
测试类/方法<br>
entity(po,model)<br>
JavaBean实体
