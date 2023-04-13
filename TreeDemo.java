class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
  
   
   /*
   recursive insert method
	
   */
   public Node insert(Node root, int value){
	   
	  if(this.root==null) {
		  this.root = new Node(value);
		  return this.root;
	  } 
      //base case
      if(root == null){
    	 
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   Prints the value of every node preorder
   */
   /**
    * Prints each element in the tree preOrder
    * @param root the origin of the BinaryTree
    */
   public void preOrderTraversal(Node root){
	   
      
	   if(root==null)return;
	   System.out.println(root.value);
	   preOrderTraversal(root.left);
	   preOrderTraversal(root.right);
	   
   }

   
   
   /*
   in-order traversal
   */
   /**
    * Prints each element in the tree InOrder
    * 
    * @param root origin of the BinaryTree
    */
   public void inOrderTraversal(Node root){
      //implement me
	   if(root==null) {
		   System.out.println("Root is null");
		   return;
	   }
	   System.out.println("not null");
	   preOrderTraversal(root.left);
	   System.out.println(root.value);
	   preOrderTraversal(root.right);
   }
   
   
   
   /*
   post-order traversal
   */
   /**
    * Prints each element of the tree PostOrder
    * @param root
    */
   public void postOrderTraversal(Node root){
	   if(root==null)return;
	   preOrderTraversal(root.right);
	   preOrderTraversal(root.left);
	   System.out.println(root.value);
	   
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   /**
    * 
    * @param root 
    * @param key 
    * @return true if key is inside the binaryTree, false if key is not in the BinaryTree
    */
   public boolean find(Node root, int key){
	  if(root==null) return false; 
	  if(root.value==key) return true;
	  if(find(root.right,key)) return true;
	  if(find(root.left,key))return true;
	  return false;
	  
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   /**
    * Searches the tree preOrder to find the smallest value
    * @param root
    * @return the smallest value in the binaryTree
    */
   public int getMin(Node root){
      int currMin = root.value;
      int otherMin = Integer.MAX_VALUE; 
      
      if(root.left!=null) otherMin = getMin(root.left);
      if(root.right!=null) { 
      	int rightMin = getMin(root.right);
      	if(rightMin<otherMin) otherMin=rightMin;
      }
      if(otherMin<currMin) return otherMin;
      else return currMin;
      
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   /**
    * searches the tree preOrder
    * @param root
    * @return returns the largest number in the binary tree
    */
   public int getMax(Node root){
	   int currMin = root.value;
	      int otherMin = Integer.MIN_VALUE; 
	      
	      if(root.left!=null) otherMin = getMin(root.left);
	      if(root.right!=null) { 
	      	int rightMin = getMin(root.right);
	      	if(rightMin>otherMin) otherMin=rightMin;
	      }
	      if(otherMin>currMin) return otherMin;
	      else return currMin;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(t1.root, 24);
      t1.insert(t1.root,80);
      t1.insert(t1.root,18);
      t1.insert(t1.root,9);
      t1.insert(t1.root,90);
      t1.insert(t1.root,22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}