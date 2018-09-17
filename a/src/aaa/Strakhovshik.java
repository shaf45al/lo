/**  
 * Устанавливаем принадлежность класса к пакету  
 */ 
package aaa;

/**  
 * Подключаем библиотеки  
 */ 
import java.awt.Color; 
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.Box;
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
  * Метод zapusk для инициализации и отображения фрейма   
  */   
	public void zapusk(){    
		JFrame s=new JFrame();       
		PanelCreator pc=new PanelCreator();  
		pc.PCreatePanel(s,
						"Страховщик",
						600,
						400,
						new FlowLayout(),
						JFrame.HIDE_ON_CLOSE);	
 

		JPanel panel=new JPanel();   	
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(s.getContentPane().getBackground());
		  
		JLabel label=new JLabel("Введите страховые тарифы!");    
		label.setForeground(Color.RED); 
		//label.setFont(new Font("TimesRoman", Font.BOLD, 100));
		
		JButton VnestiKoef=new JButton("Сохранить"); 
		//VnestiKoef.setPreferredSize(new Dimension(500,300));  
		//VnestiKoef.setBackground(Color.white);
		//VnestiKoef.setForeground(Color.red);
		//VnestiKoef.setFont(new Font("TimesRoman", Font.BOLD, 100));
		
		 final JTextField predprKoefTF=new JTextField("0");       
		 //predprKoefTF.setBackground(Color.BLUE);
		
		 /**    
			 * Создаем компонент predprKoefL класса JLabel    
			 */   
			JLabel predprKoefL=new JLabel("Коэффициент для расчета страховых взносов: "); 
			//predprKoefL.setForeground(Color.RED); 
			//predprKoefL.setFont(new Font("TimesRoman", Font.BOLD, 100));
			/**   
			 *  В поле predprKoefTF устанавливаем значение, полученное из метода getPredKoef()    
			 * класса Formuly     
			 */   
			predprKoefTF.setText(Double.toString(OsnF.obj2.getPredKoef())); 
			
			/**
			 * чтобы текстовое поле не растягивалось вертикально
			 */
			predprKoefTF.setMaximumSize(new Dimension(300, predprKoefTF.getMinimumSize().height));
	 		
		 
		/**    
		 * Устанавливаем выравнивание компонентов (по середине)    
		 */   
		predprKoefL.setAlignmentX(Component.CENTER_ALIGNMENT);  
		predprKoefTF.setAlignmentX(Component.CENTER_ALIGNMENT);    
		label.setAlignmentX(Component.CENTER_ALIGNMENT);   
		VnestiKoef.setAlignmentX(Component.CENTER_ALIGNMENT); 
		/**    
		 * Добавляем компоненты label, panelStrPredpRisk, VnestiKoef на панель panel    
		 */  
		panel.add(Box.createVerticalGlue(),0); 
		panel.add(label); 
		panel.add(predprKoefL); 
		panel.add(Box.createVerticalGlue());
		panel.add(predprKoefTF);
		panel.add(Box.createVerticalGlue());
		panel.add(VnestiKoef);  
		panel.add(Box.createVerticalGlue());  
		
		/**    
		 * Добавляем основную панель на фрейм   
		 */   
		s.add(panel); 
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
