/**  
 * Устанавливаем принадлежность класса к пакету  
 */ 
package aaa;

/**  
 * Подключаем библиотеки  
 */ 
import java.awt.Color; 
import java.awt.Component; 
import java.awt.FlowLayout; 
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; 
import java.awt.Insets; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.BoxLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JTextField; 
 
/**   
 * Объявляем public класс, в котором осуществляется установка страхового тарифа  
 */  
public class Strakhovshik{ 
 
 /**     
  * Объявляем конструктор класса    
  */    
	public Strakhovshik(){  
	} 
 
 /**    
  * Метод zapusk для инициализации и отображения фрейма   
  */   
	public void zapusk(){   
		/**   
		 * Создаём объект класса JFrame   
		 */   
		JFrame s=new JFrame();       
		/**    
		 * Выполняем настройку окна    
		 */  
		s.setTitle("Страховщик");    
		s.setSize(600,400);    
		/**    
		 * Указываем операцию, которая будет произведена при закрытии окна    
		 */   
		s.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);    
		/**    
		 * Размещаем окно по середине экрана     
		 */   
		s.setLocationRelativeTo(null);                         
		/**   
		 * Устанавлваем менеджер FlowLayout для расположения компонентов на фрейме   
		 */   
		s.setLayout(new FlowLayout());    
 
		/**    
		 * Создаем компонент-контерйнер panel класса JPanel, который будет содержать панель   
		 *для вида страхования, метки и кнопку "Сохранить"    
		 */   
		JPanel panel=new JPanel();   
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));      
		/**    
		 * Создаем компонент-контерйнер panelStrPredpRisk класса JPanel для вида страхования    
		 */   
		JPanel panelStrPredpRisk=new JPanel();   
		/**    
		 * Создаем компонент label класса JLabel     
		 */   
		JLabel label=new JLabel("Введите страховые тарифы!");   
		/**    
		 * Устанавливаем цвет текста метки label    
		 */   
		label.setForeground(Color.RED);     
		/**    
		 * Создаем компонент rules класса JLabel для правил ввода коэффициента     
		 */   
		JLabel rules=new JLabel("Правила ввода коэффициентов: .5=0.5 и 5.=5.0");   
		/**    
		 * Создаем компонент VnestiKoef класса JButton    
		 */  
		JButton VnestiKoef=new JButton("Сохранить");       
		 final JTextField predprKoefTF=new JTextField("0");       
		/**    
		 * Устанавливаем выравнивание компонентов panelStrPredpRisk, label и VnestiKoef   
		 *(по середине)    
		 */   
		panelStrPredpRisk.setAlignmentX(Component.CENTER_ALIGNMENT);    
		label.setAlignmentX(Component.CENTER_ALIGNMENT);   
		VnestiKoef.setAlignmentX(Component.CENTER_ALIGNMENT); 
		rules.setAlignmentX(Component.CENTER_ALIGNMENT); 
		/**    
		 * Добавляем компоненты label, panelStrPredpRisk, VnestiKoef на панель panel    
		 */  
		panel.add(label);  
		panel.add(panelStrPredpRisk);  
		panel.add(VnestiKoef);   
		panel.add(rules);
		/**    
		 * Добавляем основную панель на фрейм   
		 */   
		s.add(panel);       
		/**    
		 * Устанавливаем вид менеджера GridBagLayout для размещения компонентов на панели   
		 * panelStrPredpRisk    
		 */   
		panelStrPredpRisk.setLayout(new GridBagLayout()); 
 
		/**    
		 * Создаем компонент predprKoefL класса JLabel    
		 */   
		JLabel predprKoefL=new JLabel("Коэффициент для расчета страховых взносов: "); 
		/**   
		 *  В поле predprKoefTF устанавливаем значение, полученное из метода getPredKoef()    
		 * класса Formuly     
		 */   
		predprKoefTF.setText(Double.toString(OsnF.obj2.getPredKoef()));                        
		/**    
		 * Добавляем компоненты predprKoefL, predprKoefTF, VnestiKoef на панель   
		 * panelStrPredpRisk    
		 */   
		panelStrPredpRisk.add(predprKoefL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));   
		panelStrPredpRisk.add(predprKoefTF,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));   
		panelStrPredpRisk.add(VnestiKoef,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));     
		/**    
		 * Добавляем слушателя к кнопке VnestiKoef с помощью вызова    
		 *addActionListener.    
		 */  
		VnestiKoef.addActionListener(new ActionListener() {    
			public void actionPerformed(ActionEvent e) {  
				try { 
					/**       
					 * Вызываем метод sohranitKoef(double koef)       
					 */     
					sohranitKoef(Double.parseDouble(predprKoefTF.getText())); 
					JOptionPane.showMessageDialog(null,"Коэффициент сохранен: "+OsnF.obj2.getPredKoef(), "", JOptionPane.PLAIN_MESSAGE);
					/**      
					 * Обрабатываем исключение e типа Exception     
					 */    
				} catch (Exception e1) {      
					JOptionPane.showMessageDialog(null, "Вводить можно только числа. Если число действительное, то дробная часть числа должна отделяться точкой ", "Проверьте правильность ввода и попробуйте еще раз", JOptionPane.ERROR_MESSAGE);     
				}
			 
				}   
			}); 
 
		s.setVisible(true);  
	}    
/**   
 * Метод sohranitKoef(double koef).   
 * При вызове метода происходит сохранение переданного значения в качестве коэффициента    
 * страхования с помощью метода setPredKoef(double predKoef) класса Formuly   
 */ 
	public void sohranitKoef(double koef) {   
		OsnF.obj2.setPredKoef(koef);  
		} 
	} 
