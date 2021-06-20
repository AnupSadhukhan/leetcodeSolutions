class MyCalendar {
    /* there can be three case
    case 1: new event is partially overlapping at left side with some other event which we have added previously
    case 2: new event is partially overlapping at right side with some other event which we have added before
    case 3: new event is totally with other event
    case 4: new event is outside i.e. not overlapping with other events
    
    if there is no overlap, we can insert or book the events else not, use treeset which we 
    store events according to start time of event, we will find ceil and floor whenever
    we are trying to book a new event, if floor events end time is more then new events start time
    or if ceil events start time is less than new events start time, we can not book the event 
    hence return false else add the event to treeset and return the result
    */
    
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
