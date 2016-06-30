package castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String,Room> exits=new HashMap<>();//存储：房子的哪个方向有什么房子的数据容器,（而不是具体设置房子有东南西北四个方向）
    public void setExit(String dir,Room room){       //存储：设置房子具体哪个方向有什么房子，还是“提取公因式”（而不是具体设置东南西北有没有房子）
        exits.put(dir,room);
    }

    public String getExitDesc() {              //得到当前房子的各个出口
        StringBuffer sb = new StringBuffer();
        for (String dir:exits.keySet()
             ) {
            sb.append(dir);
            sb.append(" ");
        }
        return sb.toString();
    }

    public Room getExit(String description) {  //接收一个方向，返回该方向的房子。现在看起来一句话的方法，似乎可以省略掉这个方法，且慢，我维持getExit这个接口不变，方法内部可以方便以后改变
        return exits.get(description);
    }

    public Room(String description) {   //初始化当前位置信息（当前所在的位置）
        this.description = description;
    }

    @Override
    public String toString() {         //将房子类型的变量转换为字符串类型
        return description;
    }
}
