package sofiehk.oblig.javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import sofiehk.oblig.javalin.controller.EpisodeController;
import sofiehk.oblig.javalin.controller.TvSerieController;
import sofiehk.oblig.javalin.repo.TvSerieCSVRepository;
import sofiehk.oblig.javalin.repo.TvSerieDataRepository;
import sofiehk.oblig.javalin.repo.TvSerieJSONRepository;


public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(2509);


        app.get("/", new VueComponent("hello-world"));

        app.get("/tvserie",new VueComponent("tvserie-overview"));
        // Endring til vue så bildet endte opp med å se bra ut og ikke være zoomet inn
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}",new VueComponent("tvserie-detail"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}",new VueComponent("episode-detail"));
        // Gjorde noen endringer i vue-filen så episodebeskrivelse ikke endte opp med og både være på siden og undr bildet

        app.get("/tvserie/{tvserie-id}/createepisode",new VueComponent("episode-create"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}/updateepisode",new VueComponent("episode-update"));


        TvSerieJSONRepository tvSerieRepository = new TvSerieJSONRepository();
        TvSerieController tvSerieController = new TvSerieController(tvSerieRepository);
        EpisodeController episodeController = new EpisodeController(tvSerieRepository);

        app.get("/api/tvserie", new Handler() {
            @Override
            public void handle(Context context) throws Exception {
                tvSerieController.getAlleTvSerier(context);
            }
        });

        app.get("/api/tvserie/{tvserie-id}", tvSerieController::getTvSerie);

        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}", episodeController::getEpisoderISesong);

        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", episodeController::getEpisode);

        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}/deleteepisode",episodeController::deleteEpisode);

        app.post("/api/tvserie/{tvserie-id}/createepisode",episodeController::newEpisode);
    }
}
