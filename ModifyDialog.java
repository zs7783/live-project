package UserManageSystem;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//修改界面
public class ModifyDialog extends  JDialog implements ActionListener {
    /*******************************定义各控件**************************/
    private JLabel lbMsg=new JLabel("姓名为：");
    private JLabel lbAccount=new JLabel(Conf.account);
    private JLabel lbPassword=new JLabel("输入学号");
    private JTextField pfPassword=new JTextField(Conf.password,15);
    private JLabel lbPassword2=new JLabel("输入确认学号");
    private JTextField pfPassword2=new JTextField(Conf.password,12);
    private JLabel lbName=new JLabel("修改入校时间");
    private JTextField tfName=new JTextField(Conf.time,12);
    private JLabel lbDept=new JLabel("修改离校时间");
    private JTextField tfDept=new JTextField(Conf.leave,12);;
    private JButton btModify=new JButton("记录");
    private JButton btExit=new JButton("关闭");
    public ModifyDialog(JFrame frm) {
        /***********************界面初始化***************************/
        super(frm,true);
        this.setLayout(new GridLayout(6,2));
        this.add(lbMsg);
        this.add(lbAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(lbName);
        this.add(tfName);
        this.add(lbDept);
        this.add(tfDept);
        this.add(btModify);
        this.add(btExit);
        this.setSize(240,200);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*******************增加监听*******************************/
        btModify.addActionListener(this);
        btExit.addActionListener(this);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btModify) {
            String password1=pfPassword.getText();
            String password2=pfPassword2.getText();
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"两个学号不相同");
                return;
            }
            String name=tfName.getText();
            String dept=tfDept.getText();
            //将新的值存入静态变量
            Conf.password=password1;
            Conf.time=name;
            Conf.leave=dept;
            FileOpe.updateCustomer(Conf.account,password1,name,dept);
            JOptionPane.showMessageDialog(this,"修改成功");
        }
        else {
            this.dispose();
        }
    }
}
