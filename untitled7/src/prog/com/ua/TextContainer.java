package prog.com.ua;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(value = RetentionPolicy.RUNTIME)
@interface SaveTo {
    String path();
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface Saver {


    @SaveTo(path = "c:\\file.txt")
    public String text = "Hello";


    @Saver
    public class TextContainer {
        public static void save(String path) {
            try {
                FileWriter wr = new FileWriter("file.txt");
                wr.write(text);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}


