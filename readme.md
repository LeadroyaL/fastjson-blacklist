# fastjson blacklist

### 背景

`fastjson` 在1.2.42开始，把原本明文的黑名单改成了哈希过的黑名单，防止安全研究者对其进行研究。在 [https://github.com/alibaba/fastjson/commit/eebea031d4d6f0a079c3d26845d96ad50c3aaccd](https://github.com/alibaba/fastjson/commit/eebea031d4d6f0a079c3d26845d96ad50c3aaccd) 这次commit中体现出来。

```
-     private String[] denyList = "bsh,com.mchange,com.sun.,java.lang.Thread,java.net.Socket,java.rmi,javax.xml,org.apache.bcel,org.apache.commons.beanutils,org.apache.commons.collections.Transformer,org.apache.commons.collections.functors,org.apache.commons.collections4.comparators,org.apache.commons.fileupload,org.apache.myfaces.context.servlet,org.apache.tomcat,org.apache.wicket.util,org.apache.xalan,org.codehaus.groovy.runtime,org.hibernate,org.jboss,org.mozilla.javascript,org.python.core,org.springframework".split(",");

+        denyHashCodes = new long[]{
+                -8720046426850100497L,
+                 ......
+                8838294710098435315L
+        };

```

网上没找到类似的仓库，为了弄清楚每个hash到底对应的是什么，就写了个小轮子，跑一下这些case，列出来。

### 功能

```java
public class Main {
    public static void main(String[] args) throws IOException {
        // 功能1：完善已知列表
        // 使用指定的class去完善
        BreakerUtils.completeDatabase(new String[]{"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory"});
        // 使用指定的jar去完善
        BreakerUtils.completeDatabase(new File("C:\\Users\\leadroyal\\.gradle\\caches\\modules-2\\files-2.1\\com.alibaba\\fastjson\\1.2.24\\a2b82688715ee16d874d90229d204daf3efcac8e\\fastjson-1.2.24.jar"));
        // 使用指定的目录去完善
        BreakerUtils.completeDatabase(new File("C:\\Users\\leadroyal\\.gradle\\caches\\modules-2\\files-2.1\\"), true);


        // 功能2：输入版本号，输出已知和未知的列表
        BreakerUtils.listDatabase(1242);
        BreakerUtils.listDatabase();

        // 功能3：输入classname，输出被ban情况
        BreakerUtils.isBanned("org.apache.ibatis.datasource.jndi.JndiDataSourceFactory");
    }
}
```

### 如何贡献

- 如果您是maven/gradle用户的话，本地会缓存很多jar包，可以使用扫目录的方式把所有的代码都扫一遍，很方便，可能会扫出有用的东西

- 直接修改src/java/com/leadroyal/breaker/data代码，并且修改readme，提交pull request就行。

### 目前的列表

| version | hash | hex-hash | name |
|---|---|---|---|
| 1.2.42 | -8720046426850100497 | 0x86fc2bf9beaf7aefL | org.apache.commons.collections4.comparators |
| 1.2.42 | -8109300701639721088 | 0x8f75f9fa0df03f80L | org.python.core |
| 1.2.42 | -7966123100503199569 | 0x9172a53f157930afL | org.apache.tomcat |
| 1.2.42 | -7766605818834748097 | 0x9437792831df7d3fL | org.apache.xalan |
| 1.2.42 | -6835437086156813536 | 0xa123a62f93178b20L | javax.xml |
| 1.2.42 | -4837536971810737970 | 0xbcdd9dc12766f0ceL | org.springframework. |
| 1.2.42 | -4082057040235125754 | 0xc7599ebfe3e72406L | org.apache.commons.beanutils |
| 1.2.42 | -2364987994247679115 | 0xdf2ddff310cdb375L | org.apache.commons.collections.Transformer |
| 1.2.42 | -1872417015366588117 | 0xe603d6a51fad692bL | org.codehaus.groovy.runtime |
| 1.2.42 | -254670111376247151 | 0xfc773ae20c827691L  | java.lang.Thread |
| 1.2.42 | -190281065685395680 | 0xfd5bfc610056d720L  | javax.net. |
| 1.2.42 | 313864100207897507 | 0x45b11bc78a3aba3L  | com.mchange |
| 1.2.42 | 1203232727967308606 | 0x10b2bdca849d9b3eL | org.apache.wicket.util |
| 1.2.42 | 1502845958873959152 | 0x14db2e6fead04af0L  | java.util.jar. |
| 1.2.42 | 3547627781654598988 | 0x313bb4abd8d4554cL | org.mozilla.javascript |
| 1.2.42 | 3730752432285826863 | 0x33c64b921f523f2fL | java.rmi |
| 1.2.42 | 3794316665763266033 | 0x34a81ee78429fdf1L  | java.util.prefs. |
| 1.2.42 | 4147696707147271408 | 0x398f942e01920cf0L | com.sun. |
| 1.2.42 | 5347909877633654828 | 0x4a3797b30328202cL | java.util.logging. |
| 1.2.42 | 5450448828334921485 | 0x4ba3e254e758d70dL | org.apache.bcel |
| 1.2.42 | 5751393439502795295 | 0x4fd10ddc6d13821fL | java.net.Socket |
| 1.2.42 | 5944107969236155580 | 0x527db6b46ce3bcbcL | org.apache.commons.fileupload |
| 1.2.42 | 6742705432718011780 | 0x5d92e6ddde40ed84L | org.jboss |
| 1.2.42 | 7179336928365889465 | 0x63a220e60a17c7b9L | org.hibernate |
| 1.2.42 | 7442624256860549330 | 0x6749835432e0f0d2L | org.apache.commons.collections.functors |
| 1.2.42 | 8838294710098435315 | 0x7aa7ee3627a19cf3L | org.apache.myfaces.context.servlet |
| 1.2.43 | -2262244760619952081 | 0xe09ae4604842582fL | java.net.URL |
| 1.2.46 | -8165637398350707645 | 0x8eadd40cb2a94443L | junit. |
| 1.2.46 | -8083514888460375884 | 0x8fd1960988bce8b4L | org.apache.ibatis.datasource |
| 1.2.46 | -7921218830998286408 | 0x92122d710e364fb8L | org.osjava.sj. |
| 1.2.46 | -7768608037458185275 | 0x94305c26580f73c5L | org.apache.log4j. |
| 1.2.46 | -6179589609550493385 | 0xaa3daffdb10c4937L | org.logicalcobwebs. |
| 1.2.46 | -5194641081268104286 | 0xb7e8ed757f5d13a2L | org.apache.logging. |
| 1.2.46 | -3935185854875733362 | 0xc963695082fd728eL | org.apache.commons.dbcp |
| 1.2.46 | -2753427844400776271 | 0xd9c9dbf6bbd27bb1L | com.ibatis.sqlmap.engine.datasource |
| 1.2.46 | -1589194880214235129 | 0xe9f20bad25f60807L | org.jdom. |
| 1.2.46 | 1073634739308289776 | 0xee6511b66fd5ef0L | org.slf4j. |
| 1.2.46 | 5688200883751798389 | 0x4ef08c90ff16c675L | javassist. |
| 1.2.46 | 7017492163108594270 | 0x616323f12c2ce25eL | oracle.net |
| 1.2.46 | 8389032537095247355 | 0x746bd4a53ec195fbL | org.jaxen. |
| 1.2.48 | 1459860845934817624 | 0x144277b467723158L | java.net.InetAddress |
| 1.2.48 | 8409640769019589119 | 0x74b50bb9260e31ffL | java.lang.Class |
| 1.2.49 | 4904007817188630457 | 0x440e89208f445fb9L | com.alibaba.fastjson.annotation |
| 1.2.59 | 5100336081510080343 | 0x46c808a4b5841f57L | org.apache.cxf.jaxrs.provider. |
| 1.2.59 | 6456855723474196908 | 0x599b5c1213a099acL | ch.qos.logback. |
| 1.2.59 | 8537233257283452655 | 0x767a586a5107feefL | net.sf.ehcache.transaction.manager. |
| 1.2.60 | 3688179072722109200 | 0x332f0b5369a18310L | com.zaxxer.hikari. |
| 1.2.61 | -4401390804044377335 | 0xc2eb1e621f439309L | flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor |
| 1.2.61 | -1650485814983027158 | 0xe9184be55b1d962aL | org.apache.openjpa.ee. |
| 1.2.61 | -1251419154176620831 | 0xeea210e8da2ec6e1L | oracle.jdbc.rowset.OracleJDBCRowSet |
| 1.2.61 | -9822483067882491 | 0xffdd1a80f1ed3405L | com.mysql.cj.jdbc.admin. |
| 1.2.61 | 99147092142056280 | 0x1603dc147a3e358L | oracle.jdbc.connector.OracleManagedConnectionFactory |
| 1.2.61 | 3114862868117605599 | 0x2b3a37467a344cdfL | org.apache.ibatis.parsing. |
| 1.2.61 | 4814658433570175913 | 0x42d11a560fc9fba9L | org.apache.axis2.jaxws.spi.handler. |
| 1.2.61 | 6511035576063254270 | 0x5a5bd85c072e5efeL | jodd.db.connection. |
| 1.2.61 | 8925522461579647174 | 0x7bddd363ad3998c6L | org.apache.commons.configuration.JNDIConfiguration |



### 目前未知的列表

| version | hash | hex-hash | name |
|---|---|---|
| 1.2.42 | 0x761619136cc13eL | 33238344207745342    |  |

### 感谢补充

- @UUUUnotfound [https://github.com/LeadroyaL/fastjson-blacklist/issues/1](https://github.com/LeadroyaL/fastjson-blacklist/issues/1)
- @nanolikeyou [https://github.com/LeadroyaL/fastjson-blacklist/pull/2](https://github.com/LeadroyaL/fastjson-blacklist/pull/2)
- @nanolikeyou [https://github.com/LeadroyaL/fastjson-blacklist/issues/3](https://github.com/LeadroyaL/fastjson-blacklist/issues/3)