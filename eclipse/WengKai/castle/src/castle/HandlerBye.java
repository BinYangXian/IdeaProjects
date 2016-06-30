package castle;

/**
 * Created by fangc on 2016/1/21.
 */
public class HandlerBye extends Handler {
    public HandlerBye(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        System.out.println("感谢您的光临。再见！");
    }

    @Override
    public boolean isBye() {
        return true;
    }
}
