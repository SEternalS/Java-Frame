package Frame.FrameUser;

import Frame.SubInterface.ChangeRoll;
import Frame.SubInterface.UserManage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Toolbar{

    public JToolBar toolbar;
    private MyButton[] bt=new MyButton[14];
    private JTextField text;

    private Keyhandler keybutton=new Keyhandler();

    private String[] str= {"1.参数设定（Parameter Setup）","2.系统配置（System Config）","3.标定（Calibrate）",
                           "4.更换卷号（Roll）","5.备份/恢复缺省设置（Backup）","6.用户管理（User Manager）",
                           "7.其他（Other）","8.扫描图（Profile）","9.定点图（Trend）",
                           "10.历史数据（History）","11.报表（Report）","12.注册（Register）",
                           "13.登陆（Login）","14.退出（Exit）"};

    /**
     * 自建的工具条构造器
     */
    public Toolbar() {

        toolbar = new JToolBar();
        toolbar.setFloatable(false);

        for (int j = 0; j < 14; j++) {

            bt[j] = new MyButton();
            bt[j].setToolTipText(str[j]);
            toolbar.add(bt[j]);
            bt[j].addActionListener(keybutton);
            if (j == 6) {
                text = new JTextField("信息栏(information)");
                text.setHorizontalAlignment(JTextField.CENTER);
                toolbar.add(text);
            }
        }

        bt[0].setIcon(new ImageIcon("png/111.png"));
        bt[1].setIcon(new ImageIcon("png/222.png"));
        bt[2].setIcon(new ImageIcon("png/333.png"));
        bt[3].setIcon(new ImageIcon("png/444.png"));
        bt[4].setIcon(new ImageIcon("png/555.png"));
        bt[5].setIcon(new ImageIcon("png/666.png"));
        bt[6].setIcon(new ImageIcon("png/777.png"));
        bt[7].setIcon(new ImageIcon("png/100.png"));
        bt[8].setIcon(new ImageIcon("png/200.png"));
        bt[9].setIcon(new ImageIcon("png/300.png"));
        bt[10].setIcon(new ImageIcon("png/400.png"));
        bt[11].setIcon(new ImageIcon("png/500.png"));
        bt[12].setIcon(new ImageIcon("png/600.png"));
        bt[13].setIcon(new ImageIcon("png/700.png"));
    }

    //切换面板的按钮的监听器
    class Keyhandler extends CenterFunction implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==bt[0]) {
                Register.fr.cf.card.show(Register.fr.cf.cardpanel, "1");
            }
            if(e.getSource()==bt[1]){
                Register.fr.cf.card.show(Register.fr.cf.cardpanel, "2");
            }
            if(e.getSource()==bt[2]){
                Register.fr.cf.card.show(Register.fr.cf.cardpanel, "3");
            }
            if (e.getSource()==bt[4]) {
                new ChangeRoll();
            }
            if (e.getSource()==bt[6]) {
                new UserManage();
            }
        }
    }
}

/**
 * 给按钮创建提示信息
 */
class MyButton extends JButton {

    public JToolTip createToolTip() {
        JToolTip jt = super.createToolTip();
        jt.setBackground(Color.WHITE);
        jt.setFont(new Font("微软雅黑",0,15));
        jt.updateUI();
        return jt;
    }
}
