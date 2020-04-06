package prog.com.ua;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args)  {
       try{
        TextContainer container = new TextContainer();
        Class<?> ss = container.getclass();

        SaveTo aaSaveTo = ss.getAnnotations(SaveTo.class));
        String path = aaSaveTo.path();

        Method[] methods = ss.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotation(Saver.class)) {
                method.invoke(container, aaSaveTo.path);

            }
        }

       } catch(IllegalAccessException|InvocationTargetException e) {
           e.printStackTrace();
       }

    }

}
