package Frame.FrameUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.*;

public class SouthButton {

    public JPanel panel;

    private String[] str1= {"扫描运行(F1)","定点运行(F2)","停止运行(F3)","正向泊车(F4)",
            "反向泊车(F5)","动态温修(F8)","异常处理(F10)"};
    private String[] str2= {"(Scan Operation)","(Position Operation)","(Stop)","(Forward Direction)",
            "(Reverse Direction)","(Scan Correction)","(Exception Handle)"};
    private JLabel label;
    private JButton[] bt=new JButton[7];
    AddComponents acs=new AddComponents();

    /**
     * 创建主界面南部区域按钮的构造函数
     */
    public SouthButton() {

        panel=new JPanel(new GridLayout(1,7));
        panel.setBackground(null);
        panel.setOpaque(false);


        for(int i=0;i<7;i++)
        {
            bt[i]=new JButton();
            panel.add(acs.CreateSouthButton(bt[i],str1[i],str2[i]));
        }
        /*for(int i=0;i<7;i++)
        {
            final int j=i;
            bt[i]=new JButton(str1[i]){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon ico=new ImageIcon("png/图片"+j+".png");
                    g.drawImage(ico.getImage(),0,0,getSize().width,getSize().height,bt[j]);
                }
            };
            bt[i].setBorderPainted(false);
            panel.add(bt[i]);

            Keyhandler key=new Keyhandler();
            bt[i].addActionListener(key);
        }

        for(int i=0;i<7;i++)
        {
            final int k=i;
            label=new JLabel(str2[i],JLabel.CENTER){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon ico=new ImageIcon("png/图"+k+".png");
                    g.drawImage(ico.getImage(),0,0,getSize().width,getSize().height,bt[k]);
                }
            };
            label.setFont(new Font("楷体",1,15));
            label.setForeground(Color.WHITE);
            panel.add(label);
        }*/
    }

    //用于添加监听器，暂时没有可用代码
    class Keyhandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String input=e.getActionCommand();
            //text.setText(input);
        }
    }
}
