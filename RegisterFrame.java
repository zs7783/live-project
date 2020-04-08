package UserManageSystem;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.Date;
import java.text.SimpleDateFormat;


//登记界面
public class RegisterFrame extends JFrame implements ActionListener {
    /**********************定义各控件********************************/
    private JLabel lbAccount=new JLabel("输入姓名");
    private JTextField tfAccount=new JTextField(15);
    private JLabel lbPassword=new JLabel("输入学号");
    private JTextField pfPassword=new JTextField(15);
    private JLabel lbPassword2=new JLabel("输入确认学号");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    private JTextField pfPassword2=new JTextField(12);
    private JLabel lbName=new JLabel("输入入校时间");
    private JTextField tfName=new JTextField(12);
    private JLabel lbDept=new JLabel("输入离校时间");
    private JTextField tfDept=new JTextField(12);
    
    
    private JButton btRegister=new JButton("登记");
    private JButton btLogin=new JButton("查询");
    private JButton btExit=new JButton("退出");
    public RegisterFrame() {
        /******************界面初始化********************/
        super("注册");
        this.setLayout(new FlowLayout());
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(lbName);
        this.add(tfName);
        this.add(lbDept);
        this.add(tfDept);
        this.add(btRegister);
        this.add(btLogin);
        this.add(btExit);
        this.setSize(240,220);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /****************************增加监听***********************/
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btRegister) {
            String password1=pfPassword.getText();
            String password2=pfPassword2.getText();
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"两个学号不相同");
                return;
            }
            String account=tfAccount.getText();
            FileOpe.getInfoByAccount(account);
            if(Conf.account!=null) {
                JOptionPane.showMessageDialog(this,"用户已经登记");
                return;
            }
            String name=df.format(new Date());
            String dept=df.format(new Date());
            FileOpe.updateCustomer(account,password1,name,dept);
            JOptionPane.showMessageDialog(this,"登记成功");
        }
        else if(e.getSource()==btLogin) {
            this.dispose();
            new LoginFrame();
        }
        else {
            JOptionPane.showMessageDialog(this,"谢谢光临");
            System.exit(0);
        }
    }
}
