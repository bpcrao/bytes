package org.rest.bytes;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/resty")
public class WSApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public WSApplication() {
        singletons.add(new Library());
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(Library.class);
        return classes;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
