package Frame.FrameUser;

import java.awt.*;

/**
 * 字体参数类1   1
 */
public class Setfont {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height-30;
    float size1=20+((float) screenWidth*(float) screenHeight)/(1300 * 800);
    float size2=13+((float) screenWidth*(float) screenHeight)/(1300 * 800);
    float size3=15+((float) screenWidth*(float) screenHeight)/(1300 * 800);
    float size4=25+((float) screenWidth*(float) screenHeight)/(1300 * 800);
    float size5=28+((float) screenWidth*(float) screenHeight)/(1300 * 800);
    public Font font1=new Font("楷体",1,(int)size1);
    public Font font2=new Font("微软雅黑",1,(int)size2);
    public Font font3=new Font("微软雅黑",1,(int)size3);
    public Font font4=new Font("微软雅黑", 0, (int)size4);
    public Font font5=new Font("楷体",1,(int)size5);
}