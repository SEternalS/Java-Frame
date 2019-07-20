package Frame.FrameUser;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Register {

    public static Frameter fr;


    private JPanel panel;
    JTextField text_identity;
    JPasswordField text_password;
    JLabel login,exit;

    public static void main(St ring[] args) {
        new Register();
    }

    /**
     * 登陆界面
     */
    public Register() {

        final JFrame jframe=new JFrame("陕西波特兰在线测厚控制系统");
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(3);
        jframe.setBounds(300,150,700,400);

        panel=new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ico=new ImageIcon("png/登陆界面.png");
                g.drawImage(ico.getImage(),0,0,getSize().width,getSize().height,panel);
            }
        };
        panel.setLayout(null);

        login=new JLabel();
        ImageIcon icon=new ImageIcon("png/登录1.png");
        login.setIcon(icon);
        login.setBounds(390,260,233,60);

        exit=new JLabel();
        ImageIcon iconExit=new ImageIcon("png/退1.png");
        exit.setIcon(iconExit);
        exit.setBounds(670,0,30,25);

        JLabel label1=new JLabel();
        ImageIcon icon1=new ImageIcon("png/用户名.png");
        label1.setIcon(icon1);
        label1.setBounds(350,140,35,35);

        JLabel label2=new JLabel();
        ImageIcon icon2=new ImageIcon("png/密码.png");
        label2.setIcon(icon2);
        label2.setBounds(350,200,35,35);

        text_identity=new JTextField();
        text_identity.setBounds(390,140,233,35);
        text_password=new JPasswordField();
        text_password.setEchoChar('*');
        text_password.setBounds(390,200,233,35);

        panel.add(label1);
        panel.add(label2);
        panel.add(text_identity);
        panel.add(text_password);
        panel.add(login);
        panel.add(exit);

        jframe.add(panel);
        jframe.setVisible(true);

        /*text_password.addKeyListener(new KeyAdapter()
        {
            String user=text_identity.getText();
            String password=String.valueOf(text_password.getPassword());
            public void keyPressed(KeyEvent e)
            {
                int code = e.getKeyCode();
                if(user.equals("1")==false)
                {
                    JOptionPane.showMessageDialog(null, "用户名错误或不存在");
                }
                else if(password.equals("1")==false)
                {
                    JOptionPane.showMessageDialog(null, "密码错误");
                }
                else if(code==KeyEvent.VK_ENTER)
                {
                    fr = Frameter.GetInstance();
                    jframe.setVisible(false);
                }
            }
        });*/

        /*text_password.addKeyListener(new KeyAdapter()
        {
            String user=text_identity.getText();
            String password=String.valueOf(text_password.getPassword());
            public void keyPressed(KeyEvent e)
            {
                int code = e.getKeyCode();
                if(user.equals("1")==false)
                {
                    JOptionPane.showMessageDialog(null, "用户名错误或不存在");
                    if(password.equals("1")==false)
                    {
                        JOptionPane.showMessageDialog(null, "密码错误");
                    }
                }
                if(code==KeyEvent.VK_ENTER)
                {
                    fr = Frameter.GetInstance();
                    jframe.setVisible(false);
                }
            }
        });*/

        //登录按钮的监听器
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String user=text_identity.getText();
                String password=String.valueOf(text_password.getPassword());

                if(user.equals("1")==false)
                {
                    JOptionPane.showMessageDialog(null, "用户名错误或不存在");
                }
                else if(password.equals("1")==false)
                {
                    JOptionPane.showMessageDialog(null, "密码错误");
                }
                else
                {
                    fr = Frameter.GetInstance();
                    jframe.setVisible(false);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                ImageIcon icon=new ImageIcon("png/登录2.png");
                login.setIcon(icon);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                ImageIcon icon=new ImageIcon("png/登录1.png");
                login.setIcon(icon);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon icon=new ImageIcon("png/登录2.png");
                login.setIcon(icon);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ImageIcon icon=new ImageIcon("png/登录1.png");
                login.setIcon(icon);
            }
        });

        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                ImageIcon icon=new ImageIcon("png/退2.png");
                exit.setIcon(icon);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                ImageIcon icon=new ImageIcon("png/退1.png");
                exit.setIcon(icon);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon icon=new ImageIcon("png/退2.png");
                exit.setIcon(icon);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ImageIcon icon=new ImageIcon("png/退1.png");
                exit.setIcon(icon);
            }
        });
    }
}
