package SalaryCalc;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	// Создаем окно калькулятора:
	static JPanel panel = new JPanel();
	//JPanel panel2 = new JPanel();
	// Создаем кнопку для выбора работы калькулятора:
	JButton byxgalterButton = new JButton("Бухгалтер");
	static JButton rabot9gaButton = new JButton("Сотрудник");
	JButton exitButton = new JButton("Выход");
	JLabel label=new JLabel("Выберите пользователя:"); //надпись № 1
	
	MainFrame() {
		super("Калькулятор расчета заработной платы");
		// Завершение программы при закрытии окна:
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //разместить по середине экрана форму frame 

		// Установка размеров окна и расположение элементов:
		  setSize(250, 125);//Размер главного окна

			
		  panel.setLayout(new FlowLayout());// Метод расположения кнопок
		  
		  panel.setBackground(Color.WHITE);// Фон главного окна
		  
		  byxgalterButton.setBackground(Color.GREEN);// Фон кнопки БУХГАЛТЕР
		  rabot9gaButton.setBackground(Color.GREEN);// Фон кнопки СОТРУДНИК
		  exitButton.setBackground(Color.RED);// Фон кнопки ВЫХОД
		  
		  label.setForeground(Color.BLACK);//Цвет шрифта ВЫБЕРИТЕ ПОЛЬЗОВАТЕЛЯ
		  byxgalterButton.setForeground(Color.BLACK);//Цвет шрифта БУХГАЛТЕР
		  rabot9gaButton.setForeground(Color.BLACK);//Цвет шрифта СОТРУДНИК
		  exitButton.setForeground(Color.BLACK);//Цвет шрифта ВЫХОД
		  
          panel.add(label);
          panel.add(byxgalterButton); 
          panel.add(rabot9gaButton);
          panel.add(exitButton);
          add(panel);
          
          byxgalterButton.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent ae) {
                          new SalaryCalc();
                      }
                  });
          rabot9gaButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent ae) {
                  new SalaryCalcjunior();
              }
          });
			

/*	exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
		});*/
          
         class CustomListener implements MouseListener {
        	  
              public void mouseClicked(MouseEvent e) {
                   JButton exitButton = (JButton) e.getSource();
                   String text = "<html><b>" + exitButton.getText()
                             + " mouseReleased() <br>" + exitButton.getText()
                             + " mouseClicked() </b><html>";
                   label.setText(text);
              }
     
              public void mouseEntered(MouseEvent e) {
                   JButton exitButton = (JButton) e.getSource();
                   label.setText(exitButton.getText() + " mouseEntered()");
              }
     
              public void mouseExited(MouseEvent e) {
                   JButton exitButton = (JButton) e.getSource();
                   label.setText(exitButton.getText() + " mouseExited()");
              }
     
              public void mousePressed(MouseEvent e) {
                   JButton exitButton = (JButton) e.getSource();
                   label.setText(exitButton.getText() + " mousePressed()");
              }
     
              public void mouseReleased(MouseEvent e) {
                   JButton exitButton = (JButton) e.getSource();
                   label.setText(exitButton.getText() + " mouseReleased()");
              }
         }
          
	}
	public static void main(String[] args) {
		// Создаем объект класса Counter (калькулятора):
	MainFrame rgr = new MainFrame();
		// Запускаем окно калькулятора:
		rgr.setVisible(true);
	}
}
