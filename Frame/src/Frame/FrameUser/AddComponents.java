package Frame.FrameUser;

import javax.swing.*;
import java.awt.*;

public class AddComponents {

    Setfont sf=new Setfont();
    private JPanel panel;

    /**
     *系统设置的左侧面板以panel为一单元的部件的创建函数
     */
    public JPanel CreateComponents(JTextField text,String str1,String str2){

        panel=new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.setBackground(null);
        panel.setOpaque(false);
        JLabel label1=new JLabel(str1);
        label1.setFont(sf.font1);
        JLabel label2=new JLabel(str2);
        label2.setFont(sf.font2);
        text.setFont(sf.font3);

        panel.add(label1);
        panel.add(text);
        panel.add(label2);
        return panel;
    }


    /**
     * 中心功能面板单元创建函数
     */
    public JLabel CreateCenterFunction(JLabel label,String str){

        label.setText("     "+str);
        label.setFont(sf.font4);
        label.setEnabled(true);
        return label;
    }

    /**
     * 主界面南部区域按钮单元创建函数
     */
    public JPanel CreateSouthButton(JButton bt,String str1,String str2){

        panel=new JPanel();
        panel.setLayout(new GridLayout(2,1));
        bt.setText(str1);
        bt.setFont(sf.font3);
        JLabel label=new JLabel(str2,JLabel.CENTER);
        label.setFont(sf.font2);
        bt.setBorderPainted(false);
        panel.add(bt);
        panel.add(label);
        return panel;
    }
}

