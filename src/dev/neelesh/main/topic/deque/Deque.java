package dev.neelesh.main.topic.deque;

public class Deque implements DequeTemplate {
    @Override
    public Node insertFront(Node first, int number, int MAX_SIZE) {

        if (isFull(first, MAX_SIZE)) return first;

        Node head = new Node(number);
        if (first == null) first = head;
        else {
            head.right = first;
            first.left = head;
        }
        return head;
    }

    @Override
    public Node insertRear(Node last, int number, int MAX_SIZE) {

        if (isFull(last, MAX_SIZE)) return last;

        Node tail = new Node(number);

        if (last == null) last = tail;
        else {
            last.right = tail;
            tail.left = last;
        }
        return tail;
    }

    @Override
    public Node deleteFront(Node first, int number) {
        if (first == null) return first;

        Node head = first.right;
        first.right = null;
        head.left = null;

        return head;
    }

    @Override
    public Node deleteRear(Node last, int number) {
        if (last == null) return last;

        Node tail = last.left;
        last.left = null;
        tail.right = null;

        return tail;
    }

    @Override
    public int size(Node node) {
        if (node == null) return 0;

        int nodeCount = 0;

        if (node.left == null) {
            while (node != null) {
                nodeCount++;
                node = node.right;
            }
        } else {
            while (node != null) {
                nodeCount++;
                node = node.left;
            }
        }

        return nodeCount;
    }

    @Override
    public boolean isFull(Node node, int size) {
        return size(node) == size;
    }

    @Override
    public boolean isEmpty(Node node) {
        return node == null;
    }
}
