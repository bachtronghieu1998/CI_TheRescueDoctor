package bases;

public class FrameCounter {
    public int count = 0;
    public int limit;
    public boolean expired ;

    public FrameCounter(int limit){
        this.limit = limit;
        this.count = 0;
        this.expired = false;
    }

    public void run(){
        if (count>=limit){
            expired = true;
        }else {
            count++;
        }
    }

    public void reset(){
        count = 0;
        expired = false;
    }
}
