public class FacultyNode extends TreeNode {
    private Faculty faculty;
    private int score = 0;
    private int playersNum = 0;
    private int[] players = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public FacultyNode(int key, TreeNode left, TreeNode middle, TreeNode right, TreeNode parent) {
        super(key, left, middle, right, parent);

    }

    public FacultyNode(int facultyId) {
        super(facultyId);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlayersNum() {
        return playersNum;
    }

    public void setPlayersNum(int playersNum) {
        this.playersNum = playersNum;
    }

    public int[] getPlayers() {
        return players;
    }

    public void setPlayers(int[] players) {
        this.players = players;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addPlayer(int id) {
        if (this.playersNum < 11) {
            this.players[this.playersNum++] = id;
        }
    }

    public void removePlayer(int id) {
        if (this.playersNum > 2) {
            for (int i=0; i<this.playersNum-1; i++) {
                if (this.players[i] == id) {
                    this.players[i] = this.players[this.playersNum-1];
                    this.players[this.playersNum-1] = -1;
                    this.playersNum--;
                    return;
                }
            }
        }
    }

    public void updateScore(int points) {
        this.score += points;
    }
}
