class MyCalendar {
    private TreeSet<int[]> events;
    public MyCalendar() {
        events=new TreeSet<int[]>((int[] a,int[] b)->a[0]-b[0]);
    }
    
    public boolean book(int start, int end) {
        int[] event={start,end};
        int[] ceil=events.ceiling(event);
        int[] floor=events.floor(event);
        if(ceil!=null && ceil[0]<end) return false;
        if(floor!=null && floor[1]>start) return false;
        events.add(event);
        return true;
    }
}
​
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
