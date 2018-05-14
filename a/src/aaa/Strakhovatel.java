/**  
 * Устанавливаем принадлежность класса к пакету  
 */
package aaa;
/**  
 * Подключаем библиотеки  
 */
import java.awt.Color; 
import java.awt.Component;
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
 
import javax.swing.Box;
import javax.swing.BoxLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
 
/**   
 * Объявляем public класс, в котором осуществляется переход к окнам "Личный кабинет" и "Регистрация"  
 */  
public class Strakhovatel{   
	/**   
	 *  Создаём переменную типа boolean, которая соответствует отображению окна         
	 *  регистрации на экране. false - если окно регистрации не отображается   
	 */  
	static boolean isRun1=false; 
 
	/**     
	 * Объявляем конструктор класса    
	 */  
	public Strakhovatel(){  }    
	/**    
	 * Метод zapusk для инициализации и отображения фрейма   
	 */ 
	protected void zapusk(){  
		/**   
		 * Создаём объект класса JFrame   
		 */  
		JFrame s=new JFrame();   
		/**    
		 * Выполняем настройку окна    
		 */  
		s.setTitle("Страхователь");  
		s.setSize(500,400);  
		/**    
		 * Указываем операцию, которая будет произведена при закрытии окна    
		 */   
		s.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   
		/**    
		 * Размещаем окно по середине экрана     
		 */  
		s.setLocationRelativeTo(null);               
		/**   
		 * Устанавливаем менеджер GridLayout для расположения компонентов на фрейме   
		 */ 
		s.setLayout(new GridLayout());     
		/**    
		 * Создаем компоненты     
		 * zaregat класса JButton,     
		 * lichKab класса JButton,     
		 * podatZayavL класса JLabel,    
		 * и компонент-контерйнер panel класса JPanel, который будет содержать   
		 * вышеперечисленные компоненты    
		 */  
		JPanel panel=new JPanel();  
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));   
		JButton zaregat=new JButton("Регистрация");  
		zaregat.setForeground(Color.BLUE); 
		JButton lichKab=new JButton("Войти в личный кабнет");  
		JLabel podatZayavL=new JLabel("Еще не зарегистрированы?"); 
		
		/**    
		 * Устанавливаем выравнивание компонентов zaregat, lichKab и podatZayavL   
		 * (по середине)    
		 */ 
		zaregat.setAlignmentX(Component.CENTER_ALIGNMENT);   
		lichKab.setAlignmentX(Component.CENTER_ALIGNMENT);  
		podatZayavL.setAlignmentX(Component.CENTER_ALIGNMENT);    
		/**    
		 * Добавляем компоненты lichKab, podatZayavL, zaregat на панель    
		 */  
		panel.add(Box.createVerticalGlue(),0);  
		panel.add(lichKab);    
		/**    
		 * Вставляем пружину    
		 */   
		panel.add(Box.createVerticalGlue());  
		panel.add(podatZayavL); 
		panel.add(zaregat); 
		panel.add(Box.createVerticalGlue());  
 
		/**    
		 * Добавляем слушателя к кнопке zaregat с помощью вызова    
		 *addActionListener.    
		 */
		zaregat.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) {  
				/**      
				 * Создаем объект класса Registracya и вызываем метод zapusk()      
				 */   
				Registracya p=new Registracya();  
				p.zapusk();    
			}   
		});     
		/**    
		 * Добавляем слушателя к кнопке lichKab с помощью вызова    
		 *addActionListener.    
		 */  
		lichKab.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) {   
				/**      
				 * Создаем объект класса Registracya и вызываем метод zapusk()      
				 */  
				LichnyKab l=new LichnyKab();   
				l.zapusk(); 
			}  
		});   
		
		s.add(panel); 
		s.setVisible(true);  
	}   
}
