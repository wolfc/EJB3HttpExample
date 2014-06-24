package example;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

public class HelloClient
{

    public static void main(String[] args) throws Exception
    {
        InitialContext ctx = getInitialContext();

        Object obj = ctx.lookup("myHello");

        Hello ejbObject = (Hello) obj;
        System.out.println(ejbObject.sayHello());

    }

    protected static InitialContext getInitialContext() throws NamingException
    {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        env.put(Context.PROVIDER_URL, "localhost:1100,localhost:1200");
        env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(env);
    }

}
