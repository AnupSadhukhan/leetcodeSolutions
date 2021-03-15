public class Codec {
    Map<String,String> longToShort=new HashMap<String,String>();
    Map<String,String> shortToLong=new HashMap<String,String>();
    char[] seed="abc3defghi0jklmno2pqr1stw4xyz5ABCDE6FGHIJ7KLMNOP8QRST9WXYZ".toCharArray();
    String base="http://tinyurl.com";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String s=longToShort.get(longUrl);
       if(s!=null) return base+"/="+s;
        StringBuilder sb=new StringBuilder();
        do{
            sb=new StringBuilder();
            sb.append(seed[(int) (Math.random()*seed.length)]);
        }
        while(shortToLong.get(sb.toString())!=null);
        s=sb.toString();
            shortToLong.put(s,longUrl);
        return base+"/="+s;
        
    }
​
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] arr=shortUrl.split("=");
        return shortToLong.get(arr[1]);
    }
    
}
​
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
