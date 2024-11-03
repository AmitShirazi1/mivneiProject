import java.util.ArrayList;

public class TechnionTournament implements Tournament{
    private TwoThreeTree2Key faculties;
    private TwoThreeTree2Key players;

    TechnionTournament(){};

    @Override
    public void init() {
        this.faculties = new FacultyTree2Key();
        this.players = new PlayerTree2Key();
    }

    @Override
    public void addFacultyToTournament(Faculty faculty) {
        FacultyNode newNode = new FacultyNode(faculty.getId());
        this.faculties.insert(newNode);
        newNode.setFaculty(faculty);
    }

    @Override
    public void removeFacultyFromTournament(int faculty_id) {
        FacultyNode faculty = (FacultyNode) this.faculties.search(this.faculties.root, faculty_id);
        this.faculties.deleteLeaf(faculty);
        int[] fPlayers = faculty.getPlayers();
        PlayerNode1Key player;
        for (int i=0; i<faculty.getPlayersNum(); i++) {
            player = (PlayerNode1Key) this.players.search(this.players.root, fPlayers[i]);
            player.setFacultyId(-1);
        }
    }

    @Override
    public void addPlayerToFaculty(int faculty_id, Player player) {
        PlayerNode1Key newNode = new PlayerNode1Key(player.getId(), faculty_id);
        this.players.insert(newNode);
        newNode.setPlayer(player);
        FacultyNode faculty = (FacultyNode) this.faculties.search(this.faculties.root, faculty_id);
        faculty.addPlayer(player.getId());
    }

    @Override
    public void removePlayerFromFaculty(int faculty_id, int player_id) {
        PlayerNode1Key player = (PlayerNode1Key) this.players.search(this.players.root, player_id);
        player.setFacultyId(-1);
        FacultyNode faculty = (FacultyNode) this.faculties.search(this.faculties.root, faculty_id);
        faculty.removePlayer(player_id);
    }

    @Override
    public void playGame(int faculty_id1, int faculty_id2, int winner,
                         ArrayList<Integer> faculty1_goals, ArrayList<Integer> faculty2_goals) {
        FacultyNode faculty1 = (FacultyNode) this.faculties.search(this.faculties.root, faculty_id1);
        FacultyNode faculty2 = (FacultyNode) this.faculties.search(this.faculties.root, faculty_id2);
        if (winner==0) {
            faculty1.updateScore(1);
            faculty2.updateScore(1);
        }
        else if (winner==1) {
            faculty1.updateScore(3);
        }
        else {
            faculty2.updateScore(3);
        }
        PlayerNode1Key player;
        int numGoals = faculty1_goals.size();
        for (int i = 0; i < numGoals; i++) {
            player = (PlayerNode1Key) this.players.search(this.players.root, faculty1_goals.get(i));
            player.updateGoals();
        }
        numGoals = faculty2_goals.size();
        for (int j = 0; j < numGoals; j++) {
            player = (PlayerNode1Key) this.players.search(this.players.root, faculty2_goals.get(j));
            player.updateGoals();
        }
    }

    @Override
    public void getTopScorer(Player player) {

    }

    @Override
    public void getTopScorerInFaculty(int faculty_id, Player player) {

    }

    @Override
    public void getTopKFaculties(ArrayList<Faculty> faculties, int k, boolean ascending) {

    }

    @Override
    public void getTopKScorers(ArrayList<Player> players, int k, boolean ascending) {

    }

    @Override
    public void getTheWinner(Faculty faculty) {

    }

    ///TODO - add below your own variables and methods
}
