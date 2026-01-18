package ru.ruazanova.structures;

public class Node {
    private Integer value;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node() { }

    public void addValue(int newValue) {
        if (value == null) {
            value = newValue;
            return;
        }

        if (newValue <= value) {
            if (leftChild == null) {
                leftChild = new Node();
                leftChild.parent = this;
            }
            leftChild.addValue(newValue);
        } else {
            if (rightChild == null) {
                rightChild = new Node();
                rightChild.parent = this;
            }
            rightChild.addValue(newValue);
        }
    }

    public boolean findValue(int searchValue) {
        if (value != null && value == searchValue) {
            return true;
        }
        boolean foundInLeft = leftChild != null && leftChild.findValue(searchValue);
        boolean foundInRight = rightChild != null && rightChild.findValue(searchValue);
        return foundInLeft || foundInRight;
    }

    public void removeValue(int removeValue) {
        if (value == null) return;

        if (value == removeValue) {
            if (leftChild != null) {
                Node maxLeft = leftChild;
                while (maxLeft.rightChild != null) {
                    maxLeft = maxLeft.rightChild;
                }
                value = maxLeft.value;
                leftChild.removeValue(maxLeft.value);
            } else if (rightChild != null) {
                Node minRight = rightChild;
                while (minRight.leftChild != null) {
                    minRight = minRight.leftChild;
                }
                value = minRight.value;
                rightChild.removeValue(minRight.value);
            } else {
                if (parent != null) {
                    if (parent.leftChild == this) parent.leftChild = null;
                    if (parent.rightChild == this) parent.rightChild = null;
                } else {
                    value = null; // корень без потомков
                }
            }
        } else if (removeValue < value && leftChild != null) {
            leftChild.removeValue(removeValue);
        } else if (removeValue > value && rightChild != null) {
            rightChild.removeValue(removeValue);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (leftChild != null) sb.append(leftChild).append(" ");
        if (value != null) sb.append(value).append(" ");
        if (rightChild != null) sb.append(rightChild).append(" ");
        return sb.toString().trim();
    }
}
