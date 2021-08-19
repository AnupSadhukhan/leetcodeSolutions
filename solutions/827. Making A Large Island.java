        return father[id] = find(father, father[id]);
​
    }
​
    
​
    public void union(int[] father, int[] size, int id1, int id2) {
​
        int fa1 = find(father, id1);
​
        int fa2 = find(father, id2);
​
        if (fa1 != fa2) {
​
            father[fa1] = fa2;
​
            size[fa2] += size[fa1];
​
        }
​
    }
​
    
​
    public boolean isValid(int rows, int cols, int i, int j) {
​
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
​
            return true;
​
        }
​
        return false;
​
    }
    }
        
​
​
