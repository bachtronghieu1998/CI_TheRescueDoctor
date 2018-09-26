import bases.utils.Utils;
import com.google.gson.Gson;
import com.sun.media.jfxmedia.MediaError;
import game.GameWindow;
import game.maps.Map;

public class Program {

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.mainLoop();
//        String mapContain=Utils.readTextFile("images/background/tut_lv.json");
//        Gson gson=new Gson();
//      Map map=  gson.fromJson(mapContain, Map.class);
//        System.out.println(map);
    }
}
