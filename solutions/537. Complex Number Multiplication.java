class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] realImg1 = num1.split("\\+");
        int real1 = Integer.parseInt(realImg1[0]);
        int img1 = Integer.parseInt(realImg1[1].split("i")[0]);
        //System.out.println(real1+" : "+img1);
        
        String[] realImg2 = num2.split("\\+");
        int real2 = Integer.parseInt(realImg2[0]);
        int img2 = Integer.parseInt(realImg2[1].split("i")[0]);
        
        //System.out.println(real2+" : "+img2);
        
        int real = 0;
        int img = 0;
        real+=(real1*real2);
        real+=-(img1*img2);
        img+=(real1*img2);
        img+=(real2*img1);
        return real+"+"+img+"i";
    }
}
