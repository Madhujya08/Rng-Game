public class Player {
    private String name;
    private int gamesPlayed;
    private int wins;
    private int lost;

    public Player(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Player name cannot be left blank");

        }
        this.name = name;
        this.gamesPlayed = 0;
        this.wins = 0;
        this.lost = 0;
    }
    public String getName(){
        return name;
    }
    public void incrementGamesPlayed(){
        gamesPlayed++;
    }
    public void incrementWins(){
        wins++;
    }
    public void incrementLost(){
        lost++;
    }
    public int getGamesPlayed(){
        return gamesPlayed;
    }
    public int getWins(){
        return wins;
    }
    public int getLost(){
        return lost;
    }




}
