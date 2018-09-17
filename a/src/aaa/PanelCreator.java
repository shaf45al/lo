/**
 * Устанавливаем принадлежность класса к пакету
 */
package aaa;

import java.awt.Color;
import java.awt.LayoutManager;

/**
 * Подключаем библиотеку для работы с графическим интерфейсом
 */
import javax.swing.JFrame;

public class PanelCreator {
	/**
	 * Приватный метод для создания и указания параметров панели
	 */
	private void CreatePanel(JFrame frame, String Title,int x, int y,LayoutManager manager,int operation) {
		
		/**
		 * Устанавливаем название окна
		 */
		frame.setTitle(Title);
		/**
		 * Указываем координаты верхней левой вершины окна, а также его ширину и высоту.
		 */
		frame.setSize(x,y);
		/**
		 * Указываем операцию, которая будет произведена при закрытии окна.
		 */
		frame.setDefaultCloseOperation(operation);
		
		
		frame.setLocationRelativeTo(null);  
		/**
		 * Устанавливаем менеджер для расположения элементов
		 */
		frame.getContentPane().setLayout(manager);
	}
	
	/**
	 * конструктор с цветом панели
	 */
	private void CreatePanel(JFrame frame, String Title,int x, int y,LayoutManager manager,int operation, Color bg) {
		CreatePanel(frame,Title,x,y,manager,operation);
		frame.getContentPane().setBackground(bg);
	}
	
	/**
	 * Публичный метод для вызова приватного метода
	 */
	public void PCreatePanel(JFrame frame, String Title,int x, int y,LayoutManager manager,int operation) {
		CreatePanel(frame,Title,x,y,manager,operation);
	}
	
	/**
	 * с цветом панели
	 */
	public void PCreatePanel(JFrame frame, String Title,int x, int y,LayoutManager manager,int operation, Color bg) {
		CreatePanel(frame,Title,x,y,manager,operation,bg);
	}
}

