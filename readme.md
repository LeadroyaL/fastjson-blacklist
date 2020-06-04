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

`fastjson` 在1.2.61开始，在[https://github.com/alibaba/fastjson/commit/d1c0dff9a33d49e6e7b98a4063da01bbc9325a38](https://github.com/alibaba/fastjson/commit/d1c0dff9a33d49e6e7b98a4063da01bbc9325a38)中，把黑名单从十进制数变成了十六进制数，可能是为了防止安全研究者进行搜索，恕我直言有点可笑。

```
        denyHashCodes = new long[]{
-                -8720046426850100497L,
-                -8165637398350707645L,
-                -8109300701639721088L,

+                0x86fc2bf9beaf7aefL,
+                0x8eadd40cb2a94443L,
+                0x8f75f9fa0df03f80L,
```

`fastjson` 在1.2.62开始，[https://github.com/alibaba/fastjson/commit/014444e6c62329ec7878bb6b0c6b28c3f516c54e](https://github.com/alibaba/fastjson/commit/014444e6c62329ec7878bb6b0c6b28c3f516c54e)中，从小写改成了大写，可能是为了规范吧。

本git只记录十进制和小写的十六进制数，不记录大写的十六进制数。

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
| 1.2.62 | -9164606388214699518 | 0x80d0c70bcc2fea02L | org.apache.ibatis.executor. |
| 1.2.62 | -8649961213709896794 | 0x87f52a1b07ea33a6L | net.sf.cglib. |
| 1.2.62 | -6316154655839304624 | 0xa85882ce1044c450L | oracle.net.|
| 1.2.62 | -5764804792063216819 | 0xafff4c95b99a334dL | com.mysql.cj.jdbc.MysqlDataSource |
| 1.2.62 | -4608341446948126581 | 0xc00be1debaf2808bL | jdk.internal. |
| 1.2.62 | -4438775680185074100 | 0xc2664d0958ecfe4cL | aj.org.objectweb.asm. |
| 1.2.62 | -3319207949486691020 | 0xd1efcdf4b3316d34L | oracle.jdbc. |
| 1.2.62 | -2192804397019347313 | 0xe1919804d5bf468fL | org.apache.commons.collections.comparators. |
| 1.2.62 | -2095516571388852610 | 0xe2eb3ac7e56c467eL | net.sf.ehcache.hibernate. |
| 1.2.62 | 4750336058574309 | 0x10e067cd55c5e5L | com.mysql.cj.log. |
| 1.2.62 | 218512992947536312 | 0x3085068cb7201b8L | org.h2.jdbcx. |
| 1.2.62 | 823641066473609950 | 0xb6e292fa5955adeL | org.apache.commons.logging. |
| 1.2.62 | 1534439610567445754 | 0x154b6cb22d294cfaL | org.apache.ibatis.reflection. |
| 1.2.62 | 1818089308493370394 | 0x193b2697eaaed41aL | org.h2.server. |
| 1.2.62 | 2164696723069287854 | 0x1e0a8c3358ff3daeL | org.apache.ibatis.datasource. |
| 1.2.62 | 2653453629929770569 | 0x24d2f6048fef4e49L | org.objectweb.asm. |
| 1.2.62 | 2836431254737891113 | 0x275d0732b877af29L | flex.messaging.util.concurrent. |
| 1.2.62 | 3089451460101527857 | 0x2adfefbbfe29d931L | org.apache.ibatis.javassist. |
| 1.2.62 | 3256258368248066264 | 0x2d308dbbc851b0d8L | java.lang.UNIXProcess |
| 1.2.62 | 3718352661124136681 | 0x339a3e0b6beebee9L | org.apache.ibatis.ognl. |
| 1.2.62 | 4046190361520671643 | 0x3826f4b2380c8b9bL | com.mysql.cj.jdbc.MysqlConnectionPoolDataSource |
| 1.2.62 | 4841947709850912914 | 0x43320dc9d2ae0892L | org.codehaus.jackson. |
| 1.2.62 | 6280357960959217660 | 0x5728504a6d454ffcL | org.apache.ibatis.scripting. |
| 1.2.62 | 6534946468240507089 | 0x5ab0cb3071ab40d1L | org.apache.commons.proxy.|
| 1.2.62 | 6734240326434096246 | 0x5d74d3e5b9370476L | com.mysql.cj.jdbc.MysqlXADataSource |
| 1.2.62 | 7123326897294507060 | 0x62db241274397c34L | org.apache.commons.collections.functors. |
| 1.2.62 | 8488266005336625107 | 0x75cc60f5871d0fd3L | org.apache.commons.configuration |
| 1.2.66 | -2439930098895578154 | 0xde23a0809a8b9bd6L | javax.script. |
| 1.2.66 | -582813228520337988 | 0xf7e96e74dfa58dbcL | javax.sound. |
| 1.2.66 | -26639035867733124 | 0xffa15bf021f1e37cL | javax.print. |
| 1.2.66 | 386461436234701831 | 0x55cfca0f2281c07L | javax.activation. |
| 1.2.66 | 1153291637701043748 | 0x100150a253996624L | javax.tools. |
| 1.2.66 | 1698504441317515818L | 0x17924cca5227622aL | javax.management. |
| 1.2.66 | 7375862386996623731L | 0x665c53c311193973L | org.apache.xbean. |
| 1.2.66 | 7658177784286215602L | 0x6a47501ebb2afdb2L | org.eclipse.jetty. |
| 1.2.66 | 8055461369741094911L | 0x6fcabf6fa54cafffL | javax.naming. |
| 1.2.67 | -7775351613326101303L | 0x941866e73beff4c9L | org.apache.shiro.realm. |
| 1.2.67 | -6025144546313590215L | 0xac6262f52c98aa39L | org.apache.http.conn. |
| 1.2.67 | -5939269048541779808L | 0xad937a449831e8a0L | org.quartz. |
| 1.2.67 | -5885964883385605994L | 0xae50da1fad60a096L | com.taobao.eagleeye.wrapper |
| 1.2.67 | -3975378478825053783L | 0xc8d49e5601e661a9L | org.apache.http.impl. |
| 1.2.67 | -2378990704010641148L | 0xdefc208f237d4104L | com.ibatis. |
| 1.2.67 | -905177026366752536L | 0xf3702a4a5490b8e8L | org.apache.catalina. |
| 1.2.67 | 2660670623866180977L | 0x24ec99d5e7dc5571L | org.apache.http.auth. |
| 1.2.67 | 2731823439467737506L | 0x25e962f1c28f71a2L | br.com.anteros. |
| 1.2.67 | 3637939656440441093L | 0x327c8ed7c8706905L | com.caucho. |
| 1.2.67 | 4254584350247334433L | 0x3b0b51ecbf6db221L | org.apache.http.cookie. |
| 1.2.67 | 5274044858141538265L | 0x49312bdafb0077d9L | org.javasimon. |
| 1.2.67 | 5474268165959054640L | 0x4bf881e49d37f530L | org.apache.cocoon. |
| 1.2.67 | 5596129856135573697L | 0x4da972745feb30c1L | org.apache.activemq.jms.pool. |
| 1.2.67 | 6854854816081053523L | 0x5f215622fb630753L | org.mortbay.jetty. |
| 1.2.68 | -3077205613010077203L | 0xd54b91cc77b239edL | org.apache.shiro.jndi. |
| 1.2.68 | -2825378362173150292L | 0xd8ca3d595e982bacL | org.apache.ignite.cache.jta. |
| 1.2.68 | 2078113382421334967L | 0x1cd6f11c6a358bb7L | javax.swing.J |
| 1.2.68 | 6007332606592876737L | 0x535e552d6f9700c1L | org.aoju.bus.proxy.provider. |
| 1.2.68 | 9140390920032557669L | 0x7ed9311d28bf1a65L | java.awt.p |
| 1.2.68 | 9140416208800006522L | 0x7ed9481d28bf417aL | java.awt.i |
| 1.2.69 | -8024746738719829346L | 0x90a25f5baa21529eL | java.io.Serializable |
| 1.2.69 | -5811778396720452501L | 0xaf586a571e302c6bL | java.io.Closeable |
| 1.2.69 | -3053747177772160511L | 0xd59ee91f0b09ea01L | oracle.jms.AQ |
| 1.2.69 | -2114196234051346931L | 0xe2a8ddba03e69e0dL | java.util.Collection |
| 1.2.69 | -2027296626235911549L | 0xe3dd9875a2dc5283L | java.lang.Iterable |
| 1.2.69 | -2939497380989775398L | 0xd734ceb4c3e9d1daL | java.lang.Object |
| 1.2.69 | -1368967840069965882L | 0xed007300a7b227c6L | java.lang.AutoCloseable |
| 1.2.69 | 2980334044947851925L | 0x295c4605fd1eaa95L | java.lang.Readable |
| 1.2.69 | 3247277300971823414L | 0x2d10a5801b9d6136L | java.lang.Cloneable |
| 1.2.69 | 5183404141909004468L | 0x47ef269aadc650b4L | java.lang.Runnable |
| 1.2.69 | 7222019943667248779L | 0x6439c4dff712ae8bL | java.util.EventListener |
| 1.2.70 | -5076846148177416215L | 0xb98b6b5396932fe9L | org.apache.commons.collections4.Transformer |
| 1.2.70 | -4703320437989596122L | 0xbeba72fb1ccba426L | org.apache.commons.collections4.functors |
| 1.2.70 | -4314457471973557243L | 0xc41ff7c9c87c7c05L | org.jdom2.transform. |
| 1.2.70 | -2533039401923731906L | 0xdcd8d615a6449e3eL | org.apache.hadoop.shaded.com.zaxxer.hikari. |
| 1.2.70 | 156405680656087946L | 0x22baa234c5bfb8aL | com.p6spy.engine. |
| 1.2.70 | 1214780596910349029L | 0x10dbc48446e0dae5L | org.apache.activemq.pool. |
| 1.2.70 | 3085473968517218653L | 0x2ad1ce3a112f015dL | org.apache.aries.transaction. |
| 1.2.70 | 3129395579983849527L | 0x2b6dd8b3229d6837L | org.apache.activemq.ActiveMQConnectionFactory |
| 1.2.70 | 4241163808635564644L | 0x3adba40367f73264L | org.apache.activemq.spring. |
| 1.2.70 | 7240293012336844478L | 0x647ab0224e149ebeL | org.apache.activemq.ActiveMQXAConnectionFactory |
| 1.2.70 | 7347653049056829645L | 0x65f81b84c1d920cdL | org.apache.commons.jelly. |
| 1.2.70 | 7617522210483516279L | 0x69b6e0175084b377L | org.apache.axis2.transport.jms. |

### 目前未知的列表

| version | hash | hex-hash | name |
|---|---|---|---|
| 1.2.42 | 33238344207745342 | 0x761619136cc13eL | |
| 1.2.67 | -831789045734283466L | 0xf474e44518f26736L | |

### 内置白名单

`fastjson`在1.2.67开始，将内置白名单也使用哈希的方式存放。体现在这次commit中 [https://github.com/alibaba/fastjson/commit/84eca8e56003ff6ebad3da19c6d69dcd842dbdf7](https://github.com/alibaba/fastjson/commit/84eca8e56003ff6ebad3da19c6d69dcd842dbdf7)，以下为对照表。

PS: `org.springframework.security.web.savedrequest.DefaultSavedRequest` 在该次commit中从白名单移除。

| hash | name |
|----|-----|
| 0xD4788669A13AE74L | java.awt.Rectangle |
| 0xE08EE874A26F5EAFL | java.awt.Point |
| 0xDDAAA11FECA77B5EL | java.awt.Font |
| 0xB81BA299273D4E6L | java.awt.Color |
| 0xA8AAA929446FFCE4L | com.alibaba.fastjson.util.AntiCollisionHashMap |
| 0xD0E71A6E155603C1L | com.alipay.sofa.rpc.core.exception.SofaTimeOutException |
| 0x9F2E20FB6049A371L | java.util.Collections.UnmodifiableMap |
| 0xD45D6F8C9017FAL | java.util.concurrent.ConcurrentSkipListMap |
| 0x64DC636F343516DCL | java.util.concurrent.ConcurrentSkipListSet |
| 0x7FE2B8E675DA0CEFL | org.springframework.dao.CannotAcquireLockException |
| 0xF8C7EF9B13231FB6L | org.springframework.dao.CannotSerializeTransactionException |
| 0x42646E60EC7E5189L | org.springframework.dao.CleanupFailureDataAccessException |
| 0xCC720543DC5E7090L | org.springframework.dao.ConcurrencyFailureException |
| 0xC0FE32B8DC897DE9L | org.springframework.dao.DataAccessResourceFailureException |
| 0xDC9583F0087CC2C7L | org.springframework.dao.DataIntegrityViolationException |
| 0x5449EC9B0280B9EFL | org.springframework.dao.DataRetrievalFailureException |
| 0xEB7D4786C473368DL | org.springframework.dao.DeadlockLoserDataAccessException |
| 0x44D57A1B1EF53451L | org.springframework.dao.DuplicateKeyException |
| 0xC92D8F9129AF339BL | org.springframework.dao.EmptyResultDataAccessException |
| 0x9DF9341F0C76702L | org.springframework.dao.IncorrectResultSizeDataAccessException |
| 0xDB7BFFC197369352L | org.springframework.dao.IncorrectUpdateSemanticsDataAccessException |
| 0x73FBA1E41C4C3553L | org.springframework.dao.InvalidDataAccessApiUsageException |
| 0x76566C052E83815L | org.springframework.dao.InvalidDataAccessResourceUsageException |
| 0x61D10AF54471E5DEL | org.springframework.dao.NonTransientDataAccessException |
| 0x82E8E13016B73F9EL | org.springframework.dao.NonTransientDataAccessResourceException |
| 0xE794F5F7DCD3AC85L | org.springframework.dao.OptimisticLockingFailureException |
| 0x3F64BC3933A6A2DFL | org.springframework.dao.PermissionDeniedDataAccessException |
| 0x863D2DD1E82B9ED9L | org.springframework.dao.PessimisticLockingFailureException |
| 0x4BB3C59964A2FC50L | org.springframework.dao.QueryTimeoutException |
| 0x552D9FB02FFC9DEFL | org.springframework.dao.RecoverableDataAccessException |
| 0x21082DFBF63FBCC1L | org.springframework.dao.TransientDataAccessException |
| 0x178B0E2DC3AE9FE5L | org.springframework.dao.TransientDataAccessResourceException |
| 0x24AE2D07FB5D7497L | org.springframework.dao.TypeMismatchDataAccessException |
| 0x90003416F28ACD89L | org.springframework.dao.UncategorizedDataAccessException |
| 0x73A0BE903F2BCBF4L | org.springframework.jdbc.BadSqlGrammarException |
| 0x7B606F16A261E1E6L | org.springframework.jdbc.CannotGetJdbcConnectionException |
| 0xAFCB539973CEA3F7L | org.springframework.jdbc.IncorrectResultSetColumnCountException |
| 0x4A39C6C7ACB6AA18L | org.springframework.jdbc.InvalidResultSetAccessException |
| 0x9E404E583F254FD4L | org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException |
| 0x34CC8E52316FA0CBL | org.springframework.jdbc.LobRetrievalFailureException |
| 0xB5114C70135C4538L | org.springframework.jdbc.SQLWarningException |
| 0x7F36112F218143B6L | org.springframework.jdbc.UncategorizedSQLException |
| 0x26C5D923AF21E2E1L | org.springframework.cache.support.NullValue |
| 0xD11D2A941337A7BCL | org.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken |
| 0x4F0C3688E8A18F9FL | org.springframework.security.oauth2.common.DefaultOAuth2AccessToken |
| 0xC59AA84D9A94C640L | org.springframework.security.oauth2.common.DefaultOAuth2RefreshToken |
| 0x1F10A70EE4065963L | org.springframework.util.LinkedMultiValueMap |
| 0x557F642131553498L | org.springframework.util.LinkedCaseInsensitiveMap |
| 0x8B2081CB3A50BD44L | org.springframework.remoting.support.RemoteInvocation |
| 0x8B2081CB3A50BD44L | org.springframework.remoting.support.RemoteInvocation |
| 0x54DC66A59269BAE1L | org.springframework.security.web.savedrequest.SavedCookie |
| 0x111D12921C5466DAL | org.springframework.security.web.csrf.DefaultCsrfToken |
| 0x19DCAF4ADC37D6D4L | org.springframework.security.web.authentication.WebAuthenticationDetails |
| 0x604D6657082C1EE9L | org.springframework.security.core.context.SecurityContextImpl |
| 0xF4AA683928027CDAL | org.springframework.security.authentication.UsernamePasswordAuthenticationToken |
| 0x92F252C398C02946L | org.springframework.security.core.authority.SimpleGrantedAuthority |
| 0x6B949CE6C2FE009L | org.springframework.security.core.userdetails.User |



### 感谢补充

- @UUUUnotfound [https://github.com/LeadroyaL/fastjson-blacklist/issues/1](https://github.com/LeadroyaL/fastjson-blacklist/issues/1)
- @nanolikeyou [https://github.com/LeadroyaL/fastjson-blacklist/pull/2](https://github.com/LeadroyaL/fastjson-blacklist/pull/2)
- @nanolikeyou [https://github.com/LeadroyaL/fastjson-blacklist/issues/3](https://github.com/LeadroyaL/fastjson-blacklist/issues/3)
- @MiliTing [https://github.com/LeadroyaL/fastjson-blacklist/issues/5](https://github.com/LeadroyaL/fastjson-blacklist/issues/5)
- @j1anFen [https://github.com/LeadroyaL/fastjson-blacklist/pull/6](https://github.com/LeadroyaL/fastjson-blacklist/pull/6)
- @Kevin-sa [https://github.com/LeadroyaL/fastjson-blacklist/pull/7](https://github.com/LeadroyaL/fastjson-blacklist/pull/7)
- [https://m.weibo.cn/detail/4505978526222190](https://m.weibo.cn/detail/4505978526222190)
- @Ramos-dev [https://github.com/LeadroyaL/fastjson-blacklist/issues/8](https://github.com/LeadroyaL/fastjson-blacklist/issues/8)
- @Ramos-dev [https://github.com/LeadroyaL/fastjson-blacklist/issues/9](https://github.com/LeadroyaL/fastjson-blacklist/issues/9)