class Solution {

    public int largestIsland(int[][] grid) {

        int rows = grid.length;

        int cols = grid[0].length;

        

        // create father array and size array, and initialize them

        int[] father = new int[rows * cols];

        for (int i = 0; i < rows * cols; i++) {

            father[i] = i;

        }

        int[] size = new int[rows * cols];

        Arrays.fill(size, 1);

        

        int[] dx = {0, 1, -1, 0};

        int[] dy = {1, 0, 0, -1};

        

        // scan grid, update father array and size array

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    int id = i * cols + j;

                    for (int k = 0; k < 4; k++) {

                        int newi = i + dx[k];

                        int newj = j + dy[k];

                        int newid = newi * cols + newj;

                        if (isValid(rows, cols, newi, newj) && grid[newi][newj] == 1) {

                            union(father, size, id, newid);

                        }

                    }

                }

            }

        }

        

        // find current max component size

        int max = 0;

        for (int i = 0; i < size.length; i++) {

            max = Math.max(max, size[i]);

        }

        

        // find max component size if we set any 0 to 1

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0) {

                    int id = i * cols + j;

                    int combinedSize = 1;

                    Set<Integer> prevFather = new HashSet<>();

                    for (int k = 0; k < 4; k++) {

                        int newi = i + dx[k];

                        int newj = j + dy[k];

                        int newid = newi * cols + newj;

                        if (isValid(rows, cols, newi, newj) && grid[newi][newj] == 1) { 

                            int currFather = find(father, newid);

                            if (prevFather.isEmpty() || !prevFather.contains(currFather)) {

                                combinedSize += size[currFather];

                                prevFather.add(currFather);

                            }

                        }

                    }

                    max = Math.max(max, combinedSize);

                }

            }

        }

        

        // return whole size if the grid is an all 1 matrix, otherwise return the value of max

        return max == 0 ? rows * cols : max;

    }

    

    public int find(int[] father, int id) {

        if (father[id] == id) {

            return id;

        }

        return father[id] = find(father, father[id]);

    }

    

    public void union(int[] father, int[] size, int id1, int id2) {

        int fa1 = find(father, id1);

        int fa2 = find(father, id2);

        if (fa1 != fa2) {

            father[fa1] = fa2;

            size[fa2] += size[fa1];

        }

    }

    

    public boolean isValid(int rows, int cols, int i, int j) {

        if (i >= 0 && i < rows && j >= 0 && j < cols) {

            return true;

        }

        return false;

    }
    }
        

