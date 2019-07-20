package Frame.SubInterface;

import javax.swing.*;
import static javax.swing.SpringLayout.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeRoll {

    public JDialog jdg;

    private JTextField text;
    private JButton yes,cancel;
    private JLabel label;
    private JPanel panel;

    /**
     * 创建更换卷号弹窗的构造函数
     */
    public ChangeRoll(){

        SpringLayout slt=new SpringLayout();
        jdg=new JDialog();
        panel=new JPanel(slt);
        jdg.setTitle("更换卷号（Roll）");
        jdg.setBounds(617,300,300,200);
        jdg.setVisible(true);

        text=new JTextField(23);
        yes=new JButton("确定");
        cancel=new JButton("取消");
        label=new JLabel("卷号(Serial Volume Number)",JLabel.CENTER);
        label.setFont(new Font("宋体",1,15));

        panel.add(label);
        slt.putConstraint(NORTH,label,30,NORTH,panel);
        slt.putConstraint(WEST,label,30,WEST,panel);
        panel.add(text);
        slt.putConstraint(WEST,text,30,WEST,panel);
        slt.putConstraint(NORTH,text,10,SOUTH,label);
        panel.add(yes);
        slt.putConstraint(NORTH,yes,10,SOUTH,text);
        slt.putConstraint(WEST,yes,130,WEST,panel);
        panel.add(cancel);
        slt.putConstraint(WEST,cancel,15,EAST,yes);
        slt.putConstraint(NORTH,cancel,10,SOUTH,text);
        jdg.add(panel);

        //确定按钮的监听器
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=text.getText();
                if(str != null && str.length() != 0)
                {
                    JOptionPane.showInternalConfirmDialog(null, "未输入任何数据", "错误ʾ",
                            JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
                    jdg.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "已成功更换卷号", "系统提示ʾ",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //取消按钮的监听器
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdg.dispose();
            }
        });
    }
}
