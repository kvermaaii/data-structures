package datastructures;

public class BinaryTree {
	
	Node root;
	
	public void insert(int value) {
		
		if(this.root == null) 
		{
			Node newRoot = new Node(value);
			this.root = newRoot;
		}else {
			Node newChild = new Node(value);
			Node travel = this.root;
			Node parent = travel;
			while(travel != null) {
				parent = travel;
				if(travel.value > value)
				{
					travel = travel.left;
				}else {
					travel = travel.right;
				}
			}
		    if(parent.value > value) 
		    {
		    	parent.left = newChild;
			}else {
				parent.right = newChild;
			}
			
		}
	}
	
	public void delete(int value) {
		Node toBeDeleted = this.search(value, root);
		Node parent = toBeDeleted;
		while(toBeDeleted != null && toBeDeleted.value != value) 
		{
			parent = toBeDeleted;
			
			if(toBeDeleted.value > value) 
			{
				toBeDeleted = toBeDeleted.left;
			}else {
				toBeDeleted = toBeDeleted.right;				
			}
			
		}
		if(toBeDeleted == null) {
			System.out.println("Value does not exist");
			return;
		}
		
		if(toBeDeleted == this.root)
		{
			this.root = null;
			return;
		}
		//case 1: No children
		if(toBeDeleted.left==null && toBeDeleted.right==null) {
			if(parent.value > value) {
				parent.left = null;
			}else {
				parent.right = null;
			}
			return;
		}
		if(toBeDeleted.left == null) {
			// replace the node with its successor
			Node parentOfSucces = toBeDeleted;			
			toBeDeleted = toBeDeleted.right;
			while(toBeDeleted.left != null) {
				parentOfSucces = toBeDeleted;
				toBeDeleted = toBeDeleted.left; //making toBeDeleted the successor
			}
			if(parent.value > value)
			{
				parent.left = toBeDeleted;
			}else {
				parent.right = toBeDeleted;
			}
			
			parentOfSucces.left = toBeDeleted.right; //making the right tree of successor node the left child of succesor parent
			return;
		}else {
			//replace with its predecessor
			Node parentOfPredeces = toBeDeleted;
			toBeDeleted = toBeDeleted.left;
			while(toBeDeleted.right != null) {
				parentOfPredeces = toBeDeleted;
				toBeDeleted = toBeDeleted.right;
			}
			if(parent.value >  value) 
			{
				parent.left = toBeDeleted;
			}else {
				parent.right = toBeDeleted;
			}
			
			parentOfPredeces.right = toBeDeleted.left;
			return;
		}
		
	}
	
	public Node search(int value, Node travel) {
		if(travel == null || travel.value == value) {
			return travel;
		}
		if(travel.value > value) 
		{
			return search(value, travel.left);
		}else {
			return search(value, travel.right);
		}
	}
	
	public Node findSucces(int value)
	{
		Node x = this.search(value, root);
		if(x.right != null) 
		{
			x = x.right;
		}else {
			return x.right;
		}
		while(x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	public Node findPredeces(int value) 
	{
		Node x = this.search(value, root);
		if(x.left != null) 
		{
			x = x.left;
		}else {
			x= x.right;
		}
		while(x.right != null) {
			x = x.right;
		}
		return x;
	}
	
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
	
	
	public void maximum() {
		Node travel = this.root;
		if(travel == null) {
			return;
		}
		while(travel.right != null) {
			travel = travel.right;
		}
		System.out.println(travel.value);
	}
	
	public void minimum() {
		Node travel = this.root;
		if(travel == null) {
			return;
		}
		while(travel.left != null) {
			travel = travel.left;
		}
		System.out.println(travel.value);		
	}
	
    public void display(Node node) {
        if (node == null) {
            return;
        }
        display(node.left);

        System.out.print(node.value + " ");

        display(node.right);
    }
	
	public static class  Node{
		int value;
		Node right;
		Node left;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
