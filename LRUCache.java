import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Node head = null;
    Node tail = null;
    Map<Integer, Integer> map = new HashMap<>();
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node key1 = new Node();
            key1.key = key;
            remove(key1);
            int value = map.get(key);
            add(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node key1 = new Node();
            key1.key = key;
            remove(key1);
            map.put(key, value);
            add(key, value);
        } else {
            if(cap >= map.size() + 1) {
                add(key, value);
                map.put(key, value);
            } else {
                map.remove(tail.key);
                map.put(key, value);
                remove(tail);
                add(key, value);
            }
        }
        print(head);
    }

    public void print(Node head) {
        if(head != null) {
            Node currNode = head;
            while(currNode.next != null) {
                //System.out.println(currNode.key + "->");
                currNode = currNode.next;
            }
        }
    }

    public void add(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;
        if(head != null) {
            //System.out.println(head.key);
            Node prevHead = head;
            prevHead.prev = node;
            node.next = prevHead;
            node.prev = null;
            head = node;
        } else {
            head = node;
            //System.out.println(head.key);
            tail = node;
        }
    }

    public void remove(Node key) {
        if(head != null) {
            Node currentNode = head;
            boolean flag = false;
            if(currentNode.next == null && currentNode.key == key.key) {
                head = null;
                tail = null;
                return;
            }
            while(currentNode.next != null) {
                if(currentNode.key == key.key) {
                    Node prevNode = currentNode.prev;
                    Node nextNode = currentNode.next;
                    if(prevNode != null) {
                        prevNode.next = nextNode;
                    } else {
                        head = currentNode.next;
                    }
                    if(nextNode != null) {
                        nextNode.prev = prevNode;
                    } else {
                        tail = currentNode.prev;
                    }
                    flag = true;
                    break;
                }
                currentNode = currentNode.next;
            }
            if(!flag && currentNode.next == null) {
                Node prevNode = currentNode.prev;
                if(prevNode != null) {
                    prevNode.next = null;
                }
                tail = prevNode;
            }
        }
    }

    public static void main(String[] args) {
       LRUCache lru =new LRUCache(2);
       lru.put(2, 1);
       lru.put(3, 2);
       System.out.println(lru.get(3));
       System.out.println(lru.get(2));
       lru.put(4, 3);
       System.out.println(lru.get(2));
       System.out.println(lru.get(3));
       System.out.println(lru.get(4));
       
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */