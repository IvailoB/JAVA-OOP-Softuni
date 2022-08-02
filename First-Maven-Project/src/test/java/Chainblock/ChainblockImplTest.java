package Chainblock;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private Chainblock chainblock;
    private List<Transaction> transactions;

    @Before
    public void prepare() {
        this.chainblock = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        this.prepareTransactions();
    }

    private void fillChainBlockWithTransactions() {
        transactions.forEach(t -> chainblock.add(t));
    }

    private void prepareTransactions() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Pesho", "Sasho", 10.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Toshko", 12.20);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.UNAUTHORIZED, "Sasho", "Pesho", 11.20);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Toshko", "Sasho", 11.0);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.FAILED, "Sasho", "Pesho", 10.0);
        transactions.add(transaction);
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
    }

    @Test
    public void add() {
        chainblock.add(transactions.get(0));
        assertEquals(1, chainblock.getCount());
        chainblock.add(transactions.get(1));
        assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testAddShouldNotAddDuplicateTransaction() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(0));
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void containsShouldReturnFalse() {
        chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(1));
        assertFalse(chainBlockContainsTransaction);
    }

    @Test
    public void containsShouldReturnTrue() {
        chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(0));
        assertTrue(chainBlockContainsTransaction);
    }

    @Test
    public void containsWithIdShouldReturnFalse() {
        chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(1).getId());
        assertFalse(chainBlockContainsTransaction);
    }

    @Test
    public void containsWithIdShouldReturnTrue() {
        chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(0).getId());
        assertTrue(chainBlockContainsTransaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowForMissingTransaction() {
        chainblock.changeTransactionStatus(100, TransactionStatus.FAILED);
    }

    @Test
    public void changeTransactionStratusShouldChangeStatus() {
        chainblock.add(transactions.get(0));
        chainblock.changeTransactionStatus(transactions.get(0).getId(), TransactionStatus.FAILED);
        TransactionStatus newTransactionStatus = chainblock.getById(transactions.get(0).getId()).getStatus();
        assertEquals(TransactionStatus.FAILED, newTransactionStatus);
    }

    @Test
    public void getById() {
        chainblock.add(transactions.get(0));
        Transaction actual = chainblock.getById(transactions.get(0).getId());
        assertEquals(transactions.get(0), actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldThrowFromMissingTransaction() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));
        chainblock.getById(200);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdShouldThrow() {
        fillChainBlockWithTransactions();
        chainblock.removeTransactionById(200);
    }

    @Test
    public void removeTransactionByIdShouldRemoveIt() {
        fillChainBlockWithTransactions();
        chainblock.removeTransactionById(1);
        assertFalse(chainblock.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatus_ShouldThrowIfNoSuchTransaction() {
        fillChainBlockWithTransactions();
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getByTransactionStatus_ShouldReturnTransactions() {
        fillChainBlockWithTransactions();
        List<Transaction> expectedTransactions = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> actualTransactions = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowException() {
        fillChainBlockWithTransactions();

        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllSendersWithTransactionStatus() {
        fillChainBlockWithTransactions();
        List<String> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
        Iterable<String> actual = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowException() {
        fillChainBlockWithTransactions();

        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllReceiversWithTransactionStatus() {
        fillChainBlockWithTransactions();
        List<String> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount))
                .map(Transaction::getTo)
                .collect(Collectors.toList());
        Iterable<String> actual = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expected, actual);
    }

    @Test
    public void getAllOrderedByAmountDescendingThenById() {
    }

    @Test
    public void getBySenderOrderedByAmountDescending() {
    }

    @Test
    public void getByReceiverOrderedByAmountThenById() {
    }

    @Test
    public void getByTransactionStatusAndMaximumAmount() {
    }

    @Test
    public void getBySenderAndMinimumAmountDescending() {
    }

    @Test
    public void getByReceiverAndAmountRange() {
    }

    @Test
    public void getAllInAmountRange() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> expected = transactions.stream()
                .filter(t->t.getAmount() < 12 && t.getAmount() > 10)
                .collect(Collectors.toList());
        Iterable<Transaction> actual = chainblock.getAllInAmountRange(10,12);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllInAmountRangeShouldReturnEmptyCollection() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> expected = transactions.stream()
                .filter(t->t.getAmount() < 1222 && t.getAmount() > 1022)
                .collect(Collectors.toList());
        Iterable<Transaction> actual = chainblock.getAllInAmountRange(1022,1222);
        assertEquals(expected, actual);
    }

    @Test
    public void iterator() {
    }
}