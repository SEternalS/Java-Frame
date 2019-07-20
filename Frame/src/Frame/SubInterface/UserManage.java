package Frame.SubInterface;

import Frame.FrameUser.GBC;
import static javax.swing.SpringLayout.*;
import javax.swing.*;
import java.awt.*;

public class UserManage {

    private JTextField text;
    private JButton closer,deleteuser,adduser;
    private JLabel label;
    public JDialog jdg;
    private JPanel left,right;
    private JSplitPane jspanel;

    /**
     * 创建用户管理弹窗的构造函数，未添加监听器
     */
    public UserManage(){

        SpringLayout slt=new SpringLayout();
        jdg=new JDialog();
        jdg.setLayout(slt);
        jdg.setTitle("用户管理（User Manager）");
        jdg.setResizable(false);
        jdg.setBounds(617,300,600,400);
        jdg.setVisible(true);

        label=new JLabel("用户管理（User Manager）",JLabel.CENTER);
        label.setFont(new Font("微软雅黑",1,18));
        jdg.add(label);
        slt.putConstraint(NORTH,label,10,NORTH,jdg);
        slt.putConstraint(WEST,label,200,WEST,jdg);

        SelectUser();
        UserInformation();

        jspanel=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,right);//将界面分为左右两个部分
        jspanel.setDividerLocation(200);
        jspanel.setEnabled(false);
        jdg.add(jspanel);
        slt.putConstraint(NORTH,jspanel,20,SOUTH,label);
        slt.putConstraint(WEST,jspanel,10,WEST,jdg);
        slt.putConstraint(EAST,jspanel,560,EAST,jdg);
        slt.putConstraint(SOUTH,jspanel,280,SOUTH,jdg);
    }

    /**
     * 创建左侧的选择面板
     * @return
     */
    private JPanel SelectUser(){

        left=new JPanel(new BorderLayout());
        label=new JLabel("选择一个用户（Select）");
        label.setFont(new Font("楷体",1,15));
        left.add(label,BorderLayout.NORTH);

        JTable table=new JTable(20,1);
        table.setBorder(BorderFactory.createLoweredBevelBorder());
        table.setShowGrid(false);
        left.add(table,BorderLayout.CENTER);

        return left;
    }

    /**
     * 创建右侧的用户信息输入面板
     * @return
     */
    private JPanel UserInformation(){

        right=new JPanel(new GridBagLayout());
        label=new JLabel("用户信息（User Information）");
        label.setFont(new Font("楷体",1,15));
        right.add(label,new GBC(0,0,8,1).setWeight(100,0).setInsets(5,10,5,5));

        String[] str={"用户名","密码", "确认密码","权限"};
        for(int i=0,y=1;i<4;i++,y++)
        {
            label=new JLabel(str[i]);
            right.add(label,new GBC(0,y,3,1).setFill(GBC.BOTH).setWeight(0,0).setInsets(5,15,5,5));
            if(i<3)
            {
                text=new JTextField(150);
                right.add(text,new GBC(3,y,4,1).setFill(GBC.BOTH).setWeight(100,0).setInsets(5,5,5,5));
                label=new JLabel("18个字符以内",JLabel.LEFT);
                right.add(label,new GBC(7,y,2,1).setFill(GBC.BOTH).setWeight(100,0).setInsets(5,5,5,5));
            }
        }
        return right;
    }
}
