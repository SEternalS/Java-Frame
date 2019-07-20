package Frame.SubInterface;


import javax.swing.*;
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import Frame.DataLibrary.MysqlConnect;
import Frame.FrameUser.GBC;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class SystemSetup {
    /*  *//**
     * test  5-12 16:34
     *//*
    JPanel testjp[]=new JPanel[6];
    JTextField TextField[]=new JTextField[6];

    *//**test  5-12 16:34    弃用2019-5-14
     * 打包左半边组件
     *//*
    private void PackLeftcomponent(JPanel panel,JTextField TextField,String chinaName,String unit,String englishName){
        JLabel label_chinaName=new JLabel(chinaName),label_unit=new JLabel(unit),label_englishName=new JLabel(englishName);
        JPanel Top= new JPanel(),Bottom=new JPanel();

        panel.setLayout(new GridBagLayout());
       *//* panel.add(Top,new GBC(0, 0, 5, 1).setAnchor(GridBagConstraints.NORTH).setFill(GBC.BOTH).setWeight(0,0));
        panel.add(Bottom,new GBC(0, 1, 5, 1).setAnchor(GridBagConstraints.SOUTH).setFill(GBC.BOTH).setWeight(0,0));
       *//* panel.add(label_chinaName,new GBC(0, 0, 2, 1).setWeight(2, 0).setInsets(0,0,0,100).setAnchor(GridBagConstraints.WEST));
        panel.add(TextField,new GBC(2, 0, 2, 1).setWeight(1, 0).setInsets(0,0,0,0).setAnchor(GridBagConstraints.CENTER));
        panel.add(label_unit,new GBC(4, 0, 1, 1).setWeight(1, 0).setInsets(0,0,0,0).setAnchor(GridBagConstraints.EAST));
        panel.add(label_englishName,new GBC(0, 5, 2, 1).setAnchor(GridBagConstraints.NORTH).setFill(GBC.BOTH).setWeight(2, 0));
    }

*/


    public JSplitPane jSplitPane_TB, jSplitPane_LR;
    private JPanel jPanel_Top, jPanel_Bottom, jPanel_Left, jPanel_Right;

    /**
     * 左半部分变量
     */
    private JLabel title;
    private JLabel []    left_Labels=new JLabel[20];
    private JTextField[] left_TextFields=new JTextField[6];
    private JButton[]    left_Buttons=new JButton[2];

    /**
     * 右半部分变量
     */
    private JLabel [] right_Labels =new JLabel[31];
    private JTextField[] right_TextField = new JTextField[12];
    private JButton[] right_Button = new JButton[2];


    public SystemSetup() {
        /*

         */
/**
 * test 5-12 16.38初始化赋值
 *//*

       for(int i=0;i<6;i++){
           testjp[i]=new JPanel();
           TextField[i]=new JTextField(""+i+"_666");
           PackLeftcomponent(testjp[i],TextField[i],""+i+"电机脉冲当量：",""+i+"P/Rev",""+i+"(Motor pulse equivalence)");
       }

*/


        /**
         *   初始化分块后上下左右四个容器
         */
        jPanel_Top = new panel();
        jPanel_Top.setLayout(new GridLayout(1, 1));
        jPanel_Bottom = new panel();
        jPanel_Bottom.setLayout(new GridLayout(1, 1));



        jPanel_Left = new panel();
        jPanel_Left.setLayout( new GridBagLayout());

        jPanel_Right = new panel();
        jPanel_Right.setLayout(new GridBagLayout());


        /**
         * 将卡片三分成3块 ,  上  &   下（左\右）
         */
        jSplitPane_TB = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jPanel_Top, jPanel_Bottom);//上下分割
        jSplitPane_TB.setEnabled(false);
        jSplitPane_TB.setDividerLocation(70);
        jSplitPane_LR = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanel_Left, jPanel_Right);//左右分割
        jSplitPane_LR.setEnabled(false);
        jSplitPane_LR.setDividerLocation(350);
        jPanel_Bottom.add(jSplitPane_LR);

        /**
         *添加标题
         */
        title = new JLabel("系统设置 （System Setup）", JLabel.CENTER);
        title.setFont(new Font("宋体", Font.BOLD, 30));
        jPanel_Top.add(title);


        /**
         * 初始化左侧组件
         */
        for(int i=0;i<20;i++)
        {
            left_Labels[i]=new JLabel();
        }
        for (int i=0;i<2;i++)
        {
            left_Buttons[i]=new JButton();
            left_Buttons[i].addActionListener(new ButtonHandler());
        }
        for(int i=0;i<6;i++)
        {
            left_TextFields[i]=new JTextField();
        }



        /**
         *   添加左边参数
         */
        left_Labels[0].setText(" 电机脉冲当量： ");
        left_Labels[1].setText("P/Rev");
        left_Labels[2].setText("(Motor pulse equivalence)");
        left_Labels[3].setText(" 皮带轮周长： ");
        left_Labels[4].setText("mm");
        left_Labels[5].setText("(Belt perimeter)");
        left_Labels[6].setText(" 回零速度： ");
        left_Labels[7].setText("mm/s");
        left_Labels[8].setText("（Return to parking space speed）");
        left_Labels[9].setText(" 手动速度： ");
        left_Labels[10].setText("mm/s");
        left_Labels[11].setText("（Manual speed）");
        left_Labels[12].setText(" 扫描速度： ");
        left_Labels[13].setText("mm/s");
        left_Labels[14].setText("（Scan speed）");
        left_Labels[15].setText(" 启停位置偏置： ");
        left_Labels[16].setText("mm");
        left_Labels[17].setText("（Rev.stop Location bias）");
        for(int i=0;i<18;i++){
            left_Labels[i].setFont(new Font("黑体",Font.BOLD, 18));
        }
