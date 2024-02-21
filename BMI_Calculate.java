package Calculator;


import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Calculate2 extends JFrame implements ActionListener {

    Container c;
    ImageIcon img, img1;
    Label imgLabel, l1, l2, l3, label;
    Font font,font1;
    JPanel panel;
    Button btn1, btn2;
    TextField text1, text2, text3;
    TextArea area;

    Calculate2() {

        c = this.getContentPane();
       c.setBackground(Color.black);
        c.setLayout(null);

        font = new Font("Bodone MT", Font.BOLD, 16);
        font1 = new Font("Bodone MT", Font.BOLD, 20);

        img = new ImageIcon("D:\\My Projects\\Java Projects\\My_Java_Projects\\src\\main\\java\\Calculator\\bmi.png");
        this.setIconImage(img.getImage());

        label = new Label("BMI Calculator");
        label.setForeground(Color.white);
        label.setBounds(130, 10, 200, 50);
        label.setFont(font1);
        c.add(label);

        l1 = new Label("Enter Weight(kilogram)");
        l1.setForeground(Color.white);
        l1.setFont(font);
        l2 = new Label("Enter Height(feet)");
        l2.setForeground(Color.white);
        l2.setFont(font);
        l3 = new Label("     Result:   ");
        l3.setForeground(Color.white);
        l3.setFont(font);
        
        
        area = new TextArea();
        area.setBounds(70, 360, 250, 50);
        area.setBackground(Color.black);
        area.setFont(font);
        c.add(area);

        text1 = new TextField(6);
        text1.setFont(font);
        text2 = new TextField(6);
        text2.setFont(font);
        text3 = new TextField(6);
        text3.setFont(font);

        btn1 = new Button("SUBMIT");
        btn1.setFont(font);
        btn1.addActionListener(this);
        btn2 = new Button("Clear");
        btn2.setFont(font);
        btn2.addActionListener(this);
        

        panel = new JPanel();
        panel.setBounds(70, 60, 250, 300);
        panel.setBackground(Color.black);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 10));
        panel.add(l1);
        panel.add(text1);
        panel.add(l2);
        panel.add(text2);
        panel.add(btn1);
        panel.add(l3);
        panel.add(text3);
        
        panel.add(btn2);

        c.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String value1 = text1.getText();
        String value2 = text2.getText();

        if (value1.isEmpty() && value2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please, Enter height and weight", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            double num1 = Double.parseDouble(value1);
            double num2 = Double.parseDouble(value2);
            double meter = num2 * 0.3048;
            double feet = meter * meter;

            double bmi = num1 / feet;
            int init = (int)bmi;
            
            text3.setText(String.valueOf(init)+" kg/m2");
            
            if(init<16){
                text3.setBackground(Color.red);
                area.setText("\t    UnderWeight");
                area.setForeground(Color.red);
            }
            else if(init>=16 && init<18.5){
                text3.setBackground(Color.yellow);
                area.setText("\t    UnderWeight");
                area.setForeground(Color.yellow);
            }
            else if(init>=18.5 && init<25){
                text3.setBackground(Color.green);
                area.setText("\t          Normal");
                area.setForeground(Color.green);
            }
            else if(init>=25 && init<30){
                text3.setBackground(Color.yellow);
                area.setText("\t    OverWeight");
                area.setForeground(Color.yellow);
            }
            else if(init>=30 && init<35){
                text3.setBackground(Color.orange);
                area.setText("\t          Obesity");
                area.setForeground(Color.orange);
            }
            else if(init>=35 && init<40){
                text3.setBackground(Color.MAGENTA);
                area.setText("\t        Obesity");
                area.setForeground(Color.magenta);
            }
            else{
                text3.setBackground(Color.red);
                area.setText("\t        Obesity");
                area.setForeground(Color.red);
            }
            
        }

        if (e.getSource() == btn2) {
            text1.setText("");
            text2.setText("");
            text3.setText("");
            area.setText("");
        }

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
public class BMI_Calculate{
    public static void main(String[] args) {
        Calculate2 frame = new Calculate2();
        frame.setTitle("BMI Calculator");
        frame.setBounds(200, 200, 400, 450);
        frame.setBackground(Color.cyan);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }
}
