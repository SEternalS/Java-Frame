package Frame.FrameUser;

import javax.swing.*;
import java.awt.*;

public class Frameter{

    private static Frameter frameter;

    public CenterFunction cf;
    public DataJpanel data_jpanel;
    private JFrame frame=new JFrame();

    public static Frameter GetInstance() {
        if (frameter == null)
            frameter = new Frameter();
        return frameter;
    }

    /**
     * 主界面构造函数
     */
    private Frameter(){

        frame.setTitle("陕西波特兰在线测厚系统");
        frame.setDefaultCloseOperation(3);
        frame.setBounds(130,20,1300,800);
        int fraWidth = frame.getWidth();
        int fraHeight = frame.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height-30;
        frame.setSize(screenWidth, screenHeight);
        frame.setLocation(0, 0);
        float proportionW = (float) screenWidth / fraWidth;
        float proportionH = (float) screenHeight / fraHeight;
        FrameShow.modifyComponentSize(frame, proportionW, proportionH);
        frame.toFront();
        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());


        //创建自建的工具条类的对像
        Toolbar tb=new Toolbar();
        frame.add(tb.toolbar,new GBC(0,0,20,1).setFill(GBC.BOTH).setWeight(100,0));

        //创建自建的数据界面类的对像
        data_jpanel=new DataJpanel();
        frame.add(data_jpanel.mainpanel,new GBC(0,1,20,3).setFill(GBC.BOTH).setWeight(100,20));

        //创建自建的南部按钮类的对像
        SouthButton sbn=new SouthButton();
        frame.add(sbn.panel,new GBC(0,11,20,4).setFill(GBC.BOTH).setWeight(100,10));

        //创建自建的中心功能类的对像
        cf=new CenterFunction();
        frame.add(cf.cardpanel,new GBC(0,4,20,7).setFill(GBC.BOTH).setWeight(100,100));
    }

    /////能量计数值,厚度值接口/////
    public boolean ChangePercision(int[] data){

        String[] str=new String[2];
        str[0]=String.valueOf(data[0]);
        str[1]=String.valueOf(data[1]);
        data_jpanel.data_first[1].setText(str[0]);
        data_jpanel.thick_data.setText(str[1]);
        return true;
    }
}

class FrameShow{

    public static void modifyComponentSize(JFrame frame,float proportionW,float proportionH){
        try {
            Component[] components = frame.getRootPane().getContentPane().getComponents();
            for (Component co : components) {
                float locX = co.getX() * proportionW;
                float locY = co.getY() * proportionH;
                float width = co.getWidth() * proportionW;
                float height = co.getHeight() * proportionH;
                co.setLocation((int) locX, (int) locY);
                co.setSize((int) width, (int) height);
                int size = (int) (co.getFont().getSize() * proportionH);
                Font font = new Font(co.getFont().getFontName(), co.getFont().getStyle(), size);
                co.setFont(font);
            }
        }
        catch (Exception e)
        {

        }
    }
}

