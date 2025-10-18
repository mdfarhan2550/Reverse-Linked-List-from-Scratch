class RevLL {
    Node head;
    private int size = 0;

    class Node {
       int data;
       Node next;
       
       Node(int data) {
           this.data = data;
           this.next = null;
       }
    }
    //don't change head of the linkedlist

    //add - first, last
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }
    //print list
    public void printList() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }
    //delete a node - first,last
    public void deleteFirst() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        size--;
        //head.next = null -> lastNode = null
        if(head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;
    }

    public int getSize() {
        return size;
    }

    public void reverseIterate() {
        if(head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursion(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String args[]) {
        RevLL list = new RevLL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();

        list.head = list.reverseRecursion(list.head);
        list.printList();
    }
}

