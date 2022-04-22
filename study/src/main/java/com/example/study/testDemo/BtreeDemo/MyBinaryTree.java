package com.example.study.testDemo.BtreeDemo;

import java.util.Stack;

public class MyBinaryTree {
    //根节点
    private MyNode root;

    //注意，这是私有方法，对用户开放的新增方法在下面,其它几个方法也是
    private MyNode addNode(MyNode current, int value) {
        //如果根节点为空，直接new个新节点
        if (current == null) return new MyNode(value);
        if (value < current.value) {
            //如果当前插入节点的值小于根节点，则在树的左边递归插入
            current.left = addNode(current.left, value);
        } else if (value > current.value) {
            //如果当前插入节点的值大于根节点，则在树的右边递归插入
            current.right = addNode(current.right, value);
        } else {
            //如果等于，直接返回
            return current;
        }
        return current;
    }

    public void addNode(int value) {
        //指定当前根节点
        root = addNode(root, value);
    }

    private boolean isContainNode(MyNode current, int value) {
        //如果当前根节点不存在，直接返回false
        if (current == null) return false;
        //如果根节点存在并且值等于当前查找值，返回true
        if (current.value == value) return true;
        //如果目标值大于当前节点值，则在右子树递归查找，反之在左子树递归查找
        return value > current.value ? isContainNode(current.right, value) : isContainNode(current.left, value);
    }

    public boolean isContainNode(int value) {
        //从根节点开始找
        return isContainNode(root, value);
    }

    //删除节点比较复杂，或许会让你看了以后疯狂怀疑自己，请酌情查看
    private MyNode deleteNode(MyNode current, int value) {
        //如果节点不存在，就不删咯
        if (!isContainNode(value) || current == null) return null;
        //如果目标节点等于根节点
        if (current.value == value) {
            //目标节点无子节点，直接删除目标节点
            if (current.left == null && current.right == null) return null;
            //目标节点只有左子节点，直接删除目标节点，并将目标节点的父节点指向左子节点
            if (current.right == null) return current.left;
            //目标节点只有右子节点，直接删除目标节点，并将目标节点的父节点指向右子节点
            if (current.left == null) return current.right;
            //目标节点既有左子节点又有右子节点，这种比较复杂
            //需要将目标节点右子节点的最左节点，或者目标节点左子节点的最右节点替换成目标节点，然后将目标节点删除
            //我们这里是替换目标节点右子节点的最左节点，所以需要找到目标节点右子节点下面最小的那个节点，即左最节点
            int i = findSmallerNode(current.right);
            //将目标节点替换成找到的最左节点
            current.value = i;
            //递归删除，满足上面能删除的三种情况
            current.right = deleteNode(current.right, i);
            return current;
        } else if (current.value > value) {
            current.left = deleteNode(current.left, value);
            return current;
        } else {
            current.right = deleteNode(current.right, value);
            return current;
        }
    }

    public boolean deleteNode(int value) {
        MyNode node = deleteNode(root, value);
        if (node == null) return false;
        return true;
    }

    //中序递归遍历
    private void centerShow(MyNode root) {
        if (root != null) {
            //先递归遍历左子树
            centerShow(root.left);
            //遍历根节点
            System.out.print(root.value + " ");
            //再递归遍历右子树
            centerShow(root.right);
        }
    }

    public void centerShow() {
        System.out.print("\n中序递归遍历：");
        centerShow(root);
    }

    public void centerShowPro() {
        System.out.print("\n中序非递归遍历：");
        //利用栈的先进后出
        Stack<MyNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            //将根节点遍历入栈
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            //取出栈顶元素作为根节点并删除栈顶元素，此时栈顶元素为最左节点的值
            root = nodeStack.pop();
            //遍历左节点，因为是从根往左入栈，所以出栈是从左到根
            System.out.print(root.value + " ");
            //找到下一个节点，依次往右遍历
            root = root.right;
        }
    }

    private void preShow(MyNode root) {
        if (root != null) {
            //先遍历根节点
            System.out.print(root.value + " ");
            //然后遍历左节点
            preShow(root.left);
            //再遍历右节点
            preShow(root.right);
        }
    }

    public void preShow() {
        System.out.print("\n先序递归遍历：");
        preShow(root);
    }

    public void preShowPro() {
        System.out.print("\n先序非递归遍历：");
        Stack<MyNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            while (root != null) {
                //同中序非递归遍历，只是这里先遍历根节点
                System.out.print(root.value + " ");
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            root = root.right;
        }
    }

    private void afterShow(MyNode root) {
        if (root != null) {
            afterShow(root.left);
            afterShow(root.right);
            System.out.print(root.value + " ");
        }
    }

    public void afterShow() {
        System.out.print("\n后序递归遍历：");
        afterShow(root);
    }

    public void afterShowPro() {
        System.out.print("\n后序非递归遍历：");
        Stack<MyNode> nodeStack = new Stack<>();
        MyNode lastNode = null;
        while (root != null || !nodeStack.isEmpty()) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            //取出栈顶元素但不删除
            root = nodeStack.peek();
            //如果栈顶元素的右节点为空或者它是最后一次访问的节点
            if (root.right == null || root.right == lastNode) {
                //遍历当前节点
                System.out.print(root.value + " ");
                lastNode = nodeStack.pop();
                root = null;
            } else {
                root = root.right;
            }
        }
    }

    private int findSmallerNode(MyNode root) {
        //删除节点用的，用来找到节点的最左子节点
        return root.left == null ? root.value : findSmallerNode(root.right);
    }

    //节点，为了演示方便，只支持存放int数字
    private class MyNode {
        private int value;
        private MyNode left;
        private MyNode right;

        public MyNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}

