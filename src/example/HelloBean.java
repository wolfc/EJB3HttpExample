package example;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.jboss.ejb3.annotation.Clustered;

@Clustered
@Stateful(name="Hello")
@Remote(Hello.class)
public class HelloBean implements Hello
{
    public String sayHello()
    {
        return "Hello World!";
    }
}
