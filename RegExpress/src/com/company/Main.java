package com.company;

import sun.rmi.runtime.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //简单认识正则表达式的概念
//       p("abc".matches("..."));  //true
//        p("a51356a".replace("\\d","-")); //a----a
//        Pattern p=Pattern.compile("[a-z](3)"); //匹配三个都是a-z的字符的字符串（这里就先compile一次，比最后一起编译的匹配速度更快）
////        Matcher m=p.m("fda");//匹配字符串后的结果保留在m里。
////        p(m.matches());//打印出匹配的结果。
//        p("fda".matches("[a-z](3)")); //上边三句话可以合为一句，但速度较低 简单粗暴。
//
//        //初步认识metadata  . * + ？   等等这些都是正则表示中的特殊元字符，需要使用反斜杠修饰，
//        // 而在java中又需再加一个反斜杠修饰反斜杠。
//
//        p("214523145234532".matches("\\d{3,100}"));//数字有 3-100个
//        p("192".matches("[0-2][0-9][0-9]"));//true
//        p("".matches("a?"));//0宽度匹配//t
//        p("aaaa".matches("a*"));//0宽度匹配//t
//        p("aaaa".matches("a+"));//t
//        p("a".matches("a?"));//t
//
//        //范围
//        p("a".matches("[abc]"));//取中括号内的一个字符来比较//t
//        p("a".matches("[^abc]"));//取除了中括号内的三个字母之外的字母来比较；不匹配//f
//        p("A".matches("[a-zA-Z]"));//取中括号内由范围规定的字母来比较//t
//        p("A".matches("[a-z]|[A-Z]"));//取中括号内由范围规定的字母来比较//t
//        p("A".matches("[a-z[A-Z]]"));//取中括号内由范围规定的字母来比较//t
//        p("R".matches("[A-Z&&[RFG]]"));//取中括号内由范围规定的字母来比较（需要同时为RFG之一）//t
//
//        //认识 \s \w \d \
//        p("\\".matches("\\\\")); //匹配一个反斜杠的方法//t
//        p(" \n\r\t".matches("\\s(4)"));//匹配四个空字符//f
//        p(" ".matches("\\S"));//f
//        p("a_8".matches("\\w(3)"));//f
//        p("abc888&^%".matches("[a-z](1,3)\\d+[&#^%]+"));//f

//       Pattern p1 = Pattern.compile("\\d{3,5}");
//        String s = "123-34345-234-00";
//        Matcher m1 = p1.matcher(s);
////        p(m1.matches());//尝试用m1模板匹配整个字符串，如果成功则为true，此处分析到第四个字符后发现不匹配，
//// 下述的匹配会从第五个字符开始（如果不重启匹配器的话）//f。
////        m1.reset(); //此话对输出有大影响，将匹配器重置
////        p(m1.find());//t
////        p(m1.find());//t
////        p(m1.find());//t
////        p(m1.find());//f

//        p(m1.lookingAt());
//        p(m1.lookingAt());
//        p(m1.lookingAt());
//        p(m1.lookingAt());

/*        Pattern pat = Pattern.compile("\\[(\\d\\d):(\\d\\d)\\.(\\d\\d)\\]");
        Matcher matcher1 = pat.matcher("[00:05.75]Vae(许嵩)&何曼婷-素颜");
        StringBuffer buf = new StringBuffer();
        Pattern pattern = Pattern.compile("\\d\\d");
        if (matcher1.find()) {
            Matcher matcher = pattern.matcher(matcher1.group());//用"\\d\\d"模板匹配模板"\\[(\\d\\d):(\\d\\d)\\.(\\d\\d)\\]"的->
            // 格式化字符串形式。
            while (matcher.find()) {
                p(matcher.group());
            }
            matcher1.replaceFirst("");
        }
        matcher1.appendTail(buf);
        p(buf);*/
        //POSIX style(unix操作系统的一套标准风格，译为可移植操作系统标准，用的并不多)//

        //boundary 边界匹配 \b  指空格/换行字符/各种特殊字符
//        p("hello sir".matches("^h.*"));
//        p("hello sir".matches(".*ir$"));
//        p("hello sir".matches("^h.[a-z]{1,3}o\\b.*"));
//        p("hellosir".matches("^h.[a-z]{1,3}o\\b.*"));


        //replacement
/*        Pattern p=Pattern.compile("java",Pattern.CASE_INSENSITIVE);//参数二是忽略大小写
        Matcher m=p.matcher("java Java JAVa jaVa IloveJAVa you hateJavA jaVa asd");
        StringBuffer buf=new StringBuffer();
        int i=0;
        while (m.find()){
//            p(m.group());//每次找到匹配子串后打印出来
            i++;
            if (i%2==0){
                m.appendReplacement(buf,"java");//偶数时候替换为小写
            }else {
                m.appendReplacement(buf,"JAVA");//奇数时候替换为大写
            }
        }
        m.appendTail(buf);//添加上尾部未能find到java的子串。
        p(buf);*/

