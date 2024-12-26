package datastructures;

import java.util.ArrayList;

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
	
    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        System.out.print(node.value + " ");

        inorder(node.right);
    }
    
    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
        
    }
    
    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }
    
    public ArrayList<Integer> levelorder(Node root) {
    	Queue<Node> queue = new Queue<>();
    	ArrayList<Integer> list = new ArrayList<>();
    	queue.enqueue(root);
    	while(!queue.isEmpty()) {
    		Node curr = queue.dequeue();
    		System.out.print(curr.value + " ");
    		list.add(curr.value);
    		if(curr.left != null) {
    			queue.enqueue(curr.left);
    		}
    		if(curr.right != null) {
    			queue.enqueue(curr.right);
    		}
    		}
    	return list;
    }
    
    public void mirror() {
    	
    }
    
	public static class  Node{
		int value;
		Node right;
		Node left;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	
	public int largestPath() {
		if(this.root == null) {
			return 0;
		}
		//find the max path in left of root
		//find the max path in right of root
//		Node right = this.root.right; 
//		Node left = this.root.left;
//		int[] rightCount = {0};
//		int[] leftCount = {0};
//		count = 0;
//		calculateLargestPathLength(left, leftCount);
		return 1 + 
				calculateLargestPathLength(this.root.left, 0) + 
				calculateLargestPathLength(this.root.right, 0);
	}

    
    public int calculateLargestPathLength(Node node, int count) {
        if (node == null) {
            return count;
        }
        return Math.max(
        	calculateLargestPathLength(node.left,1+count), 
        	calculateLargestPathLength(node.right,1+count)
        );
    }
    
    public int calculateLargestPathLengthAlt(Node node) {
        if (node == null) {
            return 0;
        }
        return 1+Math.max(
        	calculateLargestPathLengthAlt(node.left), 
        	calculateLargestPathLengthAlt(node.right)
        );
    }
    
}

 class MirrorTree extends BinaryTree{
	 
	@Override
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
				if(travel.value < value)
				{
					travel = travel.left;
				} else {
					travel = travel.right;
				}
			}
		    if(parent.value < value) 
		    {
		    	parent.left = newChild;
			} else {
				parent.right = newChild;
			}
		}
	}
}


/*
       3 
    2     5
   1       6
 
 3  print 3
 node.left 2
 node.right 5    2 5    
 node.left.left 1
 node.left.righ 0
 node.right.left 4
 node.right.right 6
 
 2 5 1 0 4 6 
 
        15                   15
    6        18         18         6
  3   7     17 20     20  17     7   3
 2 4   13                      13   2  4
      9                          9
 */





