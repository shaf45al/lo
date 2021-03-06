/**  
 * Устанавливаем принадлежность класса к пакету  
 */
package aaa;

import java.awt.Color;
/**  
 * Подключаем библиотеки  
 */ 
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 
 
import javax.swing.Box; 
import javax.swing.BoxLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
 
import aaa.StrVyplata; 
 
/**   
 * Объявляем public класс, в котором осуществляется взнос страховой премии,  
 * вывод остатка по страховым взносам, а также переход к окну "Страховая выплата"  
 */  
public class LichnyKab{ 
	/**   
	 * Создаём переменную класса FileReader и присваиваем ей значение null   
	 */ 
 
	private FileReader input = null;    
	/**   
	 *  Создаём переменную типа boolean, которая соответствует наличию/отсутствию факта   
	 *  получения страховой выплаты.   
	 *  false - если страховая выплата не была получена   
	 */  
	static boolean isRun1=false;           
	String parolProverka="";    
	/**   
	 * Создаем компонент ostatokPoVznosam класса JLabel для отображения остатка по страховым   
	 * взносам   
	 */  
	static JLabel ostatokPoVznosam=new JLabel("");    
 
	/**     
	 * Объявляем конструктор класса    
	 */  
	public LichnyKab(){  }    
	/**    
	 * Метод zapusk для инициализации и отображения фрейма   
	 */    
	protected void zapusk(){   
		System.out.println("Зашел в личный кабинет"); 
 
	/**   
	 * Создаём объект класса JFrame   
	 */   
	 final JFrame s=new JFrame();       
	/**    
	 * Переменной parolProverka присваивается строка, введенная пользователем в   
	 * диалоговом окне ввода данных    
	 */   
	parolProverka=JOptionPane.showInputDialog(null, "Введите пароль", null,  JOptionPane.INFORMATION_MESSAGE);      
	JTextField textField=new JTextField(10);      
	/**   
	 * Выполняем отслеживание блока кода, где может произойти ошибка, при   
	 * помощи исключения try   
	 */ 
	try {    
		/**    
		 * Создаём объект класса FileReader с именем файла p.txt, откуда будет  
		 * происходить чтение    
		 */    input = new FileReader("p.txt");    
		/**     
		 * Сохраняем содержимое потока input в textfield     
		 */    
		 textField.read(input, "p.txt");    
		 /**     
		  * Закрываем поток     
		  */    
		 input.close();      
		 /**    
		  * Обрабатываем исключение e1 типа FileNotFoundException    
		  */   
		 } catch (FileNotFoundException e1) {    
			 /**     
			  * Печатаем исключение, которое произошло     
			  */    
			 e1.printStackTrace();       
			 /**    
			  * Обрабатываем исключение e1 типа IOException     
			  */   
			 } catch (IOException e1) {    
				 /**     
				  * Печатаем исключение, которое произошло     
				  */    
				 e1.printStackTrace();   
				 }     
	/**    
	 * Если введенный пароль верный, то выполняется настройка окна "Личный кабинет"   
	 */   
	if(textField.getText().equals(parolProverka)){     
		System.out.println("Вы правы");
		
		/**    
		 * Выполняем настройку окна    
		 */
		PanelCreator pc=new PanelCreator();  
		pc.PCreatePanel(s,
						"Личный кабинет",
						600,
						400,
						new FlowLayout(),
						JFrame.HIDE_ON_CLOSE);
		        
		/**       
		 * Создаем компоненты        
		 * vykhod класса JButton,        
		 * vnestiVznos класса JButton,        
		 * ostatokPoVznosamL класса JLabel,       
		 * polychitVyplaty класса JButton,               
		 */ 
		JPanel panel=new JPanel();    
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
		panel.setBackground(s.getContentPane().getBackground());
		
		
		JButton vykhod=new JButton("Выход"); 
		//vykhod.setPreferredSize(new Dimension(500,300));  
		//vykhod.setBackground(Color.white);
		//vykhod.setFont(new Font("TimesRoman", Font.BOLD, 100));
		
		JButton vnestiVznos=new JButton("Внести взнос");  
		//vnestiVznos.setPreferredSize(new Dimension(500,300));  
		//vnestiVznos.setBackground(Color.white);
		//vnestiVznos.setFont(new Font("TimesRoman", Font.BOLD, 100));
		
		JLabel ostatokPoVznosamL= new JLabel("Остаток по страховым взносам,руб: "); 
		//ostatokPoVznosamL.setFont(new Font("TimesRoman", Font.BOLD, 100));
		
		JButton polychitVyplaty=new JButton("Получить страховую выплату"); 
		//polychitVyplaty.setPreferredSize(new Dimension(500,300));  
		//polychitVyplaty.setBackground(Color.red);
		//polychitVyplaty.setFont(new Font("TimesRoman", Font.BOLD, 100));
		/**      
		 * В текстовый компонент ostatokPoVznosam устанавливается значение,   
		 * полученное из метода UznatOstatok() класса Formuly.      
		 * Но, если текст в текстовом компоненте ostatokPoVznosam соответствует   
		 * '0'(остаток по стр. взносам равен 0),      
		 *  то метод UznatOstatok() класса Formuly вызываться не будет      
		 */     
		if(ostatokPoVznosam.getText().equals("0"))               
			System.out.println("Остаток по взносам 0");     
		else  {      
			ostatokPoVznosam.setText(String.valueOf(UznatOstatok()));       
		}          
		/**      
		 * Устанавливаем выравнивание компонентов ostatokPoVznosamL,   
		 * ostatokPoVznosam, vnestiVznos, vykhod, polychitVyplaty (по середине)      
		 */     
		ostatokPoVznosamL.setAlignmentX(Component.CENTER_ALIGNMENT);      
		ostatokPoVznosam.setAlignmentX(Component.CENTER_ALIGNMENT);      
		vnestiVznos.setAlignmentX(Component.CENTER_ALIGNMENT);      
		vykhod.setAlignmentX(Component.CENTER_ALIGNMENT);      
		polychitVyplaty.setAlignmentX(Component.CENTER_ALIGNMENT); 
		//vykhod.setPreferredSize(new Dimension(100,100));
		

		/**      
		 * Добавляем компоненты ostatokPoVznosamL, ostatokPoVznosam,       
		 * vnestiVznos, polychitVyplaty, vykhod на панель panel      
		 */     
		panel.add(Box.createVerticalGlue());      
		panel.add(ostatokPoVznosamL);      
		/**      
		 * Вставляем пружину      
		 */     
		panel.add(Box.createVerticalGlue());      
		panel.add(ostatokPoVznosam);        
		panel.add(Box.createVerticalGlue());       
		panel.add(vnestiVznos);     
		panel.add(Box.createVerticalGlue());      
		panel.add(polychitVyplaty);     
		panel.add(Box.createVerticalGlue());      
		panel.add(vykhod);     
		panel.add(Box.createVerticalGlue());  
 
    /**      
     * Добавляем слушателя к кнопке vykhod с помощью вызова      
     * addActionListener.      
     */     
		vykhod.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent e) {       
				/**       
				 * Фрейм перестает отображаться        
				 */       
				s.setVisible(false);              
				}     
			});       
    /**      
     * Добавляем слушателя к кнопке vnestiVznos с помощью вызова      
     * addActionListener.      
     */     
		vnestiVznos.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent e) {       
				/**         
				 * Вызываем метод VnestiStrVznos()         
				 */       
				VnestiStrVznos();           
				}     
			});          
		/**      
		 * Добавляем слушателя к кнопке polychitVyplaty с помощью вызова      
		 *addActionListener.      
		 */     
		polychitVyplaty.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent e) {       
				/**        
				 * Если текст в ostatokPoVznosam соответствует   
				 * '0'(страховая премия внесена),        
				 * создаем объект класса StrVyplata и вызываем метод   
				 * zapusk()        
				 */       
				if(ostatokPoVznosam.getText().equals("0")) {        
					StrVyplata myVyplata=new StrVyplata();        
					myVyplata.zapusk();       
				}else       
					JOptionPane.showMessageDialog(null, "остаток по страховой премии не 0","Необходимо оплатить взнос", JOptionPane.PLAIN_MESSAGE);    
				}     
			});            
		s.add(panel);      
		s.setVisible(true);    
		}else
			JOptionPane.showMessageDialog(null, "Попробуйте еще раз","", JOptionPane.PLAIN_MESSAGE);
	}    
	/**   
	 * Метод VnestiStrVznos()   
	 */ 
	public void VnestiStrVznos(){   
		/**    
		 * В переменную StrPrem класса Formuly устанавливаем значение '0'    
		 */   
		OsnF.obj2.setStrPrem(0);   
		/**    
		 * В текстовый компонент ostatokPoVznosam устанавливаем значение '0'    
		 */   
		ostatokPoVznosam.setText("0");  
		}     
	/**   
	 * Метод UznatOstatok()   
	 */  
	public int UznatOstatok(){   
		/**    
		 * Вызываем метод RaschitatSP() класса Formuly    
		 */   
		return OsnF.obj2.RaschitatSP();  
		}  
	} 
     