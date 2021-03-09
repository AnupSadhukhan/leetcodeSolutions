class Solution {
   /* approch 1*/ 
   class TrieNode{
            Map<Character,TrieNode> map;
            boolean eh;
            StringBuilder s;
            TrieNode(char c){
                map=new HashMap<Character,TrieNode>();
                eh=false;
                s=null;
            }
        }
          TrieNode root=new TrieNode('1');
        public  List<String> findWords(char[][] board, String[] words) {
            for(String w : words){
                
                insert(w);
            }
            List<String> li=new ArrayList<String>();
            
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    TrieNode cur=root.map.get(board[i][j]);
                    if(cur!=null ){
                        char ch=board[i][j];
                        board[i][j]='$';
                        
                        dfs(cur,i,j,board,li);
                        
                        board[i][j]=ch;
                        
                    }
                }
            }
           
            return li;
        }
        public  void insert(String s){
            TrieNode x=root;
            StringBuilder s1=new StringBuilder();
