class Solution {
    double a;
    double b;
    double r;
    
    public Solution(double radius, double x_center, double y_center) {
        this.a=x_center;
        this.b=y_center;
        this.r=radius;
        
    }
    
    public double[] randPoint() {
        double R=Math.sqrt(Math.random())*r;
        double angle=Math.random()*2*Math.PI;
        double x=a+R*Math.cos(angle);
        double y=b+R*Math.sin(angle);
       
        return new double[]{x,y};
    }
    
}
/*class Solution {
    double radius, x_center, y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }
    
    public double[] randPoint() {
        double len= Math.sqrt(Math.random())*radius;
        double deg= Math.random()*2*Math.PI;
        double x= x_center+len*Math.cos(deg);
        double y= y_center+len*Math.sin(deg);
        return new double[]{x,y};
    }
}*/
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
