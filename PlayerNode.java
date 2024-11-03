public class PlayerNode extends TreeNode {
    private Player player;
    private int facultyId;
    private int numOfGoals = 0;

    public PlayerNode(int key, int facultyId, TreeNode left, TreeNode middle, TreeNode right, TreeNode parent) {
        super(key, left, middle, right, parent);
        this.facultyId = facultyId;
    }

    public PlayerNode(int facultyId, int playerId) {
        super(playerId);
        this.facultyId = facultyId;
    }

    public PlayerNode(int playerId) {
        this(-1, playerId);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public void setNumOfGoals(int numOfGoals) {
        this.numOfGoals = numOfGoals;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public void updateGoals() {
        this.numOfGoals ++;
    }
}
