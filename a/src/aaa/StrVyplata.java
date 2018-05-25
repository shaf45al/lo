/**  
 * Устанавливаем принадлежность класса к пакету  
 */ 
package aaa;
import java.awt.Color;
/**  
 * Подключаем библиотеки  
 */ 
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout; 
import javax.swing.Box; 
import javax.swing.BoxLayout; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
 
/**   
 * Объявляем public класс, в котором осуществляется предоставление информации относительно страховой выплаты  
 */
public class StrVyplata{     
	/**       
	 * Объявляем и инициализируем переменную типа String для полученного дохода       
	 */   
	String poluchD="0";    
	/**     
	 * Объявляем конструктор класса    
	 */ 
	public StrVyplata(){  }   
	/**    
	 * Метод zapusk для инициализации и отображения фрейма   
	 */  
	public void zapusk(){   
		/**   
		 * Создаём объект класса JFrame   
		 */  
		JFrame s=new JFrame();    
		/**    
		 * если isRun1 равно false (страховая выплата еще не была получена) выполняется блок   
		 * кода внутри фигурных скобок    
		 */  
		if(LichnyKab.isRun1==false){   
			/**     
			 * переменной isRun1 класса LichnyKab задается значение true, т.к. счиатем, что   
			 * страховая выплата получена     
			 */
			LichnyKab.isRun1=true;      
			/**     
			 * Переменной poluchD присваивается строка, введенная пользователем в   
			 * диалоговом окне ввода данных     
			 */ 
			poluchD = JOptionPane.showInputDialog(null, "Введите полученный ущерб", null,  JOptionPane.INFORMATION_MESSAGE);     
			
			/** 
			 * Если poluchD не равно null (пользователь не закрыл окно ввода получ.дохода), выполняется следущий блок 
			 */
			if (!(poluchD == null)) {
			/**     
			 * Проверяем,соответствует ли данная строка регулярному выражению [0-9]+
			 * [0-9] значит, что строка содержит цифру
			 * + означает "один или несколько раз"
			 * Если строка НЕ соответствует данному выражению, то выполняется след. блок кода
			 */  
			if (!(poluchD.matches("[0-9]+")) ) {
				JOptionPane.showMessageDialog(null, "Доход должен быть целым числом", null, JOptionPane.PLAIN_MESSAGE);
				LichnyKab.isRun1=false;    
				s.setVisible(false);   
				}   
			else {       
				/**      
				 * Выполняем настройку окна "Страховая выплата"      
				 */    
				s.setTitle("Страховая выплата"); 
				s.setSize(600,400);       
				/**      
				 * Размещаем окно по середине экрана       
				 */   
				s.setLocationRelativeTo(null);                         
				s.setLayout(new GridLayout());       
				/**      
				 * Создаем компоненты       
				 * label класса JLabel,       
				 * strVyplataL класса JLabel,       
				 * pravila класса JLabel,      
				 * pravila1 класса JLabel,      
				 * и компонент-контерйнер panel класса JPanel, который будет содержать   
				 * вышеперечисленные компоненты      
				 */   
				JPanel panel=new JPanel();    
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
 
				JLabel label=new JLabel("Сумма страховой выплаты, руб:");  
				/**      
				 * В метку strVyplataL устанавливается значение, полученное из метода       
				 * UznatStrVyp(int poluchD)      
				 */   
				JLabel strVyplataL=new   JLabel(String.valueOf(UznatStrVyp(Integer.parseInt(poluchD)))); 
				//strVyplataL.setFont(strVyplataL.getFont().deriveFont(300f));
 
				JLabel pravila=new JLabel("Для получения страховой выплаты");    
				JLabel pravila1=new  JLabel("обратитесь в приемный отдел по адресу: ул.Гафури, д.76"); 
				//pravila.setForeground(Color.pink);pravila1.setForeground(Color.pink);
				/**      
				 * Устанавливаем выравнивание компонентов label, strVyplataL, pravila и   
				 * pravila1 (по середине)      
				 */     
				label.setAlignmentX(Component.CENTER_ALIGNMENT);      
				strVyplataL.setAlignmentX(Component.CENTER_ALIGNMENT);      
				pravila.setAlignmentX(Component.CENTER_ALIGNMENT);      
				pravila1.setAlignmentX(Component.CENTER_ALIGNMENT);  
 
				/**      
				 * Добавляем компоненты label, strVyplataL, pravila и pravila1 на панель   
				 * panel      
				 */     
				panel.add(Box.createVerticalGlue());       
				panel.add(label);     
				/**      
				 * Вставляем пружину      
				 */    
				panel.add(Box.createVerticalGlue());     
				panel.add(strVyplataL);     
				panel.add(Box.createVerticalGlue());     
				panel.add(pravila);     
				panel.add(pravila1);     
				panel.add(Box.createVerticalGlue());  
 
				s.add(panel);    
				s.setVisible(true);  
				}  
			}else
				/** 
				 * Т.к. пользователь закрыл окно ввода получ. дохода считаем, что стр.выплата не была получена
				 */
				LichnyKab.isRun1=false;    
			}  else
				JOptionPane.showMessageDialog(null, "Страховая выплата уже была предоставлена! ", "Повторное получение", JOptionPane.PLAIN_MESSAGE);
		}    
	/**   
	 * Метод UznatStrVyp(int poluchD)   
	 */  
	protected int UznatStrVyp(int poluchD){   
		/**    
		 * Сохраняем переданное значение в качестве полученного дохода     
		 * с помощью метода setdPol(int poluchD) класса Formuly    
		 */  
		OsnF.obj2.setdPol(poluchD);  
		/**    
		 * Возвращаем значение, полученное из метода RaschitatSV() класса Formuly    
		 */ 
		return OsnF.obj2.RaschitatSV();  
	}
}