# spring-handler
spring自定义handler demo

# 时序图
- springcontext 读取 context.xml
- context.xml 加载 xsd文件
- xsd文件默认在META-INF目录下
- 读取spring.schemas
- 读取spring.handlers
- 根据名字加载自定义的handler

# 要点
实现自定义的名字空间handler
```$xslt

public class MyNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}
```

实现解析器
```$xslt
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    protected Class getBeanClass(Element element){
        return User.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");

        if (StringUtils.hasText(userName)) {
            bean.addPropertyValue("userName", userName);
        }
        if (StringUtils.hasText(email)) {
            bean.addPropertyValue("email", email);
        }
    }
}

```

spring.handlers在META-INF目录下，内容为：
```$xslt
http\://www.jpnie.com/schema/user=com.jpnie.demo.bean.MyNamespaceHandler
```

spring.schemas在META-INF目录下，内容为：
```$xslt
http\://www.jpnie.com/schema/user.xsd=META-INF/spring-user.xsd
```

# 坑
spring.handlers不能有空格，否则会报classnotfound异常。