import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.Javalin;
import io.javalin.plugin.json.JavalinJson;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Javalin app = initJavalin();
        app.get("/", ctx -> ctx.result("Hello World"));
        app.post("/cloudrecording", ctx -> {
//            AgoraCallback ac = new Gson().fromJson(ctx.body(),AgoraCallback.class);
            writeToLogFile(ctx.body());
            ctx.status(201);
        });
    }

    private static Javalin initJavalin() {
        Javalin app = Javalin.create().start(7000);
        Gson gson = new GsonBuilder().create();
        JavalinJson.setFromJsonMapper(gson::fromJson);
        JavalinJson.setToJsonMapper(gson::toJson);
        return  app;
    }

    private static void writeToLogFile(String content) {
        try {
            KotlinHelperKt.writeToFile(content,"/tmp/agoraCloudRecording.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
