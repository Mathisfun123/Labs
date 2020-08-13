import java.util.ArrayList;

public class Queue1<E> {
	private ArrayList<E> data;
	public Queue1(){
		data = new ArrayList<>();
	}
	public boolean isEmpty(){
		return data.size()==0;
	}
	public void add(E x){
		data.add(x);
	}
	public E remove(){
		return data.remove(0);
	}
	public E peek(){
		return data.get(0);
	}
	public int size(){
		return data.size();
	}
}
