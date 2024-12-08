package datastructures;

public class BinaryTree {
	
	Node root;
	
	public void insert(int value) {
		if(this.root == null) 
		{
			Node newRoot = new Node(value);
			this.root = newRoot;
		} else {
			Node newChild = new Node(value);
			Node travel = this.root;
			Node parent = travel;
			while(travel != null) {
				parent = travel;
				if(travel.value > value)
				{
					travel = travel.left;
				} else {
					travel = travel.right;
				}
			}
		    if(parent.value > value) 
		    {
		    	parent.left = newChild;
			} else {
				parent.right = newChild;
			}
		}
	}
	
	public void delete(int value) {
		Node toBeDeleted = this.search(value, root);

		if(toBeDeleted == null) {
			System.out.println("Value does not exist");
			return;
		}
		if(toBeDeleted == this.root) {
			// if root has no children
	        if (toBeDeleted.left == null && toBeDeleted.right == null) {
	        	this.root = null;
				return;
	        }
	        // if root has only right child
	        if (toBeDeleted.left == null) {
	            this.root = toBeDeleted.right;  
	            return;
	        }
	        if (toBeDeleted.right == null) {
	            this.root = toBeDeleted.left; 
	            return;
	        }	
	        //if root has two child
	        Node successor = findSucces(value); 
	        this.delete(successor.value);
	        toBeDeleted.value = successor.value;
	        return;
		}
		// if the node to be deleted is not root
		toBeDeleted = this.root;
		Node parent = null;
		while(toBeDeleted != null && toBeDeleted.value != value) 
		{
			parent = toBeDeleted;
			if(toBeDeleted.value > value) 
			{
				toBeDeleted = toBeDeleted.left;
			} else {
				toBeDeleted = toBeDeleted.right;				
			}
		}
		//case 1: No children
		if(toBeDeleted.left==null && toBeDeleted.right==null) {
			if(parent.value > value) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}
		//case 2: only right child exist
		if(toBeDeleted.left == null) {
			if(parent.value > value) {
				parent.left = toBeDeleted.right;
			} else {
				parent.right = toBeDeleted.right;
			}
			return;
		}
		//case 3: only left child exist
	    if (toBeDeleted.right == null) {
	        if (parent.left == toBeDeleted) {
	            parent.left = toBeDeleted.left;
	        } else {
	            parent.right = toBeDeleted.left;
	        }
	        return;
	    }
	    //case 4: Two children exist
	    Node successor = this.findSucces(value);
	    toBeDeleted.value = successor.value;
	    this.delete(successor.value);
	}
	
	public Node search(int value, Node travel) {
		if(travel == null || travel.value == value) {
			return travel;
		}
		if(travel.value > value) 
		{
			return search(value, travel.left);
		} else {
			return search(value, travel.right);
		}
	}
	
	public Node findSucces(int value) {
		Node x = this.search(value, root);
		if(x==null) {
			return x;
		}
		if(x.right != null) {
			x = x.right;
		} else {
			return x.right;
		}
		while(x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	public Node findPredeces(int value) {
		Node x = this.search(value, root);
		if(x==null) {
			return x;
		}
		if(x.left != null) 
		{
			x = x.left;
		} else {
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
