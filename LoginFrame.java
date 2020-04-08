package UserManageSystem;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
//查询界面
public class LoginFrame extends JFrame implements ActionListener {
    /****************************定义各控件**************************/
    
    
    private JLabel lbAccount=new JLabel("输入姓名");
    private JTextField tfAccount=new JTextField(15);
    private JLabel lbPassword=new JLabel("输入学号");
    private JTextField pfPassword=new JTextField(15);
    private JButton btLogin=new JButton("查询");
    private JButton btRegister=new JButton("登记");
    private JButton btExit=new JButton("退出");
    public LoginFrame() {
        /**********************界面初始化*****************************/
        super("查询");
        this.setLayout(new FlowLayout());
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(btLogin);
        this.add(btRegister);
        this.add(btExit);
        this.setSize(240,180);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /*****************************增加监听************************/
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btLogin) {
            String account=tfAccount.getText();
            String password=pfPassword.getText();
            FileOpe.getInfoByAccount(account);
            if(Conf.account==null||!Conf.password.equals(password)) {
                JOptionPane.showMessageDialog(this,"查询失败");
                return;
            }
            JOptionPane.showMessageDialog(this,"查询成功");
            this.dispose();
            new OperationFrame();
        }
        else if(e.getSource()==btRegister) {
            this.dispose();
            new RegisterFrame();
        }
        else {
            JOptionPane.showMessageDialog(this,"谢谢光临");
            System.exit(0);
        }
    }
}