/******************************************************
 * BST ADT.
 * Supported operations:
 * Insert
 * Delete
 * Find
 * Min
 * Max
 * Depth
 * Print
 ******************************************************/
public class BST {
    private BSTNode root;      /* Pointer to the root of the tree */
    private int noOfNodes;     /* No of nodes in the tree */
    /*******************************************************
     * Constructor: Initializes the BST
     *******************************************************/
    public BST() {root = null; noOfNodes = 0;}
    /*******************************************************
     * Returns a pointer to the root of the tree
     *******************************************************/
    public BSTNode Root() {return root;}
    /*******************************************************
     * Returns the number of nodes in the tree
     *******************************************************/
    public int NoOfNodes() {return noOfNodes;}
    /*******************************************************
     * Inserts the key into the BST. Returns a pointer to
     * the inserted node
     *******************************************************/
    public BSTNode Insert(int key) {BSTNode new_Node_2 = new BSTNode(key); BSTNode parent = null; BSTNode location = root;
        while (location != null) {parent = location;
            if (key == location.key) {location.count = location.count + 1; return new_Node_2;}
            else if (key > location.key) {location = location.right;}
            else {location = location.left;}}
        new_Node_2.right = null; new_Node_2.left = null;
        if (root == null) {root = new_Node_2;noOfNodes = noOfNodes + 1;root.count = 1;}
        else if (key > parent.key) {noOfNodes=noOfNodes+1;parent.right = new_Node_2;parent.right.count = 1;}
        else {noOfNodes=noOfNodes+1;parent.left = new_Node_2;parent.left.count = 1;}
        return new_Node_2;}
    /*******************************************************
     * Deletes the key from the tree (if found). Returns
     * 0 if deletion succeeds, -1 if it fails
     *******************************************************/
    public int Delete(int key) {BSTNode new_Node_2; BSTNode left_Child; BSTNode right_Child; BSTNode delete_Node = root; BSTNode delete_Parent = null; int control_Value = 0;
        if (root != null){while (delete_Node != null) {
            if (key == delete_Node.key) {control_Value = control_Value + 1;break;}
            else if (key > delete_Node.key) {delete_Parent = delete_Node; delete_Node = delete_Node.right;}
            else {delete_Parent = delete_Node; delete_Node = delete_Node.left;}}}
        else {return -1;}
        if (control_Value == 0) {return -1;}
        else {
            if (delete_Node.right == null&&delete_Node.left == null) {
                if (delete_Parent != null) {
                    if (delete_Node.key > delete_Parent.key) {delete_Parent.right = null;}
                    else {delete_Parent.left = null;}}
                else {root = null;}}
            else if (delete_Node.left == null) {right_Child = delete_Node.right.right; left_Child = delete_Node.right.left; delete_Node = delete_Node.right;
                if (delete_Parent == null) {root = delete_Node; root.left = left_Child; root.right = right_Child;}
                else {
                    if (delete_Node.key > delete_Parent.key) {delete_Parent.right = delete_Node; delete_Node.right = right_Child; delete_Node.left = left_Child;}
                    else {delete_Parent.left = delete_Node;}}}
            else if (delete_Node.right == null) {left_Child = delete_Node.left.left; right_Child = delete_Node.left.right; delete_Node = delete_Node.left;
                if (delete_Parent != null) {
                    if (delete_Node.key < delete_Parent.key){delete_Parent.left = delete_Node;}
                    else {delete_Parent.right = delete_Node;}
                    delete_Node.right = right_Child; delete_Node.left = left_Child;}
                else {root = delete_Node; root.left = left_Child; root.right = right_Child;}}
            else {BSTNode p_New_Node_2 = null; new_Node_2 = delete_Node.left;
                while (new_Node_2.right != null) {p_New_Node_2 = new_Node_2; new_Node_2 = new_Node_2.right;}
                right_Child = delete_Node.right; left_Child = delete_Node.left; delete_Node = new_Node_2;
                if (delete_Parent != null) {
                    if (delete_Node.key < delete_Parent.key){delete_Parent.left = delete_Node;}
                    else{delete_Parent.right = delete_Node;}
                    delete_Node.right = right_Child; delete_Node.left = left_Child;}
                else {root = delete_Node; root.right = right_Child; root.left = left_Child;}
                assert p_New_Node_2 != null;
                if (new_Node_2.key < p_New_Node_2.key){p_New_Node_2.left = null;}
                else{p_New_Node_2.right = null;}}}
        noOfNodes=noOfNodes-1; return 0;}
    /*******************************************************
     * Searches the BST for a key. Returns a pointer to the
     * node that contains the key (if found) or NULL if unsuccessful
     *******************************************************/
    public BSTNode Find(int key) {BSTNode location = root;
        while (location != null) {
            if (key == location.key){return location;}
            else if (key > location.key){location = location.right;}
            else{location = location.left;}}
        return null;}
    /*******************************************************
     * Returns a pointer to the node that contains the minimum key
     *******************************************************/
    public BSTNode Min() {BSTNode location_MIN = root;
        if (root != null){while (location_MIN.left != null) {location_MIN = location_MIN.left; }
            return location_MIN;}
        else {return null;}}
    /*******************************************************
     * Returns a pointer to the node that contains the maximum key
     *******************************************************/
    public BSTNode Max() {
        BSTNode location_MAX = root;
        if (root != null) {
            while (location_MAX.right != null) {location_MAX = location_MAX.right;}
            return location_MAX;}
        else {return null;}}
    /*******************************************************
     * Returns the depth of tree. Depth of a tree is defined as
     * the depth of the deepest leaf node. Root is at depth 0
     *******************************************************/
    public int Depth() {return dept_Root(root) - 1;}
    /*******************************************************
     * Performs an inorder traversal of the tree and prints [key, count]
     * pairs in sorted order
     *******************************************************/
    public void Print() {
        print_Node(root); System.out.print("\n");}
    private int dept_Root(BSTNode root) {int right_Node; int left_Node;
    if (root != null) {left_Node = dept_Root(root.left); right_Node = dept_Root(root.right);}
    else {return 0;}
    return Math.max(left_Node, right_Node) + 1;}
    private void print_Node(BSTNode root) {
        if (root != null) {System.out.print(root.key + "  "); print_Node(root.right); print_Node(root.left);}}}