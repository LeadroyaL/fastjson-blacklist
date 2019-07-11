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

| version | hash | name |
|---|---|---|
| 1.2.42 | -8720046426850100497 | org.apache.commons.collections4.comparators |
| 1.2.42 | -8109300701639721088 | org.python.core |
| 1.2.42 | -7966123100503199569 | org.apache.tomcat |
| 1.2.42 | -7766605818834748097 | org.apache.xalan |
| 1.2.42 | -6835437086156813536 | javax.xml |
| 1.2.42 | -4837536971810737970 | org.springframework. |
| 1.2.42 | -4082057040235125754 | org.apache.commons.beanutils |
| 1.2.42 | -2364987994247679115 | org.apache.commons.collections.Transformer |
| 1.2.42 | -1872417015366588117 | org.codehaus.groovy.runtime |
| 1.2.42 | -254670111376247151  | java.lang.Thread |
| 1.2.42 | -190281065685395680  | javax.net. |
| 1.2.42 | 313864100207897507  | com.mchange |
| 1.2.42 | 1203232727967308606 | org.apache.wicket.util |
| 1.2.42 | 1502845958873959152  | java.util.jar. |
| 1.2.42 | 3547627781654598988 | org.mozilla.javascript |
| 1.2.42 | 3730752432285826863 | java.rmi |
| 1.2.42 | 3794316665763266033  | java.util.prefs. |
| 1.2.42 | 4147696707147271408 | com.sun. |
| 1.2.42 | 5347909877633654828 | java.util.logging. |
| 1.2.42 | 5450448828334921485 | org.apache.bcel |
| 1.2.42 | 5751393439502795295 | java.net.Socket |
| 1.2.42 | 5944107969236155580 | org.apache.commons.fileupload |
| 1.2.42 | 6742705432718011780 | org.jboss |
| 1.2.42 | 7179336928365889465 | org.hibernate |
| 1.2.42 | 7442624256860549330 | org.apache.commons.collections.functors |
| 1.2.42 | 8838294710098435315 | org.apache.myfaces.context.servlet |
| 1.2.43 | -2262244760619952081 | java.net.URL |
| 1.2.46 | -8165637398350707645 | junit. |
| 1.2.46 | -8083514888460375884 | org.apache.ibatis.datasource |
| 1.2.46 | -7768608037458185275 | org.apache.log4j. |
| 1.2.46 | -5194641081268104286 | org.apache.logging. |
| 1.2.46 | -3935185854875733362 | org.apache.commons.dbcp |
| 1.2.46 | -1589194880214235129 | org.jdom. |
| 1.2.46 | 1073634739308289776 | org.slf4j. |
| 1.2.46 | 5688200883751798389 | javassist. |
| 1.2.46 | 8389032537095247355 | org.jaxen. |
| 1.2.48 | 1459860845934817624 | java.net.InetAddress |
| 1.2.48 | 8409640769019589119 | java.lang.Class |
| 1.2.49 | 4904007817188630457 | com.alibaba.fastjson.annotation |



### 目前未知的列表

| version | hash | name |
|---|---|---|
| 1.2.42 | 33238344207745342    |  |
| 1.2.46 | -7921218830998286408 |  |
| 1.2.46 | -6179589609550493385 |  |
| 1.2.46 | -2753427844400776271 |  |
| 1.2.46 | 7017492163108594270 |  |
