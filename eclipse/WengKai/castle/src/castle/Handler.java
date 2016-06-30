package castle;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by fangc on 2016/1/21.
 */
public class Handler {
    protected Game game;
    public void doCmd(String word){

    }
    public boolean isBye(){
    return false;
    }
    public Handler(Game game){
        this.game=game;
    } //注意这里this.game的设计！！！！！！！！！！！！！！！！
}
