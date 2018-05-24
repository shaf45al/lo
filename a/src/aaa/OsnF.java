/**  
 * Устанавливаем принадлежность класса к пакету  
 */ 
package aaa;

/**  
 * Подключаем библиотеки  
 */ 
import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 
 
/**   
 * Объявляем public класс, в котором осуществляется выбор вида пользователя  
 */ 
public class OsnF {  
	/**   
	 *  Создаём объект obj2 класса Formuly   
	 */   
	static Formuly obj2 = new Formuly();     
	/**     
	 * Объявляем конструктор класса    
	 */   
	public OsnF(){   }     
	/**    
	 * Метод zapusk    
	 */   
	public void zapusk(){   
		/**   
		 * Создаём объект класса JFrame   
		 */   
		JFrame s=new JFrame();      
		/**    
		 * Выполняем настройку окна    
		 */   
		s.setTitle("Добро пожаловать!  Выберите пользователя: ");    
		s.setSize(600,400);    
		/**    
		 * Указываем операцию, которая будет произведена при закрытии окна    
		 */  
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		/**    
		 * Размещаем окно по середине экрана     
		 */  
		s.setLocationRelativeTo(null);    
		/**   
		 * Устанавлваем менеджер BorderLayout для расположения компонентов на фрейме   
		 */  
		s.setLayout(new BorderLayout()); 
		/**    
		 * Создаем кнопки StrakhovatelB и StrakhovshikB для выбора вида пользователя    
		 * и панель panel, на которой они будут расположены    
		 */   
		JPanel panel=new JPanel();  
		panel.setLayout(new GridLayout(1,2));  
		JButton StrakhovatelB=new JButton("Страхователь");   
		JButton StrakhovshikB=new JButton("Страховщик"); 
		//StrakhovshikB.setFont(new Font("TimesRoman", Font.BOLD, 100));
		//StrakhovshikB.setPreferredSize(new Dimension(500,300));
		//StrakhovshikB.setBackground(Color.blue);
		/**    
		 * Устанавливаем цвет текста кнопки StrakhovatelB    
		 */  
		StrakhovatelB.setForeground(Color.RED);   
		/**    
		 * Устанавливаем цвет текста кнопки StrakhovshikB    
		 */   
		StrakhovshikB.setForeground(Color.BLUE);                    
		/**    
		 *Добавляем слушателя к кнопке StrakhovatelB с помощью вызова    
		 *addActionListener    
		 */ 
		StrakhovatelB.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) {    
				/**      
				 * Создаем объект класса Strakhovatel и вызываем метод zapusk()      
				 */    
				Strakhovatel myStrakhovatel= new Strakhovatel();                               
				myStrakhovatel.zapusk();    
		}});     
		/**    
		 *Добавляем слушателя к кнопке StrakhovshikB с помощью вызова    
		 *addActionListener    
		 */ 
		StrakhovshikB.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) {     
				/**      
				 * Создаем объект класса Strakhovshik и вызываем метод zapusk      
				 */    
				Strakhovshik strakh=new Strakhovshik();     
				strakh.zapusk();              
		}});      
		/**    
		 * Добавляем кнопки StrakhovatelB , StrakhovshikB на панель    
		 */   
		panel.add(StrakhovatelB);   
		panel.add(StrakhovshikB); 
 
		/**    
		 * Создаем панель panel1c    
		 */   
		JPanel panel1=new JPanel();  
		panel1.setLayout(new FlowLayout());   
		/**    
		 *Устанавливаем цвет фона панели    
		 */   
		panel1.setBackground(Color.WHITE);                       
		/**    
		 * Создаём компонент kopiright класса JLabel и добавляем его на панель panel1    
		 */  
		JLabel kopiright= new JLabel("copyright © 2018"); 
		//kopiright.setForeground(Color.RED);
		//kopiright.setFont(new Font("TimesRoman", Font.BOLD, 100));
		panel1.add(kopiright);            
		/**    
		 *Добавляем panel и panel1 на фрейм    
		 */   
		s.add(panel,BorderLayout.CENTER);  
		s.add(panel1,BorderLayout.PAGE_END); 
		s.setVisible(true); 
	}
} 
