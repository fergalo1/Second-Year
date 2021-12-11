package CS210;
public class Queue{  
	private int maxSize;   
	private String[] queArray;    
	private int front;    
	private int rear;    
	private int nItems; 

	

public Queue(int s) {            
	maxSize = s;       
	queArray = new String[maxSize];       
	front = 0;       
	rear = -1;       
	nItems = 0; 
}
public void insert(String item) {     
	if(nItems==0){   
		queArray[0] = item;          
		}else{                              
			int j = nItems;   
			while(j > 0 && queArray[j-1].length() > item.length()){   
				queArray[j] = queArray[j-1];    
				j--;        
				}         
			queArray[j] = item;                
			}       nItems++;      
			}
public String remove() {
	if(isEmpty()) 
		{
		return null;  
		}  
	String temp = queArray[front];
	front++;       
	
	if(front == maxSize)          
	{ front = 0;      
	nItems--;} 
	return temp;  }     
public String peekFront(){ 
	return queArray[front]; }       

	 
public boolean isEmpty() {             
	return (nItems==0); }       
 
public boolean isFull() {    
	return (nItems==maxSize); }       
 
public int size() {       
	return nItems; }   
}
