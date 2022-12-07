package kaptajner.delfinprojekt;

import kaptajner.delfinprojekt.agegroupenum.ageGroup;

public class Subscription {
    private Member member;
    private double payment;


    public Subscription(Member member) {
        this.member = member;
    }


    public double getSubscriptionPerMember() {

            if (member.isActive() == true) {
                if (member.memberAgeGroup() == ageGroup.UNDER_18) {
                    payment = 1000;
                } else if (member.memberAgeGroup() == ageGroup.OVER_18) {
                    payment = 1600;
                } else if (member.memberAgeGroup() == ageGroup.OVER_60) {
                    payment = 1200;
                }
            } else {
                payment = 500;
            }
        return payment;
    }
}