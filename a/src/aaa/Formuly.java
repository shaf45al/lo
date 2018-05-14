/**  
 * Устанавливаем принадлежность класса к пакету  
 */ 
package aaa;

import javax.swing.JOptionPane;

/**   
 * Объявляем public класс, в котором осуществляется расчет 
 * страховой премии, ущерба от предпринимательской деятельности и страховой выплаты 
 */  
public class Formuly {    
	/**    
	 * Объявляем private переменную типа int, обозначающую размер страховой выплаты (руб.)   
	 */   
	private int StrVyp;    
	/**    
	 * Объявляем private переменную типа int, обозначающую размер страховой премии (руб.)   
	 */   
	private int StrPrem;    
	/**    
	 * Объявляем и инициализируем private переменную типа double, обозначающую страховой   
	 * коэффициент   
	 */   
	private double predKoef=0.5;    
	/**    
	 * Объявляем private переменную типа int, обозначающую прогнозируемый доход (руб.)   
	 */   
	private int dPr;    
	/**    
	 * Объявляем private переменную типа int, обозначающую полученный доход (руб.)   
	 */   
	private int dPol; 
 
 /**   
  * Объявляем private переменную типа int, обозначающую процент ответственности   
  * страховщика (%)  
  */   
	private int a; 
 
 /**  
  * Метод RaschitatSP().   
  * При вызове метода происходит сохранение значения, полученного по формуле StrPrem=DPr*k,   
  *  в переменную StrPrem с помощью метода setStrPrem(int strPrem) класса Formuly   
  */  
	public int RaschitatSP(){   
		return this.setStrPrem((int)(this.dPr*this.predKoef));  
	}    
/**   
 * Метод RaschitatY().   
 * При вызове метода происходит расчет ущерба    
 * и возвращение полученного значения   
 */  
	private int RaschitatY(){   int Y=0; 
 
  /**    
   * Если dPol<dPr (полученный доход меньше чем прогнозируемый)    
   */   
	if(this.dPol<this.dPr)     
		Y=this.dPr-this.dPol;   
	/**    
	 * если dPol>=dPr (полученный доход больше или равен прогнозируемому)    
	 */   
	else {   
		JOptionPane.showMessageDialog(null, "ущерба не было нанесено", "", JOptionPane.PLAIN_MESSAGE);
		Y=0;   
	} 
	return Y;  
	} 
 
 /**  
  * Метод RaschitatSV().   
  * При вызове метода происходит расчет страховой выплаты по формуле StrVyp=Y*a/100   
  * и сохранение полученного значения в переменную StrVyp    
  */  
	public int RaschitatSV(){  
		return this.StrVyp= (int)(RaschitatY()*this.a/100);  
	}    
	/**   
	 * сеттеры и геттеры для private переменных данного класса   
	 */   
	public double getPredKoef() {   
		return predKoef;  
	} 
 
 public void setPredKoef(double predKoef) {   
	 this.predKoef = predKoef;  
 }    
 public int getdPol() {   
	 return dPol;  
} 
 
 public void setdPol(int dPol) {   
	 this.dPol = dPol;  
 }    
 public int getdPr() {   
	 return dPr;  
} 
 
 public void setdPr(int dPr) {   
	 this.dPr = dPr;  
} 
 
 public int getStrVyp() {   
	 return StrVyp;  
} 
 
 public void setStrVyp(int strVyp) {   
	 StrVyp = strVyp;  
} 
 
 public int getStrPrem() {   
	 return StrPrem;  
} 
 
 public int setStrPrem(int strPrem) {   
	 StrPrem = strPrem;   
	 return strPrem;  
} 
 
 public int getA() {   
	 return a;  
} 
 
 public void setA(int a) {   
	 this.a = a;  
} 
} 
