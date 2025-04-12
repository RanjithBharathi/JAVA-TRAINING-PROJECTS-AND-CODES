import java.util.*;

class Node{
	int data;
	Node left,right;
	
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
//-----------------------------TREE INSERTION---------------------------------------//
class tree {
    Node root;

    public void insert(int data) {
        Node nn = new Node(data);

        if (root == null) {
            root = nn;
        } else {
            insertion( root, data);
        }
    }
	
	public Node insertion(Node root,int data){
		if(root==null){
			root=new Node(data);
			return root;
		}
		
		if(data<root.data){
				root.left=insertion(root.left,data);
			}
			else{
				root.right=insertion(root.right,data);
			}
			return root;
	}
	
//------------------------------MAX&MIN-----------------------------------------//
	
	public void maxi(Node root){
		LinkedList ll=new LinkedList<>();
	
		Queue<Node> q=new LinkedList<>();
		q.add(root);
	
		while(!q.isEmpty()){
			Node current=q.poll();
			ll.add(current.data);
		
			if(current.left!=null){
			q.add(current.left);
		     }
		   if(current.right!=null){
			q.add(current.right);
		}
	}
	

	System.out.println("Min value is "+Collections.min(ll));
	System.out.println("Max value is "+Collections.max(ll));
	
}
//---------------------------IDENTICAL TREES-----------------------------------//
public boolean id(Node a, Node b){
	if(a==null&&b==null){
		return true;
	}
	
	if(a!=null&&b!=null){
		return (a.data==b.data)&&id(a.left,b.left)&&id(a.right,b.right);
		
	}
	return false;
}

//-----------------------------------IS BINARYSEARCH TREE------------------------------------//
public boolean isBst(Node root){
	return isBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
}
public boolean isBST(Node root,int max,int min){
	if(root==null){return true;}
	
	if(root.data<=min||root.data>=max)return false;
	
	return isBST(root.left,root.data,min)&&isBST(root.right,max,root.data);
}}
//-------------------------------------MAIN CLASS-------------------------------------//
class BSTOPERATIONS{
	public static void main(String[] args){
		tree bst=new tree();
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(40);
		bst.insert(50);
		bst.insert(60);
		bst.insert(70);
		
		tree cst=new tree();
		cst.insert(10);
		cst.insert(20);
		cst.insert(30);
		cst.insert(20);
		cst.insert(80);
		cst.insert(60);
		cst.insert(70);
		
System.out.println("Really BINARY SEARCH TREE --> "+ bst.isBst(bst.root));
		bst.maxi(bst.root);	

System.out.println("IDENTICAL --> "+ bst.id(bst.root,cst.root));
		
}
}
