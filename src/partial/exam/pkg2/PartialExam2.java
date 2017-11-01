/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partial.exam.pkg2;

/**
 *
 * @author neighbor
 */


class AVLNode{
    
    AVLNode left, right;
    int data;
    int height;
    
    // Constructor
    
    public AVLNode(){
        left = null;
        right = null;
        data = 0;
        height = 0;
    }
    
    public AVLNode(int n){
        left = null;
        right = null;
        data = n;
        height = 0;
        
    }
}

class AVLTree{
    private AVLNode root;
    
    //constructor
    
    public AVLTree(){
        
        root = null;
        
    }
    
    public void makeEmpty(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void add(int data){
        root = add(data, root); //review
    }
    
    public int height(AVLNode t){
        return t == null ? -1 : t.height;
    }
    
    private int max(int lhs, int rhs){
        return lhs > rhs ? lhs : rhs;
    }
    
    private AVLNode add(int x, AVLNode t){
        if (t == null){
            t = new AVLNode(x);
        } else if (x < t.data){
            t.left = add(x, t.left);
            if (height(t.right) - height(t.left) == 2)
                if (x > t.right.data)
                    t = rotateWithLeftChild(t);
                else
                    t = doubleWithLeftChild(t);
        } else if ( x > t.data){
            t.right = add(x, t.right);
            if (height(t.right) - height(t.left) == 2)
                if (x > t.right.data)
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
        }
        else
            ;
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }
    
    private AVLNode rotateWithLeftChild(AVLNode k2){
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }
    
    private AVLNode rotateWithRightChild(AVLNode k1){
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left),height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }
    
    private AVLNode doubleWithLeftChild(AVLNode k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    
    private AVLNode doubleWithRightChild(AVLNode k3){
        k3.left = rotateWithLeftChild(k3.left);
        return rotateWithRightChild(k3);
    }
}


public class PartialExam2 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
