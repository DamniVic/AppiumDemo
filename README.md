# AppiumDemo
#已知对方IP，怎么建立一个双向通信的连接
##socket通信
分析：

∵服务器要想跟我发送消息，

∴就一定先要建立连接，

又∵建立连接就一定需要事先知道我的IP。

那么，又是怎么知道我的IP呢，一定得是有人告诉你，我怎么告诉你呢，

已知条件，你的IP是公开的，所以我可以自由的跟你建立连接，

这里我们采用socket告诉你，而不是接口，

步骤：

首先，协定好，socket服务端的端口都用9527.

重新申明一下，现在的已知条件是，服务器公开IP为S，socket服务端的端口都用9527，我们记为P。（P=9527）

1. 服务器的IP，port，服务器开启一个socket的服务端，不停循环来接收消息，实际作用是来监听连接。
2. 脚本端开启一个socket的客户端，与服务器的socket服务端建立连接。（这里可以不发送任何消息，建立一个空连接）
3. 服务器的socket监听到有新建立的连接，那么，就可以获取到对方的IP，port。
4. 脚本端开启一个socket的服务端，端口用P，
5. 服务器已经知道脚本端的IP，那么就可以开启一个socket的客户端，与脚本端的socket服务端建立连接（脚本端IP，P）

总结一下现在的情况：
	
- 脚本端开启了socket客户端，服务器开启了socket服务端，这里脚本端可以任意的向发送消息。
- 服务器开启了socket客户端，脚本端开启了socket服务端，这里服务器可以任意的向脚本端发送消息

这里就已经实现的双向通信。

![](http://i.imgur.com/xI9urIy.png)
