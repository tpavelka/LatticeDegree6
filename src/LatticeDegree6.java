import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a lattice in which every Node has six
 * possible Nodes to connect to. I called this class
 * LatticeDegree6 because of the number of connections allowed
 * per Node. The smallest lattice is of a single Node with
 * length, width, and height equal to one. See this class's
 * constructor for more detail.
 * @author Travis Austin Pavelka
 */
public class LatticeDegree6 {
	/**
	 * Test if the node is on the back side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onBack(Node node) {
		assert(this.nodes.contains(node));
		if(node.getId() >= length*width*height - width*height) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node's id is on the back side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onBack(int id) {
		if(id >= length*width*height - width*height) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node is on the front side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onFront(Node node) {
		assert(this.nodes.contains(node));
		if(node.getId() < width*height) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node's id is on the front side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onFront(int id) {
		if(id < width*height) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node is on the left side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onLeft(Node node) {
		assert(this.nodes.contains(node));
		if(node.getId()%width == 0) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node's id is on the left side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onLeft(int id) {
		if(id%width == 0) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node is on the right side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onRight(Node node) {
		assert(this.nodes.contains(node));
		if(node.getId()%width == width-1) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node's id is on the right side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onRight(int id) {
		if(id%width == width-1) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node is on the top side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onTop(Node node) {
		assert(this.nodes.contains(node));
		if(node.getId()% width*height < width) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node's id is on the top side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onTop(int id) {
		if(id%(this.getWidth()*this.getHeight()) < this.getWidth()) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node is on the bottom side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onBottom(Node node) {
		assert(this.nodes.contains(node));
		if(node.getId()% this.getWidth()*this.getHeight()
				>= this.getWidth()*(this.getHeight()-1)) {
			return true;
		}
		return false;
	}
	/**
	 * Test if the node's id is on the bottom side of the lattice.
	 * @param node
	 * @return
	 */
	public boolean onBottom(int id) {
		if(id% width*height >= width*(height-1)) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	/**
	 * A variable to hold the length of the lattice. If looking
	 * at 2-D paper, length goes down into the paper. Length is
	 * counted by Nodes, not connections.
	 */
	private int length = 1;
	public int getLength() {
		return this.length;
	}
	/**
	 * Be careful that if messing with this method after
	 * connections have been set that this is the true length
	 * of the lattice. Length is counted by Nodes, not
	 * connections.
	 * @param length
	 */
	private void setLength(int length) {
		assert(length > 0);
		this.length = length;
	}

	/**
	 * A variable to hold the width of the lattice. If looking
	 * at 2-D paper, width goes across the paper left and right.
	 * Width is counted by Nodes, not connections.
	 */
	private int width = 1;
	public int getWidth() {
		return this.width;
	}
	/**
	 * Be careful that if messing with this method after
	 * connections have been set that this is the true width
	 * of the lattice. Width is counted by Nodes, not
	 * connections.
	 * @param length
	 */
	private void setWidth(int width) {
		assert(width > 0);
		this.width = width;
	}

	/**
	 * A variable to hold the height of the lattice. If looking
	 * at 2-D paper, height goes across the paper up and down.
	 * Height is counted by Nodes, not connections.
	 */
	private int height = 1;
	public int getHeight() {
		return this.width;
	}
	/**
	 * Be careful that if messing with this method after
	 * connections have been set that this is the true height
	 * of the lattice. Height is counted by Nodes, not
	 * connections.
	 * @param length
	 */
	private void setHeight(int height) {
		assert(height > 0);
		this.width = height;
	}
	
	/**
	 * The collection of nodes in this Lattice.
	 */
	private Collection<Node> nodes = new ArrayList<Node>();
	public Collection<Node> getNodes() {
		return this.nodes;
	}
	/**
	 * Be careful when using this as this method does not
	 * update the length, width, and height of the lattice.
	 * @param nodes
	 */
	private void setNodes(Collection<Node> nodes) {
		this.nodes = nodes;
	}
	
	/**
	 * Returns a node by its identification number.
	 * @param id
	 * @return
	 */
	private Node getNodeByID(int id) {
		for(Node n: nodes) {
			if(n.getId() == id) {
				return n;
			}
		}
		return null;
	}
	
	/**
	 * Searches the lattice for the given word and returns
	 * true if it is found and false otherwise.
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		// the word should be longer than 0 letters
		assert(word.length() > 0);
		// split the word into its letters
		String[] letters = word.split("");
		// search all nodes in the lattice for the first letter
		for(Node n: this.nodes) {
			// the current letter searching paths for
			int index = 0;
			if(n.getLetter().equals(letters[index])) {
				// it was found so increment to next letter
				index++;
				// while all letters are not found, search path
				while(index < letters.length) {
					// set n to the node that has the next letter
					n = n.hasConnection(letters[index]);
					if(n != null) {
						// increment to the next letter
						index++;
					} else {
						// no path found, so break
						break;
					}
				}
				// if index left the while at the letters length
				if(index == letters.length ) {
					// the path exists
					return true;
				}
			}
		}
		// no path was found
		return false;
	}
	
	
	
	
	
	
	/**
	 * The constructor of the LatticeDegree6. Nodes never have
	 * holes in the lattice unless the Node present is defined
	 * to be a hole. Nodes's id increases by one to the right
	 * along the width of the lattice, then once the end of
	 * the lattice is reached, the next row down along the
	 * height continues the identification of the Nodes until
	 * the bottom of the lattice is reached, then the next
	 * layer of Nodes (if looking at 2-D paper, into the
	 * paper) continues identification of the Nodes until the
	 * back of the Lattice is reached. The ArrayList of one
	 * length Strings called letters is used to set the Nodes
	 * to their letters. This class does not record the
	 * letters. Letters should be length * width * height.
	 * @param length
	 * @param width
	 * @param height
	 */
	public LatticeDegree6(int length, int width, int height,
			ArrayList<String> letters) {
		assert(letters.size() == length * width * height);
		this.length = length;
		this.width = width;
		this.height = height;
		// nodes already defined
		// counter is used to assign letters to Nodes by index
		for(int l = 0; l < length; l++) {
		  for(int h = 0; h < height; h++) {
		    for(int w = 0; w < width; w++) {
		      // calculate the id of the Node based off 'lwh'
		      // see documentation for more detail
		      int id = (w)+(width*h)+(width*height*l);
		      String letter = letters.get(id);
			  // create a node
		      Node node = new Node(this, id, l, w, h, letter);
		      this.nodes.add(node);
		    }
		  }
		}
		// nodes are created and in the lattice with letters
		this.linkNodes();
	}
	/**
	 * Links all nodes to all of the other nodes around a node.
	 * This algorithm starts with the front nodes and links each
	 * node to the node behind it and the node behind it to the
	 * node that is infront of it. Then it links each node on the
	 * top to the nodes below and backlinks the link. Then it
	 * links the nodes on the left to the nodes on the right and
	 * backlinks it.
	 */
	private void linkNodes() {
		// Link nodes to nodes behind of them.
		// Iterate through the collection of nodes on the front of
		// the lattice.
		for(int id1 = 0; id1 < this.nodes.size(); id1++) {
			if(this.onFront(id1)) {
				Node node1 = this.getNodeByID(id1);
				while(node1.hasFar()) {
					int id2 = node1.getFar();
					Node node2 = this.getNodeByID(id2);
					this.linkNodes(node1, node2);
					node1 = node2;
				}
			}
		}
		// Link nodes to nodes below of them.
		// Iterate through the collection of nodes on the top of
		// the lattice.
		for(int id1 = 0; id1 < this.nodes.size(); id1++) {
			if(this.onTop(id1)) {
				Node node1 = this.getNodeByID(id1);
				while(node1.hasDown()) {
					int id2 = node1.getDown();
					Node node2 = this.getNodeByID(id2);
					this.linkNodes(node1, node2);
					node1 = node2;
				}
			}
		}
		// Link nodes to nodes right of them.
		// Iterate through the collection of nodes on the left of
		// the lattice.
		for(int id1 = 0; id1 < this.nodes.size(); id1++) {
			if(this.onLeft(id1)) {
				Node node1 = this.getNodeByID(id1);
				while(node1.hasRight()) {
					int id2 = node1.getRight();
					Node node2 = this.getNodeByID(id2);
					this.linkNodes(node1, node2);
					node1 = node2;
				}
			}
		}
		
	}
	/**
	 * Links node a to b and node b to a.
	 * @param a
	 * @param b
	 */
	private void linkNodes(Node a, Node b) {
		a.addConnection(b);
		b.addConnection(a);
	}
	/**
	 * Links nodes a and b by given id numbers.
	 * @param a
	 * @param b
	 */
	private void linkNodes(int a, int b) {
		Node A = this.getNodeByID(a);
		Node B = this.getNodeByID(b);
		if(A != null) {
		  if(B != null) {
		    A.addConnection(B);
		    B.addConnection(A);
		  }
		}
	}
}
