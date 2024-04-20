package dev.neelesh.main.topic.deque;

public interface DequeTemplate {
    Node insertFront(Node first, int number, int MAX_SIZE);

    Node insertRear(Node last, int number, int MAX_SIZE);

    Node deleteFront(Node first, int number);

    Node deleteRear(Node last, int number);

    int size(Node node);

    boolean isFull(Node node, int MAX_SIZE);

    boolean isEmpty(Node node);
}
