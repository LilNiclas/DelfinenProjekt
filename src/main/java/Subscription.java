import java.util.ArrayList;

public class Subscription {
    private Member member;
    private double payment;


    public Subscription(Member member) {
        this.member = member;
    }


    public double getSubscriptionPerMember() {

            if (member.isActive() == true) {
                if (member.memberAgeGroup() == AgeEnums.UNDER_18) {
                    payment = 1000;
                } else if (member.memberAgeGroup() == AgeEnums.OVER_18) {
                    payment = 1600;
                } else if (member.memberAgeGroup() == AgeEnums.OVER_60) {
                    payment = 1200;
                }
            } else {
                payment = 500;
            }
        return payment;
    }
}