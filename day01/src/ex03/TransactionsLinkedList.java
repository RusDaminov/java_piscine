package ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{
    private Node first;
    private Node last;
    private Integer size;

    private class Node {
        Transaction transaction;
        Node next;
        Node prev;
        Node(Node prev, Transaction transaction, Node next) {
            this.transaction = transaction;
            this.next = next;
            this.prev = prev;
        }
    }
    public TransactionsLinkedList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    @Override
    public void addTransaction(Transaction transaction) {
        Node current = new Node(null, transaction, null);
        if(first == null) {
            first = current;
            last = current;
            size++;
        } else {
            last.next = current;
            current.prev = last;
            last = last.next;
            this.size++;
        }
    }

    @Override
    public void removeTransactionById(UUID identifier) {
        Node tmp = first;
        while(tmp != null) {
            if(tmp.transaction.getIdentifier() == identifier) {
                Node element = new Node(tmp.prev, tmp.transaction, tmp.next);

                if(element.prev == null) {
                    first = element.next;
                } else {
                    element.prev.next = element.next;
                    tmp.prev = null;
                }

                if(element.next == null) {
                    last = element.prev;
                } else {
                    element.next.prev = element.prev;
                    tmp.next = null;
                }

                tmp.transaction = null;
                size--;
            }
            tmp = tmp.next;
        }
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[size];
        Node tmp = first;
        int i = 0;
        while(tmp != null) {
            transactions[i] = tmp.transaction;
            tmp = tmp.next;
            i++;
        }
        return transactions;
    }

    public void print() {
        Node tmp = first;
        while(tmp != null) {
            System.out.println(tmp.transaction.toString());
            tmp = tmp.next;
        }
    }
    public Integer getSize() {
        return size;
    }
}
