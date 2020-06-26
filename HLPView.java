package HealthyLivingPlanner;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

class LaunchGUIView extends JFrame {
    private JButton Enter;
    private JButton Register;
    private JLabel Title;
    private JLabel Name;
    private JLabel Password;
    private JLabel Message;
    private JTextField NameInput;
    private JTextField PasswordInput;
    LaunchGUIView() {
        setTitle("Login");
        setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("Logo.png");
        setIconImage(icon.getImage());
        setLaunchGUI();
        setSize(230, 265);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  
    void setLaunchGUI()
    {
        Title = new JLabel("Healthy Living Planner");
	Title.setFont(new Font("Helvetica",Font.PLAIN, 19));
	Name = new JLabel("Name:");
	NameInput = new JTextField(10);
        Password = new JLabel("Password:");
        PasswordInput = new JPasswordField(10);
	Enter = new JButton("Enter");
	Register = new JButton("               Register               ");
	Message = new JLabel();
        Message.setForeground(Color.red);
	JPanel labl = new JPanel(new FlowLayout());
	JPanel sel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	labl.setBackground(Color.lightGray);
        sel.setBackground(Color.decode("#9d87e4"));
        labl.add(Title);
        sel.add(Register);
	sel.add(Name);
	sel.add(NameInput);
        sel.add(Password);
        sel.add(PasswordInput);
	sel.add(Enter);
        JPanel mess = new JPanel(new FlowLayout());
        mess.setBackground(Color.lightGray);
	mess.add(Message);
	add(labl,BorderLayout.NORTH);
	add(sel,BorderLayout.CENTER);
        add(mess, BorderLayout.SOUTH);
    }
    
    public void JMessage(String promptMessage) {
        ImageIcon iconnn = new ImageIcon("Logo.png");
        Image image = iconnn.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        iconnn = new ImageIcon(newimg);
        JOptionPane.showMessageDialog(null, promptMessage, "Healthy Living Planner", JOptionPane.INFORMATION_MESSAGE, iconnn);
    }
    
    public void setBackTextBoxNameLog(){
        NameInput.setBackground(Color.red);
    }
    
    public void setBackTextBoxNameDefaultLog(){
        NameInput.setBackground(Color.WHITE);
    }
    
    public void setBackTextBoxPasswordLog(){
        PasswordInput.setBackground(Color.red);
    }
    
    public void setBackTextBoxPasswordDefaultLog(){
        PasswordInput.setBackground(Color.WHITE);
    }
    
    public JButton getEnter() {
        return Enter;
    }
    
    public JButton getRegister() {
        return Register;
    }
    
    public String getNameLogInput() {
        return NameInput.getText();
    }
    
    public String getPasswordLogInput() {
        return PasswordInput.getText();
    }
    
    public void setNameLogInput(String s) {
        NameInput.setText(s);
    }
    
    public void setPasswordLogInput(String l) {
        PasswordInput.setText(l);
    }
    
    public void setMessage(String message) {
        Message.setText(message);
    }
}

class RegisterGUIView extends JFrame {
    private JButton Create;
    private JButton Cancel;
    private JLabel Title2;
    private JLabel Name2;
    private JLabel Password2;
    private JLabel Age2;
    private JLabel Gender2;
    private JLabel Height2;
    private JLabel Weight2;
    private JLabel Message2;
    private JTextField NameInput2;
    private JTextField PasswordInput2;
    private JTextField AgeInput2;
    private JTextField GenderInput2;
    private JTextField HeightInput2;
    private JTextField WeightInput2;
    RegisterGUIView() {
        setTitle("Register");
        setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("Logo.png");
        setIconImage(icon.getImage());
        setRegisterGUI();
        setSize(1200, 185);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  
    void setRegisterGUI()
    {
        Title2 = new JLabel("New Profile");
	Title2.setFont(new Font("Helvetica",Font.PLAIN, 16));
	Name2 = new JLabel("Name:");
	NameInput2 = new JTextField(10);
        Password2 = new JLabel("        Password:");
        PasswordInput2 = new JPasswordField(10);
        Age2 = new JLabel("        Age:");
	AgeInput2 = new JTextField(10);
        Gender2 = new JLabel("        Gender:");
        GenderInput2 = new JTextField(10);
        Height2 = new JLabel("        Height (CM):");
	HeightInput2 = new JTextField(10);
        Weight2 = new JLabel("        Weight (KG):");
        WeightInput2 = new JTextField(10);
	Create = new JButton("Create Account");
        Cancel = new JButton("Cancel");
        Message2 = new JLabel();
        Message2.setForeground(Color.red);
	JPanel labl2 = new JPanel(new FlowLayout());
	JPanel sel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	labl2.setBackground(Color.lightGray);
        sel2.setBackground(Color.decode("#9d87e4"));
        labl2.add(Title2);
	sel2.add(Name2);
	sel2.add(NameInput2);
        sel2.add(Password2);
        sel2.add(PasswordInput2);
        sel2.add(Age2);
	sel2.add(AgeInput2);
        sel2.add(Gender2);
        sel2.add(GenderInput2);
        sel2.add(Height2);
	sel2.add(HeightInput2);
        sel2.add(Weight2);
        sel2.add(WeightInput2);
	sel2.add(Create);
        sel2.add(Cancel);
        JPanel mess2 = new JPanel(new FlowLayout());
        mess2.setBackground(Color.lightGray);
	mess2.add(Message2);
	add(labl2,BorderLayout.NORTH);
	add(sel2,BorderLayout.CENTER);
        add(mess2, BorderLayout.SOUTH);
    }
    
    public void setBackTextBoxName(){
        NameInput2.setBackground(Color.red);
    }
    
    public void setBackTextBoxNameDefault(){
        NameInput2.setBackground(Color.WHITE);
    }
    
    public void setBackTextBoxPassword(){
        PasswordInput2.setBackground(Color.red);
    }
    
    public void setBackTextBoxPasswordDefault(){
        PasswordInput2.setBackground(Color.WHITE);
    }
    
    public void setBackTextBoxAge(){
        AgeInput2.setBackground(Color.red);
    }
    
    public void setBackTextBoxAgeDefault(){
        AgeInput2.setBackground(Color.WHITE);
    }
    
    public void setBackTextBoxGender(){
        GenderInput2.setBackground(Color.red);
    }
    
    public void setBackTextBoxGenderDefault(){
        GenderInput2.setBackground(Color.WHITE);
    }
    
    public void setBackTextBoxHeight(){
        HeightInput2.setBackground(Color.red);
    }
    
    public void setBackTextBoxHeightDefault(){
        HeightInput2.setBackground(Color.WHITE);
    }
    
    public void setBackTextBoxWeight(){
        WeightInput2.setBackground(Color.red);
    }
    
    public void setBackTextBoxWeightDefault(){
        WeightInput2.setBackground(Color.WHITE);
    }
    
    public JButton getCreate() {
        return Create;
    }
    
    public JButton getCancel() {
        return Cancel;
    }
    
    public String getNameInput() {
        return NameInput2.getText();
    }
    
    public String getPasswordInput() {
        return PasswordInput2.getText();
    }
    
    public String getAgeInput() {
        return AgeInput2.getText();
    }
    
    public String getGenderInput() {
        return GenderInput2.getText();
    }
    
    public String getHeightInput() {
        return HeightInput2.getText();
    }
    
    public String getWeightInput() {
        return WeightInput2.getText();
    }
    
    public void setBoxInputName(String q) {
        NameInput2.setText(q);
    }
    
    public void setBoxInputPassword(String w) {
        PasswordInput2.setText(w);
    }
    
    public void setBoxInputAge(String e) {
        AgeInput2.setText(e);
    }
    
    public void setBoxInputGender(String r) {
        GenderInput2.setText(r);
    }
    
    public void setBoxInputHeight(String y) {
        HeightInput2.setText(y);
    }
    
    public void setBoxInputWeight(String x) {
        WeightInput2.setText(x);
    }

    public void setMessagee(String messagee) {
        Message2.setText(messagee);
    }
}

class MainGUIView extends JFrame {
    private JMenuItem Information;
    private JMenuItem Logout;
    private JMenuItem Name;
    private JMenuItem Password;
    private JMenuItem Age;
    private JMenuItem Height;
    private JMenuItem Weight;
    private JMenuItem Breakfast;
    private JMenuItem Lunch;
    private JMenuItem Dinner;
    private JMenuItem Light;
    private JMenuItem Moderate;
    private JMenuItem Intense;
    private JTextField tot;
    private JTextField bf;
    private JTextField ln;
    private JTextField dn;
    private JLabel mml;
    private JLabel bfl;
    private JLabel lnl;
    private JLabel dnl;
    private JLabel space;
    private JLabel space2;
    private JTextField tot2;
    private JTextField lt;
    private JTextField md;
    private JTextField in;
    private JLabel mml2;
    private JLabel ltl;
    private JLabel mdl;
    private JLabel inl;
    private JLabel space3;
    private JLabel space4;
    private JTextField totalIntake;
    private JTextField targetIntake;
    private JTextField BMIValue;
    private JTextField waterIntake;
    private JLabel toti;
    private JLabel tari;
    private JLabel bmi;
    private JLabel wi;
    private JLabel space5;
    private JLabel space6;
    