//        Pattern overallPattern = Pattern.compile("\\[\\d+\\.\\d+:\\d+\\.\\d+:\\d+\\.\\d+:\\]");
//        String s1 = "[1.0:52.123465453:332.245345321:]";
//        Matcher matcher = overallPattern.matcher(s1);
//        Pattern pattern = Pattern.compile("(\\d+.\\d+)(:)");
//        StringBuffer buf = new StringBuffer();
//        if (matcher.find()) {
//            Matcher littleMatcher = pattern.matcher(matcher.group());
//            int tempIndex=0;
//            double latitude = 0,longitude = 0,socketIndex = 0;
//            while (littleMatcher.find()){
//                switch (tempIndex){
//                    case 0:socketIndex=Double.parseDouble(littleMatcher.group(1));
//                        break;
//                    case 1:latitude=Double.parseDouble(littleMatcher.group(1));
//                        break;
//                    case 2:longitude=Double.parseDouble(littleMatcher.group(1));
//                        break;
//                }
//                tempIndex++;
//            }
//            System.out.println(socketIndex+" "+latitude+" "+longitude);
//        }

        Pattern overallPattern = Pattern.compile("\\[\\d+\\.\\d+:\\d+\\.\\d+:\\d+\\.\\d+:[-]?\\d+\\.\\d+:\\]");
            String otherLocateData = "[1.232562:52.123465453:332.245345321:-1.0:]";//测试用
        Matcher matcher = overallPattern.matcher(otherLocateData);
        Pattern pattern = Pattern.compile("([-]?\\d+[.]?\\d{0,20})(:)");
        if (matcher.find()) {
            Matcher littleMatcher = pattern.matcher(matcher.group());
            int tempIndex = 0;
            double latitude = 0, longitude = 0,direction=0,socketIndex = 0;

            while (littleMatcher.find()) {
                switch (tempIndex) {
                    case 0:
                        socketIndex = Double.parseDouble(littleMatcher.group(1));
                        break;
                    case 1:
                        latitude = Double.parseDouble(littleMatcher.group(1));
                        break;
                    case 2:
                        longitude = Double.parseDouble(littleMatcher.group(1));
                        break;
                    case 3:
                        direction = Double.parseDouble(littleMatcher.group(1));
                        break;
                }
                tempIndex++;
            }
//                //准备 marker 的图片
//                bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_openmap_focuse_mark);
            System.out.println("收到的其它客户端"+socketIndex + "：" + latitude + " " + longitude+ " " + direction);
        }

        //group
/*        Pattern p=Pattern.compile("(\\d{3,5})([a-z]{2})");//一对小括号表示一组，第一个左小括号对应第一个分组，
        // 依次类推。
        String s="123AA-64644bb-123cc-00";
        Matcher m=p.matcher(s);
        while (m.find()){
            p(m.group(1));//参数表示所在分组，没有参数表示整个分组。
//            p(m.group(2));//参数表示所在分组，没有参数表示整个分组。
//            p(m.group());//参数表示所在分组，没有参数表示整个分组。
        }*/
//        String fileName="asdmp3jfj.mp3";
//        Pattern pat = Pattern.compile("\\.mp3$");
//        StringBuffer buf=new StringBuffer();
//        Matcher match = pat.matcher(fileName);
//        if (match.find()) {
//           match.appendReplacement(buf,".lrc");
//            p(buf);
//            fileName= String.valueOf(buf);
//            p(fileName);
//        }
/*        Pattern pat = Pattern.compile("\\[(\\d\\d):(\\d\\d)\\.(\\d\\d)\\]");
        Matcher match = pat.matcher("[01:05.75]Vae(许嵩)&何曼婷-素颜");
        Pattern pattern = Pattern.compile("\\d\\d");
        StringBuffer buf = new StringBuffer();
        if (match.find()) {
            Matcher matcher = pattern.matcher(match.group());
            String str = "";
            int keyTime = 0;
            int temp = 1;
            while (matcher.find()) {
                System.out.println((matcher.group()));
                switch (temp) {
                    case 1:
                        keyTime=Integer.parseInt(matcher.group())*60*1000;
                        break;
                    case 2:
                        keyTime+=Integer.parseInt(matcher.group())*1000;
                        break;
                    case 3:
                        keyTime+=Integer.parseInt(matcher.group())*10;
                        break;
                }
                temp++;
            }
            match.replaceFirst("");//去掉时间标记
            str = String.valueOf(match.appendTail(buf));//留下歌词正文内容
            System.out.println(String.valueOf(keyTime)+"--"+str);
        }*/
    }

    private static void p(Object o) {//为了输入简便
        System.out.println(o);
    }

}
