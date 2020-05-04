import utility.collection.ArrayList;

public class ValuableDepository<T> implements Deposit{
    private ArrayList<Object> arrayList;
    private int size;
    private Logger log;
public ValuableDepository(int size){
    arrayList = new ArrayList<>();
    this.size = size;
    log = Logger.getInstance();
}
    @Override
    public void enqueue(Object object) {
        if(arrayList.size() < size){
            arrayList.add(object);
        }
        else{
            log.log("ValuableDepository is full.");
        }
    }
    @Override
    public Object dequeue(){
    if(arrayList.size() > 0){
     return arrayList.remove(arrayList.size());
    }
    else{
        log.log("Empty deposit.");
        return null;
    }
}


}
