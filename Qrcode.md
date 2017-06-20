# 二维码相关逻辑
----------
服务器有需要二维码的需求，该怎么让脚本端知道该需求？

首先，为需求写一个类，命名为pollingbean。里面的信息如下

```java
private String id;//id,该次类的唯一标识
private String text;//需要发送的文本信息
private List<String> image; //需要发送的图片URL的集合
private boolean type;//发送消息是只发文字还是文字+图片，（true表示发送文字+图片，默认为true）
private boolean enablegroup;//是否像群组里面发送信息（true表示向群组里面发送，默认为true）
private boolean addnn;//表示发送的消息是否动态加上对方的昵称（true表示加上昵称，默认为true）
private int gender;//0表示全部发送，1表示只发送给男，2表示只发送给女，默认为0
```

每当有需要二维码的需求，就新建这样一个类，并放入集合里面，这个集合可以是全局的，
```java
List<PollingBean> pollList=new ArrayList<PollingBean>();
```

接下来说接口，接口sendCode。传入参数，只有一个account。
服务器拿到这个account后，在集合pollList里面去查找，查找字段ID为account的，查找到后，拿出这个对象，然后从集合里面删去这个对象。并返回这个对象。
![](http://i.imgur.com/jgMUROB.png)


