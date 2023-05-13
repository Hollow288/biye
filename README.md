

1. 首先是shiro三张表的问题吧，一张角色表，一张权限表，一张角色-权限表，
我们登录后，先从数据库中查出用户拥有的角色集合(因为一个用户可能有多个角色)，
然后开始对这个角色集合进行循环迭代，拿出一个角色就.addRole赋给角色，
然后根据角色从数据库找出角色对应的权限，再来一个循环迭代addStringPermission，将权限赋给我们的用户，
最后返回info，就完成了授权工作，当然这一切的一切之前是有验证操作的。

2. 然后就是我一直奇怪的点:
我把我的网站图标文件放在了static文件夹下，然后在页面中引入了
<link rel="shortcut icon" type="image/x-icon" href="../static/favicon.ico" />
最开始我是这样写的，发现找不到我们的网站图标，gpt说是因为重定向了，我们的绝对路径就错了?有些表示怀疑态度

然后我就听gpt的将路径改成了
<link rel="shortcut icon" type="image/x-icon" href="/static/favicon.ico" />
但是发现这样也并不能加载到我们的网站图标，相反的是，如果我这样引入
<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" />
居然就能加载出我们的网站图标了? 总之就是很奇怪