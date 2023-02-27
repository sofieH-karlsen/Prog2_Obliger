package sofiehk.oblig.javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;


public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
                    config.staticFiles.enableWebjars();
                    config.vue.vueAppName = "app";
                }).
                start();
        app.get("/", new VueComponent("hello-world"));



    }
}