    MainGUIView() {
        setTitle("Healthy Living Planner");
        setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("Logo.png");
        setIconImage(icon.getImage());
        setMainGUI();
        setSize(699, 214);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  
    void setMainGUI()
    {
        JPanel pane = new JPanel(new FlowLayout(0 , 8, 8));
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Profile");
        Information = new JMenuItem("Information");
        Name = new JMenuItem("Name");
        Password = new JMenuItem("Password");
        Age = new JMenuItem("Age");
        Height = new JMenuItem("Height");
        Weight = new JMenuItem("Weight");
        Logout = new JMenuItem("Logout");
        menu1.add(Information);
        menu1.addSeparator();
        menu1.add(Name);
        menu1.add(Password);
        menu1.addSeparator();
        menu1.add(Age);
        menu1.addSeparator();
        menu1.add(Height);
        menu1.add(Weight);
        menu1.addSeparator();
        menu1.add(Logout);
        JMenu menu2 = new JMenu("Meals");
        Breakfast = new JMenuItem("Breakfast");
        Lunch = new JMenuItem("Lunch");
        Dinner = new JMenuItem("Dinner");
        menu2.add(Breakfast);
        menu2.addSeparator();
        menu2.add(Lunch);
        menu2.addSeparator();
        menu2.add(Dinner);
        menuBar.add(menu1);
        menuBar.add(menu2);
        JMenu menu3 = new JMenu("Exercise");
        Light = new JMenuItem("Light");
        Moderate = new JMenuItem("Moderate");
        Intense = new JMenuItem("Intense");
        menu3.add(Light);
        menu3.addSeparator();
        menu3.add(Moderate);
        menu3.addSeparator();
        menu3.add(Intense);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        setJMenuBar(menuBar);
        //pane.add(menuBar, BorderLayout.NORTH);
        
        JPanel paneE = new JPanel();
        paneE.setLayout(new GridLayout(5,2,8,8));
        paneE.setBackground(Color.lightGray);
        mml = new JLabel("Caloric Input:", JLabel.CENTER);
        space = new JLabel("", JLabel.CENTER);
        space2 = new JLabel("", JLabel.CENTER);
        bfl = new JLabel("Breakfast:", JLabel.CENTER);
        lnl = new JLabel("Lunch:", JLabel.CENTER);
        dnl = new JLabel("Dinner:", JLabel.CENTER);
        tot = new JTextField(10);
        tot.setHorizontalAlignment(JTextField.CENTER);
        tot.setEditable(false);
        tot.setOpaque(false);
        tot.setBorder(new LineBorder(Color.decode("#9d87e4"), 2));
        bf = new JTextField(10);
        bf.setHorizontalAlignment(JTextField.CENTER);
        bf.setEditable(false);
        bf.setOpaque(false);
        bf.setBorder(new LineBorder(Color.decode("#9d87e4"), 2));
        ln = new JTextField(10);
        ln.setHorizontalAlignment(JTextField.CENTER);
        ln.setEditable(false);
        ln.setOpaque(false);
        ln.setBorder(new LineBorder(Color.decode("#9d87e4"), 2));
        dn = new JTextField(10);
        dn.setHorizontalAlignment(JTextField.CENTER);
        dn.setEditable(false);
        dn.setOpaque(false);
        dn.setBorder(new LineBorder(Color.decode("#9d87e4"), 2));
        paneE.add(mml);
        paneE.add(tot);
        paneE.add(space);
        paneE.add(space2);
        paneE.add(bfl);
        paneE.add(bf);
        paneE.add(lnl);
        paneE.add(ln);
        paneE.add(dnl);
        paneE.add(dn);
        
        JPanel paneW = new JPanel();
        paneW.setLayout(new GridLayout(5,2,8,8));
        paneW.setBackground(Color.lightGray);
        mml2 = new JLabel("Caloric Output:", JLabel.CENTER);
        space3 = new JLabel("", JLabel.CENTER);
        space4 = new JLabel("", JLabel.CENTER);
        ltl = new JLabel("Light:", JLabel.CENTER);
        mdl = new JLabel("Moderate:", JLabel.CENTER);
        inl = new JLabel("Intense:", JLabel.CENTER);
        tot2 = new JTextField(10);
        tot2.setHorizontalAlignment(JTextField.CENTER);
        tot2.setEditable(false);
        tot2.setOpaque(false);
        tot2.setBorder(new LineBorder(Color.decode("#9d87e4"), 2));
        lt = new JTextField(10);
        lt.setHorizontalAlignment(JTextField.CENTER);
        lt.setEditable(false);
        lt.setOpaque(false);
        lt.setBorder(new LineBorder(Color.decode("#9d87e4"), 2));
        md = new JTextField(10);
        md.setHorizontalAlignment(JTextField.CENTER);
        md.setEditable(false);
        md.setOpaque(false);
        md.setBorder(new LineBorder(Color.decode("#9d87e4"), 2));
        in = new JTextField(10);
        in.setHorizontalAlignment(JTextField.CENTER);
        in.setEditable(false);
        in.setOpaque(false);
        in.setBorder(new LineBorder(Color.decode("#9d87e4"), 2));
        paneW.add(mml2);
        paneW.add(tot2);
        paneW.add(space3);
        paneW.add(space4);
        paneW.add(ltl);
        paneW.add(lt);
        paneW.add(mdl);
        paneW.add(md);
        paneW.add(inl);
        paneW.add(in);
        
        JPanel paneC = new JPanel();
        paneC.setLayout(new GridLayout(5,2,8,8));
        paneC.setBackground(Color.decode("#9d87e4"));
        toti = new JLabel("Total Intake:", JLabel.CENTER);
        space5 = new JLabel("", JLabel.CENTER);
        space6 = new JLabel("", JLabel.CENTER);
        tari = new JLabel("Target Intake:", JLabel.CENTER);
        bmi = new JLabel("BMI:", JLabel.CENTER);
        wi = new JLabel("Sufficient Water:", JLabel.CENTER);
        totalIntake = new JTextField(10);
        totalIntake.setHorizontalAlignment(JTextField.CENTER);
        totalIntake.setEditable(false);
        totalIntake.setOpaque(false);
        totalIntake.setBorder(new LineBorder(Color.lightGray, 2));
        targetIntake = new JTextField(10);
        targetIntake.setHorizontalAlignment(JTextField.CENTER);
        targetIntake.setEditable(false);
        targetIntake.setOpaque(false);
        targetIntake.setBorder(new LineBorder(Color.lightGray, 2));
        BMIValue = new JTextField(10);
        BMIValue.setHorizontalAlignment(JTextField.CENTER);
        BMIValue.setEditable(false);
        BMIValue.setOpaque(false);
        BMIValue.setBorder(new LineBorder(Color.lightGray, 2));
        waterIntake = new JTextField(10);
        waterIntake.setHorizontalAlignment(JTextField.CENTER);
        waterIntake.setEditable(false);
        waterIntake.setOpaque(false);
        waterIntake.setBorder(new LineBorder(Color.lightGray, 2));
        paneC.add(toti);
        paneC.add(totalIntake);
        paneC.add(space5);
        paneC.add(space6);
        paneC.add(tari);
        paneC.add(targetIntake);
        paneC.add(bmi);
        paneC.add(BMIValue);
        paneC.add(wi);
        paneC.add(waterIntake);
        pane.add(paneC);
        pane.add(paneE);
        pane.add(paneW);
        add(pane);
        JScrollPane sp = new JScrollPane(pane);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(sp);
    }
    
    public String JInput(String prompt) {
        String input;
        boolean loop = false;
        ImageIcon icn = new ImageIcon("Logo.png");
        Image image = icn.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        icn = new ImageIcon(newimg);
        do {input = (String) JOptionPane.showInputDialog(null,prompt,"Healthy Living Planner",JOptionPane.INFORMATION_MESSAGE,icn,null,""); if (prompt != null) {loop = true;}} while (loop == false || input.isEmpty() == true);
        return input;
    }
    
    public void JMessage(String promptMessage) {
        ImageIcon iconn = new ImageIcon("Logo.png");
        Image image = iconn.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        iconn = new ImageIcon(newimg);
        JOptionPane.showMessageDialog(null, promptMessage, "Healthy Living Planner", JOptionPane.INFORMATION_MESSAGE, iconn);
    }
    
    public JMenuItem getInformationMenuItem() {
        return Information;
    }
    
    public JMenuItem getLogoutMenuItem() {
        return Logout;
    }
    
    public JMenuItem getNameMenuItem() {
        return Name;
    }
    
    public JMenuItem getPasswordMenuItem() {
        return Password;
    }
    
    public JMenuItem getAgeMenuItem() {
        return Age;
    }
    
    public JMenuItem getHeightMenuItem() {
        return Height;
    }
    
    public JMenuItem getWeightMenuItem() {
        return Weight;
    }
    
    public JMenuItem getBreakfastMenuItem() {
        return Breakfast;
    }
    
    public JMenuItem getLunchMenuItem() {
        return Lunch;
    }
    
    public JMenuItem getDinnerMenuItem() {
        return Dinner;
    }
    
    public JMenuItem getLightMenuItem() {
        return Light;
    }
    
    public JMenuItem getModerateMenuItem() {
        return Moderate;
    }
    
    public JMenuItem getIntenseMenuItem() {
        return Intense;
    }
    
    public void setTotalIntake(String tint) {
        totalIntake.setText(tint);
    }
    
    public void setTargetIntake(String taint) {
        targetIntake.setText(taint);
    }
    
    public void setBMI(String taaint) {
        BMIValue.setText(taaint);
    }
    
    public void setWaterIntake(String ttint) {
        waterIntake.setText(ttint);
    }
    
    public void setTotalCaloricIntake(String tiint) {
        tot.setText(tiint);
    }
    
    public void setBreakfast(String tinnt) {
        bf.setText(tinnt);
    }
    
    public void setLunch(String tintnt) {
        ln.setText(tintnt);
    }
    
    public void setDinner(String tinlt) {
        dn.setText(tinlt);
    }
    
    public void setTotalExcersize(String tfint) {
        tot2.setText(tfint);
    }
    
    public void setLight(String tkint) {
        lt.setText(tkint);
    }
    
    public void setModerate(String ptint) {
        md.setText(ptint);
    }
    
    public void setIntense(String btint) {
        in.setText(btint);
    }
}

public class HLPView{
    public HLPView() {

    }
}