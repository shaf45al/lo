/**  
 * Устанавливаем принадлежность класса к пакету  
 */
package aaa;

/** 
 * Подключаем класс событий 
 */ 
	import java.awt.EventQueue; 
 
/** 
 * Объявляем public класс 
 */ 
	public class main {  
	 /**  
	  * Запуск приложения  
	  */  
	public static void main(String[] args) {   
	/**   
	 * Объявляем, что это необходимо выполнять в главном потоке   
	 */   
	EventQueue.invokeLater(new Runnable() {   
		public void run() {     
			/**     
			 * Выполняем отслеживание блока кода, где может произойти ошибка, при     
			 * помощи исключения try     
			 */ 
 
			try {      
				/**      
				 * Создаём объект myOsnF      
				 */      
				OsnF myOsnF= new OsnF();      
				/**       
				 * Вызываем метод zapusk       
				 */      
				myOsnF.zapusk();           
				/**      
				 * Обрабатываем исключение e типа Exception     
				 */    
			} catch (Exception e) {      
				/**       
				 * Печатаем исключение, которое произошло       
				 */       
				e.printStackTrace();     
			}    
		}   
		});  
	} 
	}
     