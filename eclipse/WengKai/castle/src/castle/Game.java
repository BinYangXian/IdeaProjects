package castle;

import java.util.*;

public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<>();

    public Game() {
//        handlers.put("go", new HandlerGo(this));//注意这里this的设计！！！！！！！！！！！！！！！！
//        handlers.put("bye", new HandlerBye(this));
//        handlers.put("help", new HandlerHelp(this));
        handlers.put("go", new Handler(this){
            @Override
            public void doCmd(String word) {
                game.goRoom(word);
            }
        });
        handlers.put("bye", new Handler(this){
            @Override
            public void doCmd(String word) {
                System.out.println("感谢您的光临。再见！");
            }

            @Override
            public boolean isBye() {
                return true;
            }
        });
        handlers.put("help", new Handler(this){
            @Override
            public void doCmd(String word) {
                System.out.print("迷路了吗？你可以做的命令有：go bye help");
                System.out.println("如：\tgo east");
            }
        });
        createRooms();
    }

    private void paly() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);//将容器中的key值对应的Handler实例赋值给handler，如key值无对应Handler实例，handler指向为空
            String value = "";
            if (words.length > 1) {   //当words数组有一个字符串以上，让value等于第二个输入的字符串
                value = words[1];
            }
            if (handler != null) {   //如果handler指向不为空，则执行value对应的函数
                handler.doCmd(value);
                if (handler.isBye())  //注意上下的这三句的顺序
                    break;
            }
        }
        in.close();
    }

    private void createRooms() {
        //	设定有什么房子
        Room outside , lobby , pub , study , bedroom ;
        outside = new Room("城堡外");
        lobby = new Room("大堂");//(Room) it.next();
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        HashSet<Room> anyRoom=new HashSet<>();
//        anyRoom.add(outside);
//        anyRoom.add(lobby);
//        anyRoom.add(pub);
//        anyRoom.add(study);
//        anyRoom.add(bedroom);
//        Iterator it = anyRoom.iterator();

        //	初始化房间的出口（布局），由房子建造者来决定具体房子哪个方向有什么房子
        outside.setExit("east", lobby);
                outside.setExit("south", study);
                      outside.setExit("west", pub);
        lobby.setExit("west", outside);
                      pub.setExit("south", outside);
                study.setExit("west", outside);
                            study.setExit("south", bedroom);
                            bedroom.setExit("west", study);
                                        lobby.setExit("up", pub);
                                        pub.setExit("down", lobby);
        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    // 以下为用户命令

    protected void goRoom(String direction) {
        if (currentRoom.getExit(direction) == null) {
            System.out.println("那里没有门！");
        } else {
            currentRoom = currentRoom.getExit(direction);
            showPrompt();
        }
    }

    private void showPrompt() {
        System.out.println("你在" + currentRoom);
        System.out.print("出口有: ");
        System.out.println(currentRoom.getExitDesc());
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printWelcome();
        game.paly();
    }
}
