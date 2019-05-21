package sorting.tree;

public class Tree {

    public Node node;

    public Tree(int value){
        node = new Node(value);
    }

    public Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        // Move para a esquerda se o valor
        // passado é menor que o atual nó
        if(value < node.value){
            node.left = insert(node.left, value);
        }
        // Move para a direita se o valor
        // passado é maior que o atual nó
        else if(value > node.value){
            node.right = insert(node.right, value);
        }
        return node;
    }

    // For traversing in order
    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    public void inOrderDesc(Node node){
        if(node != null){
            inOrderDesc(node.right);
            System.out.println(node.value + " ");
            inOrderDesc(node.left);
        }
    }
}
