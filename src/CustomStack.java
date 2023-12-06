public class CustomStack {
    int maxSize;
    int length;
    NodeStack botton;
    NodeStack top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.length = 0;

    }

    public void push(int x) {
        if(length < maxSize) {
            NodeStack current = new NodeStack(x);
            if(length == 0) {
                this.botton = current;
                this.top = current;
            }
            else {
                NodeStack temp = this.top;
                this.top = current;
                current.next = temp;
            }
            this.length++;

        }}

    public int pop() {
        if(this.length == 0) return -1;
        if(this.top == this.botton) this.botton = null;

        NodeStack temp = this.top;
        this.top = this.top.next;
        this.length--;
        return temp.val;


    }

    public void increment(int k, int val) {
        traverse(k, val, this.length, this.top);


    }
    private void traverse(int index, int value, int length, NodeStack node){
        int tempIndex = length;
        if(node == null) {
            System.out.println("sale");
            return;}
        if(tempIndex > index){
            tempIndex--;
            traverse(index, value, tempIndex, node.next);
        }
        if(tempIndex <= index && tempIndex > 0) {
            tempIndex--;
            node.val += value;
            System.out.println("tempIndex "+tempIndex+" index "+index+" novel.val " + node.val);
            traverse(index, value, tempIndex, node.next);
            System.out.println(tempIndex);
        }

    }
}

class NodeStack{
    int val;
    NodeStack next;
    public NodeStack(int val){
        this.val = val;
        this.next = null;
    }
}
