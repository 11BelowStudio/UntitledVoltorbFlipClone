package FlipBoardClasses;

import java.awt.*;

//everything is either private or package-private

class BombShape {

    //record of the dimensions of the shapes being drawn
    private int x;
    private int y;
    private int size;
    private int[] xPoints;
    private int[] yPoints;

    BombShape(){
        x = 0;
        y = 0;
        size = 10;
        makeSpikes();
        //creates some initial values to prevent exceptions from being thrown,
        //and calls makeSpikes() to set up the arrays for the spiky bit shape (idk what exactly to call it)
    }

    void updateSize(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
        makeSpikes();
        //updates the attributes to the values in the arguments, before also updating the arrays for the spiky bit shape
    }

    private void makeSpikes(){
        //These are the co-ordinates of each point of the shape that essentially is the spikes of the bomb
        xPoints = new int[]{x, (x+(size/2)), (x+size), (x+(4*(size/5))), (x+size), (x+(size/2)), x, (x+(size/5)) };
        yPoints = new int[]{y, (y+(size/5)), y, (y+(size/2)), (y+size), (y+(4*(size/5))), (y+size), (y+(size/2)) };

        /*
        These essentially construct triangles with lines using these sorts of equations:
            x = -0.5y-2.5
            y = -0.5x+2.5
            x = y-4
         (assuming that circleSize = 10, constructing circle x^2 + y^2 = 25)
         (also there are 4 of these triangles, one for each corner of the circle's bounding square)
         */
    }


    void draw(Graphics g){

        g.setColor(Color.darkGray);
        g.fillPolygon(xPoints,yPoints,8);
        /*
        creates the spiky bits that poke out of the bomb, and it's dark grey
        drawn first so it appears underneath the circle
        */

        g.setColor(Color.black);
        g.fillOval(x,y,size,size);
        /*
        creates the circle which is the main body of the bomb, and its black
        drawn first so it covers the main body of the spiky thing,
        leaving only the tips of the spikes visible.
        */

    }


}
