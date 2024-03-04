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
    Label imgLabel, l1, l2, l3,l4, label;
    Font font,font1;
    JPanel panel;
    Button btn1, btn2;
    TextField text1, text2, text3,text4;
    TextArea area;

    Calculate2() {

        c = this.getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);

        font = new Font("Bodone MT", Font.BOLD, 16);
        font1 = new Font("Bodone MT", Font.BOLD, 20);

        img = new ImageIcon("D:\\My Projects\\Java Projects\\My_Java_Projects\\src\\main\\java\\Calculator\\bmi.png");
        this.setIconImage(img.getImage());

        label = new Label("BMI Calculator");
        label.setForeground(Color.white);
        label.setBounds(150, 10, 200, 50);
        label.setFont(font1);
        c.add(label);

        l1 = new Label("Enter Weight (kilogram)");
        l1.setForeground(Color.white);
        l1.setBounds(10, 70, 200, 30);
        l1.setFont(font);
        c.add(l1);
        
        text1 = new TextField();
        text1.setBounds(210, 70, 100, 30);
        text1.setFont(font);
        c.add(text1);
        
        l2 = new Label("Enter Height         (feet)");
        l2.setForeground(Color.white);
        l2.setBounds(10, 110, 200, 30);
        l2.setFont(font);
        c.add(l2);
        
        text2 = new TextField();
        text2.setBounds(210, 110, 100, 30);
        text2.setFont(font);
        c.add(text2);
        
        l3 = new Label("(Inch)");
        l3.setBounds(320,110, 50, 30);
        l3.setForeground(Color.white);
        l3.setFont(font);
        c.add(l3);
        
        text3 = new TextField();
        text3.setBounds(370, 110, 70, 30);
        text3.setFont(font);
        c.add(text3);
        
        l4 = new Label("Result: ");
        l4.setBounds(140, 150, 70, 30);
        l4.setForeground(Color.white);
        l4.setFont(font);
        c.add(l4);
        
        text4 = new TextField();
        text4.setBounds(210, 150, 100, 30);
        text4.setFont(font);
        c.add(text4);
         
        area = new TextArea();
        area.setBounds(310, 150, 200, 50);
        area.setBackground(Color.gray);
        area.setFont(font);
        c.add(area);

        btn1 = new Button("SUBMIT");
        btn1.setBounds(210, 220, 70, 30);
        btn1.setFont(font);
        btn1.addActionListener(this);
        c.add(btn1);
        
        
        btn2 = new Button("Clear");
        btn2.setBounds(290, 220, 70, 30);
        btn2.setFont(font);
        btn2.addActionListener(this);
        c.add(btn2);
        

   
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String value1 = text1.getText();
        String value2 = text2.getText();
        String value3 = text3.getText();

        if (value1.isEmpty() || value2.isEmpty() || value3.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please, Enter height and weight", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            double num1 = Double.parseDouble(value1);
            double num2 = Double.parseDouble(value2);
            double num3 = Double.parseDouble(value3);
            
            double inch = (num2 * 12)+num3;
            double meter = inch * 0.0254;
            double feet = meter * meter;

            double bmi = num1 / feet;
            int init = (int)bmi;
            
            text4.setText(String.valueOf(bmi)+" kg/m2");
            
            if(bmi<16){
                text4.setBackground(Color.red);
                area.setText("\tUnderWeight");
                area.setForeground(Color.red);
            }
            else if(bmi>=16 && bmi<18.5){
                text4.setBackground(Color.yellow);
                area.setText("\tUnderWeight");
                area.setForeground(Color.yellow);
            }
            else if(bmi>=18.5 && bmi<25){
                text4.setBackground(Color.green);
                area.setText("\tNormal");
                area.setForeground(Color.green);
            }
            else if(bmi>=25 && bmi<30){
                text4.setBackground(Color.yellow);
                area.setText("\tOverWeight");
                area.setForeground(Color.yellow);
            }
            else if(bmi>=30 && bmi<35){
                text4.setBackground(Color.orange);
                area.setText("\tObesity");
                area.setForeground(Color.orange);
            }
            else if(bmi>=35 && bmi<40){
                text4.setBackground(Color.MAGENTA);
                area.setText("\tObesity");
                area.setForeground(Color.magenta);
            }
            else{
                text4.setBackground(Color.red);
                area.setText("\tObesity");
                area.setForeground(Color.red);
            }
            
        }

        if (e.getSource() == btn2) {
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
            text4.setBackground(Color.white);
            area.setText("");
        }

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
public class BMI_Calculate{
    public static void main(String[] args) {
        Calculate2 frame = new Calculate2();
        frame.setTitle("BMI Calculator");
        frame.setBounds(200, 200, 500, 400);
        frame.setBackground(Color.cyan);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }
}
