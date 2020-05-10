import java.util.ArrayList;

public class Box <T extends Fruit> {

    public ArrayList <T> box = new ArrayList<> ();

    public float getWeight() {
      float weight = 0.0f;
      for (T o : box ) weight += o.getWeight();
        return weight;
    }

    public boolean compare (Box secondBox) {
      if (getWeight() == secondBox.getWeight()) return true;
      return false;}

    public void sprinkle(Box<T> secondBox){
    secondBox.box.addAll(box);
    box.clear();
  }

    public void addF(T fruit , int count){
      for (int i = 0; i < count ; i++) {
            box.add(fruit);
      }
  }
}
