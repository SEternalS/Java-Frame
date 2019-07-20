package Frame.FrameUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DataJpanel {

    public JPanel mainpanel;
    public JPanel panel_label_data_first;
    public JPanel panel_label_data_second;
    public JPanel panel_thick;
    public JPanel panel_Bolt_Max_min_OnOff;

    public JLabel data_first[];
    public JLabel data_second[];
    public JLabel thick_unit,thick_data;

    private JLabel label_name_second;
    private JLabel label_name_first;
    private JLabel bolt;
    private JLabel max;
    private JLabel min;

    private String[] str_label_name_first={"产品名称","(Production Name)","计数值","(Precision)","用户名","(GetCurrentUser)"};
    private String[] str_label_name_second={"目标上限","(Target upper limit)","目标值","(Target Value)","目标下限","(Target lower limit)"};

    public DataJpanel() {

        GridBagLayout layout=new GridBagLayout();//初始化一个网格包布局管理器的对象

        //左边第一块标签说明+数据的面板“产品名称”等等
        panel_label_data_first=new JPanel();
        panel_label_data_first.setLayout(layout);
        panel_label_data_first.setPreferredSize(new Dimension(220, 140));
        panel_label_data_first.setBackground(null);
        panel_label_data_first.setOpaque(false);
        for(int i=0;i<6;i++) {

            datanamefirst(i);
        }
        datafirst("111");

        //左边第二块标签说明+数据的面板“目标上限”等等
        panel_label_data_second=new JPanel();
        panel_label_data_second.setLayout(layout);
        panel_label_data_second.setPreferredSize(new Dimension(220, 140));
        panel_label_data_second.setBackground(null);
        panel_label_data_second.setOpaque(false);
        for(int i=0;i<6;i++) {

            datanamesecond(i);
        }
        datasecond("16");

        /**
         * 厚度数据显示区的函数
         */
        Thick();

        /**
         * 最右边的面板
         */
        panel_Bolt_Max_min_OnOff=new JPanel();
        panel_Bolt_Max_min_OnOff.setLayout(layout);
        panel_Bolt_Max_min_OnOff.setPreferredSize(new Dimension(240, 0));
        panel_Bolt_Max_min_OnOff.setBackground(null);
        panel_Bolt_Max_min_OnOff.setOpaque(false);
        Bolt("0 Bolt");
        Max("1649");
        Min("49");
        ScanYesNo();

        /**
         * 容纳了以上四个界面的面板，用于填充背景
         */
        mainpanel = new JPanel(new GridLayout(1,4)){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ico=new ImageIcon("png/北部.png");
                g.drawImage(ico.getImage(),0,0,getSize().width,getSize().height,mainpanel);
            }
        };
        mainpanel.add(panel_label_data_first);
        mainpanel.add(panel_label_data_second);
        mainpanel.add(panel_thick);
        mainpanel.add(panel_Bolt_Max_min_OnOff);
    }

    /**
     * 创建主界面第一快块板的标签区，包括用户名label_name_first[0]，计数值label_name_first[1]，产品名称label_name_first[2]
     * @param i
     */
    public void datanamefirst(int i) {

        label_name_first=new JLabel(str_label_name_first[i]);
        label_name_first.setForeground(Color.WHITE);
        label_name_first.setFont(new Font("微软雅黑",0,15));
        panel_label_data_first.add(label_name_first,new GBC(0,i,1,1).setFill(GBC.BOTH).setWeight(5,100).setInsets(5,5,0,0));
    }

    /**
     *
     * 创建主界面第一块面板的数据区，包括用户名data_first[0]，计数值（实时显示）data_first[1]，产品名称data_first[2]
     * @param str
     */
    public void datafirst(String str) {
        data_first=new JLabel[3];
        int y=0;
        for(int i=0;i<3;i++)
        {
            data_first[i] = new JLabel();
            data_first[i].setForeground(Color.WHITE);
            data_first[i].setFont(new Font("微软雅黑", 1, 20));
            data_first[i].setText(str);
            panel_label_data_first.add(data_first[i], new GBC(1, y, 1, 2).setFill(GBC.BOTH).setWeight(5, 100).setInsets(5, 0, 0, 0));
            y=y+2;
        }
    }

    /**
     * 创建主界面第二块面板的标签区，包括目标上限label_name_second[0]，目标值label_name_second[1]，目标下限label_name_second[2]
     * @param i
     */
    public void datanamesecond(int i) {

        label_name_second=new JLabel(str_label_name_second[i]);
        label_name_second.setForeground(Color.WHITE);
        label_name_second.setFont(new Font("微软雅黑",0,15));
        panel_label_data_second.add(label_name_second,new GBC(0,i,1,1).setFill(GBC.BOTH).setWeight(5,100).setInsets(5,5,0,0));
    }

    /**
     * 主界面第二块面板的数据区，包括目标上限 data_second[0]，目标值 data_second[1]，目标下限 data_second[2]
     * @param str
     */
    public void datasecond(String str) {
        data_second=new JLabel[3];
        int y=0;
        for(int i=0;i<3;i++)
        {
            data_second[i]=new JLabel(str);
            data_second[i].setForeground(Color.WHITE);
            data_second[i].setFont(new Font("微软雅黑",1,20));
            panel_label_data_second.add(data_second[i],new GBC(1,y,1,2).setFill(GBC.BOTH).setWeight(5,100).setInsets(5,0,0,0));
            y=y+2;
        }
    }

    /**
     * 创建厚度值显示面板
     */
    public void Thick() {

        panel_thick=new JPanel();
        panel_thick.setLayout(new GridLayout(1,2));
        panel_thick.setPreferredSize(new Dimension(400, 0));

        panel_thick.setBackground(null);
        panel_thick.setOpaque(false);

        thick_unit=new JLabel("μm");
        thick_data=new JLabel("111",JLabel.RIGHT);
        thick_unit.setForeground(Color.WHITE);
        thick_data.setForeground(Color.WHITE);
        thick_unit.setFont(new Font("微软雅黑",1,25));
        thick_data.setFont(new Font("微软雅黑",1,40));
        panel_thick.add(thick_data);
        panel_thick.add(thick_unit);
    }


    /**
     * 创建最右边的面板的第一列第一个标签
     * @param str
     */
    public void Bolt(String str) {

        bolt=new JLabel(str,JLabel.CENTER);
        bolt.setFont(new Font("微软雅黑",1,20));
        bolt.setForeground(Color.WHITE);
        bolt.setText(str);
        panel_Bolt_Max_min_OnOff.add(bolt,new GBC(0,0,2,2).setAnchor(GridBagConstraints.CENTER).setFill(GBC.NONE).setWeight(0,0).setInsets(10,5,10,10));
    }

    /**
     * 创建最右边的面板的第一列第二个标签
     * @param str
     */
    public void Max(String str) {

        max=new JLabel(str,JLabel.CENTER);
        max.setFont(new Font("微软雅黑",1,20));
        max.setForeground(Color.WHITE);
        max.setText(str+" mm");
        panel_Bolt_Max_min_OnOff.add(max,new GBC(2,0,2,2).setAnchor(GridBagConstraints.CENTER).setFill(GBC.NONE).setWeight(0,0).setInsets(10,10,10,5));
    }

    /**
     * 创建最右边的面板的第一列第三个标签
     * @param str
     */
    public void Min(String str) {

        min=new JLabel(str,JLabel.CENTER);
        min.setFont(new Font("微软雅黑",1,20));
        min.setForeground(Color.WHITE);
        min.setText(str+" mm");
        panel_Bolt_Max_min_OnOff.add(min,new GBC(4,0,2,2).setAnchor(GridBagConstraints.CENTER).setFill(GBC.NONE).setWeight(0,0).setInsets(10,10,10,10));
    }

    /**
     * 添创建加波特率，添加串口的下拉菜单
     */
    public void ScanYesNo() {

        final JComboBox change_Baudrate=new JComboBox();
        final JComboBox change_Serial=new JComboBox();
        panel_Bolt_Max_min_OnOff.add(change_Baudrate,new GBC(0,2,3,2).setAnchor(GridBagConstraints.CENTER).setFill(GBC.BOTH).setWeight(0,0).setInsets(10,10,10,10));
        panel_Bolt_Max_min_OnOff.add(change_Serial,new GBC(3,2,3,2).setAnchor(GridBagConstraints.CENTER).setFill(GBC.BOTH).setWeight(0,0).setInsets(10,10,10,10));

        JButton add_Baudrate=new JButton("添加波特率");
        JButton add_Serial=new JButton("添加串口名");
        JButton right=new JButton("确定");
        panel_Bolt_Max_min_OnOff.add(add_Baudrate,new GBC(0,4,2,2).setAnchor(GridBagConstraints.CENTER).setFill(GBC.NONE).setWeight(0,0).setInsets(10,10,7,10));
        panel_Bolt_Max_min_OnOff.add(add_Serial,new GBC(2,4,2,2).setAnchor(GridBagConstraints.CENTER).setFill(GBC.NONE).setWeight(0,0).setInsets(10,10,7,10));
        panel_Bolt_Max_min_OnOff.add(right,new GBC(4,4,2,2).setAnchor(GridBagConstraints.CENTER).setFill(GBC.BOTH).setWeight(0,0).setInsets(10,10,7,10));

        //添加波特率按钮的监听器
        add_Baudrate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) JOptionPane.showInputDialog(null, "添加波特率\n", "添加Baudrate", JOptionPane.PLAIN_MESSAGE, null, null,
                        "请输入Baudrate");
                change_Baudrate.addItem(str);
            }
        });

        //添加串口名按钮的监听器
        add_Serial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) JOptionPane.showInputDialog(null, "添加串口名\n", "添加串口名", JOptionPane.PLAIN_MESSAGE, null, null,
                        "请输入串口名");
                change_Serial.addItem(str);
            }
        });

        //确定按钮的监听器
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str_Baudrate=(String)change_Baudrate.getSelectedItem();
                String str_Serial=(String)change_Serial.getSelectedItem();
                if(str_Baudrate!=null&&str_Serial!=null)
                {
                    JOptionPane.showInternalConfirmDialog(null, "已成功修改数据", "系统提示",
                            JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
                }
                else if(str_Baudrate==null||str_Serial==null)
                {
                    JOptionPane.showMessageDialog(null, "串口名和波特率为空",
                            "错误提示ʾ",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
