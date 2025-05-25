/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=30200
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {

    public static class Node {

        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final Integer capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    private Node getNode(int key) {
        // 判定是否存在，存在则获取节点值，并把节点前置；
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        removeNode(node);
        pushFront(node);
        return node;
    }

    public void put(int key, int value) {
        // 判定当前值是否存在, getNode会更新链表
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        node = new Node(key, value);
        map.put(key, node);
        pushFront(node);
        // 如果超过了lru的容量，那么会删除最后一个
        if (map.size() > capacity) {
            Node prev = dummy.prev;
            removeNode(prev);
            map.remove(prev.key);
        }
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void pushFront(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
