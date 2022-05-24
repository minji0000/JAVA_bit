package bank;

public class Play {
    public static void main (String [] args) {
        Customer cus = new Customer();
        cus.SetCusInfoAccountNo("351-0800-4677-13");
        cus.PutCusInfoAccountNo();
        cus.SetCusInfoAccountName("진민지");
        cus.PutCusInfoAccountName();
        cus.SetCusInfoAccountBalance(280000);
        cus.PutCusInfoAccountBalance();

    }
}
