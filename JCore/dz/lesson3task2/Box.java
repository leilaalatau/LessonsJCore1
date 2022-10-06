package lessonsJCore.JCore.dz.lesson3task2;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    ArrayList<T> FruitList;

    public Box(ArrayList<T> FruitList){
        this.FruitList = FruitList;
    }

    public Box() {

    }

    public Integer getAddFruitList(){
        Integer result = 0;
        for(T t: getFruitList()) {
            if (t != null) {
                Integer value = t.getAddFruit();
                result = result + value;
            }
        }
        return result;
    }

    public ArrayList<T>  getFruitList() {
        return FruitList;
    }

    public Boolean compareList(Box<T> box){
        if (box.getAddFruitList().intValue() == this.getAddFruitList().intValue()) {
            return false;
        }
        return true;
    }

    private int getWeight(){
        int result = 0;
        for (T t: getFruitList()){
            if (t!=null)result++;
        }
        return result;
    }


    public void toEmptyList(Box<T> box){
        System.out.println("В коробке до: " + this.getFruitList());
        System.out.println("В текущей коробке: " + box.getFruitList());
        for (T t: box.getFruitList()){
            this.getFruitList().add(t);
        }
        box.getFruitList().clear();
        System.out.println("В коробке после: " + this.getFruitList());
        System.out.println("В текущей коробке после: " + box.getFruitList());
    }


    public void compare(Box<Orange> box3) {

    }
}
