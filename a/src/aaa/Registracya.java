/**  
 * Устанавливаем принадлежность класса к пакету  
 */ 
package aaa;

import java.awt.Color;
/**  
 * Подключаем библиотеки  
 */ 
import java.awt.FlowLayout; 
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; 
import java.awt.Insets; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.FileWriter; 
import java.io.IOException; 
 
import javax.swing.JButton; 
import javax.swing.JComboBox; 
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource; 
 
/**   
 * Объявляем public класс, в котором осуществляется регистрация в системе 
 */  
public class Registracya{  
	/**  
	 * Создаём переменную класса FileWriter и присваиваем ей значение null   
	 */  
	private FileWriter writer = null;    
	/**     
	 * Объявляем конструктор класса    
	 */  
	public Registracya(){  
	}    
	/**    
	 * Метод zapusk для инициализации и отображения фрейма   
	 */  
	public void zapusk(){   
	/**   
	 * Создаём объект класса JFrame   
	 */   
		final JFrame s=new JFrame();      
	/**    
	 * Проверяем, открыто ли окно регистрации на момент подачи новой заявки    
	 * (открыто - переменная Strakhovatel.isRun1 равна true)    
	 */   
	if(Strakhovatel.isRun1==false){   
		//UIManager.put("OptionPane.background", new ColorUIResource(111,1,24));
		//UIManager.put("Panel.background", new ColorUIResource(111,1,24));
		
		/**     
		 * Переменной opcion присваивается целое число, указывающее опцию,   
		 * выбранную пользователем в диалоговом окне подтверждения действия     
		 */    
		int opcion=JOptionPane.showConfirmDialog(null, "При подаче новой заявки, старая  будет недействительна. Продолжить?", null,  JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);      
		if(opcion==JOptionPane.YES_OPTION){           
			/**      
			 * Переменной LichnyKab.isRun1 задается значение false.      
			 * Это необходимо для того, чтобы пользователь смог получить выплату  
			 * по новому случаю страхования, т.к. после получения предыдущей  
			 * страховой выплаты, переменная LichnyKab.isRun1 установится true,      
			 * что приведет к невозможности повторного ее получения.      
			 */    
			LichnyKab.isRun1=false;       
    /**      
     * Переменная устанавливается true,  
     * т.к. окно регистрации отображается на экране      
     */     
	Strakhovatel.isRun1=true;           
	/**      
	 * Выполняем настройку окна      
	 */     
	s.setTitle("Создание новой учетной записи");     
	s.setSize(600,400);        
	/**      
	 * Размещаем окно по середине экрана       
	 */     
	s.setLocationRelativeTo(null);                        
	/**      
	 * Указываем операцию, которая будет произведена при закрытии окна      
	 */     
	s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);      
	/**     
	 * Устанавливаем менеджер FlowLayout для расположения  
	 * компонентов на фрейме    
	 */     
	s.setLayout(new FlowLayout());         
	/**      
	 * Создаем компонент-контерйнер panel класса JPanel      
	 */     
	final JPanel panel=new JPanel();     
	panel.setBackground(Color.orange);
	s.getContentPane().setBackground(Color.orange);
	panel.setLayout(new GridBagLayout());          
	/**      
	 * Создаем компоненты для личных данных пользователя      
	 */     
	final JButton vykhod=new JButton("Выход");      
	final JButton prodolj=new JButton("Продолжить");      
	final JTextField FIO=new JTextField();     
	final JTextField parolTF=new JTextField(9);     
	/**     
	 * Устанавливаем варианты для combobox      
	 */     
	String[] vidStr = {                                     
			"страхование предпринимательких рисков"      
	};     
	final JComboBox<String> comboBoxVidStr = new JComboBox<String>(vidStr);     
	//comboBoxVidStr.setBackground(Color.BLUE);
	final JButton PodatZayavky=new JButton("Завершить регистрацию");           
	final JLabel FIOL= new JLabel("Введите ФИО: ");     
	final JLabel parolL= new JLabel("Придумайте пароль: ");    
	final JLabel VidStrL= new JLabel("Выберите вид страхования: "); 
 
 
    /**      
     * Добавляем созданные компоненты на панель panel      
     */     
	panel.add(FIOL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));     
	panel.add(parolL,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));     
	panel.add(VidStrL,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));    
    panel.add(parolTF,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));     
    panel.add(FIO,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));     
    panel.add(comboBoxVidStr,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));     
    panel.add(prodolj,new GridBagConstraints(0,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));     
    panel.add(vykhod,new GridBagConstraints(1,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0)); 
 
    /**     
     * Добавляем панель panel на фрейм      
     */     
    s.add(panel);              
    /**      
     * Создаем компоненты для страхования предпринимательских рисков        
     */     
    final JTextField PrognozirDoh=new JTextField("0");    
    final JTextField proczOtvetStrahovshikaP=new JTextField("0");     
    final JLabel PrognozirDohL= new JLabel("Прогнозируемый доход, руб: ");    
    final JLabel proczOtvetStrahovshikaPL= new JLabel("Процент ответственности  страховщика,%: "); 
 
    /**      
     * Добавляем слушателя к кнопке vykhod с помощью вызова      
     *addActionListener.      
     */     
    vykhod.addActionListener(new ActionListener() {      
    	public void actionPerformed(ActionEvent e) { 
    		/**        
    		 * Переменная устанавливается false, т.к. окно регистрации   
    		 * не будет отображаться на экране        
    		 */       
    		Strakhovatel.isRun1=false;      
    		/**        
    		 * Фрейм перестает отображаться        
    		 */       
    		s.setVisible(false);      
    	}     
    });          
    /**      
     * Добавляем слушателя к кнопке prodolj с помощью вызова      
     *addActionListener.     
      */    
    prodolj.addActionListener(new ActionListener() {      
    	public void actionPerformed(ActionEvent arg0) {       
    		System.out.println(parolTF.getText());       
    		/**        
    		 * Вызываем метод sohranitParol()       
    		 */       
    		sohranitParol(parolTF);              
    		/**        
    		 * Удаляем с панели компоненты для личных данных  
    		 * пользователя         
    		 */       
    		panel.remove(parolTF); 
    		panel.remove(FIO);       
    		panel.remove(comboBoxVidStr);       
    		panel.remove(parolL);       
    		panel.remove(FIOL);       
    		panel.remove(VidStrL);      
    		panel.remove(prodolj);                
    		/**        
    		 * Добавляем компоненты для страхования предпринимательских   
    		 * рисков         
    		 */       
    		panel.add(PrognozirDoh,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));       
    		panel.add(proczOtvetStrahovshikaP,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0)); 
 
    		panel.add(PrognozirDohL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));      
    		panel.add(proczOtvetStrahovshikaPL,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));    
    		panel.add(PodatZayavky,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));      
    		panel.add(vykhod,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));           
    		/**        
    		 * Сообщаем менеджеру компоновки пересчитать макет        
    		 */       
    		panel.revalidate();          
    		}     
    	});          
    /**      
     * Добавляем слушателя к кнопке PodatZayavky с помощью вызова     
     *addActionListener.      
     */     
    PodatZayavky.addActionListener(new ActionListener() {      
    	public void actionPerformed(ActionEvent e) { 
    		try { 
    			/**        
        		 * Вызываем метод sohranitDannye(int pr, int a)        
        		 */        
        		sohranitDannye(Integer.parseInt(PrognozirDoh.getText()), Integer.parseInt(proczOtvetStrahovshikaP.getText()));        
        		/**         
        		 * Удаляем текст содержащийся в метке ostatokPoVznosam    
        		 * класса LichnyKab          
        		 */       
        		LichnyKab.ostatokPoVznosam.setText("");
        		JOptionPane.showMessageDialog(null,"Данные сохранены. Для дальнейших действий войдите в Личный кабинет", "", JOptionPane.PLAIN_MESSAGE);
				/**      
				 * Обрабатываем исключение e типа Exception     
				 */    
			} catch (Exception e1) {      
				JOptionPane.showMessageDialog(null, "Доход и процент ответственности страховщика должны быть целыми числами!", "Проверьте правильность ввода и попробуйте еще раз", JOptionPane.ERROR_MESSAGE);     
			}
    		      
    		}     
    	});          
    s.setVisible(true);             
	}                  
	}else     
		JOptionPane.showMessageDialog(null, "Чтобы открыть новое окно регистрации, закройте предыдущее", "Вы уже открыли форму!", JOptionPane.PLAIN_MESSAGE); 
	}    