/**
 * /*按钮相关
 *
 * */
        left_Labels[18].setText("(parameter input)");
        left_Labels[19].setText("(parameter display)");
        left_Buttons[0].setText("参数输入");
        left_Buttons[1].setText("参数显示");
        left_Buttons[0].setFont(new Font("黑体",Font.BOLD, 15));
        left_Buttons[1].setFont(new Font("黑体",Font.BOLD,15));
        left_Labels[18].setFont(new Font("黑体",Font.BOLD,17));
        left_Labels[19].setFont(new Font("黑体",Font.BOLD,17));


       /**
         * 从数据库读取左半边文本框内数据（首次使用创建数据库，以后直接加载上次修改过的数据）
         */


            /*Statement sql;
            ResultSet res;
            Connection con=new MysqlConnect().getConnection("test");
            try{
                sql = con.createStatement();
                res = sql.executeQuery("select* from  system_stetup ");
                /**
                 * 从数据库读取配置并显示
                 */
                /*while (res.next()) {
                    String Motor_pulse_equivalen = res.getString("Motor_pulse_equivalen");
                    String Belt_perimeter=res.getString("Belt_perimeter");
                    String Return_to_parking_space_speed=res.getString("Return_to_parking_space_speed");
                    String Manual_speed=res.getString("Manual_speed");
                    String Scan_speed=res.getString("Scan_speed");
                    String Rev_stop_Location_bias=res.getString("Rev_stop_Location_bias");


                    left_TextFields[0].setText(Motor_pulse_equivalen);
                    left_TextFields[1].setText(Belt_perimeter);
                    left_TextFields[2].setText(Return_to_parking_space_speed);
                    left_TextFields[3].setText(Manual_speed);
                    left_TextFields[4].setText(Scan_speed);
                    left_TextFields[5].setText(Rev_stop_Location_bias);

                }
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }*/

        /**
         * 添加组件到左侧jPanel_Left
         */

        //电机脉冲当量
        jPanel_Left.add(left_Labels[0],new GBC(0, 0, 3, 1).setFill(GBC.BOTH).setWeight(0, 0).setInsets(5,0,0,0));
        jPanel_Left.add(left_TextFields[0],new GBC(3, 0, 2, 1).setFill(GBC.BOTH).setWeight(1, 0));
        jPanel_Left.add(left_Labels[1],new GBC(5, 0, 1, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_Labels[2],new GBC(0, 1, 6, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,5,10,5) );
        /**  皮带周长*/
        jPanel_Left.add(left_Labels[3],new GBC(0, 2, 3, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_TextFields[1],new GBC(3, 2, 2, 1).setFill(GBC.BOTH).setWeight(1, 0));
        jPanel_Left.add(left_Labels[4],new GBC(5, 2, 1, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_Labels[5],new GBC(0, 3, 6, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,5,10,5) );
        /**回零速度  */
        jPanel_Left.add(left_Labels[6],new GBC(0, 4, 3, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_TextFields[2],new GBC(3, 4, 2, 1).setFill(GBC.BOTH).setWeight(1, 0));
        jPanel_Left.add(left_Labels[7],new GBC(5, 4, 1, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_Labels[8],new GBC(0, 5, 6, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,5,10,5) );
        /** 手动速度*/
        jPanel_Left.add(left_Labels[9],new GBC(0, 6, 3, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_TextFields[3],new GBC(3, 6, 2, 1).setFill(GBC.BOTH).setWeight(1, 0));
        jPanel_Left.add(left_Labels[10],new GBC(5, 6, 1, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_Labels[11],new GBC(0, 7, 6, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,5,10,5) );
        /**扫描速度*/
        jPanel_Left.add(left_Labels[12],new GBC(0, 8, 3, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_TextFields[4],new GBC(3, 8, 2, 1).setFill(GBC.BOTH).setWeight(1, 0));
        jPanel_Left.add(left_Labels[13],new GBC(5, 8, 1, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_Labels[14],new GBC(0, 9, 6, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,5,10,5) );
        /**启停位置偏置*/
        jPanel_Left.add(left_Labels[15],new GBC(0, 11, 3, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_TextFields[5],new GBC(3, 11, 2, 1).setFill(GBC.BOTH).setWeight(1, 0));
        jPanel_Left.add(left_Labels[16],new GBC(5, 11, 1, 1).setFill(GBC.BOTH).setWeight(0, 0));
        jPanel_Left.add(left_Labels[17],new GBC(0, 12, 6, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,5,10,5) );
        /**按钮  参数输入、参数显示*/
        jPanel_Left.add(left_Buttons[0],new GBC(0, 13, 4, 2).setFill(GBC.BOTH).setWeight(0, 0).setInsets(30,0,3,0) );
        jPanel_Left.add(left_Buttons[1],new GBC(3, 13, 3, 2).setFill(GBC.BOTH).setWeight(0, 0).setInsets(30,10,3,0) );
        jPanel_Left.add(left_Labels[18],new GBC(0, 15, 3, 1).setFill(GBC.BOTH).setWeight(0, 0).setInsets(0,3,3,0) );
        jPanel_Left.add(left_Labels[19],new GBC(3, 15, 3, 1).setFill(GBC.BOTH).setWeight(0, 0).setInsets(0,17,3,0) );

/**
 *初始化右侧组件
 */
        for(int i=0;i<31;i++){
            right_Labels[i]=new JLabel();
        }
        for(int i=0;i<12;i++){
            right_TextField[i]=new JTextField();
        }
        for(int i=0;i<2;i++){
            right_Button[i]=new JButton();
            right_Button[i].addActionListener(new ButtonHandler());
        }
/**
 * 设置右侧组件文字
 */
        right_Labels[0].setText("扫描起点：");
        right_Labels[1].setText("mm");
        right_Labels[2].setText("区间总数：");
        right_Labels[3].setText("（Scan start point）      ");
        right_Labels[4].setText("（Total number）          ");
        right_Labels[5].setText("扫描终点：");
        right_Labels[6].setText("mm");
        right_Labels[7].setText("测量开始区间：");
        right_Labels[8].setText("（Scan end point）        ");
        right_Labels[9].setText("（Scan start）");
        right_Labels[10].setText("扫描中心点：");
        right_Labels[11].setText("mm");
        right_Labels[12].setText("测量结束区间：");
        right_Labels[13].setText("（Scan center point）     ");
        right_Labels[14].setText("（Scan end）");
        right_Labels[15].setText("机台幅宽：");
        right_Labels[16].setText("mm");
        right_Labels[17].setText("有效统计开始区间：");
        right_Labels[18].setText("（Machine width）         ");
        right_Labels[19].setText("（Effective scan start）");
        right_Labels[20].setText("扫描架校正：");
        right_Labels[21].setText("有效统计结束区间：");
        right_Labels[22].setText("（Scan correct）");
        right_Labels[23].setText("（Effective scan end）");
        right_Labels[24].setText("动态温修周期：");
        right_Labels[25].setText("T");
        right_Labels[26].setText("定位泊车：");
        right_Labels[27].setText("（Dynamic correct cycle）");
        right_Labels[28].setText("（Position park）");
        right_Labels[29].setText("（Parameter input）");
        right_Labels[30].setText("（Parameter display）");
        for(int i=0;i<31;i++){
            right_Labels[i].setFont(new Font("黑体",Font.BOLD, 18));
        }

        right_Button[0].setText("参数输入");
        right_Button[1].setText("参数显示");
        for(int i=0;i<2;i++){
            right_Button[i].setFont(new Font("宋体",Font.BOLD, 18));
        }

/**
 * 向右侧添加组件
 */


         //扫描起点、区间总数

        jPanel_Right.add(right_Labels[0],new GBC(0, 0, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(10,50,0,0));
        jPanel_Right.add(right_TextField[0],new GBC(2, 0, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-150,0,0));
        jPanel_Right.add(right_Labels[1],new GBC(4, 0, 1, 1).setFill(GBC.BOTH).setWeight(2, 0).setInsets(0,3,3,0) );
        jPanel_Right.add(right_Labels[2],new GBC(5, 0, 2, 1).setFill(GBC.BOTH).setWeight(2, 0).setInsets(0,-120,3,0) );
        jPanel_Right.add(right_TextField[1],new GBC(7, 0, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-190,3,0) );
        jPanel_Right.add(right_Labels[3],new GBC(0, 1, 3, 1).setFill(GBC.BOTH).setWeight(5, 0).setInsets(0,50,3,0) );
        jPanel_Right.add(right_Labels[4],new GBC(3, 1, 4, 1).setFill(GBC.BOTH).setWeight(5, 0).setInsets(0,220,3,0));


        // 扫描终点、测量开始区间

        jPanel_Right.add(right_Labels[5],new GBC(0, 2, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,50,0,0));
        jPanel_Right.add(right_TextField[2],new GBC(2, 2, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-150,0,0));
        jPanel_Right.add(right_Labels[6],new GBC(4, 2, 1, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,3,3,0) );
        jPanel_Right.add(right_Labels[7],new GBC(5, 2, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,-120,3,0) );
        jPanel_Right.add(right_TextField[3],new GBC(7, 2, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-190,3,0) );
        jPanel_Right.add(right_Labels[8],new GBC(0, 3, 3, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,50,3,0) );
        jPanel_Right.add(right_Labels[9],new GBC(3, 3, 4, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,220,3,-300) );
          //扫描中心点、测量结束区间
        jPanel_Right.add(right_Labels[10],new GBC(0, 4, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,50,0,0));
        jPanel_Right.add(right_TextField[4],new GBC(2, 4, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-150,0,0));
        jPanel_Right.add(right_Labels[11],new GBC(4, 4, 1, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,3,3,0) );
        jPanel_Right.add(right_Labels[12],new GBC(5, 4, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,-120,3,0) );
        jPanel_Right.add(right_TextField[5],new GBC(7, 4, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-190,3,0) );
        jPanel_Right.add(right_Labels[13],new GBC(0, 5, 3, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,50,3,0) );
        jPanel_Right.add(right_Labels[14],new GBC(3, 5, 4, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,220,3,-300) );
        //机台幅宽、有效统计开始区间
        jPanel_Right.add(right_Labels[15],new GBC(0, 6, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,50,0,0));
        jPanel_Right.add(right_TextField[6],new GBC(2, 6, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-150,0,0));
        jPanel_Right.add(right_Labels[16],new GBC(4, 6, 1, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,3,3,0) );
        jPanel_Right.add(right_Labels[17],new GBC(5, 6, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,-120,3,0) );
        jPanel_Right.add(right_TextField[7],new GBC(7, 6, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-190,3,0) );
        jPanel_Right.add(right_Labels[18],new GBC(0, 7, 3, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,50,3,0) );
        jPanel_Right.add(right_Labels[19],new GBC(3, 7, 4, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,220,3,-300) );
         //扫描架校正、有效统计结束区间
        jPanel_Right.add(right_Labels[20],new GBC(0, 8, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,50,0,0));
        jPanel_Right.add(right_TextField[8],new GBC(2, 8, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-150,0,0));
        jPanel_Right.add(right_Labels[21],new GBC(5, 8, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,-120,3,0) );
        jPanel_Right.add(right_TextField[9],new GBC(7, 8, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-190,3,0) );
        jPanel_Right.add(right_Labels[22],new GBC(0, 9, 3, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,50,3,0) );
        jPanel_Right.add(right_Labels[23],new GBC(3, 9, 4, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,220,3,-300) );
         //动态温修周期、定位泊车
        jPanel_Right.add(right_Labels[24],new GBC(0, 10, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5,50,0,0));
        jPanel_Right.add(right_TextField[10],new GBC(2, 10, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-150,0,0));
        jPanel_Right.add(right_Labels[25],new GBC(4, 10, 1, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,3,3,0) );
        jPanel_Right.add(right_Labels[26],new GBC(5, 10, 2, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,-120,3,0) );
        jPanel_Right.add(right_TextField[11],new GBC(7, 10, 2, 1).setFill(GBC.BOTH).setWeight(0.25, 0).setInsets(0,-190,3,0) );
        jPanel_Right.add(right_Labels[27],new GBC(0, 11, 3, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,50,3,0) );
        jPanel_Right.add(right_Labels[28],new GBC(3, 11, 4, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(3,220,3,-300) );
         //按钮  参数输入、参数显示
        jPanel_Right.add(right_Button[0],new GBC(0, 12, 3, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(55,90,3,0) );
        jPanel_Right.add(right_Button[1],new GBC(3, 12, 4, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(55,220,3,50) );
        jPanel_Right.add(right_Labels[29],new GBC(0, 13, 3, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,90,0,0) );
        jPanel_Right.add(right_Labels[30],new GBC(3, 13, 4, 1).setFill(GBC.BOTH).setWeight(1, 0).setInsets(0,220,0,-300) );
    }



    /**
     *
     *   背景图
     */
    class panel extends JPanel {
        ImageIcon ico;
        panel() {
            ico = new ImageIcon("png/此处调用图片.png" );
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension d = this.getParent().getSize();
            g.drawImage(ico.getImage(), 0, 0, d.width, d.height, null);
        }
    }

    /**
     * 监听器（未添加事件）
     */
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            if(e.getSource()==left_Buttons[0]);//参数输入-》左

            if(e.getSource()==left_Buttons[1]);//参数显示-》左

            if(e.getSource()==right_Button[0]);//参数输入-》右
            if(e.getSource()==right_Button[1]);//参数显示-》右

        }
    }
}


