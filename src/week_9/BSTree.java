package week_9;

public class BSTree<T extends Comparable<T>> {

    private static class BSTNode<T> {
        private T item;
        private BSTNode<T> left;
        private BSTNode<T> right;

        private BSTNode(T item) {
            this.item = item;
            this.left = null;
            this.right = null;
        }
    }

    private BSTNode<T> root;
    private boolean insertSuccess;
    private boolean removeSuccess;

    public BSTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean insert(T data) {
        root = insert(root, data);
        return insertSuccess;
    }

    private BSTNode<T> insert(BSTNode<T> node, T data) {
        if (node == null) {
            insertSuccess = true;
            node = new BSTNode<T>(data);
        }
        else if (node.item.compareTo(data) < 0) {
            node.right = insert(node.right, data);
        }
        else if (node.item.compareTo(data) > 0) {
            node.left = insert(node.left, data);
        }
        else
            insertSuccess = false;
        return node;
    }


    public boolean remove(T data) {
        root = remove(root, data);
        return removeSuccess;
    }

    private BSTNode<T> remove(BSTNode<T> node, T data) {
        if (node == null)
            removeSuccess = false;
        else if (node.item.compareTo(data) < 0)
            node.right = remove(node.right, data);
        else if (node.item.compareTo(data) > 0)
            node.left =  remove(node.left, data);
        else {	// 삭제할 노드 찾음
            removeSuccess = true;
            if (node.right == null)	// 왼쪽 자식 노드만 있는 경우
                node = node.left;
            else if (node.left == null) // 오른쪽 자식 노드만 있는 경우
                node = node.right;
            else {	// 왼쪽, 오른쪽 자식 노드가 모두 있는 경우
                BSTNode<T> maxNode = node.left; // 왼쪽 서브트리 중에서
                while (maxNode.right != null) { // .. 가장 오른쪽 노드 찾음
                    maxNode = maxNode.right;
                }
                node.item = maxNode.item;
                node.left = remove(node.left, maxNode.item);
            }
        }
        return node;
    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(BSTNode<T> node, T data) {
        if (node == null)
            return false;
        else if (node.item.compareTo(data) < 0)
            return search(node.right, data);
        else if (node.item.compareTo(data) > 0)
            return search(node.left, data);
        else
            return true;
    }


    public void inorderTraverse() {
        inorderTraverse(this.root);
        System.out.println();
    }

    private void inorderTraverse(BSTNode<T> node) {
        if(node != null) {
            inorderTraverse(node.left);
            System.out.print(node.item + " ");
            inorderTraverse(node.right);
        }
    }

    public void print() {
        print(this.root, 0);
    }

    private void print(BSTNode<T> node, int depth) {
        if(node != null) {
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<depth; i++)
                sb.append("\t\t\t");

            sb.append(node.item);

            if(node.left != null)
                sb.append(",L");
            if(node.right != null)
                sb.append(",R");

            print(node.right, depth + 1);
            System.out.println(sb.toString());
            print(node.left, depth + 1);
        }
    }

    public int height() {
        return (int)(Math.log(countNodes())/Math.log(2));
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(BSTNode<T> node) {
        if (node == null)
            return 0;
        else
            return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves() {
        return countLeaves(this.root);
    }

    private int countLeaves(BSTNode<T> node) {
        if(node == null)
            return 0;
        else if(node.left == null && node.right == null)
            return 1;
        else
            return countLeaves(node.left) + countLeaves(node.right);
    }
}
