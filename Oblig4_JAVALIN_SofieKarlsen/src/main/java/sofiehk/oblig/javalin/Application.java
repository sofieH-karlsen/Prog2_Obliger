package sofiehk.oblig.javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import sofiehk.oblig.javalin.controller.TvSerieController;
import sofiehk.oblig.javalin.repo.TvSerieDataRepository;


public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(2509);


        app.get("/", new VueComponent("hello-world"));

        app.get("/tvserie",new VueComponent("tvserie-overview"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}",new VueComponent("tvserie-detail"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}",new VueComponent("episode-detail"));

        TvSerieDataRepository tvSerieRepository = new TvSerieDataRepository();
        TvSerieController tvSerieController = new TvSerieController(tvSerieRepository);

        app.get("/api/tvserie", new Handler() {
            @Override
            public void handle(Context context) {
                tvSerieController.getAlleTvSerier(context);
            }
        });

        app.get("/api/tvserie/{tvserie-id}", new Handler() {
            @Override
            public void handle(Context context){
                tvSerieController.getTvSerie(context);
            }
        });

        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}", new Handler() {
            @Override
            public void handle(Context context){
                tvSerieController.getEpisoderISesong(context);
            }
        });

        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new Handler() {
            @Override
            public void handle(Context context){
                tvSerieController.getEpisode(context);
            }
        });
    }
}
