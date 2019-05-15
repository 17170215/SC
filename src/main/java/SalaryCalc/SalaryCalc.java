/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalaryCalc;

//добавляем библиотеки для работы с текстовыми полями, метками, 
//для создания графического окна
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

//Главный класс, реализуюй интерфейс ActionListener
//Интерфейс нужен для обработки события нажатия на кнопку
public class SalaryCalc implements ActionListener{

    
    JFrame frame = new JFrame("Зарплатный калькулятор"); //главное окно
    JPanel panelLeft = new JPanel(); //панель с метками
    JPanel panelRight = new JPanel(); //панель с текстовыми полями
    JPanel panelBottom = new JPanel(); //панель с кнопками 
    public JTextField[] arrTf = new JTextField[10];//массив текстовых полей
    
    
    //конструктор
    public SalaryCalc(){
        
        //устанавливаем менеджер компоновки для панели с метками
        //делаем выравнивание по вертикали
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        //устанавлиаем  размер 250 на 300 пикселей
        panelLeft.setPreferredSize(new Dimension(250, 300));
        
        //устанавливаем менеджер компоновки для панели с текстовыми полями
        //делаем выравнивание по вертикали
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        //устанавливаем  размер 130 на 300 пикселей
        panelRight.setPreferredSize(new Dimension(130,300));
        
        //добавлям метки через метод addLabel
        addLabel(panelLeft, "Ф.И.О.:", Color.RED);
        addLabel(panelLeft, "Тарифная ставка (в час):", Color.RED);
        addLabel(panelLeft, "Рабочий день (часы):", Color.RED);
        addLabel(panelLeft, "Количество отработанных дней:", Color.RED);
        addLabel(panelLeft, "Налоговая ставка (%)*:", Color.RED);
        addLabel(panelLeft, "Ф.И.О.:", Color.GREEN);
        addLabel(panelLeft, "Чистый заработок(без налогов):", Color.GREEN);
        addLabel(panelLeft, "Премия***:", Color.GREEN);
        addLabel(panelLeft, "Подоходный налог:", Color.GREEN);
        addLabel(panelLeft, "Сумма к выдаче:", Color.GREEN);
        
        //добавляем текстовые поля через цикл и записываем их в массив
        for(int i=0; i<arrTf.length; i++){
            //записываем ссылку из метода в массив для дальнейшей работы с 
            //тестовым поелм
            arrTf[i] = addTextField(panelRight);
        }
        
        //добавляем кнопки расчета и сброса
        JButton calc = addButton(panelBottom, "Расчет");
        //добавляем слушатель на событие нажатия
        calc.addActionListener(this);
        JButton reset = addButton(panelBottom, "Сброс");
        //добавляем слушатель на событие нажатия
        reset.addActionListener(this);
        
        
        //делаем главную форму видимой
        frame.setVisible(true);
        //устанавливаем действие при нажатии на крестик - завершение приложения
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //устанавливаем начальное положение относительно центра экрана (по центру)
        frame.setLocationRelativeTo(null);
        //Устанавливаем размер главного окна(400 на 285)
        frame.setSize(400,285);
        //Добавляем метку с информацией к работе в самый верх окна
        JLabel top = new JLabel("Красные поля являются обязательными для заполнения");
        //устанавливаем выравнивание текста в метке по центру
        top.setHorizontalAlignment(JLabel.CENTER);
        
        //добавляем панели на клавное окно
        frame.add(top, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelRight, BorderLayout.EAST);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.setResizable(false); //запрещаем изменение размеров главного окна
        
    }
    
    
    //метод добавления текстовых меток
    public void addLabel(JComponent container, String name, Color color){
        //создаем тестовую метку с именем name
        JLabel lb = new JLabel(name);
        //устанавливаем максимально допустимый размер
        lb.setMaximumSize(new Dimension(400,20));
        //устанавливаем цвета текста
        lb.setForeground(color);
        //устанавливаем выравнивание по правому краю
        lb.setHorizontalAlignment(JLabel.RIGHT);
        //добавляем рамку
        lb.setBorder(new EtchedBorder());
        //Добавляем текстовую метку в панель
        container.add(lb);
    }
    
    //метод добавления текстовых полей
    public JTextField addTextField(JComponent container){
        //Создаем текстовое поле
        JTextField tf = new JTextField();
        //устанавливаем его максимально допустимый размер
        tf.setMaximumSize(new Dimension(150,20));
        
        //добавляем текстовое поле на панель
        container.add(tf);
        //возвращаем ссылку на текстовое поле
        return tf;
    }
    
    //метод добавления кнопок
    public JButton addButton(JComponent container, String name){
        //Создаем кнопку
        JButton btn = new JButton(name);
        //Устанавливаем максимально допустимый размер
        btn.setMaximumSize(new Dimension(100,20));
        //Выравниваем по горизонтали по центру
        btn.setHorizontalAlignment(JButton.CENTER);
        
        //добавляем кнопку на панель
        container.add(btn);
        //возвращаем ссылку на кнопку
        return btn;
    }
    
    
    //метод расчета зарплаты
    public void calcSalary() throws Exception{
    	String lol= String.format(arrTf[0].getText());
        //получаем текст из первого текстового поля, преобразовываем его в тип double и записываем
        //в переменную ставка
        double stavka = Double.valueOf(arrTf[1].getText()); //ставка
        double hours = Double.valueOf(arrTf[2].getText()); //часы работы
        double days = Double.valueOf(arrTf[3].getText()); //дни работы
        double stavkaNalog = Double.valueOf(arrTf[4].getText()); //ставка налога
        double pribil = stavka * hours * days; //расчет прибыли
        double prem = pribil * 0.1; //расчет премии 
        double nalog = (pribil + prem) * stavkaNalog / 100; //расчет налога
        double result = pribil + prem - nalog; //считаем зп на руки
        arrTf[5].setText(String.format(lol));
        arrTf[6].setText(String.format("%.2f", pribil)); //выводим прибыль в 5-е текстовое поле
        arrTf[7].setText(String.format("%.2f", prem)); //выводим премию в 6-е т.п.
        arrTf[8].setText(String.format("%.2f", nalog)); //выводим налог в 7-е т.п.
        arrTf[9].setText(String.format("%.2f", result)); //выводим зп на руки в 8-е т.п.
    }

    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SalaryCalc();
            }
        });
    }
    */

    //Метод обработки события нажатия на кнопку
    public void actionPerformed(ActionEvent e) {
        //узнаем имя кнопки, на которую нажали
        if (e.getActionCommand().equals("Расчет")) {
            try {
                //выполняем расчет зарплаты
               calcSalary();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
            
        }else{
            //Выходим
        	System.exit(0);            }
        }
        
    }
    

