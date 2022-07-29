package ex03;

import java.util.LinkedList;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Amanda", 500);
        User user2 = new User("Miranda", 1000);
        User user3 = new User("qwe", 700);
        User user4 = new User("ryt", 1500);
        User user5 = new User("ads", 550);
        User user6 = new User("zxc", 1100);

        Transaction transaction1 = new Transaction(UUID.randomUUID(), user1, user2, Category.CREDITS, -100);
        Transaction transaction2 = new Transaction(UUID.randomUUID(), user3, user4, Category.CREDITS, -200);
        Transaction transaction3 = new Transaction(UUID.randomUUID(), user2, user4, Category.DEBITS, 200);
        Transaction transaction4 = new Transaction(UUID.randomUUID(), user5, user6, Category.DEBITS, 200);

        TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();

        transactionsLinkedList.addTransaction(transaction1);
        transactionsLinkedList.addTransaction(transaction2);
        transactionsLinkedList.addTransaction(transaction3);
        transactionsLinkedList.addTransaction(transaction4);
        transactionsLinkedList.addTransaction(transaction1);

        System.out.println("Add transactions to TransactionsLinkedList\n");
        transactionsLinkedList.print();
        System.out.println("\n\n");

        transactionsLinkedList.removeTransactionById(transaction3.getIdentifier());

        System.out.println("Remove transactions By Id\n");
        transactionsLinkedList.print();
        System.out.println("\n\n");

        Transaction[] transactions = transactionsLinkedList.toArray();
        for(Integer i = 0; i < transactionsLinkedList.getSize(); i++) {
            System.out.println(transactions[i].toString());
        }

    }
}
