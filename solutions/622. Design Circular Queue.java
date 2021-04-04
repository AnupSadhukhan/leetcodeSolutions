class MyCircularQueue {
    int[] arr;
    int front;
    int rear;
    int k;
    public MyCircularQueue(int k) {
        arr=new int[k];
        front=-1;
        rear=-1;
        this.k=k;
        Arrays.fill(arr,-1);
    }
    
    public boolean enQueue(int value) {
        //System.out.println("enq "+value);
        if(isFull()){
            return false;
        }
        rear=(rear+1)%k;
        //System.out.println("rear "+rear);
        arr[rear]=value;
        return true;
    }
    
    public boolean deQueue() {
         //System.out.println("dq ");
        if(isEmpty()) return false;
        front=(++front)%k;
        //System.out.println("dq front "+front);
        arr[front]=-1;
        if(rear==front){
            rear=-1;
