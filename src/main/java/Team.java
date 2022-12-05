import java.util.ArrayList;

public class Team {

    private ArrayList<Member> members = new ArrayList<>();
    private  ArrayList<Coach> coaches = new ArrayList<>();

    private String teamName;
    private String disciplin;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName() {
        this.teamName = teamName;
    }

    //List of members and coaches
    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }


    public void addMember(Member member) {
        members.add(member);
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }




}
