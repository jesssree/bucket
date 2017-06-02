//****************************************
//  This class models a n-sided die
//  Borrowed from Professor Cannon. 
//
//****************************************
// change Die
public class Die {
    
    private int n;
    private int side;

    public Die(int shape)
    {
    	n=shape;
    	roll();
    }

    public Die()
    {
    	n=6;
        roll();
    }

    public void roll() 
    {
    	side = (int) (Math.random() * n + 1);
    }

    public int getSide() 
    {
    	return side;
    }


} //end class
