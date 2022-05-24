package bank;

public abstract class Bank {

    private String acc_no;
    private String acc_name;
    private int acc_balance;

    public void SetCusInfoAccountNo(String no) {
        acc_no = no;
    }

    public void SetCusInfoAccountName(String name) {
        acc_name = name;
    }

    public void SetCusInfoAccountBalance(int b) {
        acc_balance = b;
    }

    public String GetCusInfoAccountNo() {
        return acc_no;
    }

    public String GetCusInfoAccountName() {
        return acc_name;
    }

    public int GetCusInfoAccountBalance() {
        return acc_balance;
    }

    public void PutCusInfoAccountNo( ) {
        System.out.println("계좌번호는 " + acc_no);
    }

    public void PutCusInfoAccountName( ) {
        System.out.println("고객님의 성함은 " + acc_name);
    }

    public void PutCusInfoAccountBalance() {
        System.out.println("고객님의 잔액은 " + acc_balance);
    }


}
