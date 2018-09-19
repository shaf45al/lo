/**  
 * Устанавливаем принадлежность класса к пакету  
 */ 
package aaa;

/**  
 * Подключаем библиотеки  
 */ 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

 
/**   
 * Объявляем public класс, в котором осуществляется выбор вида пользователя  
 */ 
public class OsnF {  
  
	private JButton Strakhovatel;
	private JButton StrakhovshikB;
	
	private JButton ButtonName[]= {Strakhovatel,StrakhovshikB};
	private String Button_keys_label[] = {"Страхователь","Страховщик"};
	
	 static Formuly obj2 = new Formuly();     
	 private ComponentsCreator cc; 
	 private PanelCreator pc;   
	
	 
	 
	public void zapusk(){   	
		/**   
		 * Создаём объект класса JFrame   
		 */   
		JFrame s=new JFrame(); 
		pc=new PanelCreator();
		cc = new ComponentsCreator(s);
		
		/**    
		 * Выполняем настройку окна    
		 */   
		pc.PCreatePanel(s,
						"Добро пожаловать!  Выберите пользователя: ",
						600,
						400,
						new GridLayout(1,2),
						JFrame.EXIT_ON_CLOSE);
  		
		 
		
		for(int i=0;i<ButtonName.length;i++) {
			/**
			 * Создаем экземпляр класса
			 */
        	ButtonName[i] = new JButton();
        	cc.PJButtonSettings(ButtonName[i], Button_keys_label[i]);
        	
        	ButtonName[i].addActionListener(new ActionListener() {   
    			public void actionPerformed(ActionEvent e) {     
    				/**
    				 * Проверка нажатия на кнопку ButtonName[0](button_AddObject)
    				 */
    					if (e.getSource() == ButtonName[0]) {
    						/**      
    						 * Создаем объект класса Strakhovatel и вызываем метод zapusk()      
    						 */    
    						Strakhovatel myStrakhovatel= new Strakhovatel();                               
    						myStrakhovatel.zapusk(); 
    					}
    					/**
    					 * Проверка нажатия на кнопку ButtonName[1](button_CountFreeArea)
    					 */
    					else if(e.getSource() == ButtonName[1]){
    						/**      
    						 * Создаем объект класса Strakhovshik и вызываем метод zapusk      
    						 */    
    						Strakhovshik strakh=new Strakhovshik();     
    						strakh.zapusk(); 
    					}          
    		}});
        	
        	s.getContentPane().add(ButtonName[i]);      	
		} 
		
		for(int i=0;i<ButtonName.length;i++) {
			//if(i==0)
				//ButtonName[i].setPreferredSize(new Dimension(100,100));  
				//ButtonName[i].setBackground(Color.white);
				//ButtonName[i].setForeground(Color.red);
				//ButtonName[i].setFont(new Font("TimesRoman", Font.BOLD, 100));
			//else
			//ButtonName[i].setForeground(Color.blue);
		}
 
		s.setVisible(true); 
	}
} 
