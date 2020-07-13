public class NBody{

    public static double readRadius(String filenName){

	In in = new In("./data/planets.txt");
	in.readInt();
    double Radius = in.readDouble();

    return Radius;

}
 public static Body[] readBodies(String filenName){
     In in = new In("./data/planets.txt");
     int num =in.readInt();
     in.readDouble();
     Body[] Planets= new Body[num];

     int i=0;
     for (i=0;i<num;i++){
       double xP=in.readDouble();
       double yP=in.readDouble();
       double xV=in.readDouble();
       double yV=in.readDouble();
       double m = in.readDouble();
       String img= in.readString();
       Planets[i]=new Body(xP,yP,xV,yV,m,img);


     }
     return Planets;
 }
/**
* Get data from file
*/
 public static void main(String[] args){
 	double T = Double.parseDouble(args[0]);
 	double dt =Double.parseDouble(args[1]);
 	String filenName= args[2];
 	double uniRadius=NBody.readRadius(filenName);
 	Body[] Planets=NBody.readBodies(filenName);

/**
* set background
*/
     StdDraw.setScale(-uniRadius,uniRadius);
     StdDraw.clear();
     StdDraw.picture(0, 0, "images/starfield.jpg");

/**
* drawing planets
*/

	for (Body planet : Planets) {
            planet.draw();
        }

  /*
  *enable animation
  */

    StdDraw.enableDoubleBuffering();
 /*
 *calculate forces
 */    
    for(double t=0;t<=T;t+=dt){
    	double[] xForces= new double[Planets.length];
    	double[] yForces= new double[Planets.length];
             for (int i = 0; i < Planets.length; i++) {
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
            }

    for (int i = 0; i < Planets.length; i++) {
                Planets[i].update(dt, xForces[i], yForces[i]);
            }

    StdDraw.picture(0, 0, "images/starfield.jpg");

    for (Body planet : Planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

StdOut.printf("%d\n", bodies.length);
StdOut.printf("%.2e\n", radius);
for (int i = 0; i < bodies.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
}

    }
 }
}





