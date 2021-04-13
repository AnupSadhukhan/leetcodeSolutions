/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
   //we will use and recursive function to flatten the nestedInteger type data to List<Integer>
    // once we got the List<Integer> we can iterate over the list and return the ans
    List<Integer> res;
    Iterator<Integer> itr;
    public NestedIterator(List<NestedInteger> nestedList) {
       
        res=flatten(nestedList);
        itr=res.iterator();
        
    }
​
    @Override
    public Integer next() {
      return itr.next();
    }
​
    @Override
    public boolean hasNext() {
        return itr.hasNext();
    }
    private List<Integer> flatten(List<NestedInteger> li){
        List<Integer> res=new ArrayList<>();
        for(NestedInteger x : li){
            if(x.isInteger()) res.add(x.getInteger());
            else res.addAll(flatten(x.getList()));
        }
        return res;
    }
}
​
​
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
