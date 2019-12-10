import java.util.ArrayList;
import java.util.Collection;

/**
 * A class to represent a node in a lattice. Nodes have an id, letter,
 * and a list of connections to other Nodes.
 * @author Travis Austin Pavelka
 */
public class Node {
	/**
	 * A reference to this node's lattice object.
	 */
	private LatticeDegree6 lattice;
	
	/**
	 * Get the id of the Node above. It may not exist though.
	 * @return
	 */
	@Deprecated public int getUp() {
		int up = this.id - lattice.getWidth();
		if(up < 0) {
			up = -1;
		}
		return up;
	}
	/**
	 * Determines if there is a node in the Down direction of
	 * this node.
	 * @return
	 */
	public boolean hasDown() {
		if((height+1.0)/lattice.getHeight() < 1.0) {
			return true;
		}
		return false;
	}
	/**
	 * Get the id of the Node below. It may not exist though.
	 * @return
	 */
	@Deprecated public int getDown() {
		int down = this.id + lattice.getWidth();
		return down;
	}
	/**
	 * Get the id of the Node left. It may not exist though.
	 * @return
	 */
	@Deprecated public int getLeft() {
		int left = this.id - 1;
		if(left < 0) {
			return -1;
		}
		return left;
	}
	/**
	 * Determines if there is a node in the Right direction of
	 * this node.
	 * @return
	 */
	public boolean hasRight() {
		if((width+1.0)/lattice.getWidth() < 1.0) {
			return true;
		}
		return false;
	}
	/**
	 * Get the id of the Node right. It may not exist though.
	 * @return
	 */
	@Deprecated public int getRight() {
		int right = this.id + 1;
		return right;
	}
	/**
	 * Determines if there is a node in the Far direction of
	 * this node.
	 * @return
	 */
	public boolean hasFar() {
		if((length+1.0)/lattice.getLength() < 1.0) {
			return true;
		}
		return false;
	}
	/**
	 * Get the id of the Node far. It may not exist though.
	 * @return
	 */
	@Deprecated public int getFar() {
		int far = this.id + lattice.getWidth() * lattice.getHeight();
		return far;
	}
	/**
	 * Get the id of the Node near. It may not exist though.
	 * @return
	 */
	@Deprecated public int getNear() {
		int near = this.id - lattice.getWidth() * lattice.getHeight();
		if(near < 0) {
			return -1;
		}
		return near;
	}
	
	/**
	 * this.length, this.width, and this.height should be set before
	 * the execution of this method.
	 * @param l
	 * @param w
	 * @param h
	 * @return
	 */
	@Deprecated public int calcID(int l, int w, int h) {
		return (w) + (this.width * h) + (this.width * this.height + l);
	}
	
	
	
	
	
	
	/**
	 * The numerical identifier of the Node to be used to reference
	 * the Node in its lattice.
	 */
	private int id = 0;
	public int getId() {
		return this.id;
	}
	@Deprecated public void setId(int id) {
		assert(id > -1);
		this.id = id;
	}
	
	/**
	 * Length positional of this Node.
	 */
	private int length = 0;
	public int getLength() {
		return this.length;
	}
	@Deprecated public void setLength(int length) {
		assert(length > -1);
		this.length = length;
	}
	
	/**
	 * Width positional of this Node.
	 */
	private int width = 0;
	public int getWidth() {
		return this.width;
	}
	@Deprecated public void setWidth(int width) {
		assert(width > -1);
		this.width = width;
	}
	
	/**
	 * Height positional of this Node.
	 */
	private int height = 0;
	public int getHeight() {
		return this.height;
	}
	@Deprecated public void setHeight(int height) {
		assert(height > -1);
		this.height = height;
	}
	
	/**
	 * The letter this Node contains in the lattice which is used to
	 * make words.
	 */
	private String letter = "a";
	public String getLetter() {
		return this.letter;
	}
	public void setLetter(String letter) {
		assert(letter.length() == 1);
		this.letter = letter;
	}
	
	/**
	 * A Collection of connections this node has to other nodes in no
	 * specific order. This is preffered to using the getDir() methods.
	 */
	private Collection<Node> connections = new ArrayList<Node>();
	public void addConnection(Node node) {
		this.connections.add(node);
	}
	public void removeConnection(Node node) {
		this.connections.remove(node);
	}
	public Collection<Node> getConnections() {
		return new ArrayList<Node>(this.connections);
	}
	
	/**
	 * Tests if this node has a connection of the specified letter.
	 * Returns null if no connection was found with the letter.
	 * @param letter
	 * @return
	 */
	public Node hasConnection(String letter) {
		for(Node n: this.connections) {
			if(n.getLetter().equals(letter)) {
				return n;
			}
		}
		return null;
	}
	
	
	
	
	
	
	/**
	 * The Node constructor.
	 * @param id
	 * @param letter
	 */
	public Node(LatticeDegree6 lattice, int id, int length, int width,
			int height, String letter) {
		this.lattice = lattice;
		this.id = id;
		this.length = length;
		this.width = width;
		this.height = height;
		this.letter = letter;
		// connections already defined
	}
}
