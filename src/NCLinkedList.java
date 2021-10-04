public class NCLinkedList extends DLinkedList<NameCount> {  
    @Override 
    public boolean contains(NameCount nameCount) {
        Node target = referenceOf(nameCount);
        if(target == null) return false;
        target.data.increment();
        return true;  
    }
}  
