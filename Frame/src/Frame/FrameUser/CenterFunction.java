package Frame.FrameUser;

import Frame.SubInterface.ChangeRoll;
import Frame.SubInterface.ParameterSetupFrame;
import Frame.SubInterface.SystemSetup;
import Frame.SubInterface.UserManage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CenterFunction {

    public JPanel cardpanel;

    protected CardLayout card = new CardLayout();

    private JLabel[] item = new JLabel[14];
    private JPanel panel;
    private String[] str = {"1.参数设定（Parameter Setup）", "8.扫描图（Profile）",
            "2.系统配置（System Config）", "9.定点图（Trend）", "3.标定（Calibrate）",
            "10.历史数据（History）", "4.更换卷号（Roll）", "11.报表（Report）",
            "5.备份/恢复缺省设置（Backup）", "12.注册（Register）", "6.用户管理（User Manager）",
            "13.登陆（Login）", "7.其他（Other）", "14.退出（Exit）"};

    AddComponents acs=new AddComponents();

    /**
     * 中心功能菜单类以及对同一区域的子界面的切换
     */
    public CenterFunction() {

        //卡片布局容器
        cardpanel = new JPanel();
        cardpanel.setLayout(card);
        cardpanel.setBackground(null);
        cardpanel.setOpaque(false);

        //给中心区域的功能菜单面板上背景图
        panel = new JPanel(new GridLayout(7,2)){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ico=new ImageIcon("png/主界面2(1).png");
                g.drawImage(ico.getImage(),0,0,getSize().width,getSize().height,panel);
            }
        };

        //将标签添加到中心区域的功能菜单面板
        for (int i = 0; i < 14; i++) {

            item[i]=new JLabel();
            item[i]=acs.CreateCenterFunction(item[i],str[i]);
            item[i].addMouseListener(new Keyhandler());
            panel.add(item[i]);
        }

        //添加子卡片用于切换
        cardpanel.add(panel, "1");

        ParameterSetupFrame psf = new ParameterSetupFrame();
        cardpanel.add(psf.jspanel, "2");

        SystemSetup ssp = new SystemSetup();
        cardpanel.add(ssp.jSplitPane_TB, "3");
    }
    //子界面切换的监听器
    private class Keyhandler implements MouseListener{

        //鼠标点击事件（控制卡片切换）
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getSource()==item[0])
            {
                card.show(cardpanel, "2");
            }
            if(e.getSource()==item[2])
            {
                card.show(cardpanel, "3");
            }
            if(e.getSource()==item[6])
            {
                new ChangeRoll();
            }
            if(e.getSource()==item[10])
            {
                new UserManage();
            }
        }

        //其余鼠标事件
        public void mousePressed(MouseEvent e){
        }
        public void mouseReleased(MouseEvent e){
        }
        public void mouseEntered(MouseEvent e){
        }
        public void mouseExited(MouseEvent e){
        }
    }
}
