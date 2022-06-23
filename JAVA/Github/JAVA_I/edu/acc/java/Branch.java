package edu.acc.java;

/*
 * Demo code during class 5/25/17 of 2 dimensional array and
 * intro to objects (done from memory so may not match exactly :)
 */
class Branch {
    
    int deptNum; // instance variable for branch dept. number
    int branchNum; // instance variable for branch number
    String branchAddr; // instance variable for branch address

    static public void main (String[] args) { // we can run this class directly

        // 2 dimensional array demo
        int[][] y = { {1,2,3}, {4,5,6,7} };  // an arbitrary 2 dim array
        for (int i=0; i < y.length; i++) { // iterates the outer array
            for (int j=0; j < y[i].length; j++) { // iterates the inner array
                System.out.println("y[" + i + "][" + j + "] is " + y[i][j]);
            }
        }

        // onward to branch related work...
        Branch myBranch = new Branch();  // new a Branch instance to use instance
                                         // variables and methods
        // create Jane the well-paid Employee (from Employee.java)
        Employee myEmployee = new Employee(102000, "Jane Conehead"); 

        // print branch number and branch address using instance methods
        System.out.println(myBranch.getBranchNum());   
        System.out.println(myBranch.getBranchAddress());   
    }

    public int getBranchNum() { return 12345; }
    public String getBranchAddress() { return "123 Pine St."; }
}