/**   
 * Метод sohranitDannye(int pr, int a). 
 * При вызове метода происходит сохранение переданных значений в качестве прогнозируемого   
 * дохода и процента ответственности страховщика c помощью методов setdPr(int dPr) и   
 * setA(int a) класса Formuly   
 */  
public void sohranitDannye(int pr, int a) {   
	OsnF.obj2.setdPr(pr);  
	OsnF.obj2.setA(a);   
	System.out.println(OsnF.obj2.getdPr()+" "+OsnF.obj2.getA()); 
}    
/**   
 * Метод sohranitParol(JTextField textfield).   
 * При вызове метода происходит сохранение текста из компонента textfield в файл p.txt   
 */  
public void sohranitParol(JTextField textfield) {   
	/**   
	 * Выполняем отслеживание блока кода, где может произойти ошибка, при   
	 * помощи исключения try   
	 */   
	try {    
		/**    
		 * Создаём объект класса FileWriter с именем файла p.txt, куда будет происходить  
		 * запись    
		 */    
		writer = new FileWriter("p.txt");   
		/**     
		 * Сохраняем содержимое textfield в поток writer     
		 */    
		textfield.write(writer);    
		/**     
		 * Закрываем поток     
		 */   
		writer.close();   
		/**    
		 * Обрабатываем исключение e типа IOException     
		 */   
		} catch (IOException e) {    
			/**     
			 * Печатаем исключение, которое произошло     
			 */    
			e.printStackTrace();   
			}     
	} 
}
