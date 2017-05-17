package trees;

public class Trees {
	
	public boolean areTreesSame(Node a, Node b){

		if(a == null && b == null) return true; 
		if(a == null || b == null) return false; 
		
		if(a.data == b.data){
			return areTreesSame(a.left, b.left) && areTreesSame(a.right, b.right);
		}
		
		return false;
	}

	public boolean isSubtree(Node a, Node b){
		if(b == null) return false;
		if(areTreesSame(a,b)) 
			return true;
		else
			return isSubtree(a, b.left) || isSubtree(a, b.right);
	}	
}
