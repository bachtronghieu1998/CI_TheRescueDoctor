package bases.scenes;

public class SceneManager {
    static public Scene currentScene;
    static Scene nextScene;
    public static void changeScene(Scene newScene){
        nextScene=newScene;

    }

    public static void changeSceneIfNeeded() {
        if(nextScene!=null){
            if(currentScene!=null){
                currentScene.denit();

            }
            nextScene.init();
            currentScene=nextScene;
            nextScene=null;
        }
    }
}

