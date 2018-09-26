package game.maps;

import bases.utils.Utils;
import com.google.gson.Gson;

import java.util.List;

public class Map {
    List<Layer> layers;

    @Override
    public String toString() {
        return "Map{" +
                "Layers=" + layers +
                '}';
    }

    public static Map load(String url) {
        String mapContain = Utils.readTextFile(url);
        Gson gson = new Gson();
        return gson.fromJson(mapContain, Map.class);
    }

    public void generate(){
        if(layers.size()>0){
           Layer layer= layers.get(0);
           layer.generate();
        }
    }
}
