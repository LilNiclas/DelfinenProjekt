import java.util.ArrayList;

public class Subscription {

    private double payment;
    private double totalPayment;


    private Member member = new Member();
    private Database database = new Database();

    private ArrayList<Member> subscriptionDatabase = new ArrayList<>();

    public void getSubscriptionPerMember() {

        for (Member member : database.getMembers()) {
            if (member.isMembershipStatus() == true) {
                if (member.getAge() < 18) {
                    payment = 1000;
                } else if (member.getAge() <= 60) {
                    payment = 1600;
                } else if (member.getAge() > 60) {
                    payment = 1200;
                }
            } else {
                payment = 500;
            }
        }


    }


}