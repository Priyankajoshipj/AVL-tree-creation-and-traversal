
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author priyanka
 */
public class AVL 
{
       Node root;

        class Node
        {
            int val;
            Node left;
            Node right;
            int height=0;
            int parent=0;
            Node(int v,int par) 
            {
                val = v; left = null; 
                right = null;
                height=0;
                parent=par;
            }
        }
        // returns height of the Node
        int calculateHeight(Node node)
            {
                if (node!=null)
                        return node.height;
                else
                        return 0;
            
            }
        int findMax(int N1, int N2)
        {
            if (N1>N2)
            {
                return N1;
            }
            else
                return N2;
        }
        
        Node rotateRight(Node N)
        {
            Node N1=N.left;
            N1.parent=N.parent;
            Node temp=N1.right;
            N.parent=N1.val;
            // rotate
            N1.right = N;
            N.left= temp;
            //temp.parent=N.val;
            
            
            // Update Heights
            N.height= findMax(calculateHeight(N.left),calculateHeight(N.right))+1;
            N1.height= findMax(calculateHeight(N1.left),calculateHeight(N1.right))+1;
            return N1;
        }
        Node rotateLeft(Node N)
        {
            Node N1=N.right;
            N1.parent=N.parent;
            Node temp=N1.left;
            N.parent=N1.val;
            //rotate
            N1.left = N;
            N.right= temp;
            //temp.parent=N.val;
            // Update Heights
            N.height= findMax(calculateHeight(N.left),calculateHeight(N.right))+1;
            N1.height= findMax(calculateHeight(N1.left),calculateHeight(N1.right))+1;
            return N1;
        }
        Node rotateRightLeft(Node N)
        {
            N.right=rotateLeft(N.right);
            return rotateLeft(N);
            
        }
        Node rotateLeftRight(Node N)
        {
             N.left=rotateLeft(N.left);
            return rotateRight(N);
        }
        void printup(int N)
        {
            Node par;
           par = null;
            
            if(N==root.val)
            {
                
                System.out.println("\nRoot Value "+root.val+" Root Left Height "+calculateHeight(root.left)+" Root Right Height"+calculateHeight(root.right));
                
            }
            else
                printHeight(N,par);
        }
        void printHeight(int new_val, Node N)
        {
            if(N==null)
                N=root;
            if(N.val==new_val)
                {
                    System.out.println("\nNode value: "+N.val+"Node Height"+calculateHeight(N));
                    printup(N.parent);
                }
            else
            {
                if(N.val>new_val)
                    printHeight(new_val,N.left);
                else
                    printHeight(new_val,N.right);
            }
            
        }
        int Balance(Node n) {
        if (n == null)
            return 0;
        return calculateHeight(n.right) - calculateHeight(n.left);
    }
          public void insert(int val) {
        root = insertNode(val,root,0);
    }        
        Node insertNode(int new_val,Node node,int parent)
        {
            

                
                if(node==null)
                {
                    return (new Node(new_val,parent));
                }
                
                
                if(new_val>node.val)
                {
                        
                    node.right=insertNode(new_val,node.right,node.val);
                            
                }
                else if(new_val<node.val) 
                {
                    node.left=insertNode(new_val,node.left,node.val);
                }
                node.height=findMax(calculateHeight(node.right),calculateHeight(node.left))+1;
                int balance = Balance(node);
        
 
        //Left-Left Rotation
        if (balance<0 && new_val<node.left.val) {
            return rotateRight(node);
        }
        
        //Left-Right Rotation
        if (balance<0 && new_val>node.left.val) {
            
            return rotateLeftRight(node);
        }
        
        //Right-Right Rotation
        if (balance>1 && new_val>node.right.val) {
            return rotateLeft(node);
        }
        
        //Right-Left Rotation
        if (balance>1 && new_val<node.right.val) {
            
            return rotateRightLeft(node);
        }
                return node;
        }
public void inorder() {
        inorderTraversal(root);
    }
      private void inorderTraversal(Node n) {
        if(n == null)return;
        inorderTraversal(n.left);
        System.out.print(n.val+" ");
        inorderTraversal(n.right);
    }      
        
                      
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n Enter Total No. of Nodes: ");
        int n=in.nextInt();
        Node N=null;
        if (n<15){
            System.out.println("\nNo. of Nodes should be at least 15");
        }
        else
        {
            System.out.println("\nEnter Node Values, Duplicates not handled");
            
            AVL AVLtree = new AVL();
            int[] a= new int[n];
            for (int i=0;i<n;i++)
            {
                int x=in.nextInt();
                a[i]=x;
                AVLtree.insert(x);
                
                
            }
            System.out.println("\nInorder Traversal of the AVL Tree");
            AVLtree.inorder();
            AVLtree.printHeight(a[n-1],N);
        }
    }
}
 