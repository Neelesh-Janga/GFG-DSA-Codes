package dev.neelesh.test.searching;

import dev.neelesh.main.topic.deque.Deque;
import dev.neelesh.main.topic.deque.DequeTemplate;
import dev.neelesh.main.topic.deque.Node;

public class DequeTesting {
    public static void main(String[] args) {
        testInsertFront();
        testInsertRear();
        testSize();
        testDeleteFront();
        testDeleteRear();
    }

    static void testInsertFront() {
        DequeTemplate service = new Deque();
        int MAX_SIZE = 2;
        Node head = null;

        head = service.insertFront(head, 5, MAX_SIZE);
        assert head.data == 5;
        assert head.left == null;
        assert head.right == null;

        head = service.insertFront(head, 3, MAX_SIZE);
        assert head.data == 3;
        assert head.left == null;
        assert head.right.data == 5;
        assert head.right.left.data == 3;
        assert head.right.right == null;

        assert service.insertFront(head, 7, MAX_SIZE) == head;

        System.out.println("Test cases for insertFront passed successfully.");
    }

    static void testInsertRear() {
        DequeTemplate service = new Deque();
        int MAX_SIZE = 2;
        Node head = null;
        Node tail;

        head = service.insertRear(head, 5, MAX_SIZE);
        assert head.data == 5;
        assert head.left == null;
        assert head.right == null;

        tail = head;

        tail = service.insertRear(tail, 7, MAX_SIZE);
        assert head.data == 5;
        assert head.left == null;
        assert head.right.data == 7;
        assert head.right.left.data == 5;
        assert head.right.right == null;

        assert service.insertRear(tail, 3, MAX_SIZE) == tail;

        System.out.println("Test cases for insertRear passed successfully.");
    }

    static void testSize() {
        DequeTemplate service = new Deque();

        assert service.size(null) == 0;

        Node head = new Node(2);
        Node tail = head;
        assert service.size(head) == 1;

        head = service.insertFront(head, 1, 10);
        assert service.size(head) == 2;

        tail = service.insertRear(tail, 3, 10);
        assert service.size(head) == 3;

        System.out.println("Test cases for size passed successfully.");
    }

    static void testDeleteFront() {
        DequeTemplate service = new Deque();

        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.right = node2;
        node2.left = head;
        node2.right = node3;
        node3.left = node2;

        assert service.deleteFront(null, 1) == null;

        head = service.deleteFront(head, 1);
        assert head.data == 2;
        assert head.left == null;
        assert head.right.data == 3;
        assert head.right.left.data == 2;
        assert head.right.right == null;

        System.out.println("Test cases for deleteFront passed successfully.");
    }

    static void testDeleteRear() {
        DequeTemplate service = new Deque();

        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node tail;

        head.right = node2;
        node2.left = head;
        node2.right = node3;
        node3.left = node2;
        tail = node3;

        assert service.deleteRear(null, 3) == null;

        tail = service.deleteRear(tail, 3);
        assert head.data == 1;
        assert head.left == null;
        assert head.right.data == 2;
        assert head.right.left.data == 1;
        assert head.right.right == null;

        System.out.println("Test cases for deleteRear passed successfully.");
    }
}
