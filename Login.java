package UserManageSystem;
import java.awt.*;
import javax.swing.*;
 
public class Login{
    public static void main (String []args){
 
        AFrame f = new AFrame("学生信息管理系统");
    }
}
class AFrame extends JFrame{
    Button b1;
    Button b2;
    JTextField t1;
    JTextField t2;
 
    public AFrame(String title){
        super(title);
        this.setLayout(null);
        b1 =new Button("登陆");
        b2 =new Button("离开");
    
        t1 =new JTextField(25);
        t1.setFont(new Font("宋体",Font.BOLD,25));
 
        t2 =new JPasswordField(25);
        t2.setFont(new Font("宋体",Font.BOLD,25));
 
        JLabel nameLabel = new JLabel("用户名");
        nameLabel.setFont(new Font("宋体",Font.BOLD,25));
        nameLabel.setHorizontalAlignment(JTextField.CENTER);
        JLabel pwdLabel = new JLabel("密码");
        pwdLabel.setFont(new Font("宋体",Font.BOLD,25));
        pwdLabel.setHorizontalAlignment(JTextField.CENTER);
 
        this.setBounds(300,300,1000,500);
        this.add(nameLabel);
        this.add(t1);
        this.add(pwdLabel);
        this.add(t2);
        this.add(b1);
        this.add(b2);
 
        nameLabel.setBounds(100,100,200,50);
        pwdLabel.setBounds(100,200,200,50);
        t1.setBounds(600,100,200,50);
        t2.setBounds(600,200,200,50);
        b1.setBounds(100,300,200,50);
        b2.setBounds(600,300,200,50);
 
        b1.addActionListener(new ResponseButton());
 
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"单击确定退出");
                System.exit(0);
            }
        });
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
}
    public class ResponseButton  implements ActionListener{
        public void actionPerformed(ActionEvent e){
                String str ="123456";
                if(t1.getText().equals(str) ){
                    JFrame f1 = new JFrame("学生信息管理系统");
                    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f1.setVisible(true);
                }else{
                    System.out.print(t1.getText());
                    JOptionPane.showMessageDialog(null, "账号或者密码错误", "Error.mxy",JOptionPane.ERROR_MESSAGE); 
            
                }
        }
    }
 
}
