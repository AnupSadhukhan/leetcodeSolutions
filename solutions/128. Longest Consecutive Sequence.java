                    dist[0]+=down[0];
                    
                    
                    map.put(num+up[0],dist);
                    map.put(num-down[0],dist);
                    map.put(num,dist);
                    max=Math.max(max,dist[0]);
                }
                else if(up==null && down!=null){
                    down[0]++;
                    map.put(num,down);
                    max=Math.max(max,down[0]);
                }
                else if(down==null && up!=null){
                    up[0]++;
                    map.put(num,up);
                    max=Math.max(max,up[0]);
                }
                else{
                    map.put(num,new int[]{1});
                    max=Math.max(max,1);
                }
            
            }
            
        }
        return max;
    }*/
}
