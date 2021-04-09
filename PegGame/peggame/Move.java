package peggame;

public class Move {
    Location from;
    Location to;

    public Move(Location from, Location to){
        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return this.from;
    }
    public Location getTo() {
        return this.to;
    }
    
    @Override
    public boolean equals(Object obj) {
        if((obj instanceof Move)){
            Move move = (Move) obj;
            return this.from == move.getFrom() && this.to == move.getTo();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return (int)Math.pow(Math.pow(this.from.getRow(),this.to.getRow()),Math.pow(this.from.getCol(),this.to.getCol()));
    }

    @Override
    public String toString() {
        return "Move{from = " + this.from + ", to = " + this.to + "}";
    }

}
