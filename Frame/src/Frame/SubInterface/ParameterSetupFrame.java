package Frame.SubInterface;

import Frame.FrameUser.AddComponents;
import Frame.FrameUser.GBC;
import Frame.FrameUser.Register;
import Frame.FrameUser.Setfont;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ParameterSetupFrame {

    public JPanel jspanel;

    private JPanel panel;
    private JPanel left,right;
    private JLabel label;
    private JTextField[] text=new JTextField[8];
    private JComboBox jcb;
    private String[] str={"current revised data(59)","revised data1(111)","revised data2(0)","revised data3(0)"};
    private JButton bt,yes;
    private String[] strChinese={"扫描架校正","清除温修值","扫描架清零"};
    private String[] strEnglish={"Scanning Frame Correction Clear","Scanning Frame Correction","Clear Static Correction"};

    Setfont sf=new Setfont();
    AddComponents acs=new AddComponents();
    /**
     * 参数设定功能的界面
     */
    public ParameterSetupFrame() {

        left=new JPanel();
        left.setLayout(new GridBagLayout());
        left.setBackground(null);
        left.setOpaque(false);

        right=new JPanel();
        right.setLayout(new GridBagLayout());
        right.setBackground(null);
        right.setOpaque(false);

        jspanel=new JPanel(new GridLayout(1,2)){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ico=new ImageIcon("png/主界面2(1).png");
                g.drawImage(ico.getImage(),0,0,getSize().width,getSize().height,jspanel);
            }
        };

        jspanel.add(left);
        jspanel.add(right);

        addlabel_ParameterSetup("参数设定（ParameterSetup）");
        for(int i=0;i<8;i++)
        {
            text[i]=new JTextField();
        }
        left.add(acs.CreateComponents(text[0],"产品名称","(Production Name)"),new GBC(0,1,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(5,40,5,80));
        left.add(acs.CreateComponents(text[1],"目标上限","(Target upper limit)"),new GBC(0,2,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,40,5,80));
        left.add(acs.CreateComponents(text[2],"目标值","(Target Value)"),new GBC(0,3,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,40,5,80));
        left.add(acs.CreateComponents(text[3],"目标下限","(Target lower limit)"),new GBC(0,4,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,40,5,80));
        left.add(acs.CreateComponents(text[4],"正行修正偏差","(Forward Correction windage)"),new GBC(0,5,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,40,5,80));
        left.add(acs.CreateComponents(text[5],"反行修正偏差","(Reverse Correction windage)"),new GBC(0,6,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,40,5,80));
        left.add(acs.CreateComponents(text[6],"补偿修正","(Compensation Correction)"),new GBC(0,7,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,40,5,80));
        left.add(acs.CreateComponents(text[7],"扫描架校正基准值","(Scanning Frame Correction Reference)"),new GBC(0,8,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,40,5,80));

        yes=new JButton("确定");
        yes.setFont(sf.font3);
        left.add(yes,new GBC(2,9,1,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,450,10,80));

        //确定按钮的监听器
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] input=new String[3];
                for(int i=0;i<3;i++) {
                    input[i] = text[i + 1].getText();
                    Register.fr.data_jpanel.data_second[i].setText(input[i]);
                }
                String username=text[0].getText();
                Register.fr.data_jpanel.data_first[0].setText(username);
            }
        });

        add_label_ScanningFrameCorrection();
        add_JScanning_Frame_Correction_Data();
        addbutton();
        addjcheckbox();
        addjradiobutton();
    }

    /**
     * 创建左侧面板标题的标签说明
     * @param str
     */
    public void addlabel_ParameterSetup(String str) {

        label=new JLabel(str,JLabel.CENTER);
        label.setFont(sf.font5);
        left.add(label,new GBC(0,0,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(10,0,15,0));
    }

    /**
     * 创建右侧面板标题的标签
     */
    public void add_label_ScanningFrameCorrection(){
        label=new JLabel("扫描架校正（Scanning Frame Correction）",JLabel.CENTER);
        label.setFont(new Font("楷体",1,28));
        right.add(label,new GBC(0,0,8,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(10,0,10,0));
    }

    /**
     *创建扫描架校正的下拉菜单
     */
    public void add_JScanning_Frame_Correction_Data(){

        panel=new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(null);
        panel.setOpaque(false);
        jcb=new JComboBox(str);
        jcb.setEditable(false);
        label=new JLabel("扫描架校正数据列表");
        label.setFont(new Font("楷体",1,20));
        panel.add(label,new GBC(0,1,2,1).setFill(GBC.NONE).setWeight(0,0).setInsets(0,50,0,5));
        panel.add(jcb,new GBC(2,1,4,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,5,0,5));

        label=new JLabel("（Scanning Frame Correction Data）");
        label.setFont(new Font("微软雅黑",1,15));
        panel.add(label,new GBC(0,2,5,1).setFill(GBC.NONE).setWeight(0,0).setInsets(0,50,20,5));

        bt=new JButton("确定(OK)");
        panel.add(bt,new GBC(6,1,2,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,5,0,50));
        right.add(panel,new GBC(0,1,8,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,0,0,0));
    }

    /**
     * 创建"扫描架校正","清除温修值","扫描架清零ֵ"三个按钮
     */
    public void addbutton(){
        panel=new JPanel(new GridLayout(2,3,30,0));
        panel.setBackground(null);
        panel.setOpaque(false);
        for(int i=0;i<3;i++)
        {
            bt=new JButton(strChinese[i]);
            bt.setFont(new Font("微软雅黑",1,15));
            panel.add(bt);
        }
       for(int j=0;j<3;j++)
        {
            label=new JLabel(strEnglish[j],JLabel.CENTER);
            label.setFont(new Font("微软雅黑",1,10));
            panel.add(label);
        }
        right.add(panel,new GBC(0,3,8,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(0,50,0,50));
    }

    /**
     * 创建跟踪平均值，是否报警两个复选框
     */
    public void addjcheckbox()
    {
        JCheckBox checkboxAverage = new JCheckBox("跟踪平均值(Follow AVG)");
        checkboxAverage.setSelected(true);
        JCheckBox checkboxPolice = new JCheckBox("是否报警(Alarm Switch)");

        checkboxAverage.setContentAreaFilled(false);
        checkboxPolice.setContentAreaFilled(false);

        checkboxAverage.setFont(new Font("楷体",1,20));
        checkboxPolice.setFont(new Font("楷体",1,20));
        panel=new JPanel(new GridLayout(1,2,5,5));
        panel.setBackground(null);
        panel.setOpaque(false);
        panel.add(checkboxAverage);
        panel.add(checkboxPolice);
        right.add(panel,new GBC(0,4,8,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(20,50,20,50));
    }

    /**
     * 创建显示方式，计量单位，模头镜像三个单选按钮组
     */
    public void addjradiobutton(){

        JPanel mainpanel=new JPanel(new GridLayout(1,3,5,5));
        mainpanel.setBackground(null);
        mainpanel.setOpaque(false);
        //显示方式单选按钮组
        ButtonGroup bg1=new ButtonGroup();//创建包括所有单选项的组
        JRadioButton normal_jrb=new JRadioButton("正常显示(Normal)");//创建单选按钮
        normal_jrb.setSelected(true);
        JRadioButton section_jrb=new JRadioButton("分段显示(Section)");
        JRadioButton threeColor_jrb=new JRadioButton("三色显示(Three Color)");
        JRadioButton curveSurface_jrb=new JRadioButton("曲面(Curve Surface)");
        JRadioButton curve_jrb=new JRadioButton("曲线(Curve)");

        normal_jrb.setContentAreaFilled(false);
        section_jrb.setContentAreaFilled(false);
        threeColor_jrb.setContentAreaFilled(false);
        curveSurface_jrb.setContentAreaFilled(false);
        curve_jrb.setContentAreaFilled(false);

        panel=new JPanel(new GridLayout(5,1));
        panel.setBorder(new TitledBorder(null,"显示方式",TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("楷体",1,20), Color.BLACK));
        panel.setBackground(null);
        panel.setOpaque(false);

        normal_jrb.setFont(new Font("宋体",1,15));
        section_jrb .setFont(new Font("宋体",1,15));
        curveSurface_jrb.setFont(new Font("宋体",1,15));
        threeColor_jrb.setFont(new Font("宋体",1,15));
        curve_jrb.setFont(new Font("宋体",1,15));

        bg1.add(normal_jrb);
        bg1.add(section_jrb);
        bg1.add(threeColor_jrb);
        bg1.add(curveSurface_jrb);
        bg1.add(curve_jrb);

        panel.add(normal_jrb);
        panel.add(section_jrb);
        panel.add(threeColor_jrb);
        panel.add(curveSurface_jrb);
        panel.add(curve_jrb);
        mainpanel.add(panel);

        //计量单位单选按钮组
        ButtonGroup bg2=new ButtonGroup();
        JRadioButton[] jbt=new JRadioButton[3];
        final String[] unit={"μm","<html><body>g/cm<sup>2</sup><body><html>","cmm"};

        panel=new JPanel(new GridLayout(5,1));
        panel.setBorder(new TitledBorder(null,"计量单位",TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("楷体",1,20), Color.BLACK));
        panel.setBackground(null);
        panel.setOpaque(false);
        for(int i=0;i<3;i++)
        {
            jbt[i]=new JRadioButton(unit[i]);
            jbt[i].setFont(new Font("宋体",1,15));
            jbt[i].setContentAreaFilled(false);
            bg2.add(jbt[i]);
            panel.add(jbt[i]);
        }
        jbt[0].setSelected(true);
        mainpanel.add(panel);

        //计量单位单选按钮组的监听器
        jbt[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register.fr.data_jpanel.thick_unit.setText(unit[0]);
            }
        });
        jbt[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register.fr.data_jpanel.thick_unit.setText(unit[1]);
            }
        });
        jbt[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register.fr.data_jpanel.thick_unit.setText(unit[2]);
            }
        });

        //模头镜像单选按钮组
        ButtonGroup bg3=new ButtonGroup();
        JRadioButton forward=new JRadioButton("正向显示(Forward)");
        forward.setFont(new Font("宋体",1,15));
        JRadioButton reverse=new JRadioButton("反向显示(Reverse)");
        reverse.setFont(new Font("宋体",1,15));

        forward.setContentAreaFilled(false);
        reverse.setContentAreaFilled(false);

        reverse.setSelected(true);
        panel=new JPanel(new GridLayout(5,1));
        panel.setBorder(new TitledBorder(null,"模头镜像",TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("楷体",1,20), Color.BLACK));
        panel.setBackground(null);
        panel.setOpaque(false);

        bg3.add(forward);
        bg3.add(reverse);
        panel.add(forward);
        panel.add(reverse);
        mainpanel.add(panel);
        right.add(mainpanel,new GBC(0,6,8,3).setFill(GBC.BOTH).setWeight(0,0).setInsets(20,50,30,50));
    }
}


