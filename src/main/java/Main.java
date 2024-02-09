
import org.model.LinkedList.singly.LinkedList;
import org.model.util.iterator.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> inte = new LinkedList<>();
        inte.add(1);
        inte.add(2);
        inte.add(3);
        inte.add(4);
        inte.reverse();
        Integer[] array = {1,2};
        inte.retain(array);
        Iterator<Integer> iterator = inte.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
